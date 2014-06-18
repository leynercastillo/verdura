package models.service;

import models.TinputMeasureUnit;
import models.dao.DaoInputMeasureUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceIntputMeasureUnit {

	@Autowired
	private DaoInputMeasureUnit daoInputMeasureUnit;

	@Transactional
	public boolean save(TinputMeasureUnit inputMeasureUnit) {
		if (inputMeasureUnit.getIdInputMeasureUnit() == 0) {
			return daoInputMeasureUnit.save(inputMeasureUnit);
		} else {
			return daoInputMeasureUnit.update(inputMeasureUnit);
		}
	}
	
	@Transactional
	public boolean delete(TinputMeasureUnit inputMeasureUnit) {
		return daoInputMeasureUnit.delete(inputMeasureUnit);
	}
}
