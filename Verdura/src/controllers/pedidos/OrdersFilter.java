package controllers.pedidos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import models.Torder;
import models.service.ServiceOrder;

public class OrdersFilter {

	private ServiceOrder serviceOrder;
	private List<Torder> listOrders;
	private int orderNumber;
	private String providerName;
	private String address;

	public OrdersFilter() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.serviceOrder = applicationContext.getBean(ServiceOrder.class);
		listOrders = serviceOrder.listAll();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? "" : address.trim();
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName == null ? "" : providerName.trim();
	}

	public List<Torder> getFilter(OrdersFilter ordersFilter) {
		List<Torder> auxListOrders = new ArrayList<Torder>();
		Integer auxOrderNumber = ordersFilter.getOrderNumber() == 0 ? null : orderNumber;
		String auxProviderName = ordersFilter.getProviderName().toLowerCase();
		String auxAddress = ordersFilter.getAddress().toLowerCase();
		for (Iterator<Torder> i = listOrders.iterator(); i.hasNext();) {
			Torder auxOrder = i.next();
			if (auxOrder.getTorderNumber().getIdOrderNumber() == auxOrderNumber && auxOrder.getBpName().toLowerCase().contains(auxProviderName) && auxOrder.getBpBranchAddress().toLowerCase().contains(auxAddress)) {
				auxListOrders.add(auxOrder);
			}
		}
		return auxListOrders;
	}
}
