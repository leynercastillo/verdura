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

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.InputElement;

import dao.DaoBasicData;
import dao.DaoBusinessPartner;
import dao.DaoDataType;
import dao.DaoItem;

public class FrmItemMaster {

	private String minCombo;
	private String seleccione;
	private Boolean disableAll;
	private Titem item;
	private Boolean update;
	private List<Titem> listItem;
	private List<TbasicData> listUnitCar;
	private List<TbasicData> listItemType;

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

	public List<Titem> getListItem() {
		return listItem;
	}

	public void setListItem(List<Titem> listItem) {
		this.listItem = listItem;
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

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange({ "item" })
	@Command
	public void restartForm() {
		item = new Titem();
		item.setWashable(new Boolean(false));
		minCombo = new String("--");
		seleccione = new String("--Seleccione--");
		disableAll = new Boolean(false);
		update = new Boolean(false);
		item.setStatus('A');
		DaoBasicData daoBasicData = new DaoBasicData();
		listItem = new ArrayList<Titem>();
		listUnitCar = daoBasicData.listByDataType(new DaoDataType().findByName(""))
		listItemType = daoBasicData.listByDataType(new DaoDataType().findByName(""))
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

	public Validator getNoRepeatCode() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext()
						.getValidatorArg("component");
				String string = inputElement.getText();
				String str = null;
				Titem auxItem = new DaoItem().findByCode(string);
				if (auxItem != null && !update)
					str = auxItem.getCode();
				if (string.isEmpty())
					throw new WrongValueException(inputElement,
							"Ingrese un dato valido.");
				if (string.equals(str))
					throw new WrongValueException(inputElement,
							"Este codigo ya se encuentra registrado en el sistema.");
			}
		};
	}

	@NotifyChange({ "listItem" })
	@Command
	public void loadItemByField(@BindingParam("field") String field) {
		listItem = new DaoItem().listOrderedByField(field);
	}

	@NotifyChange({ "item", "disableAll", "update", "listItem" })
	@Command
	public void searchItem(@BindingParam("field") String field,
			@BindingParam("val") String value) {
		List<Titem> listItemAux = new DaoItem().findByString(field, value);
		int listSize = listItemAux.size();
		if (listSize == 1) {
			item = new Titem();
			item = listItemAux.get(0);
			disableAll = new Boolean(false);
			update = new Boolean(true);
			return;
		} else if (listSize == 0) {
			Messagebox.show("Ningun registro coincide");
		} else {
			Map map = new HashMap();
			map.put("listItem", listItemAux);
			Window window = (Window) Executions.createComponents(
					"frmItemList.zul", null, map);
		}
	}
}