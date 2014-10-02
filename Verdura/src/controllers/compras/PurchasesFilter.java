package controllers.compras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import models.TbusinessPartnerBranch;
import models.Tpurchase;
import models.service.ServiceBusinessPartnerBranch;
import models.service.ServicePurchase;

public class PurchasesFilter {

	private ServicePurchase servicePurchase;
	private ServiceBusinessPartnerBranch serviceBusinessPartnerBranch;
	private List<Tpurchase> listPurchases;
	private String orderNumber = "";
	private String purchaseNumber = "";
	private String providerName = "";
	private String providerBranchName = "";

	public PurchasesFilter() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.servicePurchase = applicationContext.getBean(ServicePurchase.class);
		this.serviceBusinessPartnerBranch = applicationContext.getBean(ServiceBusinessPartnerBranch.class);
		listPurchases = servicePurchase.listAll();
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderBranchName() {
		return providerBranchName;
	}

	public void setProviderBranchName(String providerBranchName) {
		this.providerBranchName = providerBranchName;
	}

	public List<Tpurchase> getFilter(PurchasesFilter purchasesFilter) {
		List<Tpurchase> auxListPurchases = new ArrayList<Tpurchase>();
		String auxOrderNumber = purchasesFilter.getOrderNumber().toLowerCase();
		String auxPurchaseNumber = purchasesFilter.getPurchaseNumber().toLowerCase();
		String auxProviderName = purchasesFilter.getProviderName().toLowerCase();
		String auxProviderBranchName = purchasesFilter.getProviderBranchName().toLowerCase();
		for (Iterator<Tpurchase> i = listPurchases.iterator(); i.hasNext();) {
			Tpurchase auxPurchase = i.next();
			TbusinessPartnerBranch auxBusinessPartnerBranch = serviceBusinessPartnerBranch.findById(auxPurchase.getTbusinessPartnerBranch().getIdBusinessPartnerBranch());
			auxPurchase.setTbusinessPartnerBranch(auxBusinessPartnerBranch);
			if (Integer.toString(auxPurchase.getTorderNumber().getIdOrderNumber()).contains(auxOrderNumber) && Integer.toString(auxPurchase.getPurchaseNumber()).contains(auxPurchaseNumber) && auxPurchase.getBpName().toLowerCase().contains(auxProviderName) && auxPurchase.getTbusinessPartnerBranch().getName().toLowerCase().contains(auxProviderBranchName)) {
				auxListPurchases.add(auxPurchase);
			}
		}
		return auxListPurchases;
	}
}
