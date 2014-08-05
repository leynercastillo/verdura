package controllers.pedidos;

import general.GenericReport;
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
import models.TorderDetail;
import models.TorderNumber;
import models.service.ServiceBasicData;
import models.service.ServiceBusinessPartner;
import models.service.ServiceItem;
import models.service.ServiceOrder;
import models.service.ServiceOrderDetail;
import models.service.ServiceOrderNumber;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
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
	@WireVariable
	private ServiceOrderDetail serviceOrderDetail;
	@WireVariable
	private ServiceOrderNumber serviceOrderNumber;

	private Torder order;
	private TbusinessPartner businessPartner;
	private TbasicData unitSelected;
	private List<TbasicData> listRifType;
	private List<TbasicData> listUnitMeasure;
	private List<TbusinessPartnerBranch> listBusinessPartnerBranch;
	private List<TorderDetail> listOrderDetail;
	private ListModel<Object> listBusinessPartnerRif;
	private ListModel<Object> listBusinessPartnerName;
	private boolean disableAll;
	private boolean closeOrder;
	private String minCombo;
	private String select;
	private String modalMessage;

	public boolean isCloseOrder() {
		return closeOrder;
	}

	public void setCloseOrder(boolean closeOrder) {
		this.closeOrder = closeOrder;
	}

	public String getModalMessage() {
		return modalMessage;
	}

	public void setModalMessage(String modalMessage) {
		this.modalMessage = modalMessage;
	}

	public List<TorderDetail> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<TorderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

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
		order = new Torder();
		Date today = new Date();
		order.setOrderDate(today);
		order.setDeliveryDate(today);
		TorderNumber orderNumber = serviceOrderNumber.getMaxOrderNumber();
		if (orderNumber == null) {
			orderNumber = new TorderNumber();
			orderNumber.setIdOrderNumber(1);
			orderNumber.setStatus('A');
			if (!serviceOrderNumber.save(orderNumber)) {
				Clients.showNotification("Ha ocurrido un error.", "error", null, "middle_center", 2000);
			}
		}
		order.setTorderNumber(orderNumber);
		order.setStatus('A');
		select = "--Seleccione--";
		businessPartner = new TbusinessPartner();
		disableAll = false;
		closeOrder = false;
		listRifType = serviceBasicData.listRifType();
		minCombo = new String("--");
		listBusinessPartnerRif = new ListModelList<Object>();
		listBusinessPartnerBranch = new ArrayList<TbusinessPartnerBranch>();
		listOrderDetail = new ArrayList<TorderDetail>();
		listUnitMeasure = serviceBasicData.listMeasureUnitForOrders();
		unitSelected = new TbasicData();
		modalMessage = null;
	}

	@NotifyChange("*")
	@Command
	public void loadBusinessPartner(@BindingParam("field") String field, @BindingParam("val") String value) {
		List<TbusinessPartner> auxListBusinessPartner = new ArrayList<TbusinessPartner>();
		if (field.equals("rif")) {
			TbusinessPartner auxBusinessPartner = serviceBusinessPartner.findCustomerByRif(value);
			if (auxBusinessPartner != null) {
				auxListBusinessPartner.add(auxBusinessPartner);
			}
		} else if (field.equals("name")) {
			auxListBusinessPartner = serviceBusinessPartner.listByNameByCustomer(value);
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
			disableAll = false;
			closeOrder = true;
			listOrderDetail = new ArrayList<TorderDetail>();
			List<Titem> auxListItem = serviceItem.listActive();
			for (Titem auxItem : auxListItem) {
				TorderDetail auxOrderDetail = new TorderDetail();
				auxOrderDetail.setItemName(auxItem.getName());
				auxOrderDetail.setQuantity(0);
				auxOrderDetail.setStatus('A');
				auxOrderDetail.setTbasicData(unitSelected);
				auxOrderDetail.setTitem(auxItem);
				listOrderDetail.add(auxOrderDetail);
			}
			return;
		} else if (listSize == 0) {
			Clients.showNotification("Ningun registro coincide", "info", null, "middle_center", 2000);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("listBusinessPartner", auxListBusinessPartner);
			Executions.createComponents("system/pedidos/frmSearchOrders.zul", null, map);
		}
	}

	@NotifyChange({ "listBusinessPartnerName", "listBusinessPartnerRif" })
	@Command
	public void searchBusinessPartnerByField(@BindingParam("field") String field) {
		if (field.compareTo("name") == 0) {
			listBusinessPartnerName = new SimpleListModelCustom<Object>(serviceBusinessPartner.listNamesByCustomer());
			return;
		} else if (field.compareTo("rif") == 0) {
			listBusinessPartnerRif = new SimpleListModelCustom<Object>(serviceBusinessPartner.listRifByCustomer());
			return;
		}
	}

	@NotifyChange({ "listOrderDetail" })
	@Command
	public void selectUnitMeasure() {
		for (TorderDetail orderDetail : listOrderDetail) {
			orderDetail.setTbasicData(unitSelected);
		}
	}

	@NotifyChange("*")
	@Command
	public void save(@BindingParam("lbx") Component component) {
		boolean detailIsEmpty = true;
		for (TorderDetail orderDetail : listOrderDetail) {
			if (orderDetail.getQuantity() > 0) {
				detailIsEmpty = false;
				order.getTorderDetails().add(orderDetail);
			}
		}
		if (detailIsEmpty) {
			throw new WrongValueException(component, "Debe asignar al menos una cantidad a un articulo.");
		} else {
			order.setBpName(businessPartner.getName());
			order.setRif(businessPartner.getTbasicDataByRifType().getName() + "-" + businessPartner.getRif());
			order.setBpBranchAddress(order.getTbusinessPartnerBranch().getAddress());
			if (!serviceOrder.save(order)) {
				Clients.showNotification("No se pudo guardar el pedido.", "error", null, "middle_center", 2000);
				return;
			}
			for (TorderDetail orderDetail : order.getTorderDetails()) {
				orderDetail.setTorder(order);
				if (!serviceOrderDetail.save(orderDetail)) {
					Clients.showNotification("No se pudo guardar la orden.", "error", null, "middle_center", 2000);
					return;
				}
			}
			Clients.showNotification("Pedido guardado correctamente", "info", null, "middle_center", 2000);
			restartForm();
		}
	}

	@Command
	public void search() {
		Executions.createComponents("system/pedidos/frmSearchOrders.zul", null, null);
	}

	@NotifyChange({ "order", "listOrderDetail", "businessPartner", "disableAll", "unitSelected" })
	@GlobalCommand
	public void selectedOrder(@BindingParam("order") Torder selectedOrder) {
		order = new Torder();
		order = serviceOrder.findById(selectedOrder.getIdOrder());
		listOrderDetail = new ArrayList<TorderDetail>(order.getTorderDetails());
		businessPartner = order.getTbusinessPartnerBranch().getTbusinessPartner();
		unitSelected = listOrderDetail.get(0).getTbasicData();
		disableAll = true;
		closeOrder = true;
	}

	@NotifyChange("*")
	@Command
	public void closeOrder() {
		if (!serviceOrderNumber.closeOrder(order.getTorderNumber())) {
			Clients.showNotification("No se pudo cerrar la orden.", "error", null, "middle_center", 2000);
			return;
		}
		Clients.showNotification("Orden cerrada correctamente", "info", null, "middle_center", 2000);
		restartForm();
	}

	@NotifyChange({ "modalMessage" })
	@Command
	public void cancelModal() {
		if (modalMessage != null)
			modalMessage = null;
	}

	@NotifyChange({ "modalMessage" })
	@Command
	public void confirmCloseOrder() {
		int orderByOrderNumber = serviceOrder.listOrderByOrderNumber(order.getTorderNumber()).size();
		modalMessage = "Esta orden posee " + orderByOrderNumber + " pedidos. ¿Esta seguro de cerrar la orden?";
	}

	@Command
	public void printOrder() {
		GenericReport report = new GenericReport();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("IMAGES_DIR", "../../resource/images/system/");
		map.put("ORDER_NUMBER", order.getTorderNumber().getIdOrderNumber());
		report.createPdf("/resource/reports/orders/", "order.jasper", map, "pedido-cliente.pdf");
		report.viewPdf("/resource/reports/orders/pedido-cliente.pdf", "Pedido cliente");
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}