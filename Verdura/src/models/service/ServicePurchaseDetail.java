package models.service;

import models.dao.DaoPurchaseDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePurchaseDetail {

	@Autowired
	private DaoPurchaseDetail daoPurchaseDetail;
}
