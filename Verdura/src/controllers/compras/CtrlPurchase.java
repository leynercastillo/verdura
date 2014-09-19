package controllers.compras;

import general.SimpleListModelCustom;
import general.ValidateZK;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import models.TbasicData;
import models.TbusinesPartnerItem;
import models.TbusinessPartner;
import models.TbusinessPartnerBranch;
import models.Tpurchase;
import models.TpurchaseDetail;
import models.service.ServiceBasicData;
import models.service.ServiceBusinessPartner;
import models.service.ServiceOrder;
import models.service.ServiceOrderNumber;
import models.service.ServicePurchase;

public class CtrlPurchase {

	@WireVariable
	private ServiceBasicData serviceBasicData;
	@WireVariable
	private ServiceBusinessPartner serviceBusinessPartner;
	@WireVariable
	private ServicePurchase servicePurchase;
	@WireVariable
	private ServiceOrderNumber serviceOrderNumber;
	@WireVariable
	private ServiceOrder serviceOrder;

	private Tpurchase purchase;
	private TbusinessPartner businessPartner;
	private TbasicData unitSelected;
	private String minCombo;
	private String modalMessage;
	private String select;
	private boolean disableAll;
	private List<TbasicData> listRifType;
	private List<TbasicData> listUnitMeasure;
	private List<TpurchaseDetail> listPurchaseDetail;
	private List<TbusinessPartnerBranch> listBusinessPartnerBranch;
	private ListModel<Object> listBusinessPartnerRif;
	private ListModel<Object> listBusinessPartnerName;

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getModalMessage() {
		return modalMessage;
	}

	public void setModalMessage(String modalMessage) {
		this.modalMessage = modalMessage;
	}

	public List<TbasicData> getListUnitMeasure() {
		return listUnitMeasure;
	}

	public void setListUnitMeasure(List<TbasicData> listUnitMeasure) {
		this.listUnitMeasure = listUnitMeasure;
	}

	public ListModel<Object> getListBusinessPartnerName() {
		return listBusinessPartnerName;
	}

	public void setListBusinessPartnerName(ListModel<Object> listBusinessPartnerName) {
		this.listBusinessPartnerName = listBusinessPartnerName;
	}

	public TbasicData getUnitSelected() {
		return unitSelected;
	}

	public void setUnitSelected(TbasicData unitSelected) {
		this.unitSelected = unitSelected;
	}

	public List<TpurchaseDetail> getListPurchaseDetail() {
		return listPurchaseDetail;
	}

	public void setListPurchaseDetail(List<TpurchaseDetail> listPurchaseDetail) {
		this.listPurchaseDetail = listPurchaseDetail;
	}

	public Tpurchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Tpurchase purchase) {
		this.purchase = purchase;
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

	public Validator getNoSelect() {
		return new ValidateZK().getNoSelect();
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange({ "*" })
	@Command
	public void restartForm() {
		purchase = new Tpurchase();
		Date today = new Date();
		purchase.setPurchaseNumber(servicePurchase.getMaxPurchaseNumber());
		purchase.setTorderNumber(serviceOrderNumber.findOrderClosed());
		purchase.setPurchaseDate(today);
		purchase.setDeliveryDate(today);
		purchase.setStatus('A');
		businessPartner = new TbusinessPartner();
		minCombo = "--";
		select = "--Seleccione--";
		modalMessage = null;
		disableAll = false;
		listRifType = serviceBasicData.listRifType();
		listBusinessPartnerRif = new ListModelList<Object>();
		listBusinessPartnerName = new ListModelList<Object>();
		listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>();
		listPurchaseDetail = new ArrayList<TpurchaseDetail>();
		unitSelected = new TbasicData();
		listUnitMeasure = serviceBasicData.listMeasureUnitForOrders();
	}

	@NotifyChange("*")
	@Command
	public void loadBusinessPartner(@BindingParam("field") String field, @BindingParam("val") String value) {
		List<TbusinessPartner> auxListBusinessPartner = new ArrayList<TbusinessPartner>();
		if (field.equals("rif")) {
			TbusinessPartner auxBusinessPartner = serviceBusinessPartner.findSupplierByRif(value);
			if (auxBusinessPartner != null) {
				auxListBusinessPartner.add(auxBusinessPartner);
			}
		} else if (field.equals("name")) {
			auxListBusinessPartner = serviceBusinessPartner.listByNameBySupplier(value);
		}
		int listSize = auxListBusinessPartner.size();
		if (listSize == 1) {
			businessPartner = new TbusinessPartner();
			businessPartner = auxListBusinessPartner.get(0);
			listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>(businessPartner.getTbusinessPartnerBranches());
			for (TbusinessPartnerBranch businessPartnerBranch : listBusinessPartnerBranch) {
				if (businessPartnerBranch.isAddressDefault())
					purchase.setTbusinessPartnerBranch(businessPartnerBranch);
			}
			disableAll = false;
			listPurchaseDetail = new ArrayList<TpurchaseDetail>();
			List<TbusinesPartnerItem> auxListPartnerItem = new ArrayList<TbusinesPartnerItem>(businessPartner.getTbusinesPartnerItems());
			for (TbusinesPartnerItem auxItem : auxListPartnerItem) {
				TpurchaseDetail auxPurchaseDetail = new TpurchaseDetail();
				auxPurchaseDetail.setItemName(auxItem.getTitem().getName());
				auxPurchaseDetail.setQuantity(0);
				auxPurchaseDetail.setStatus('A');
				auxPurchaseDetail.setTbasicData(unitSelected);
				auxPurchaseDetail.setTitem(auxItem.getTitem());
				listPurchaseDetail.add(auxPurchaseDetail);
				System.out.println("Cuantos: "+serviceOrder.getQuantityRemainingByItem(auxPurchaseDetail, purchase.getTorderNumber().getIdOrderNumber()));
			}
			return;
		} else if (listSize == 0) {
			Clients.showNotification("Ningun registro coincide", "info", null, "middle_center", 2000);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("listBusinessPartner", auxListBusinessPartner);
			Executions.createComponents("system/pedidos/frmSearchPurchase.zul", null, map);
		}
	}

	@NotifyChange({ "listBusinessPartnerName", "listBusinessPartnerRif" })
	@Command
	public void searchBusinessPartnerByField(@BindingParam("field") String field) {
		if (field.compareTo("name") == 0) {
			listBusinessPartnerName = new SimpleListModelCustom<Object>(serviceBusinessPartner.listNamesBySuplier());
			return;
		} else if (field.compareTo("rif") == 0) {
			listBusinessPartnerRif = new SimpleListModelCustom<Object>(serviceBusinessPartner.listRifBySuplier());
			return;
		}
	}
	
	@NotifyChange({ "modalMessage" })
	@Command
	public void confirmFinishOrder() {
		int orderByOrderNumber = servicePurchase.listOrderByOrderNumber(purchase.getTorderNumber()).size();
		modalMessage = "Esta orden posee " + orderByOrderNumber + " compras. ¿Esta seguro de finalizar la orden?";
	}
	
	@NotifyChange({ "modalMessage" })
	@Command
	public void cancelModal() {
		if (modalMessage != null)
			modalMessage = null;
	}
	
	@NotifyChange("*")
	@Command
	public void finishOrder() {
		if (!serviceOrderNumber.finishOrder(purchase.getTorderNumber())) {
			Clients.showNotification("No se pudo cerrar la orden.", "error", null, "middle_center", 2000);
			return;
		}
		Clients.showNotification("Orden finalizada correctamente", "info", null, "middle_center", 2000);
		restartForm();
	}
}