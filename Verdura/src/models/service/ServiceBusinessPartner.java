package models.service;

import java.util.List;

import models.TbusinessPartner;
import models.dao.DaoBusinessPartner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBusinessPartner {

	@Autowired
	private DaoBusinessPartner daoBusinessPartner;
	
	@Transactional
	public boolean save(TbusinessPartner businessPartner){
		if (businessPartner.getIdBusinessPartner() == 0) {
			return daoBusinessPartner.save(businessPartner);
		}else {
			return daoBusinessPartner.update(businessPartner);
		}
	}

	@Transactional(readOnly = true)
	public TbusinessPartner findByRif(String rif) {
		return daoBusinessPartner.findByString(rif, "rif");
	}

	@Transactional(readOnly = true)
	public List<String> listNames() {
		return daoBusinessPartner.listStringByField("name");
	}

	@Transactional(readOnly = true)
	public List<String> listRif() {
		return daoBusinessPartner.listStringByField("rif");
	}

	@Transactional(readOnly = true)
	public List<TbusinessPartner> listByName(String name) {
		return daoBusinessPartner.listByString("name", name);
	}
}