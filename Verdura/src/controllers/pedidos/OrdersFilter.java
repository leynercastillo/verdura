package controllers.pedidos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import models.TbusinessPartnerBranch;
import models.Torder;
import models.service.ServiceBusinessPartnerBranch;
import models.service.ServiceOrder;

public class OrdersFilter {

	private ServiceOrder serviceOrder;
	private ServiceBusinessPartnerBranch serviceBusinessPartnerBranch;
	private List<Torder> listOrders;
	private String orderNumber = "";
	private String codNumber = "";
	private String customerName = "";
	private String customerBranchName = "";

	public OrdersFilter() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.serviceOrder = applicationContext.getBean(ServiceOrder.class);
		this.serviceBusinessPartnerBranch = applicationContext.getBean(ServiceBusinessPartnerBranch.class);
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

	public String getCustomerBranchName() {
		return customerBranchName;
	}

	public void setCustomerBranchName(String customerBranchName) {
		this.customerBranchName = customerBranchName;
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
		String auxCustomerBranchName = ordersFilter.getCustomerBranchName().toLowerCase();
		for (Iterator<Torder> i = listOrders.iterator(); i.hasNext();) {
			Torder auxOrder = i.next();
			TbusinessPartnerBranch auxBusinessPartnerBranch = serviceBusinessPartnerBranch.findById(auxOrder.getTbusinessPartnerBranch().getIdBusinessPartnerBranch());
			auxOrder.setTbusinessPartnerBranch(auxBusinessPartnerBranch);
			if (Integer.toString(auxOrder.getTorderNumber().getIdOrderNumber()).contains(auxOrderNumber) && Integer.toString(auxOrder.getCodNumber()).contains(auxCodNumber) && auxOrder.getBpName().toLowerCase().contains(auxCustomerName) && auxOrder.getTbusinessPartnerBranch().getName().toLowerCase().contains(auxCustomerBranchName)) {
				auxListOrders.add(auxOrder);
			}
		}
		return auxListOrders;
	}
}
