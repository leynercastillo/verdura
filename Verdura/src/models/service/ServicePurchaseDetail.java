package models.service;

import models.TpurchaseDetail;
import models.dao.DaoPurchaseDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicePurchaseDetail {

	@Autowired
	private DaoPurchaseDetail daoPurchaseDetail;

	@Transactional
	public boolean save(TpurchaseDetail purchaseDetail) {
		if (purchaseDetail.getIdPurchaseDetail() == 0) {
			return daoPurchaseDetail.save(purchaseDetail);
		} else {
			return daoPurchaseDetail.update(purchaseDetail);
		}
	}

	@Transactional
	public boolean delete(TpurchaseDetail purchaseDetail) {
		if (purchaseDetail.getIdPurchaseDetail() != 0) {
			return daoPurchaseDetail.delete(purchaseDetail);
		} else
			return true;
	}
}
