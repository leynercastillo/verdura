package controllers.socios;

import general.ValidateZK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import models.TbasicData;
import models.TbusinessPartner;
import models.TbusinessPartnerBranch;
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
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.impl.InputElement;

import dao.DaoBasicData;
import dao.DaoBusinessPartner;
import dao.DaoBusinessPartnerBranch;
import dao.DaoDataType;
import dao.DaoItem;

public class FrmBusinessPartnerMaster {

    @WireVariable
    private DaoBasicData daoBasicData;
    @WireVariable
    private DaoDataType daoDataType;
    @WireVariable
    private DaoBusinessPartner daoBusinessPartner;
    @WireVariable
    private DaoBusinessPartnerBranch daoBusinessPartnerBranch;
    @WireVariable
    private DaoItem daoItem;

    private String minCombo;
    private String seleccione;
    private String seleccione2;
    private Boolean disableAll;
    private Boolean disableDelAddress;
    private Boolean disableDelItem;
    private Boolean update;
    private TbusinessPartner businessPartner;
    private TbusinessPartnerBranch businessPartnerBranch;
    private Titem item;
    private TbasicData stateSelected;
    private TbasicData countrySelected;
    private List<TbasicData> listCountries;
    private List<TbasicData> listStates;
    private List<TbasicData> listRifType;
    private List<TbasicData> listCities;
    private List<TbasicData> listBusinessPartnerType;
    private ListModel<String> listBusinessPartnerName;
    private ListModel<String> listBusinessPartnerRif;
    private ListModel<String> listItem;
    private List<TbusinessPartnerBranch> listBusinessPartnerBranch;
    private List<TbusinessPartnerBranch> listBusinessPartnerBranchForDelete;
    private List<Titem> listItemByBusinessPartner;
    private List<Titem> listItemByBusinessPartnerForDelete;

    public ListModel<String> getListItem() {
	return listItem;
    }

    public void setListItem(ListModel<String> listItem) {
	this.listItem = listItem;
    }

    public Boolean getDisableDelItem() {
	return disableDelItem;
    }

    public void setDisableDelItem(Boolean disableDelItem) {
	this.disableDelItem = disableDelItem;
    }

    public Titem getItem() {
	return item;
    }

    public void setItem(Titem item) {
	this.item = item;
    }

    public List<Titem> getListItemByBusinessPartner() {
	return listItemByBusinessPartner;
    }

    public void setListItemByBusinessPartner(List<Titem> listItemByBusinessPartner) {
	this.listItemByBusinessPartner = listItemByBusinessPartner;
    }

    public ListModel<String> getListBusinessPartnerRif() {
	return listBusinessPartnerRif;
    }

    public void setListBusinessPartnerRif(ListModel<String> listBusinessPartnerRif) {
	this.listBusinessPartnerRif = listBusinessPartnerRif;
    }

    public ListModel<String> getListBusinessPartnerName() {
	return listBusinessPartnerName;
    }

    public void setListBusinessPartnerName(ListModel<String> listBusinessPartnerName) {
	this.listBusinessPartnerName = listBusinessPartnerName;
    }

    public Boolean getDisableDelAddress() {
	return disableDelAddress;
    }

    public void setDisableDelAddress(Boolean disableDelAddress) {
	this.disableDelAddress = disableDelAddress;
    }

    public TbasicData getStateSelected() {
	return stateSelected;
    }

    public void setStateSelected(TbasicData stateSelected) {
	this.stateSelected = stateSelected;
    }

    public TbasicData getCountrySelected() {
	return countrySelected;
    }

    public void setCountrySelected(TbasicData countrySelected) {
	this.countrySelected = countrySelected;
    }

    public List<TbasicData> getListCountries() {
	return listCountries;
    }

    public void setListCountries(List<TbasicData> listCountries) {
	this.listCountries = listCountries;
    }

    public List<TbasicData> getListStates() {
	return listStates;
    }

    public void setListStates(List<TbasicData> listStates) {
	this.listStates = listStates;
    }

