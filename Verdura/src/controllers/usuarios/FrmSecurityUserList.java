package controllers.usuarios;

import general.ShaEncoding;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.SecurityUser;
import models.service.ServiceSecurityUser;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;

public class FrmSecurityUserList {

	@WireVariable
	private ServiceSecurityUser serviceSecurityUser;

	private List<SecurityUserStatus> listUsers;

	public List<SecurityUserStatus> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<SecurityUserStatus> listUsers) {
		this.listUsers = listUsers;
	}

	@Init
	public void init() {
		restartForm();
	}

	@Command
	public void restartForm() {
		listUsers = generateListStatus();
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}

	@Command
	public void edit(@BindingParam("user") SecurityUserStatus user) {
		user.setEditUser(!user.getEditUser());
		/*
		 * IMPORTANTE Solo actualizao una propiedad del objeto BUDGET, mas no
		 * todo el objeto
		 */
		BindUtils.postNotifyChange(null, null, user, "editUser");
	}

	@NotifyChange("changed")
	@Command
	public void save(@BindingParam("user") SecurityUserStatus user) {
		edit(user);
		/*
		 * Al modificar un objeto persistente en la base de datos, este primero
		 * debe almacenarse en una variable local, para que hibernate no detecte
		 * dos sesiones abiertas.
		 */
		SecurityUser securityUser = user.getUser();
		ShaEncoding encoding = new ShaEncoding(securityUser.getPassword());
		try {
			securityUser.setPassword(encoding.encodingPassword());
		} catch (NoSuchAlgorithmException e) {
			Clients.showNotification("No se pudo encriptar la contrase�a", "error", null, "end_center", 2000);
			e.printStackTrace();
			return;
		}
		/*
		 * IMPORTANTE Solo actualizao una propiedad del objeto BUDGET, mas no
		 * todo el objeto
		 */
		BindUtils.postNotifyChange(null, null, user, "editUser");
		if (!serviceSecurityUser.save(securityUser)) {
			user.setModified(false);
			return;
		}
		user.setModified(true);
	}

	@Command
	public void changed(@BindingParam("Component") Component component, @BindingParam("user") SecurityUserStatus user) {
		if (user.getModified() != null)
			if (user.getModified()) {
				Clients.showNotification("Guardado", "info", component, "end_center", 2000);
				user.setModified(null);
			} else if (!user.getModified()) {
				Clients.showNotification("No pudo guardar", "error", component, "end_center", 2000);
				user.setModified(null);
			}
	}

	public List<SecurityUserStatus> generateListStatus() {
		List<SecurityUser> listUser = serviceSecurityUser.listAll();
		List<SecurityUserStatus> listUserStatus = new ArrayList<SecurityUserStatus>();
		for (SecurityUser securityUser : listUser) {
			listUserStatus.add(new SecurityUserStatus(securityUser, false));
		}
		return listUserStatus;
	}

	@Command
	public void addUser() {
		Executions.createComponents("system/usuarios/frmAddUser.zul", null, null);
	}

	@NotifyChange("listUsers")
	@GlobalCommand
	public void userAdded() {
		listUsers = generateListStatus();
	}
}