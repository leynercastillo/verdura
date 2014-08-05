package models.service;

import models.TorderDetail;
import models.dao.DaoOrderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceOrderDetail {

	@Autowired
	private DaoOrderDetail daoOrderDetail;

	@Transactional
	public boolean save(TorderDetail orderDetail) {
		if (orderDetail.getIdOrderDetail() == 0) {
			return daoOrderDetail.save(orderDetail);
		} else {
			return daoOrderDetail.update(orderDetail);
		}
	}
}
