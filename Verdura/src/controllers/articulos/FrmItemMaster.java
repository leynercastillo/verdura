package controllers.articulos;

import general.SimpleListModelCustom;
import general.ValidateZK;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
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
	private ListModel<Object> listItemCode;
	private ListModel<Object> listItemName;
	private List<TbasicData> listItemType;
	private List<TbasicData> listMeasureUnit;
	private List<TinputMeasureUnit> listInputMeasureUnit;
	private List<ToutputMeasureUnit> listOutputMeasureUnit;
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

	public List<TinputMeasureUnit> getListInputMeasureUnit() {
		return listInputMeasureUnit;
	}

	public void setListInputMeasureUnit(List<TinputMeasureUnit> listInputMeasureUnit) {
		this.listInputMeasureUnit = listInputMeasureUnit;
	}

	public List<ToutputMeasureUnit> getListOutputMeasureUnit() {
		return listOutputMeasureUnit;
	}

	public void setListOutputMeasureUnit(List<ToutputMeasureUnit> listOutputMeasureUnit) {
		this.listOutputMeasureUnit = listOutputMeasureUnit;
	}

	public Boolean getDisableBeforeSearch() {
		return disableBeforeSearch;
	}

	public void setDisableBeforeSearch(Boolean disableBeforeSearch) {
		this.disableBeforeSearch = disableBeforeSearch;
	}

	public ListModel<Object> getListItemName() {
		return listItemName;
	}

	public void setListItemName(ListModel<Object> listItemName) {
		this.listItemName = listItemName;
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

	public ListModel<Object> getListItemCode() {
		return listItemCode;
	}

	public void setListItemCode(ListModel<Object> listItemCode) {
		this.listItemCode = listItemCode;
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
				if (listOutputMeasureUnit.size() == 1) {
					throw new WrongValueException(inputElement, "Se puede añadir maximo una unidad de salida.");
				}
				if (string.isEmpty() || string.equals("--Seleccione--")) {
					throw new WrongValueException(inputElement, "Seleccione una opcion valida.");
				}
				for (ToutputMeasureUnit outputMeasureUnit : listOutputMeasureUnit) {
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
				for (TinputMeasureUnit inputMeasureUnit : listInputMeasureUnit) {
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
		minCombo = new String("--");
		seleccione = new String("--Seleccione--");
		disableAll = new Boolean(false);
		disableBeforeSearch = new Boolean(true);
		update = new Boolean(false);
		item.setStatus('A');
		listItemCode = new ListModelList<Object>();
		listItemName = new ListModelList<Object>();
		listMeasureUnit = serviceBasicData.listMeasureUnit();
		selectedInputMeasureUnit = new TbasicData();
		selectedOutputMeasureUnit = new TbasicData();
		listItemType = serviceBasicData.listItemType();
		listDeleteInputMeasureUnit = new ArrayList<TinputMeasureUnit>();
		listDeleteOutputMeasureUnit = new ArrayList<ToutputMeasureUnit>();
		// Default inputMeasureUnit
		listInputMeasureUnit = new ArrayList<TinputMeasureUnit>(defaultInputMeasuresUnit());
		listOutputMeasureUnit = new ArrayList<ToutputMeasureUnit>(defaultOutputMeasuresUnit());
	}

	@NotifyChange({ "listItemCode", "listItemName" })
	@Command
	public void searchItemByField(@BindingParam("field") String field) {
		if (field.equals("code")) {
			listItemCode = new SimpleListModelCustom<Object>(serviceItem.listCodes());
			return;
		} else if (field.equals("name")) {
			listItemName = new SimpleListModelCustom<Object>(serviceItem.listNames());
			return;
		}
	}

	@NotifyChange({ "item", "disableAll", "update", "listItem", "listInputMeasureUnit", "listOutputMeasureUnit" })
	@Command
	public void loadItem(@BindingParam("field") String field, @BindingParam("val") String value) {
		List<Titem> listItemAux = new ArrayList<Titem>();
		if (field.equals("code")) {
			Titem itemAux = serviceItem.findByCode(value);
			if (itemAux != null) {
				listItemAux.add(itemAux);
			}
		} else if (field.equals("name")) {
			listItemAux = serviceItem.listByName(value);
		}
		int listSize = listItemAux.size();
		if (listSize == 1) {
			item = new Titem();
			item = listItemAux.get(0);
			listInputMeasureUnit = new ArrayList<TinputMeasureUnit>(item.getTinputMeasureUnits());
			listOutputMeasureUnit = new ArrayList<ToutputMeasureUnit>(item.getToutputMeasureUnits());
			disableAll = new Boolean(false);
			update = new Boolean(true);
			return;
		} else if (listSize == 0) {
			Clients.showNotification("Ningun registro coincide", "info", null, "top_center", 2000);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("listItem", listItemAux);
			Executions.createComponents("system/articulos/frmItemList.zul", null, map);
		}
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
		for (ToutputMeasureUnit measureUnit : listOutputMeasureUnit) {
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
		for (TinputMeasureUnit measureUnit : listInputMeasureUnit) {
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
		restartForm();
		disableAll = new Boolean(true);
		disableBeforeSearch = new Boolean(false);
	}

	@NotifyChange({ "listOutputMeasureUnit", "selectedOutputMeasureUnit" })
	@Command
	public void addOutputUnitMeasure() {
		ToutputMeasureUnit outputMeasureUnit = new ToutputMeasureUnit();
		outputMeasureUnit.setStatus('A');
		outputMeasureUnit.setTbasicData(selectedOutputMeasureUnit);
		outputMeasureUnit.setWeightUnit(0);
		listOutputMeasureUnit.add(outputMeasureUnit);
		selectedOutputMeasureUnit = new TbasicData();
	}

	@NotifyChange({ "listInputMeasureUnit", "selectedInputMeasureUnit" })
	@Command
	public void addInputUnitMeasure() {
		TinputMeasureUnit inputMeasureUnit = new TinputMeasureUnit();
		inputMeasureUnit.setStatus('A');
		inputMeasureUnit.setTbasicData(selectedInputMeasureUnit);
		inputMeasureUnit.setWeightUnit(0);
		listInputMeasureUnit.add(inputMeasureUnit);
		selectedInputMeasureUnit = new TbasicData();
	}

	@NotifyChange({ "listOutputMeasureUnit" })
	@Command
	public void deleteOutputUnitMeasure(@BindingParam("measureUnit") ToutputMeasureUnit outputMeasureUnit) {
		listOutputMeasureUnit.remove(outputMeasureUnit);
		listDeleteOutputMeasureUnit.add(outputMeasureUnit);
	}

	@NotifyChange({ "listInputMeasureUnit" })
	@Command
	public void deleteInputUnitMeasure(@BindingParam("measureUnit") TinputMeasureUnit inputMeasureUnit) {
		listInputMeasureUnit.remove(inputMeasureUnit);
		listDeleteInputMeasureUnit.add(inputMeasureUnit);
	}

	@NotifyChange({ "item", "disableAll", "update" })
	@GlobalCommand
	public void selectedItem(@BindingParam("item") Titem selectedItem) {
		item = new Titem();
		item = selectedItem;
		disableAll = new Boolean(false);
		update = new Boolean(true);
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