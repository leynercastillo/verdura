package models.service;

import java.util.List;

import models.Tvehicle;
import models.dao.DaoVehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceVehicle {

	@Autowired
	private DaoVehicle daoVehicle;

	@Transactional
	public Boolean save(Tvehicle vehicle) {
		if (vehicle.getIdVehicle() == 0)
			return daoVehicle.save(vehicle);
		else
			return daoVehicle.update(vehicle);
	}

	@Transactional(readOnly = true)
	public List<Tvehicle> listAll() {
		return daoVehicle.listAll();
	}

	@Transactional(readOnly = true)
	public List<Tvehicle> listByDocNum(String docNum) {
		return daoVehicle.listByField("docNum", docNum);
	}

	@Transactional(readOnly = true)
	public List<String> listDocNum() {
		return daoVehicle.listStringByField("docNum");
	}

	@Transactional(readOnly = true)
	public List<String> listModel() {
		return daoVehicle.listStringByField("model");
	}

	@Transactional(readOnly = true)
	public Tvehicle findByDocNum(String docNum) {
		List<Tvehicle> list = daoVehicle.listByField("docNum", docNum);
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	@Transactional(readOnly = true)
	public List<Tvehicle> listByModel(String model) {
		return daoVehicle.listByField("model", model);
	}

	@Transactional(readOnly = true)
	public List<Tvehicle> listByOwner(String owner) {
		return daoVehicle.listByField("owner", owner);
	}

	@Transactional(readOnly = true)
	public List<String> listOwner() {
		return daoVehicle.listStringByField("owner");
	}
}
