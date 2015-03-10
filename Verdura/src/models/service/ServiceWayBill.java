package models.service;

import models.dao.DaoWayBill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceWayBill {

	@Autowired
	private DaoWayBill daoWayBill;

	@Transactional(readOnly = true)
	public Integer getMaxNumber() {
		Integer maxNumber = daoWayBill.getMaxField("number");
		if (maxNumber == null)
			maxNumber = 0;
		return maxNumber + 1;
	}
}