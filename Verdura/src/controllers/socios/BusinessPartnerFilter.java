package controllers.socios;

import java.util.List;

import models.TbusinessPartnerBranch;
import models.service.ServiceBusinessPartnerBranch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BusinessPartnerFilter {

	private ServiceBusinessPartnerBranch serviceBusinessPartnerBranch;
	private String rif = "";
	private String name = "";
	private String partnerBranchName = "";
	private String contactName = "";

	public BusinessPartnerFilter() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.serviceBusinessPartnerBranch = applicationContext.getBean(ServiceBusinessPartnerBranch.class);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	public String getPartnerBranchName() {
		return partnerBranchName;
	}

	public void setPartnerBranchName(String partnerBranchName) {
		this.partnerBranchName = partnerBranchName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public List<TbusinessPartnerBranch> getFilter(BusinessPartnerFilter businessPartnerFilter) {
		List<TbusinessPartnerBranch> auxListPartner = serviceBusinessPartnerBranch.listPartnerBySearch(businessPartnerFilter.getRif(), businessPartnerFilter.getName(), businessPartnerFilter.getPartnerBranchName(), businessPartnerFilter.getContactName());
		return auxListPartner;
	}
}