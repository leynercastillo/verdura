package general;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Tab;
import org.zkoss.zul.impl.InputElement;

public class ValidateZK {

	/**
	 * Metodo que valida que un componente ZK no este vacio.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoEmpty() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.isEmpty()) {
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un string sea un Email valido. Solo aplica para
	 * componentes ZK
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoEmail() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.isEmpty() || !string.matches(".+@.+\\.[a-zA-Z]+")) {
					throw new WrongValueException(inputElement, "Ingrese una direccion de correo valida.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un combobox small no tenga seleccionado la opcion
	 * por defecto del sistema '--'.
	 * 
	 * Solo aplica para componentes ZK
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoDash() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.isEmpty() || string.equals("--")) {
					throw new WrongValueException(inputElement, "Seleccione una opcion valida.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un combobox no tenga seleccionado la opción por
	 * defecto del sistema '--Seleccione--'.
	 * 
	 * Solo aplica para componentes ZK.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoSelect() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.isEmpty() || string.equals("--Seleccione--")) {
					throw new WrongValueException(inputElement, "Seleccione una opcion valida.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un combobox no tenga seleccionado la opción por
	 * defecto del sistema '--Seleccione--', y ademas este dentro de un tab no
	 * activo.
	 * 
	 * Solo aplica para componentes ZK.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoSelectInTab() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				Tab tab = (Tab) ctx.getBindContext().getValidatorArg("tab");
				String string = inputElement.getText();
				if (string.trim().isEmpty() || string.equals("--Seleccione--")) {
					tab.setSelected(true);
					throw new WrongValueException(inputElement, "Seleccione una opcion valida.");
					// Clients.showNotification("Seleccione una opcion valida.",
					// "error", inputElement, "end_center", -1);
					// ctx.setInvalid();
				}
			}
		};
	}

	/**
	 * Metodo que valida que un componente ZK no este vacio, y ademas se
	 * encuentre dentro de un tabbox > tabs > tab
	 * 
	 * @return
	 */
	public Validator getNoEmptyInTab() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				Tab tab = (Tab) ctx.getBindContext().getValidatorArg("tab");
				String string = inputElement.getText();
				if (string.trim().isEmpty()) {
					tab.setSelected(true);
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
					// Clients.showNotification("Ingrese un dato valido.",
					// "error", inputElement, "end_center", -1);
					// ctx.setInvalid();
				}
			}
		};
	}
}
