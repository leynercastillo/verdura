package controllers.compras;

import general.GenericReport;
import general.SimpleListModelCustom;
import general.ValidateZK;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import models.TbasicData;
import models.TbusinesPartnerItem;
import models.TbusinessPartner;
import models.TbusinessPartnerBranch;
import models.TinputMeasureUnit;
import models.Titem;
import models.TorderNumber;
import models.Tpurchase;
import models.TpurchaseDetail;
import models.service.ServiceBasicData;
import models.service.ServiceBusinessPartner;
import models.service.ServiceBusinessPartnerItem;
import models.service.ServiceItem;
import models.service.ServiceOrder;
import models.service.ServiceOrderNumber;
import models.service.ServicePurchase;
import models.service.ServicePurchaseDetail;

public class CtrlPurchase {

	@WireVariable
	private ServiceBasicData serviceBasicData;
	@WireVariable
	private ServiceBusinessPartner serviceBusinessPartner;
	@WireVariable
	private ServicePurchase servicePurchase;
	@WireVariable
	private ServicePurchaseDetail servicePurchaseDetail;
	@WireVariable
	private ServiceOrderNumber serviceOrderNumber;
	@WireVariable
	private ServiceOrder serviceOrder;
	@WireVariable
	private ServiceItem serviceItem;
	@WireVariable
	private ServiceBusinessPartnerItem serviceBusinessPartnerItem;

	private Tpurchase purchase;
	private TbusinessPartner businessPartner;
	private String minCombo;
	private String modalMessage;
	private String modalAlert;
	private String select;
	private boolean disableAll;
	private List<TbasicData> listRifType;
	private List<TbasicData> listUnitMeasure;
	private List<TpurchaseDetail> listPurchaseDetail;
	private List<TpurchaseDetail> listPurchaseDetailForDelete;
	private List<TbusinessPartnerBranch> listBusinessPartnerBranch;
	private HashMap<String, Float> hashMissingQuantity;
	private ListModel<Object> listBusinessPartnerRif;
	private ListModel<Object> listBusinessPartnerName;

	public String getModalAlert() {
		return modalAlert;
	}

	public void setModalAlert(String modalAlert) {
		this.modalAlert = modalAlert;
	}

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
		TorderNumber auxOrderNumber = serviceOrderNumber.findOrderClosed();
		if (auxOrderNumber != null) {
			purchase.setTorderNumber(auxOrderNumber);
			disableAll = false;
			modalAlert = null;
		} else {
			disableAll = true;
			modalAlert = "No existen ninguna orden de pedidos cerrada. Por favor cierre alguna orden de pedidos para efectuar alguna compra";
		}
		purchase.setPurchaseDate(today);
		purchase.setDeliveryDate(today);
		purchase.setStatus('A');
		businessPartner = new TbusinessPartner();
		minCombo = "--";
		select = "--Seleccione--";
		modalMessage = null;
		listRifType = serviceBasicData.listRifType();
		listBusinessPartnerRif = new ListModelList<Object>();
		listBusinessPartnerName = new ListModelList<Object>();
		listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>();
		listPurchaseDetail = new ArrayList<TpurchaseDetail>();
		listPurchaseDetailForDelete = new ArrayList<TpurchaseDetail>();
		listUnitMeasure = serviceBasicData.listMeasureUnitForOrders();
		hashMissingQuantity = new HashMap<String, Float>();
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
				auxPurchaseDetail.setTitem(auxItem.getTitem());
				auxPurchaseDetail.setTbasicData(auxItem.getTbasicData());
				auxPurchaseDetail.setMissingQuantity(0);
				// calculate quantity reamining
				float quantityRemaining = serviceOrder.getQuantityRemainingByItem(auxPurchaseDetail, purchase.getTorderNumber());
				hashMissingQuantity.put(auxPurchaseDetail.getTitem().getCode(), quantityRemaining);
				auxPurchaseDetail.setMissingQuantity(quantityRemaining);
				// calculate price for measure unit and provider
				float price = serviceBusinessPartnerItem.findPriceItem(businessPartner, auxPurchaseDetail.getTitem());
				auxPurchaseDetail.setPrice(price);
				listPurchaseDetail.add(auxPurchaseDetail);
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

