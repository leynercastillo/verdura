package controllers;

import general.ValidateZK;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.InputElement;

import dao.DaoBasicData;
import dao.DaoBusinessPartner;
import dao.DaoBusinessPartnerBranch;
import dao.DaoDataType;
import dao.DaoItem;

public class FrmBusinessPartnerMaster {

	private String minCombo;
	private String seleccione;
	private String seleccione2;
	private Boolean disableAll;
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
	private List<TbusinessPartner> listBusinessPartner;
	private List<TbusinessPartnerBranch> listBusinessPartnerBranch;
	private List<Titem> listItem;

	public Titem getItem() {
		return item;
	}

	public void setItem(Titem item) {
		this.item = item;
	}

	public List<Titem> getListItem() {
		return listItem;
	}

	public void setListItem(List<Titem> listItem) {
		this.listItem = listItem;
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

	public List<TbusinessPartner> getListBusinessPartner() {
		return listBusinessPartner;
	}

	public void setListBusinessPartner(List<TbusinessPartner> listBusinessPartner) {
		this.listBusinessPartner = listBusinessPartner;
	}

	public List<TbusinessPartnerBranch> getListBusinessPartnerBranch() {
		return listBusinessPartnerBranch;
	}

	public void setListBusinessPartnerBranch(
			List<TbusinessPartnerBranch> listBusinessPartnerBranch) {
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

	public void setBusinessPartnerBranch(
			TbusinessPartnerBranch businessPartnerBranch) {
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
		update = new Boolean(false);
		businessPartner.setStatus('A');
		
		DaoBasicData daoBasicData = new DaoBasicData();
		listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>();
		listItem = new ArrayList<Titem>();
		listBusinessPartnerType = daoBasicData.listByDataType(new DaoDataType()
				.findByName("BUSINESS PARTNER TYPE"));
		listRifType = daoBasicData.listByDataType(new DaoDataType()
				.findByName("RIF TYPE"));
		listCountries = daoBasicData.listByDataType(new DaoDataType()
				.findByName("COUNTRY"));
		stateSelected = new TbasicData();
		countrySelected = new TbasicData();
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
				InputElement inputElement = (InputElement) ctx.getBindContext()
						.getValidatorArg("component");
				String string = inputElement.getText();
				String str = null;
				TbusinessPartner auxBusinessPartner = new DaoBusinessPartner()
						.findByRif(string,
								businessPartner.getTbasicDataByType());
				if (auxBusinessPartner != null && !update)
					str = auxBusinessPartner.getRif();
				if (string.isEmpty())
					throw new WrongValueException(inputElement,
							"Ingrese un dato valido.");
				if (string.equals(str))
					throw new WrongValueException(inputElement,
							"Este rif ya se encuentra registrado en el sistema.");
			}
		};
	}

	@NotifyChange({ "listStates" })
	@Command
	public void loadStatesByParent() {
		listStates = new DaoBasicData().listByParent(countrySelected);
		listCities = new ArrayList<TbasicData>();
		stateSelected = new TbasicData();
		businessPartnerBranch.setTbasicData(new TbasicData());

	}

	@NotifyChange("listCities")
	@Command
	public void loadCitiesByParent() {
		listCities = new DaoBasicData().listByParent(stateSelected);
		businessPartnerBranch.setTbasicData(new TbasicData());
	}

	@NotifyChange({ "businessPartnerBranch", "seleccione2", "listCities",
			"listStates", "countrySelected", "stateSelected",
			"listBusinessPartnerBranch" })
	@Command
	public void add() {
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
		seleccione2 = "--Seleccione--";
	}
	/*
	@Command
	public void addItemOffered() {
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
		seleccione2 = "--Seleccione--";
	}*/

