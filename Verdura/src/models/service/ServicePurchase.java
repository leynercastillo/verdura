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
}
