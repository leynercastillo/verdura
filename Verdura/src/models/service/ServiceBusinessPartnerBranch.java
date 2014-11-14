package models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.TbusinessPartnerBranch;
import models.dao.DaoBusinessPartnerBranch;

@Service
public class ServiceBusinessPartnerBranch {

	@Autowired
	private DaoBusinessPartnerBranch daoBusinessPartnerBranch;

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
	public TbusinessPartnerBranch findById(Integer id) {
		return daoBusinessPartnerBranch.findByField(id, "idBusinessPartnerBranch");
	}
}
