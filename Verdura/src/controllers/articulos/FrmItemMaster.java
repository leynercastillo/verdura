package controllers.articulos;

import general.ValidateZK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import models.TbasicData;
import models.TinputMeasureUnit;
import models.Titem;
import models.ToutputMeasureUnit;
import models.service.ServiceBasicData;
import models.service.ServiceIntputMeasureUnit;
import models.service.ServiceItem;
import models.service.ServiceOutputMeasureUnit;

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
import org.zkoss.zul.Tab;
import org.zkoss.zul.impl.InputElement;

public class FrmItemMaster {

	@WireVariable
	private ServiceItem serviceItem;
	@WireVariable
	private ServiceBasicData serviceBasicData;
	@WireVariable
	private ServiceOutputMeasureUnit serviceOutputMeasureUnit;
	@WireVariable
	private ServiceIntputMeasureUnit serviceIntputMeasureUnit;

	private String minCombo;
	private String seleccione;
	private Boolean disableAll;
	private Boolean disableBeforeSearch;
	private Titem item;
	private Boolean update;
	private TbasicData selectedInputMeasureUnit;
	private TbasicData selectedOutputMeasureUnit;
	private List<TbasicData> listItemType;
	private List<TbasicData> listMeasureUnit;
	private List<TinputMeasureUnit> listDeleteInputMeasureUnit;
	private List<ToutputMeasureUnit> listDeleteOutputMeasureUnit;

	public List<TbasicData> getListMeasureUnit() {
		return listMeasureUnit;
	}

	public void setListMeasureUnit(List<TbasicData> listMeasureUnit) {
		this.listMeasureUnit = listMeasureUnit;
	}

	public TbasicData getSelectedInputMeasureUnit() {
		return selectedInputMeasureUnit;
	}

	public void setSelectedInputMeasureUnit(TbasicData selectedInputMeasureUnit) {
		this.selectedInputMeasureUnit = selectedInputMeasureUnit;
	}

	public TbasicData getSelectedOutputMeasureUnit() {
		return selectedOutputMeasureUnit;
	}

	public void setSelectedOutputMeasureUnit(TbasicData selectedOutputMeasureUnit) {
		this.selectedOutputMeasureUnit = selectedOutputMeasureUnit;
	}

	public Boolean getDisableBeforeSearch() {
		return disableBeforeSearch;
	}

	public void setDisableBeforeSearch(Boolean disableBeforeSearch) {
		this.disableBeforeSearch = disableBeforeSearch;
	}

	public List<TbasicData> getListItemType() {
		return listItemType;
	}

	public void setListItemType(List<TbasicData> listItemType) {
		this.listItemType = listItemType;
	}

	public String getMinCombo() {
		return minCombo;
	}

	public void setMinCombo(String minCombo) {
		this.minCombo = minCombo;
	}

	public String getSeleccione() {
		return seleccione;
	}

	public void setSeleccione(String seleccione) {
		this.seleccione = seleccione;
	}

