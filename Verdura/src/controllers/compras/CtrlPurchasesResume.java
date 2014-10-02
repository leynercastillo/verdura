package controllers.compras;

import general.GenericReport;
import general.SimpleListModelCustom;

import java.util.HashMap;
import java.util.Map;

import models.TorderNumber;
import models.service.ServiceOrderNumber;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.impl.InputElement;

public class CtrlPurchasesResume {

	@WireVariable
	private ServiceOrderNumber serviceOrderNumber;
	private ListModel<Object> listOrderNumber;
	private TorderNumber orderNumber;

	public TorderNumber getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(TorderNumber orderNumber) {
		this.orderNumber = orderNumber;
	}

	public ListModel<Object> getListOrderNumber() {
		return listOrderNumber;
	}

	public void setListOrderNumber(ListModel<Object> listOrderNumber) {
		this.listOrderNumber = listOrderNumber;
	}

	public Validator getNoEmpty() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.isEmpty()) {
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
				} else if (string.equals("0"))
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
			}
		};
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange({ "*" })
	@Command
	public void restartForm() {
		orderNumber = new TorderNumber();
		listOrderNumber = new ListModelList<Object>();
	}

	@NotifyChange({ "listOrderNumber" })
	@Command
	public void searchOrderNumber() {
		listOrderNumber = new SimpleListModelCustom<Object>(serviceOrderNumber.listNumber());
	}

	@NotifyChange({ "*" })
	@Command
	public void generate(@BindingParam("val") String value) {
		if (value.isEmpty())
			value = "0";
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {
				value = "0";
				break;
			}
		}
		Integer number = Integer.parseInt(value);
		TorderNumber auxOrderNumber = serviceOrderNumber.findByNumber(number);
		if (auxOrderNumber != null) {
			this.orderNumber = auxOrderNumber;
			GenericReport report = new GenericReport();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("IMAGES_DIR", "../../resource/images/system/");
			map.put("ORDER_NUMBER", orderNumber.getIdOrderNumber());
			report.createPdf("/resource/reports/orders/", "resumePurchases.jasper", map, "resumen-compra.pdf");
			report.viewPdf("/resource/reports/orders/resumen-compra.pdf", "Resumen compras");
		} else {
			Clients.showNotification("Ningun registro coincide", "info", null, "middle_center", 2000);
		}
	}
	
	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}
