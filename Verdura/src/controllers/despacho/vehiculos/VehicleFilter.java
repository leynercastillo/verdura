package controllers.despacho.vehiculos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import models.Tvehicle;
import models.service.ServiceVehicle;

public class VehicleFilter {

	private ServiceVehicle serviceVehicle;
	private List<Tvehicle> listVehicle;
	private String docNum = "";
	private String model = "";
	private String owner = "";
	private String capacity = "";

	public VehicleFilter() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.serviceVehicle = applicationContext.getBean(ServiceVehicle.class);
		listVehicle = serviceVehicle.listAll();
	}

	public String getDocNum() {
		return docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public List<Tvehicle> getFilter(VehicleFilter vehicleFilter) {
		List<Tvehicle> auxListVehicle = new ArrayList<Tvehicle>();
		String auxDocNum = vehicleFilter.getDocNum().toLowerCase();
		String auxModel = vehicleFilter.getModel().toLowerCase();
		String auxOwner = vehicleFilter.getOwner().toLowerCase();
		String auxCapacity = vehicleFilter.getCapacity().toLowerCase();
		for (Iterator<Tvehicle> i = listVehicle.iterator(); i.hasNext();) {
			Tvehicle auxVehicle = i.next();
			if (auxVehicle.getDocNum().toLowerCase().contains(auxDocNum) && auxVehicle.getModel().toLowerCase().contains(auxModel) && auxVehicle.getOwner().toLowerCase().contains(auxOwner) && Float.toString(auxVehicle.getCapacity()).contains(auxCapacity)) {
				auxListVehicle.add(auxVehicle);
			}
		}
		return auxListVehicle;
	}
}
