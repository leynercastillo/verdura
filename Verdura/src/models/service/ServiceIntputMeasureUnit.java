package models.service;

import java.util.List;

import models.TinputMeasureUnit;
import models.Titem;
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

	@Transactional(readOnly = true)
	public List<TinputMeasureUnit> listByItem(Titem item) {
		return daoInputMeasureUnit.listByField("titem", item);
	}
}
