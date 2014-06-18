package controllers.pedidos;

import general.SimpleListModelCustom;
import general.ValidateZK;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.TbasicData;
import models.TbusinessPartner;
import models.TbusinessPartnerBranch;
import models.Titem;
import models.Torder;
import models.service.ServiceBasicData;
import models.service.ServiceBusinessPartner;
import models.service.ServiceItem;
import models.service.ServiceOrder;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

public class CtrlOrders {

	@WireVariable
	private ServiceBasicData serviceBasicData;
	@WireVariable
	private ServiceBusinessPartner serviceBusinessPartner;
	@WireVariable
	private ServiceItem serviceItem;
	@WireVariable
	private ServiceOrder serviceOrder;

	private Torder order;
	private TbusinessPartner businessPartner;
	private TbasicData unitSelected;
	private List<TbasicData> listRifType;
	private List<TbasicData> listUnitMeasure;
	private List<TbusinessPartnerBranch> listBusinessPartnerBranch;
	private List<Titem> listItems;
	private ListModel<Object> listBusinessPartnerRif;
	private ListModel<Object> listBusinessPartnerName;
	private boolean disableAll;
	private String minCombo;
	private String select;

	public TbasicData getUnitSelected() {
		return unitSelected;
	}

	public void setUnitSelected(TbasicData unitSelected) {
		this.unitSelected = unitSelected;
	}

	public List<TbasicData> getListUnitMeasure() {
		return listUnitMeasure;
	}

	public void setListUnitMeasure(List<TbasicData> listUnitMeasure) {
		this.listUnitMeasure = listUnitMeasure;
	}

	public List<Titem> getListItems() {
		return listItems;
	}

	public void setListItems(List<Titem> listItems) {
		this.listItems = listItems;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public Torder getOrder() {
		return order;
	}

	public void setOrder(Torder order) {
		this.order = order;
	}

	public ListModel<Object> getListBusinessPartnerName() {
		return listBusinessPartnerName;
	}

	public void setListBusinessPartnerName(ListModel<Object> listBusinessPartnerName) {
		this.listBusinessPartnerName = listBusinessPartnerName;
	}

	public List<TbusinessPartnerBranch> getListBusinessPartnerBranch() {
		return listBusinessPartnerBranch;
	}

	public void setListBusinessPartnerBranch(List<TbusinessPartnerBranch> listBusinessPartnerBranch) {
		this.listBusinessPartnerBranch = listBusinessPartnerBranch;
	}

	public ListModel<Object> getListBusinessPartnerRif() {
		return listBusinessPartnerRif;
	}

	public void setListBusinessPartnerRif(ListModel<Object> listBusinessPartnerRif) {
		this.listBusinessPartnerRif = listBusinessPartnerRif;
	}

	public String getMinCombo() {
		return minCombo;
	}

	public void setMinCombo(String minCombo) {
		this.minCombo = minCombo;
	}

	public TbusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(TbusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	public List<TbasicData> getListRifType() {
		return listRifType;
	}

	public void setListRifType(List<TbasicData> listRifType) {
		this.listRifType = listRifType;
	}

	public boolean isDisableAll() {
		return disableAll;
	}

	public void setDisableAll(boolean disableAll) {
		this.disableAll = disableAll;
	}

	public Validator getNoDash() {
		return new ValidateZK().getNoDash();
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange({ "*" })
	@Command
	public void restartForm() {
		order = new Torder();
		Date today = new Date();
		order.setOrderDate(today);
		order.setDeliveryDate(today);
		order.setOrderNumber(serviceOrder.getMaxOrderNumber());
		select = "--Seleccione--";
		businessPartner = new TbusinessPartner();
		disableAll = new Boolean(false);
		listRifType = serviceBasicData.listRifType();
		minCombo = new String("--");
		listBusinessPartnerRif = new ListModelList<Object>();
		listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>();
		listItems = new ArrayList<Titem>();
		listUnitMeasure = serviceBasicData.listMeasureUnit();
		unitSelected = new TbasicData();
	}

	@NotifyChange("*")
	@Command
	public void loadBusinessPartner(@BindingParam("field") String field, @BindingParam("val") String value) {
		List<TbusinessPartner> auxListBusinessPartner = new ArrayList<TbusinessPartner>();
		if (field.equals("rif")) {
			TbusinessPartner auxBusinessPartner = serviceBusinessPartner.findByRif(value);
			if (auxBusinessPartner != null) {
				auxListBusinessPartner.add(auxBusinessPartner);
			}
		} else if (field.equals("name")) {
			auxListBusinessPartner = serviceBusinessPartner.listByName(value);
		}
		int listSize = auxListBusinessPartner.size();
		if (listSize == 1) {
			businessPartner = new TbusinessPartner();
			businessPartner = auxListBusinessPartner.get(0);
			listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>(businessPartner.getTbusinessPartnerBranches());
			for (TbusinessPartnerBranch businessPartnerBranch : listBusinessPartnerBranch) {
				if (businessPartnerBranch.isAddressDefault())
					order.setTbusinessPartnerBranch(businessPartnerBranch);
			}
			disableAll = new Boolean(false);
			listItems = serviceItem.listActive();
			return;
		} else if (listSize == 0) {
			Clients.showNotification("Ningun registro coincide", "info", null, "middle_center", 2000);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("listBusinessPartner", auxListBusinessPartner);
			Executions.createComponents("system/socios/frmBusinessPartnerList.zul", null, map);
		}
	}

	@NotifyChange({ "listBusinessPartnerName", "listBusinessPartnerRif" })
	@Command
	public void searchBusinessPartnerByField(@BindingParam("field") String field) {
		if (field.compareTo("name") == 0) {
			listBusinessPartnerName = new SimpleListModelCustom<Object>(serviceBusinessPartner.listNames());
			return;
		} else if (field.compareTo("rif") == 0) {
			listBusinessPartnerRif = new SimpleListModelCustom<Object>(serviceBusinessPartner.listRif());
			return;
		}
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}

}