	@NotifyChange("*")
	@Command
	public void save(@BindingParam("lbx") Component component) {
		if (listBusinessPartnerBranch.isEmpty()) {
			throw new WrongValueException(component,
					"Debe asignar al menos una dirección por cliente");
		} else {
			DaoBusinessPartner daoBusinessPartner = new DaoBusinessPartner();
			DaoBusinessPartnerBranch daoBusinessPartnerBranch = new DaoBusinessPartnerBranch();
			if (!daoBusinessPartner.save(businessPartner)) {
				Messagebox.show("Fallo Guardado Socio Negocio", "Error",
						Messagebox.OK, Messagebox.ERROR);
				return;
			}
			for (TbusinessPartnerBranch businessPB : listBusinessPartnerBranch) {
				businessPB.setTbusinessPartner(businessPartner);
				if (!daoBusinessPartnerBranch.save(businessPB)) {
					Messagebox.show(
							"Fallo Guardado Dirección socio de negocio",
							"Error", Messagebox.OK, Messagebox.ERROR);
					return;
				}
			}
			Messagebox.show("Socio de negocio guardado", "Information",
					Messagebox.OK, Messagebox.INFORMATION);
			restartForm();
		}
	}

	@NotifyChange({ "businessPartnerBranch", "stateSelected",
			"countrySelected", "listCities", "listStates" })
	@Command
	public void loadPartnerBranchByListBox() {
		TbasicData citySelected = businessPartnerBranch.getTbasicData();
		countrySelected = citySelected.getTbasicData().getTbasicData();
		loadStatesByParent();
		stateSelected = citySelected.getTbasicData();
		loadCitiesByParent();
		businessPartnerBranch.setTbasicData(citySelected);
	}

	@NotifyChange("*")
	@Command
	public void search() {
		restartForm();
		disableAll = new Boolean(true);
		update = new Boolean(false);
	}

	@NotifyChange("listBusinessPartner")
	@Command
	public void loadBusinessPartnerByField(@BindingParam("field") String field) {
		DaoBusinessPartner daoBusinessPartner = new DaoBusinessPartner();
		listBusinessPartner = daoBusinessPartner.listOrderedbyField(field);
	}

	@NotifyChange("listItem")
	@Command
	public void loadItemByField(@BindingParam("field") String field) {
		listItem = new DaoItem().listOrderedByField(field);
	}

	@NotifyChange({ "businessPartnerBranch", "listBusinessPartnerBranch" })
	@Command
	public void businessPartnerBranchDefault(
			@BindingParam("lbx") Component component) {
		if (listBusinessPartnerBranch.isEmpty()) {
			throw new WrongValueException(component,
					"Debe seleccionar al menos una dirección por cliente");
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
	public void searchBusinessPartner(@BindingParam("field") String field,
			@BindingParam("val") String value) {
		List<TbusinessPartner> listBusinessPartner2 = new DaoBusinessPartner()
				.findByString(field, value);
		int listSize = listBusinessPartner2.size();
		if (listSize == 1) {
			businessPartner = new TbusinessPartner();
			businessPartner = listBusinessPartner2.get(0);
			listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>(
					businessPartner.getTbusinessPartnerBranches());
			listItem = new ArrayList<Titem>(businessPartner.getTitems());
			disableAll = new Boolean(false);
			update = new Boolean(true);
			return;
		} else if (listSize == 0) {
			Messagebox.show("Ningun registro coincide");
		} else {
			Map map = new HashMap();
			map.put("listBusinessPartner", listBusinessPartner2);
			Window window = (Window) Executions.createComponents(
					"frmBusinessPartnerList.zul", null, map);
		}
	}

	@NotifyChange("*")
	@GlobalCommand
	public void selectedBusinessPartner(
			@BindingParam("businessPartner") TbusinessPartner businessPartner) {
		this.businessPartner = new TbusinessPartner();
		this.businessPartner = businessPartner;
		listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>(
				this.businessPartner.getTbusinessPartnerBranches());
		disableAll = new Boolean(false);
		update = new Boolean(true);
	}

	@Command
	public void close() {
		Map map = new HashMap();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}
