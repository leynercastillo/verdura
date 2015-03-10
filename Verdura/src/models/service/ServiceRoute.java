package models.service;

import java.util.List;

import models.Troute;
import models.dao.DaoRoute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceRoute {

	@Autowired
	private DaoRoute daoRoute;

	@Transactional(readOnly = true)
	public Integer getMaxPurchaseNumber() {
		Integer maxCodNumber = daoRoute.getMaxField("code");
		if (maxCodNumber == null)
			maxCodNumber = 0;
		return maxCodNumber + 1;
	}

	@Transactional
	public boolean save(Troute route) {
		if (route.getIdRoute() == 0) {
			return daoRoute.save(route);
		} else {
			return daoRoute.update(route);
		}
	}

	@Transactional(readOnly = true)
	public Troute findById(int id) {
		return daoRoute.findByField(id, "idRoute");
	}

	@Transactional(readOnly = true)
	public List<Troute> listAll() {
		return daoRoute.listAll();
	}

	@Transactional(readOnly = true)
	public List<Troute> listActive() {
		return daoRoute.listByField("status", 'A');
	}
}