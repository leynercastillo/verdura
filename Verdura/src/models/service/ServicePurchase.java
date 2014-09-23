package models.service;

import java.util.List;

import models.TorderNumber;
import models.Tpurchase;
import models.dao.DaoPurchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicePurchase {

	@Autowired
	private DaoPurchase daoPurchase;

	@Transactional
	public boolean save(Tpurchase purchase) {
		if (purchase.getIdPurchase() == 0) {
			return daoPurchase.save(purchase);
		} else {
			return daoPurchase.update(purchase);
		}
	}

	@Transactional(readOnly = true)
	public Tpurchase findById(Integer id) {
		return daoPurchase.findByField(id, "idPurchase");
	}

	@Transactional(readOnly = true)
	public Integer getMaxPurchaseNumber() {
		Integer maxCodNumber = daoPurchase.getMaxField("purchaseNumber");
		if (maxCodNumber == null)
			maxCodNumber = 0;
		return maxCodNumber + 1;
	}

	@Transactional(readOnly = true)
	public List<Tpurchase> listOrderByOrderNumber(TorderNumber orderNumber) {
		return daoPurchase.listPurchaseByField(orderNumber, "torderNumber");
	}

	@Transactional(readOnly = true)
	public List<Tpurchase> listAll() {
		return daoPurchase.listAll();
	}
}