    public List<TbasicData> getListRifType() {
	return listRifType;
    }

    public void setListRifType(List<TbasicData> listRifType) {
	this.listRifType = listRifType;
    }

    public List<TbasicData> getListCities() {
	return listCities;
    }

    public void setListCities(List<TbasicData> listCities) {
	this.listCities = listCities;
    }

    public List<TbasicData> getListBusinessPartnerType() {
	return listBusinessPartnerType;
    }

    public void setListBusinessPartnerType(List<TbasicData> listBusinessPartnerType) {
	this.listBusinessPartnerType = listBusinessPartnerType;
    }

    public List<TbusinessPartnerBranch> getListBusinessPartnerBranch() {
	return listBusinessPartnerBranch;
    }

    public void setListBusinessPartnerBranch(List<TbusinessPartnerBranch> listBusinessPartnerBranch) {
	this.listBusinessPartnerBranch = listBusinessPartnerBranch;
    }

    public Boolean getUpdate() {
	return update;
    }

    public void setUpdate(Boolean update) {
	this.update = update;
    }

    public String getSeleccione2() {
	return seleccione2;
    }

    public void setSeleccione2(String seleccione2) {
	this.seleccione2 = seleccione2;
    }

    public TbusinessPartnerBranch getBusinessPartnerBranch() {
	return businessPartnerBranch;
    }

    public void setBusinessPartnerBranch(TbusinessPartnerBranch businessPartnerBranch) {
	this.businessPartnerBranch = businessPartnerBranch;
    }

    public TbusinessPartner getBusinessPartner() {
	return businessPartner;
    }

    public void setBusinessPartner(TbusinessPartner businessPartner) {
	this.businessPartner = businessPartner;
    }

    public String getSeleccione() {
	return seleccione;
    }

    public void setSeleccione(String seleccione) {
	this.seleccione = seleccione;
    }

    public String getMinCombo() {
	return minCombo;
    }

