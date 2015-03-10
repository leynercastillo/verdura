package models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.TbusinessPartnerBranch;
import models.dao.DaoBusinessPartnerBranch;

@Service
public class ServiceBusinessPartnerBranch {

	@Autowired
	private DaoBusinessPartnerBranch daoBusinessPartnerBranch;
	@Autowired
	private ServiceBasicData serviceBasicData;

	@Transactional
	public boolean save(TbusinessPartnerBranch businessPartnerBranch) {
		if (businessPartnerBranch.getIdBusinessPartnerBranch() == 0) {
			return daoBusinessPartnerBranch.save(businessPartnerBranch);
		} else {
			return daoBusinessPartnerBranch.update(businessPartnerBranch);
		}
	}

	@Transactional
	public boolean delete(TbusinessPartnerBranch businessPartnerBranch) {
		if (businessPartnerBranch.getIdBusinessPartnerBranch() != 0)
			return daoBusinessPartnerBranch.delete(businessPartnerBranch);
		else
			return true;
	}

	@Transactional(readOnly = true)
	public List<TbusinessPartnerBranch> listAllCustomersActive() {
		return daoBusinessPartnerBranch.listAllActiveByType(serviceBasicData.findCustomer());
	}

	@Transactional(readOnly = true)
	public TbusinessPartnerBranch findById(Integer id) {
		return daoBusinessPartnerBranch.findByField(id, "idBusinessPartnerBranch");
	}

	@Transactional(readOnly = true)
	public List<TbusinessPartnerBranch> listPartnerBySearch(String rif, String partnerName, String branchName, String branchContactName) {
		if (rif == null) {
			rif = "";
		}
		if (partnerName == null) {
			partnerName = "";
		}
		if (branchName == null) {
			branchName = "";
		}
		if (branchContactName == null) {
			branchContactName = "";
		}
		return daoBusinessPartnerBranch.listSearch(rif, partnerName, branchName, branchContactName);
	}
}
