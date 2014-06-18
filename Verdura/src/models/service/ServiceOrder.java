package models.service;

import models.dao.DaoOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceOrder {

	@Autowired
	private DaoOrder daoOrder;
	
	@Transactional(readOnly = true)
	public Integer getMaxOrderNumber() {
		Integer number = (Integer) daoOrder.getMaxField("orderNumber");
		return number == null ? 1 : number;
	}
}
