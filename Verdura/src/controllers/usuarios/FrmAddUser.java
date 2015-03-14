package controllers.usuarios;

import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.InputElement;

import general.ShaEncoding;
import general.ValidateZK;
import models.SecurityGroup;
import models.SecurityUser;
import models.service.ServiceSecurityGroup;
import models.service.ServiceSecurityUser;

public class FrmAddUser {

	@WireVariable
	private ServiceSecurityUser serviceSecurityUser;
	@WireVariable
	private ServiceSecurityGroup serviceSecurityGroup;
	private SecurityUser securityUser;
	private SecurityGroup selectedSecurityGroup;
	private String repeatPassword;
	private List<SecurityGroup> listGroups;

	public SecurityGroup getSelectedSecurityGroup() {
		return selectedSecurityGroup;
	}

	public void setSelectedSecurityGroup(SecurityGroup selectedSecurityGroup) {
		this.selectedSecurityGroup = selectedSecurityGroup;
	}

	public List<SecurityGroup> getListGroups() {
		return listGroups;
	}

	public void setListGroups(List<SecurityGroup> listGroups) {
		this.listGroups = listGroups;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public SecurityUser getSecurityUser() {
		return securityUser;
	}

	public void setSecurityUser(SecurityUser securityUser) {
		this.securityUser = securityUser;
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	public Validator getNoEqualPassword() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.trim().isEmpty()) {
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
				} else if (repeatPassword.compareTo(string) != 0) {
					throw new WrongValueException(inputElement, "Las contraseñas no coinciden.");
				}
			}
		};
	}

	public Validator getNoEmail() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (!string.matches(".+@.+\\.[a-zA-Z]+")) {
					throw new WrongValueException(inputElement, "Ingrese una direccion de correo valida.");
				} else if (serviceSecurityUser.findByEmail(string) != null) {
					throw new WrongValueException(inputElement, "Esta direccion de correo ya existe.");
				}
			}
		};
	}

	public Validator getNoSelect() {
		return new ValidateZK().getNoSelect();
	}

	@Init
	public void init() {
		restartForm();
		listGroups = serviceSecurityGroup.listActive();
	}

	@NotifyChange({ "securityUser", "repeatPassword", "listGroupsToDel", "listGroupsToAdd" })
	@Command
	public void restartForm() {
		securityUser = new SecurityUser();
		securityUser.setStatus('A');
		repeatPassword = new String();
	}

	@NotifyChange({ "securityUser", "repeatPassword" })
	@Command
	public void save(@BindingParam("list") Component component, @BindingParam("window") Window window) {
		ShaEncoding encodingPass = new ShaEncoding(securityUser.getPassword());
		try {
			securityUser.setPassword(encodingPass.encodingPassword());
		} catch (Exception e) {
			Clients.showNotification("No se pudo encriptar la contraseña", "error", null, "end_center", 2000);
			e.printStackTrace();
			return;
		}
		securityUser.getSecurityGroups().add(selectedSecurityGroup);
		if (securityUser.getSecurityGroups().size() == 0) {
			throw new WrongValueException(component, "El usuario debe pertenecer a un grupo.");
		}
		if (!serviceSecurityUser.save(securityUser)) {
			Clients.showNotification("No se pudo agregar el usuario", "error", null, "end_center", 2000);
			return;
		}
		Clients.showNotification("Usuario agregado.", "info", null, "end_center", 2000);
		restartForm();
		BindUtils.postGlobalCommand(null, null, "userAdded", null);
		window.detach();
	}
}