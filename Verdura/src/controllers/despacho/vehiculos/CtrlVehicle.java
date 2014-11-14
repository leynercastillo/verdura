package controllers.despacho.vehiculos;

import general.SimpleListModelCustom;
import general.ValidateZK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.TbasicData;
import models.Tvehicle;
import models.service.ServiceBasicData;
import models.service.ServiceVehicle;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.impl.InputElement;

public class CtrlVehicle {

	@WireVariable
	private ServiceVehicle serviceVehicle;
	@WireVariable
	private ServiceBasicData serviceBasicData;

	private Tvehicle vehicle;
	private Boolean disableAll;
	private String seleccione;
	private ListModel<Object> listVehicleDocNum;
	private ListModel<Object> listVehicleModel;
	private ListModel<Object> listVehicleOwner;
	private List<TbasicData> listMeasureUnit;

	public ListModel<Object> getListVehicleOwner() {
		return listVehicleOwner;
	}

	public void setListVehicleOwner(ListModel<Object> listVehicleOwner) {
		this.listVehicleOwner = listVehicleOwner;
	}

	public String getSeleccione() {
		return seleccione;
	}

	public void setSeleccione(String seleccione) {
		this.seleccione = seleccione;
	}

	public List<TbasicData> getListMeasureUnit() {
		return listMeasureUnit;
	}

	public void setListMeasureUnit(List<TbasicData> listMeasureUnit) {
		this.listMeasureUnit = listMeasureUnit;
	}

	public ListModel<Object> getListVehicleModel() {
		return listVehicleModel;
	}

	public void setListVehicleModel(ListModel<Object> listVehicleModel) {
		this.listVehicleModel = listVehicleModel;
	}

	public Tvehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Tvehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ListModel<Object> getListVehicleDocNum() {
		return listVehicleDocNum;
	}

	public void setListVehicleDocNum(ListModel<Object> listVehicleDocNum) {
		this.listVehicleDocNum = listVehicleDocNum;
	}

	public Boolean getDisableAll() {
		return disableAll;
	}

	public void setDisableAll(Boolean disableAll) {
		this.disableAll = disableAll;
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	public Validator getNoSelectInTab() {
		return new ValidateZK().getNoSelectInTab();
	}

	public Validator getNoEmptyInTab() {
		return new ValidateZK().getNoEmptyInTab();
	}

	public Validator getNoRepeatDocNum() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				Tvehicle auxVehicle = serviceVehicle.findByDocNum(string);
				if (string.isEmpty()) {
					throw new WrongValueException(inputElement, "Ingrese una placa valida.");
				} else if (auxVehicle != null && auxVehicle.getIdVehicle() != vehicle.getIdVehicle()) {
					throw new WrongValueException(inputElement, "Esta placa ya se encuentra registrada en el sistema.");
				}
			}
		};
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		vehicle = new Tvehicle();
		vehicle.setStatus('A');
		listVehicleDocNum = new ListModelList<Object>();
		listVehicleModel = new ListModelList<Object>();
		listVehicleOwner = new ListModelList<Object>();
		listMeasureUnit = serviceBasicData.listMeasureUnit();
		seleccione = "--Seleccione--";
		disableAll = false;
	}

	@NotifyChange({ "vehicle", "disableAll" })
	@Command
	public void loadVehicle(@BindingParam("field") String field, @BindingParam("val") String value) {
		List<Tvehicle> list = new ArrayList<Tvehicle>();
		if (field.compareTo("docNum") == 0)
			list = serviceVehicle.listByDocNum(value);
		else if (field.compareTo("model") == 0)
			list = serviceVehicle.listByModel(value);
		else if (field.compareTo("owner") == 0)
			list = serviceVehicle.listByOwner(value);
		int listSize = list.size();
		if (listSize == 1) {
			vehicle = new Tvehicle();
			vehicle = list.get(0);
			disableAll = true;
			return;
		} else if (listSize == 0) {
			Clients.showNotification("Ningun registro coincide", "error", null, "middle_center", 2000);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("listVehicles", list);
			Executions.createComponents("system/despacho/vehiculos/frmVehicleList.zul", null, map);
		}
	}

	@NotifyChange({ "listVehicleDocNum", "listVehicleModel", "listVehicleOwner" })
	@Command
	public void searchVehicleByField(@BindingParam("field") String field) {
		if (field.compareTo("docNum") == 0) {
			listVehicleDocNum = new SimpleListModelCustom<Object>(serviceVehicle.listDocNum());
		} else if (field.compareTo("model") == 0) {
			listVehicleModel = new SimpleListModelCustom<Object>(serviceVehicle.listModel());
		} else if (field.compareTo("owner") == 0) {
			listVehicleOwner = new SimpleListModelCustom<Object>(serviceVehicle.listOwner());
		}
	}

	@NotifyChange("*")
	@Command
	public void save() {
		if (!serviceVehicle.save(vehicle)) {
			Clients.showNotification("El vehiculo no pudo ser guardado.", "error", null, "middle_center", 2000);
			return;
		}
		Clients.showNotification("Vehiculo guardado correctamente", "info", null, "middle_center", 2000);
		restartForm();
	}

	@Command
	public void search() {
		Executions.createComponents("system/despacho/vehiculos/frmSearchVehicle.zul", null, null);
	}

	@NotifyChange("disableAll")
	@Command
	public void edit() {
		disableAll = false;
	}

	@NotifyChange({ "vehicle", "disableAll" })
	@GlobalCommand
	public void selectedVehicle(@BindingParam("vehicle") Tvehicle selectedVehicle) {
		vehicle = new Tvehicle();
		vehicle = serviceVehicle.findByDocNum(selectedVehicle.getDocNum());
		disableAll = true;
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}