    public void setMinCombo(String minCombo) {
	this.minCombo = minCombo;
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

    public Validator getNoDash() {
	return new ValidateZK().getNoDash();
    }

    public Validator getNoSelect() {
	return new ValidateZK().getNoSelect();
    }

    public Validator getNoEmail() {
	return new ValidateZK().getNoEmail();
    }

    public Validator getNoRepeatRif() {
	return new AbstractValidator() {
	    @Override
	    public void validate(ValidationContext ctx) {
		InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
		String string = inputElement.getText();
		String str = null;
		TbusinessPartner auxBusinessPartner = daoBusinessPartner.findByRif(string, businessPartner.getTbasicDataByType());
		if (auxBusinessPartner != null && !update)
		    str = auxBusinessPartner.getRif();
		if (string.trim().isEmpty())
		    throw new WrongValueException(inputElement, "Ingrese un dato valido.");
		if (string.equals(str))
		    throw new WrongValueException(inputElement, "Este rif ya se encuentra registrado en el sistema.");
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
	businessPartner = new TbusinessPartner();
	businessPartnerBranch = new TbusinessPartnerBranch();
	item = new Titem();
	minCombo = new String("--");
	seleccione = new String("--Seleccione--");
	seleccione2 = new String("--Seleccione--");
	disableAll = new Boolean(false);
	disableDelAddress = new Boolean(true);
	disableDelItem = new Boolean(true);
	update = new Boolean(false);
	businessPartner.setStatus('A');
	listBusinessPartnerName = new ListModelList<String>();
	listBusinessPartnerRif = new ListModelList<String>();
	listItem = new ListModelList<String>();
	listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>();
	listItemByBusinessPartner = new ArrayList<Titem>();
	listBusinessPartnerBranchForDelete = new ArrayList<TbusinessPartnerBranch>();
	listItemByBusinessPartnerForDelete = new ArrayList<Titem>();
	listBusinessPartnerType = daoBasicData.listByDataType(daoDataType.findByName("BUSINESS PARTNER TYPE"));
	listRifType = daoBasicData.listByDataType(daoDataType.findByName("RIF TYPE"));
	listCountries = daoBasicData.listByDataType(daoDataType.findByName("COUNTRY"));
	listStates = new ArrayList<TbasicData>();
	listCities = new ArrayList<TbasicData>();
	stateSelected = new TbasicData();
	countrySelected = new TbasicData();
    }

    @NotifyChange({ "listStates", "listCities", "stateSelected" })
    @Command
    public void loadStatesByParent(@BindingParam("country") Object country) {
	countrySelected = (TbasicData) country;
	listStates = daoBasicData.listByParent(countrySelected);
	listCities = new ArrayList<TbasicData>();
	stateSelected = new TbasicData();
	businessPartnerBranch.setTbasicData(new TbasicData());
    }

    @NotifyChange("listCities")
    @Command
    public void loadCitiesByParent() {
	listCities = daoBasicData.listByParent(stateSelected);
	businessPartnerBranch.setTbasicData(new TbasicData());
    }

    @NotifyChange({ "businessPartnerBranch", "seleccione2", "listCities", "listStates", "countrySelected", "stateSelected", "listBusinessPartnerBranch", "disableDelAddress" })
    @Command
    public void addBranch() {
	if (listBusinessPartnerBranch.isEmpty())
	    businessPartnerBranch.setAddressDefault(true);
	int i = 0;
	Boolean found = false;
	for (TbusinessPartnerBranch bPB : listBusinessPartnerBranch) {
	    if (bPB.getName().compareTo(businessPartnerBranch.getName()) == 0) {
		businessPartnerBranch.setAddressDefault(bPB.isAddressDefault());
		listBusinessPartnerBranch.set(i, businessPartnerBranch);
		found = true;
		break;
	    }
	    i++;
	}
	if (!found)
	    listBusinessPartnerBranch.add(businessPartnerBranch);
	businessPartnerBranch = new TbusinessPartnerBranch();
	listCities = new ArrayList<TbasicData>();
	listStates = new ArrayList<TbasicData>();
	countrySelected = new TbasicData();
	stateSelected = new TbasicData();
	disableDelAddress = new Boolean(true);
	seleccione2 = "--Seleccione--";
    }

    @Command
    /*
     * Cuando se modifica un "listbox" que en el "model" posee una variable tipo "List", debe de notificarse primero ese
     * "List" antes que cualquier variable dentro del @notifychange. Ver
     * http://books.zkoss.org/wiki/ZK_Developer%27s_Reference/MVVM/ Data_Binding/Collection_and_Selection La seccion:
     * "Choose a Component's Model Type"
     */
    @NotifyChange({ "listBusinessPartnerBranch", "businessPartnerBranch", "listCities", "listStates", "countrySelected", "stateSelected", "seleccione2", "disableDelAddress" })
    public void deleteBranch() {
	Boolean wasDefault = new Boolean(false);
	for (Iterator<TbusinessPartnerBranch> iterator = listBusinessPartnerBranch.iterator(); iterator.hasNext();) {
	    TbusinessPartnerBranch bpb = iterator.next();
	    if (bpb.getName().compareTo(businessPartnerBranch.getName()) == 0) {
		wasDefault = bpb.isAddressDefault();
		listBusinessPartnerBranchForDelete.add(businessPartnerBranch);
		businessPartnerBranch = new TbusinessPartnerBranch();
		iterator.remove();
		break;
	    }
	}
	if (wasDefault && listBusinessPartnerBranch.size() > 0) {
	    listBusinessPartnerBranch.get(0).setAddressDefault(true);
	}
	listCities = new ArrayList<TbasicData>();
	listStates = new ArrayList<TbasicData>();
	countrySelected = new TbasicData();
	stateSelected = new TbasicData();
	seleccione2 = "--Seleccione--";
	disableDelAddress = new Boolean(true);
    }

    @NotifyChange("*")
    @Command
    public void save(@BindingParam("lbx") Component component) {
	if (listBusinessPartnerBranch.isEmpty()) {
	    throw new WrongValueException(component, "Debe asignar al menos una dirección por cliente");
	} else {
	    if (!update) {
		if (!daoBusinessPartner.save(businessPartner)) {
		    Clients.showNotification("Fallo guardado socio negocio", "error", null, "middle_center", 2000);
		    return;
		}
	    } else if (!daoBusinessPartner.update(businessPartner)) {
		Clients.showNotification("Fallo actualizacion Socio Negocio", "error", null, "middle_center", 2000);
		return;
	    }
	    for (TbusinessPartnerBranch businessPB : listBusinessPartnerBranchForDelete) {
		if (!daoBusinessPartnerBranch.delete(businessPB)) {
		    Clients.showNotification("No se pudo guardar direccion.", "error", null, "middle_center", 2000);
		    return;
		}
	    }
	    for (TbusinessPartnerBranch businessPB : listBusinessPartnerBranch) {
		businessPB.setTbusinessPartner(businessPartner);
		if (!update) {
		    if (!daoBusinessPartnerBranch.save(businessPB)) {
			Clients.showNotification("No se pudo guardar dirección socio", "error", null, "middle_center", 2000);
			return;
		    }
		} else if (!daoBusinessPartnerBranch.update(businessPB)) {
		    Clients.showNotification("No se pudo guardar dirección socio", "error", null, "middle_center", 2000);
		    return;
		}
	    }
	    Clients.showNotification("Socio de negocio guardado correctamente", "info", null, "middle_center", 2000);
	    restartForm();
	}
    }

    @NotifyChange({ "businessPartnerBranch", "stateSelected", "countrySelected", "listCities", "listStates", "disableDelAddress" })
    @Command
    public void loadPartnerBranchByListBox() {
	TbasicData citySelected = businessPartnerBranch.getTbasicData();
	countrySelected = citySelected.getTbasicData().getTbasicData();
	loadStatesByParent(countrySelected);
	stateSelected = citySelected.getTbasicData();
	loadCitiesByParent();
	businessPartnerBranch.setTbasicData(citySelected);
	disableDelAddress = new Boolean(false);
    }

    @NotifyChange({ "disableDelItem" })
    @Command
    public void loadItemByListBox() {
	disableDelItem = new Boolean(false);
    }

    @NotifyChange("listItem")
    @Command
    public void searchItemByField(@BindingParam("field") String field) {
	listItem = new SimpleListModel<String>(daoItem.listStringByFields(field));
    }

    @NotifyChange("")
    @Command
    public void loadItemByField(@BindingParam("input") InputElement input) {
	List<Titem> list = daoItem.listByString("name", input.getText());
	int listSize = list.size();
	if (listSize == 1) {
	    item = new Titem();
	    item = list.get(0);
	    return;
	} else if (listSize == 0) {
	    Clients.showNotification("Ningun registro coincide", "info", input, "end_center", 2000);
	} else {
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("listItem", list);
	    Executions.createComponents("system/articulos/frmItemList.zul", null, map);
	}
    }

    @NotifyChange({ "item" })
    @GlobalCommand
    public void selectedItem(@BindingParam("item") Titem selectedItem) {
	item = new Titem();
	item = selectedItem;
    }

    @NotifyChange("*")
    @Command
    public void search() {
	restartForm();
	disableAll = new Boolean(true);
	update = new Boolean(false);
    }

    @NotifyChange({ "listBusinessPartnerName", "listBusinessPartnerRif" })
    @Command
    public void searchBusinessPartnerByField(@BindingParam("field") String field) {
	if (field.compareTo("name") == 0) {
	    listBusinessPartnerName = new SimpleListModel<String>(daoBusinessPartner.listStringByField(field));
	    return;
	} else if (field.compareTo("rif") == 0) {
	    listBusinessPartnerRif = new SimpleListModel<String>(daoBusinessPartner.listStringByField(field));
	    return;
	}
    }

    @NotifyChange({ "businessPartnerBranch", "listBusinessPartnerBranch" })
    @Command
    public void businessPartnerBranchDefault(@BindingParam("lbx") Component component) {
	if (listBusinessPartnerBranch.isEmpty()) {
	    throw new WrongValueException(component, "Debe seleccionar al menos una dirección por cliente");
	} else
	    for (TbusinessPartnerBranch bPB : listBusinessPartnerBranch) {
		if (!bPB.equals(businessPartnerBranch))
		    bPB.setAddressDefault(false);
		else {
		    bPB.setAddressDefault(true);
		    businessPartnerBranch.setAddressDefault(true);
		}
	    }
    }

    @NotifyChange("*")
    @Command
    public void loadBusinessPartner(@BindingParam("field") String field, @BindingParam("val") String value) {
	List<TbusinessPartner> listBusinessPartner2 = daoBusinessPartner.listByString(field, value);
	int listSize = listBusinessPartner2.size();
	if (listSize == 1) {
	    businessPartner = new TbusinessPartner();
	    businessPartner = listBusinessPartner2.get(0);
	    listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>(businessPartner.getTbusinessPartnerBranches());
	    listItemByBusinessPartner = new ArrayList<Titem>(businessPartner.getTitems());
	    disableAll = new Boolean(false);
	    update = new Boolean(true);
	    return;
	} else if (listSize == 0) {
	    Clients.showNotification("Ningun registro coincide", "info", null, "middle_center", 2000);
	} else {
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("listBusinessPartner", listBusinessPartner2);
	    Executions.createComponents("system/socios/frmBusinessPartnerList.zul", null, map);
	}
    }

    @NotifyChange("*")
    @GlobalCommand
    public void selectedBusinessPartner(@BindingParam("businessPartner") TbusinessPartner businessPartner) {
	this.businessPartner = new TbusinessPartner();
	this.businessPartner = businessPartner;
	listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>(this.businessPartner.getTbusinessPartnerBranches());
	listItemByBusinessPartner = new ArrayList<Titem>(this.businessPartner.getTitems());
	disableAll = new Boolean(false);
	update = new Boolean(true);
    }

    @NotifyChange({ "listItemByBusinessPartner", "item", "disableDelItem" })
    @Command
    public void addItem() {
	Boolean found = false;
	for (Titem itemAux : businessPartner.getTitems()) {
	    if (itemAux.getIdItem() == item.getIdItem()) {
		found = true;
		break;
	    }
	}
	if (!found) {
	    businessPartner.getTitems().add(item);
	    BindUtils.postNotifyChange(null, null, businessPartner, "titems");
	} else
	    Clients.showNotification("Ya se encuentra en la lista", "info", null, "middle_center", 2000);
	item = new Titem();
	disableDelItem = new Boolean(true);
    }

    @Command
    /*
     * Cuando se modifica un "listbox" que en el "model" posee una variable tipo "List", debe de notificarse primero ese
     * "List" antes que cualquier variable dentro del @notifychange. Ver
     * http://books.zkoss.org/wiki/ZK_Developer%27s_Reference
     * /MVVM/Data_Binding/Collection_and_Selection#Choose_a_Component.27s_Model_Type La seccion:
     * "Choose a Component's Model Type"
     */
    @NotifyChange({ "listItemByBusinessPartner", "item", "disableDelItem" })
    public void deleteItem() {
	for (Iterator<Titem> iterator = businessPartner.getTitems().iterator(); iterator.hasNext();) {
	    Titem itemAux = iterator.next();
	    if (itemAux.getIdItem() == item.getIdItem()) {
		listItemByBusinessPartnerForDelete.add(item);
		item = new Titem();
		iterator.remove();
		BindUtils.postNotifyChange(null, null, businessPartner, "titems");
		break;
	    }
	}
	disableDelItem = new Boolean(true);
    }

    @Command
    public void close() {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("page", "");
	BindUtils.postGlobalCommand(null, null, "selectedPage", map);
    }
}
