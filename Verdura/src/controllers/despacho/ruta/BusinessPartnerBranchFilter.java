package controllers.despacho.ruta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.TbusinessPartnerBranch;
import models.service.ServiceBasicData;
import models.service.ServiceBusinessPartner;
import models.service.ServiceBusinessPartnerBranch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BusinessPartnerBranchFilter {

	private ServiceBusinessPartnerBranch serviceBusinessPartnerBranch;
	private ServiceBusinessPartner serviceBusinessPartner;
	private ServiceBasicData serviceBasicData;
	private List<TbusinessPartnerBranch> listPartners;
	private String rif = "";
	private String name = "";
	private String branchName = "";
	private String address = "";

	public BusinessPartnerBranchFilter() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.serviceBusinessPartnerBranch = applicationContext.getBean(ServiceBusinessPartnerBranch.class);
		this.serviceBusinessPartner = applicationContext.getBean(ServiceBusinessPartner.class);
		this.serviceBasicData = applicationContext.getBean(ServiceBasicData.class);
		listPartners = serviceBusinessPartnerBranch.listAllCustomersActive();
	}

	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<TbusinessPartnerBranch> getFilter(BusinessPartnerBranchFilter partnerFilter) {
		List<TbusinessPartnerBranch> auxListPartners = new ArrayList<TbusinessPartnerBranch>();
		String auxRif = partnerFilter.getRif().toLowerCase();
		String auxName = partnerFilter.getName().toLowerCase();
		String auxBranchName = partnerFilter.getBranchName().toLowerCase();
		String auxAddress = partnerFilter.getAddress().toLowerCase();
		for (Iterator<TbusinessPartnerBranch> i = listPartners.iterator(); i.hasNext();) {
			TbusinessPartnerBranch auxPartnerBranch = i.next();
			auxPartnerBranch = serviceBusinessPartnerBranch.findById(auxPartnerBranch.getIdBusinessPartnerBranch());
			auxPartnerBranch.setTbusinessPartner(serviceBusinessPartner.findById(auxPartnerBranch.getTbusinessPartner().getIdBusinessPartner()));
			auxPartnerBranch.getTbusinessPartner().setTbasicDataByRifType(serviceBasicData.findById(auxPartnerBranch.getTbusinessPartner().getTbasicDataByRifType().getIdBasicData()));
			String auxPartnerRif = auxPartnerBranch.getTbusinessPartner().getTbasicDataByRifType().getName() + "-" + auxPartnerBranch.getTbusinessPartner().getRif();
			if (auxPartnerRif.toLowerCase().contains(auxRif) && auxPartnerBranch.getTbusinessPartner().getName().toLowerCase().contains(auxName) && auxPartnerBranch.getName().toLowerCase().contains(auxBranchName) && auxPartnerBranch.getAddress().toLowerCase().contains(auxAddress)) {
				auxListPartners.add(auxPartnerBranch);
			}
		}
		return auxListPartners;
	}
}
