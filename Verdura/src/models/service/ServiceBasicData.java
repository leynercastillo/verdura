package models.service;

import java.util.List;

import models.dao.DaoBasicData;
import models.TbasicData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBasicData {

	@Autowired
	private DaoBasicData daoBasicData;
	@Autowired
	private ServiceDataType serviceDataType;

	@Transactional
	public Boolean save(TbasicData basicData) {
		if (basicData.getIdBasicData() == 0)
			return daoBasicData.save(basicData);
		else
			return daoBasicData.update(basicData);
	}

	@Transactional(readOnly = true)
	public TbasicData findById(int id) {
		return daoBasicData.findById(id);
	}

	@Transactional(readOnly = true)
	public List<TbasicData> listMeasureUnit() {
		return daoBasicData.listByDataType(serviceDataType.getUnitMeasure());
	}

	@Transactional(readOnly = true)
	public List<TbasicData> listItemType() {
		return daoBasicData.listByDataType(serviceDataType.getItemType());
	}

	@Transactional(readOnly = true)
	public List<TbasicData> listRifType() {
		return daoBasicData.listByDataType(serviceDataType.getRifType());
	}

	@Transactional(readOnly = true)
	public List<TbasicData> listBusinessPartnerType() {
		return daoBasicData.listByDataType(serviceDataType.getBusinessPartnerType());
	}

	@Transactional(readOnly = true)
	public List<TbasicData> listCountries() {
		return daoBasicData.listByDataType(serviceDataType.getCountry());
	}

	@Transactional(readOnly = true)
	public List<TbasicData> listStatesByCountry(TbasicData country) {
		return daoBasicData.listByParent(country);
	}

	@Transactional(readOnly = true)
	public List<TbasicData> listCitiesByCountry(TbasicData state) {
		return daoBasicData.listByParent(state);
	}
}