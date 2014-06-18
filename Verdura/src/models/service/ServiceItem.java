package models.service;

import java.util.List;

import models.Titem;
import models.dao.DaoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceItem {

	@Autowired
	private DaoItem daoItem;

	@Transactional
	public boolean save(Titem item) {
		if (item.getIdItem() == 0) {
			return daoItem.save(item);
		} else {
			return daoItem.update(item);
		}
	}

	@Transactional(readOnly = true)
	public Titem findByCode(String code) {
		return daoItem.findByString(code, "code");
	}

	@Transactional(readOnly = true)
	public List<String> listCodes() {
		return daoItem.listStringByFields("code");
	}

	@Transactional(readOnly = true)
	public List<String> listNames() {
		return daoItem.listStringByFields("name");
	}

	@Transactional(readOnly = true)
	public List<Titem> listByName(String name) {
		return daoItem.listByString("name", name);
	}
	
	@Transactional(readOnly = true)
	public List<Titem> listActive(){
		return daoItem.listActiveOrderedByField("name");
	}
}
