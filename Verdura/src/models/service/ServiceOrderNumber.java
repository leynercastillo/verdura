package models.service;

import models.TorderNumber;
import models.dao.DaoOrderNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceOrderNumber {

	@Autowired
	private DaoOrderNumber daoOrderNumber;

	@Transactional
	public boolean save(TorderNumber orderNumber) {
		return daoOrderNumber.save(orderNumber);
	}

	@Transactional
	public boolean closeOrder(TorderNumber orderNumber) {
		orderNumber.setStatus('C');
		if (!daoOrderNumber.update(orderNumber)) {
			return false;
		} else {
			TorderNumber nextOrder = new TorderNumber();
			nextOrder.setStatus('A');
			return daoOrderNumber.save(orderNumber);
		}
	}

	@Transactional(readOnly = true)
	public TorderNumber getMaxOrderNumber() {
		return daoOrderNumber.getWithMaxField("idOrderNumber");
	}
}