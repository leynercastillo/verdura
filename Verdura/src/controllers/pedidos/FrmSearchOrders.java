package controllers.pedidos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Torder;
import models.service.ServiceOrder;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

public class FrmSearchOrders {

	@WireVariable
	private ServiceOrder serviceOrder;
	private List<Torder> listOrders;
	private Torder selectedOrder;
	private OrdersFilter ordersFilter;

	public OrdersFilter getOrdersFilter() {
		return ordersFilter;
	}

	public void setOrdersFilter(OrdersFilter ordersFilter) {
		this.ordersFilter = ordersFilter;
	}

	public Torder getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(Torder selectedOrder) {
		this.selectedOrder = selectedOrder;
	}

	public List<Torder> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Torder> listOrders) {
		this.listOrders = listOrders;
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		listOrders = serviceOrder.listAll();
		selectedOrder = new Torder();
		ordersFilter = new OrdersFilter();
	}

	@NotifyChange({ "selectedOrder" })
	@Command
	public void backToOrder(@BindingParam("window") Window window) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("order", selectedOrder);
		close(window);
		BindUtils.postGlobalCommand(null, null, "selectedOrder", map);
	}

	@NotifyChange({ "listOrders" })
	@Command
	public void dataFilter() {
		listOrders = ordersFilter.getFilter(ordersFilter);
	}

	@Command
	public void close(@BindingParam("window") Window window) {
		window.detach();
	}
}
