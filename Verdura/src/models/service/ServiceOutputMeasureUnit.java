package models.service;

import models.ToutputMeasureUnit;
import models.dao.DaoOutputMeasureUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceOutputMeasureUnit {

	@Autowired
	private DaoOutputMeasureUnit daoOutputMeasureUnit;

	@Transactional
	public boolean save(ToutputMeasureUnit outputMeasureUnit) {
		if (outputMeasureUnit.getIdOutputMeasureUnit() == 0) {
			return daoOutputMeasureUnit.save(outputMeasureUnit);
		} else {
			return daoOutputMeasureUnit.update(outputMeasureUnit);
		}
	}
	
	@Transactional
	public boolean delete(ToutputMeasureUnit outputMeasureUnit) {
		return daoOutputMeasureUnit.delete(outputMeasureUnit);
	}
}
