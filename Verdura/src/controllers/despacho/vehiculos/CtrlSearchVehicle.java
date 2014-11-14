package controllers.despacho.vehiculos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

import models.Tvehicle;
import models.service.ServiceVehicle;

public class CtrlSearchVehicle {

	@WireVariable
	private ServiceVehicle serviceVehicle;
	private List<Tvehicle> listVehicle;
	private Tvehicle selectedVehicle;
	private VehicleFilter vehicleFilter;

	public VehicleFilter getVehicleFilter() {
		return vehicleFilter;
	}

	public void setVehicleFilter(VehicleFilter vehicleFilter) {
		this.vehicleFilter = vehicleFilter;
	}

	public Tvehicle getSelectedVehicle() {
		return selectedVehicle;
	}

	public void setSelectedVehicle(Tvehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
	}

	public List<Tvehicle> getListVehicle() {
		return listVehicle;
	}

	public void setListVehicle(List<Tvehicle> listVehicle) {
		this.listVehicle = listVehicle;
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		listVehicle = serviceVehicle.listAll();
		selectedVehicle = new Tvehicle();
		vehicleFilter = new VehicleFilter();
	}

	@NotifyChange({ "selectedVehicle" })
	@Command
	public void backToForm(@BindingParam("window") Window window) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vehicle", selectedVehicle);
		close(window);
		BindUtils.postGlobalCommand(null, null, "selectedVehicle", map);
	}

	@NotifyChange({ "listVehicle" })
	@Command
	public void dataFilter() {
		listVehicle = vehicleFilter.getFilter(vehicleFilter);
	}

	@Command
	public void close(@BindingParam("window") Window window) {
		window.detach();
	}
}
