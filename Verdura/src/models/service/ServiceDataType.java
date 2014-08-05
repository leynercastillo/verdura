package models.service;

import models.TdataType;
import models.dao.DaoDataType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceDataType {

	@Autowired
	private DaoDataType daoDataType;

	@Transactional(readOnly = true)
	public TdataType getUnitMeasure() {
		return daoDataType.findByName("UNIT MEASURE");
	}
	
	@Transactional(readOnly = true)
	public TdataType getUnitMeasureForOrders() {
		return daoDataType.findByName("UNIT MEASURE ORDER");
	}

	@Transactional(readOnly = true)
	public TdataType getItemType() {
		return daoDataType.findByName("ITEM TYPE");
	}

	@Transactional(readOnly = true)
	public TdataType getRifType() {
		return daoDataType.findByName("RIF TYPE");
	}

	@Transactional(readOnly = true)
	public TdataType getBusinessPartnerType() {
		return daoDataType.findByName("BUSINESS PARTNER TYPE");
	}

	@Transactional(readOnly = true)
	public TdataType getCountry() {
		return daoDataType.findByName("COUNTRY");
	}
}