	@NotifyChange({ "modalAlert" })
	@Command
	public void cancelModalAlert() {
		if (modalAlert != null)
			modalAlert = null;
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

	@Command
	public void changeQuantity(@ContextParam(ContextType.TRIGGER_EVENT) InputEvent event, @BindingParam("purchaseDetail") TpurchaseDetail purchaseDetail) {
		int value = 0;
		if (!event.getValue().isEmpty())
			value = Math.round(Float.parseFloat(event.getValue()));
		purchaseDetail.setQuantity(value);
		BindUtils.postNotifyChange(null, null, purchaseDetail, "quantity");
		// Update current missing quantity
		System.out.println();
		purchaseDetail.setMissingQuantity(hashMissingQuantity.get(purchaseDetail.getTitem().getCode()) - value);
		BindUtils.postNotifyChange(null, null, purchaseDetail, "missingQuantity");
		// Update total price
		purchaseDetail.setTotalPrice(purchaseDetail.getPrice() * value);
		BindUtils.postNotifyChange(null, null, purchaseDetail, "totalPrice");
	}

	@Command
	public void changePrice(@ContextParam(ContextType.TRIGGER_EVENT) InputEvent event, @BindingParam("purchaseDetail") TpurchaseDetail purchaseDetail) {
		float value = 0;
		if (!event.getValue().isEmpty())
			value = Float.parseFloat(event.getValue());
		// Update total price
		purchaseDetail.setTotalPrice(purchaseDetail.getQuantity() * value);
		BindUtils.postNotifyChange(null, null, purchaseDetail, "totalPrice");
	}

	@NotifyChange("*")
	@Command
	public void save(@BindingParam("lbx") Component component) {
		boolean detailIsEmpty = true;
		for (TpurchaseDetail purchaseDetail : listPurchaseDetail) {
			if (purchaseDetail.getQuantity() > 0) {
				detailIsEmpty = false;
				// Convert quantity to kg
				Titem auxItem = serviceItem.findByCode(purchaseDetail.getTitem().getCode());
				for (TinputMeasureUnit auxInputMeasure : auxItem.getTinputMeasureUnits()) {
					if (auxInputMeasure.getTbasicData().getIdBasicData() == purchaseDetail.getTbasicData().getIdBasicData()) {
						purchaseDetail.setQuantity(purchaseDetail.getQuantity() * auxInputMeasure.getWeightUnit());
					}
				}
				purchase.getTpurchaseDetails().add(purchaseDetail);
			} else {
				listPurchaseDetailForDelete.add(purchaseDetail);
			}
		}
		if (detailIsEmpty) {
			throw new WrongValueException(component, "Debe asignar al menos una cantidad a un articulo.");
		} else {
			// optimize after
			purchase.setBpName(businessPartner.getName());
			purchase.setRif(businessPartner.getTbasicDataByRifType().getName() + "-" + businessPartner.getRif());
			purchase.setBpBranchAddress(purchase.getTbusinessPartnerBranch().getAddress());
			if (!servicePurchase.save(purchase)) {
				Clients.showNotification("No se pudo guardar la compra.", "error", null, "middle_center", 2000);
				return;
			}
			for (TpurchaseDetail purchaseDetail : purchase.getTpurchaseDetails()) {
				purchaseDetail.setTpurchase(purchase);
				if (!servicePurchaseDetail.save(purchaseDetail) || (!serviceBusinessPartnerItem.updatePrice(purchaseDetail))) {
					Clients.showNotification("No se pudo guardar la compra.", "error", null, "middle_center", 2000);
					return;
				}
			}
			for (TpurchaseDetail auxPurchaseDetail : listPurchaseDetailForDelete) {
				if (servicePurchaseDetail.delete(auxPurchaseDetail)) {
					Clients.showNotification("No se pudo guardar la compra.", "error", null, "middle_center", 2000);
					return;
				}
			}
			Clients.showNotification("Compra guardada correctamente", "info", null, "middle_center", 2000);
			restartForm();
		}
	}

	@NotifyChange({ "disableAll" })
	@Command
	public void edit() {
		disableAll = false;
	}

	@NotifyChange({ "purchase", "listPurchaseDetail", "businessPartner", "disableAll" })
	@GlobalCommand
	public void selectedPurchase(@BindingParam("purchase") Tpurchase selectedPurchase) {
		purchase = new Tpurchase();
		purchase = servicePurchase.findById(selectedPurchase.getIdPurchase());
		listPurchaseDetail = new ArrayList<TpurchaseDetail>(purchase.getTpurchaseDetails());
		// Convert kg to selected unit
		for (TpurchaseDetail auxPurchaseDetail : listPurchaseDetail) {
			Titem auxItem = serviceItem.findByCode(auxPurchaseDetail.getTitem().getCode());
			for (TinputMeasureUnit auxInputMeasure : auxItem.getTinputMeasureUnits()) {
				if (auxInputMeasure.getTbasicData().getIdBasicData() == auxPurchaseDetail.getTbasicData().getIdBasicData()) {
					auxPurchaseDetail.setQuantity(auxPurchaseDetail.getQuantity() / auxInputMeasure.getWeightUnit());
				}
			}
			// Re calculate quantity missing
			float quantityRemaining = serviceOrder.getQuantityRemainingByItem(auxPurchaseDetail, purchase.getTorderNumber());
			hashMissingQuantity.put(auxPurchaseDetail.getTitem().getCode(), quantityRemaining);
			auxPurchaseDetail.setMissingQuantity(quantityRemaining);
		}
		businessPartner = purchase.getTbusinessPartnerBranch().getTbusinessPartner();
		disableAll = true;
	}

	@Command
	public void printPurchase() {
		GenericReport report = new GenericReport();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("IMAGES_DIR", "../../resource/images/system/");
		map.put("ID_PURCHASE", purchase.getIdPurchase());
		report.createPdf("/resource/reports/purchases/", "purchase.jasper", map, "compra-proveedor.pdf");
		report.viewPdf("/resource/reports/purchases/compra-proveedor.pdf", "Compra proveedor");
	}

	@Command
	public void search() {
		Executions.createComponents("system/compras/frmSearchPurchases.zul", null, null);
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}