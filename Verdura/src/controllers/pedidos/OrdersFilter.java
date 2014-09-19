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
	private String providerName = "";
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

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public List<Torder> getFilter(OrdersFilter ordersFilter) {
		List<Torder> auxListOrders = new ArrayList<Torder>();
		String auxOrderNumber = ordersFilter.getOrderNumber().toLowerCase();
		String auxCodNumber = ordersFilter.getCodNumber().toLowerCase();
		String auxProviderName = ordersFilter.getProviderName().toLowerCase();
		String auxAddress = ordersFilter.getAddress().toLowerCase();
		for (Iterator<Torder> i = listOrders.iterator(); i.hasNext();) {
			Torder auxOrder = i.next();
			if (Integer.toString(auxOrder.getTorderNumber().getIdOrderNumber()).contains(auxOrderNumber) && Integer.toString(auxOrder.getCodNumber()).contains(auxCodNumber) && auxOrder.getBpName().toLowerCase().contains(auxProviderName) && auxOrder.getBpBranchAddress().toLowerCase().contains(auxAddress)) {
				auxListOrders.add(auxOrder);
			}
		}
		return auxListOrders;
	}
}