	public Boolean getUpdate() {
		return update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	public Boolean getDisableAll() {
		return disableAll;
	}

	public void setDisableAll(Boolean disableAll) {
		this.disableAll = disableAll;
	}

	public Titem getItem() {
		return item;
	}

	public void setItem(Titem item) {
		this.item = item;
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	public Validator getNoEmptyInt() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				Tab tab = (Tab) ctx.getBindContext().getValidatorArg("tab");
				String string = inputElement.getText();
				if (string.trim().isEmpty()) {
					tab.setSelected(true);
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
				}
			}
		};
	}

	public Validator getNoDash() {
		return new ValidateZK().getNoDash();
	}

	public Validator getNoSelect() {
		return new ValidateZK().getNoSelect();
	}

	public Validator getNoRepeatCode() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				String str = null;
				Titem auxItem = serviceItem.findByCode(string);
				if (auxItem != null && !update)
					str = auxItem.getCode();
				if (string.isEmpty())
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
				if (string.equalsIgnoreCase(str))
					throw new WrongValueException(inputElement, "Este codigo ya se encuentra registrado en el sistema.");
			}
		};
	}

	public Validator getNoAddedOutput() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (item.getToutputMeasureUnits().size() == 1) {
					throw new WrongValueException(inputElement, "Se puede añadir maximo una unidad de salida.");
				}
				if (string.isEmpty() || string.equals("--Seleccione--")) {
					throw new WrongValueException(inputElement, "Seleccione una opcion valida.");
				}
				for (ToutputMeasureUnit outputMeasureUnit : item.getToutputMeasureUnits()) {
					if (outputMeasureUnit.getTbasicData().getName().equals(string)) {
						throw new WrongValueException(inputElement, "Esta unidad ya fue añadida.");
					}
				}
			}
		};
	}

	public Validator getNoAddedInput() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.isEmpty() || string.equals("--Seleccione--")) {
					throw new WrongValueException(inputElement, "Seleccione una opcion valida.");
				}
				for (TinputMeasureUnit inputMeasureUnit : item.getTinputMeasureUnits()) {
					if (inputMeasureUnit.getTbasicData().getName().equals(string)) {
						throw new WrongValueException(inputElement, "Esta unidad ya fue añadida.");
					}
				}
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
		item = new Titem();
		item.setWashable(new Boolean(false));
		// Default inputMeasureUnit and outputMeasureUnit
		item.setTinputMeasureUnits(new HashSet<TinputMeasureUnit>(defaultInputMeasuresUnit()));
		item.setToutputMeasureUnits(new HashSet<ToutputMeasureUnit>(defaultOutputMeasuresUnit()));
		minCombo = new String("--");
		seleccione = new String("--Seleccione--");
		disableAll = false;
		disableBeforeSearch = true;
		update = false;
		item.setStatus('A');
		listMeasureUnit = serviceBasicData.listMeasureUnit();
		selectedInputMeasureUnit = new TbasicData();
		selectedOutputMeasureUnit = new TbasicData();
		listItemType = serviceBasicData.listItemType();
		listDeleteInputMeasureUnit = new ArrayList<TinputMeasureUnit>();
		listDeleteOutputMeasureUnit = new ArrayList<ToutputMeasureUnit>();
	}

	@NotifyChange("*")
	@Command
	public void save() {
		if (!update) {
			if (!serviceItem.save(item)) {
				Clients.showNotification("Fallo guardado articulo", "error", null, "middle_center", 2000);
				return;
			}
		}
		// ELIMINAR ESTO EN EL FUTURO PARA OPTIMIZAR
		else if (!serviceItem.save(item)) {
			Clients.showNotification("Fallo guardado articulo", "error", null, "middle_center", 2000);
			return;
		}
		for (ToutputMeasureUnit measureUnit : item.getToutputMeasureUnits()) {
			measureUnit.setTitem(item);
			if (!serviceOutputMeasureUnit.save(measureUnit)) {
				Clients.showNotification("Fallo guardado articulo", "error", null, "middle_center", 2000);
				return;
			}
		}
		for (ToutputMeasureUnit measureUnit : listDeleteOutputMeasureUnit) {
			if (measureUnit.getIdOutputMeasureUnit() != 0) {
				if (!serviceOutputMeasureUnit.delete(measureUnit)) {
					Clients.showNotification("Fallo guardado articulo", "error", null, "middle_center", 2000);
					return;
				}
			}
		}
		for (TinputMeasureUnit measureUnit : item.getTinputMeasureUnits()) {
			measureUnit.setTitem(item);
			if (!serviceIntputMeasureUnit.save(measureUnit)) {
				Clients.showNotification("Fallo guardado articulo", "error", null, "middle_center", 2000);
				return;
			}
		}
		for (TinputMeasureUnit measureUnit : listDeleteInputMeasureUnit) {
			if (measureUnit.getIdInputMeasureUnit() != 0) {
				if (!serviceIntputMeasureUnit.delete(measureUnit)) {
					Clients.showNotification("Fallo guardado articulo", "error", null, "middle_center", 2000);
					return;
				}
			}
		}
		Clients.showNotification("Articulo guardado correctamente", "info", null, "middle_center", 2000);
		restartForm();
	}

	@NotifyChange({ "*" })
	@Command
	public void search() {
		Executions.createComponents("system/articulos/frmItemSearch.zul", null, null);
	}

	@NotifyChange({ "selectedOutputMeasureUnit" })
	@Command
	public void addOutputUnitMeasure() {
		ToutputMeasureUnit outputMeasureUnit = new ToutputMeasureUnit();
		outputMeasureUnit.setStatus('A');
		outputMeasureUnit.setTbasicData(selectedOutputMeasureUnit);
		outputMeasureUnit.setWeightUnit(0);
		item.getToutputMeasureUnits().add(outputMeasureUnit);
		selectedOutputMeasureUnit = new TbasicData();
		BindUtils.postNotifyChange(null, null, item, "toutputMeasureUnits");
	}

	@NotifyChange({ "selectedInputMeasureUnit" })
	@Command
	public void addInputUnitMeasure() {
		TinputMeasureUnit inputMeasureUnit = new TinputMeasureUnit();
		inputMeasureUnit.setStatus('A');
		inputMeasureUnit.setTbasicData(selectedInputMeasureUnit);
		inputMeasureUnit.setWeightUnit(0);
		item.getTinputMeasureUnits().add(inputMeasureUnit);
		selectedInputMeasureUnit = new TbasicData();
		BindUtils.postNotifyChange(null, null, item, "tinputMeasureUnits");
	}

	@Command
	public void deleteOutputUnitMeasure(@BindingParam("measureUnit") ToutputMeasureUnit outputMeasureUnit) {
		item.getToutputMeasureUnits().remove(outputMeasureUnit);
		listDeleteOutputMeasureUnit.add(outputMeasureUnit);
		BindUtils.postNotifyChange(null, null, item, "toutputMeasureUnits");
	}

	@NotifyChange({ "listInputMeasureUnit" })
	@Command
	public void deleteInputUnitMeasure(@BindingParam("measureUnit") TinputMeasureUnit inputMeasureUnit) {
		item.getTinputMeasureUnits().remove(inputMeasureUnit);
		listDeleteInputMeasureUnit.add(inputMeasureUnit);
		BindUtils.postNotifyChange(null, null, item, "tinputMeasureUnits");
	}

	@NotifyChange({ "item", "disableAll", "update" })
	@GlobalCommand
	public void selectedItem(@BindingParam("item") Titem selectedItem) {
		item = new Titem();
		item = selectedItem;
		item.setToutputMeasureUnits(new HashSet<ToutputMeasureUnit>(serviceOutputMeasureUnit.listByItem(item)));
		item.setTinputMeasureUnits(new HashSet<TinputMeasureUnit>(serviceIntputMeasureUnit.listByItem(item)));
		disableAll = false;
		update = true;
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}

	public List<TinputMeasureUnit> defaultInputMeasuresUnit() {
		List<TbasicData> auxListMeasureUnits = serviceBasicData.listMeasureUnit();
		List<TinputMeasureUnit> listMeasureUnits = new ArrayList<TinputMeasureUnit>();
		for (TbasicData measureUnit : auxListMeasureUnits) {
			if (measureUnit.getName().equals("CESTA") || measureUnit.getName().equals("MEDIA CESTA")) {
				TinputMeasureUnit inpuMeasureUnit = new TinputMeasureUnit();
				inpuMeasureUnit.setStatus('A');
				inpuMeasureUnit.setTbasicData(measureUnit);
				inpuMeasureUnit.setWeightUnit(0);
				inpuMeasureUnit.setTitem(item);
				listMeasureUnits.add(inpuMeasureUnit);
			}
		}
		return listMeasureUnits;
	}

	public List<ToutputMeasureUnit> defaultOutputMeasuresUnit() {
		List<TbasicData> auxListMeasureUnits = serviceBasicData.listMeasureUnit();
		List<ToutputMeasureUnit> listMeasureUnits = new ArrayList<ToutputMeasureUnit>();
		for (TbasicData measureUnit : auxListMeasureUnits) {
			if (measureUnit.getName().equals("MEDIA CESTA")) {
				ToutputMeasureUnit outputMeasureUnit = new ToutputMeasureUnit();
				outputMeasureUnit.setStatus('A');
				outputMeasureUnit.setTbasicData(measureUnit);
				outputMeasureUnit.setWeightUnit(0);
				outputMeasureUnit.setTitem(item);
				listMeasureUnits.add(outputMeasureUnit);
			}
		}
		return listMeasureUnits;
	}
}