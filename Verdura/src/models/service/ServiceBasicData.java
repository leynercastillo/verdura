package models.service;

import java.util.ArrayList;
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
	public TbasicData findSuplier() {
		return daoBasicData.findTypeByString("PROVEEDOR", "name", serviceDataType.getBusinessPartnerType());
	}

	@Transactional(readOnly = true)
	public TbasicData findCustomer() {
		return daoBasicData.findTypeByString("CLIENTE", "name", serviceDataType.getBusinessPartnerType());
	}

	@Transactional(readOnly = true)
	public List<TbasicData> listMeasureUnit() {
		return daoBasicData.listByDataType(serviceDataType.getUnitMeasure());
	}

	@Transactional(readOnly = true)
	public List<TbasicData> listMeasureUnitForOrders() {
		List<TbasicData> auxListMeasure = daoBasicData.listByDataType(serviceDataType.getUnitMeasure());
		List<TbasicData> listMeasure = new ArrayList<TbasicData>();
		for (TbasicData tbasicData : auxListMeasure) {
			if (tbasicData.getIdBasicData() == 18 || tbasicData.getIdBasicData() == 20) {
				listMeasure.add(tbasicData);
			}
		}
		return listMeasure; 
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