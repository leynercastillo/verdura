package models.service;

import java.util.List;

import models.Torder;
import models.TorderNumber;
import models.dao.DaoOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceOrder {

	@Autowired
	private DaoOrder daoOrder;

	@Transactional
	public boolean save(Torder order) {
		if (order.getIdOrder() == 0) {
			return daoOrder.save(order);
		} else {
			return daoOrder.update(order);
		}
	}

	@Transactional(readOnly = true)
	public List<Torder> listAll() {
		return daoOrder.listAll();
	}

	@Transactional(readOnly = true)
	public Torder findById(Integer id) {
		return daoOrder.findByField(id, "idOrder");
	}

	@Transactional(readOnly = true)
	public List<Torder> listOrderByOrderNumber(TorderNumber orderNumber) {
		return daoOrder.listOrderByField(orderNumber, "torderNumber");
	}
}