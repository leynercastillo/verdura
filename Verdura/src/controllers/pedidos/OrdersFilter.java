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
	private String orderNumber = "";
	private String codNumber = "";
	private String customerName = "";
	private String address = "";

	public OrdersFilter() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.serviceOrder = applicationContext.getBean(ServiceOrder.class);
		listOrders = serviceOrder.listAll();
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCodNumber() {
		return codNumber;
	}

	public void setCodNumber(String codNumber) {
		this.codNumber = codNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Torder> getFilter(OrdersFilter ordersFilter) {
		List<Torder> auxListOrders = new ArrayList<Torder>();
		String auxOrderNumber = ordersFilter.getOrderNumber().toLowerCase();
		String auxCodNumber = ordersFilter.getCodNumber().toLowerCase();
		String auxCustomerName = ordersFilter.getCustomerName().toLowerCase();
		String auxAddress = ordersFilter.getAddress().toLowerCase();
		for (Iterator<Torder> i = listOrders.iterator(); i.hasNext();) {
			Torder auxOrder = i.next();
			if (Integer.toString(auxOrder.getTorderNumber().getIdOrderNumber()).contains(auxOrderNumber) && Integer.toString(auxOrder.getCodNumber()).contains(auxCodNumber) && auxOrder.getBpName().toLowerCase().contains(auxCustomerName) && auxOrder.getBpBranchAddress().toLowerCase().contains(auxAddress)) {
				auxListOrders.add(auxOrder);
			}
		}
		return auxListOrders;
	}
}
