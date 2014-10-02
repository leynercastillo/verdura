package models.service;

import java.util.ArrayList;
import java.util.List;

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
		}
		TorderNumber nextOrder = new TorderNumber();
		nextOrder.setStatus('A');
		return daoOrderNumber.save(orderNumber);
	}
	
	@Transactional
	public boolean finishOrder(TorderNumber orderNumber) {
		orderNumber.setStatus('F');
		return daoOrderNumber.update(orderNumber);
	}

	@Transactional(readOnly = true)
	public TorderNumber getMaxOrderNumber() {
		return daoOrderNumber.findMaxField("idOrderNumber");
	}

	@Transactional(readOnly = true)
	public List<String> listNumber() {
		/* Chequear hacer esto mismo con un metodo mas generico */
		List<Integer> list = daoOrderNumber.listIntegerByFields("idOrderNumber");
		List<String> listOrderNumber = new ArrayList<String>();
		for (Integer number : list) {
			listOrderNumber.add(number.toString());
		}
		return listOrderNumber;
	}

	@Transactional(readOnly = true)
	public TorderNumber findByNumber(Integer number) {
		return daoOrderNumber.findById(number);
	}
	
	@Transactional(readOnly = true)
	public TorderNumber findOrderClosed() {
		return daoOrderNumber.findOrderClosed("status", 'C');
	}
}