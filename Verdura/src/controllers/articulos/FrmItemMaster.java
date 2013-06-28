package controllers.articulos;

import general.ValidateZK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.TbasicData;
import models.Titem;

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
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Tab;
import org.zkoss.zul.impl.InputElement;

import dao.DaoBasicData;
import dao.DaoDataType;
import dao.DaoItem;

public class FrmItemMaster {

    @WireVariable
    private DaoItem daoItem;
    @WireVariable
    private DaoBasicData daoBasicData;
    @WireVariable
    private DaoDataType daoDataType;

    private String minCombo;
    private String seleccione;
    private Boolean disableAll;
    private Boolean disableBeforeSearch;
    private Titem item;
    private Boolean update;
    private ListModel<String> listItemCode;
    private ListModel<String> listItemName;
    private List<TbasicData> listUnitCar;
    private List<TbasicData> listItemType;

    public Boolean getDisableBeforeSearch() {
	return disableBeforeSearch;
    }

    public void setDisableBeforeSearch(Boolean disableBeforeSearch) {
	this.disableBeforeSearch = disableBeforeSearch;
    }

    public ListModel<String> getListItemName() {
	return listItemName;
    }

    public void setListItemName(ListModel<String> listItemName) {
	this.listItemName = listItemName;
    }

    public List<TbasicData> getListItemType() {
	return listItemType;
    }

    public void setListItemType(List<TbasicData> listItemType) {
	this.listItemType = listItemType;
    }

    public List<TbasicData> getListUnitCar() {
	return listUnitCar;
    }

    public void setListUnitCar(List<TbasicData> listUnitCar) {
	this.listUnitCar = listUnitCar;
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

    public ListModel<String> getListItemCode() {
	return listItemCode;
    }

    public void setListItemCode(ListModel<String> listItemCode) {
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
		Titem auxItem = daoItem.findByCode(string);
		if (auxItem != null && !update)
		    str = auxItem.getCode();
		if (string.isEmpty())
		    throw new WrongValueException(inputElement, "Ingrese un dato valido.");
		if (string.equalsIgnoreCase(str))
		    throw new WrongValueException(inputElement, "Este codigo ya se encuentra registrado en el sistema.");
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
	listItemCode = new ListModelList<String>();
	listItemName = new ListModelList<String>();
	listUnitCar = daoBasicData.listByDataType(daoDataType.findByName("UNIT MEASURE"));
	listItemType = daoBasicData.listByDataType(daoDataType.findByName("ITEM TYPE"));
    }

    @NotifyChange({ "listItemCode", "listItemName" })
    @Command
    public void searchItemByField(@BindingParam("field") String field) {
	if (field.compareTo("code") == 0) {
	    listItemCode = new SimpleListModel<String>(daoItem.listStringByFields(field));
	    return;
	} else if (field.compareTo("name") == 0) {
	    listItemName = new SimpleListModel<String>(daoItem.listStringByFields(field));
	    return;
	}
    }

    @NotifyChange({ "item", "disableAll", "update", "listItem" })
    @Command
    public void loadItem(@BindingParam("field") String field, @BindingParam("val") String value) {
	List<Titem> listItemAux = daoItem.listByString(field, value);
	int listSize = listItemAux.size();
	if (listSize == 1) {
	    item = new Titem();
	    item = listItemAux.get(0);
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
	    if (!daoItem.save(item)) {
		Clients.showNotification("Fallo guardado articulo", "error", null, "middle_center", 2000);
		return;
	    }
	} else if (!daoItem.update(item)) {
	    Clients.showNotification("Fallo actualizacion articulo", "error", null, "middle_center", 2000);
	    return;
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
}