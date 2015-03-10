package controllers.despacho.guia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import general.ValidateZK;
import models.TbusinessPartnerRoute;
import models.TorderNumber;
import models.Troute;
import models.Tvehicle;
import models.Twaybill;
import models.service.ServiceOrderNumber;
import models.service.ServiceRoute;
import models.service.ServiceVehicle;
import models.service.ServiceWayBill;

import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class CtrlWayBill {

	@WireVariable
	private ServiceRoute serviceRoute;
	@WireVariable
	private ServiceVehicle serviceVehicle;
	@WireVariable
	private ServiceWayBill serviceWayBill;
	@WireVariable
	private ServiceOrderNumber serviceOrderNumber;

	private List<Troute> listRoute;
	private List<Tvehicle> listVehiculo;
	private List<TbusinessPartnerRoute> listBusinessPartnerRoute;
	private List<TorderNumber> listOrderFinished;

	private Twaybill waybill;
	private Boolean disableAll;
	private String select;

	public List<TorderNumber> getListOrderFinished() {
		return listOrderFinished;
	}

	public void setListOrderFinished(List<TorderNumber> listOrderFinished) {
		this.listOrderFinished = listOrderFinished;
	}

	public List<TbusinessPartnerRoute> getListBusinessPartnerRoute() {
		return listBusinessPartnerRoute;
	}

	public void setListBusinessPartnerRoute(List<TbusinessPartnerRoute> listBusinessPartnerRoute) {
		this.listBusinessPartnerRoute = listBusinessPartnerRoute;
	}

	public List<Tvehicle> getListVehiculo() {
		return listVehiculo;
	}

	public void setListVehiculo(List<Tvehicle> listVehiculo) {
		this.listVehiculo = listVehiculo;
	}

	public List<Troute> getListRoute() {
		return listRoute;
	}

	public void setListRoute(List<Troute> listRoute) {
		this.listRoute = listRoute;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public Twaybill getWaybill() {
		return waybill;
	}

	public void setWaybill(Twaybill waybill) {
		this.waybill = waybill;
	}

	public Boolean getDisableAll() {
		return disableAll;
	}

	public void setDisableAll(Boolean disableAll) {
		this.disableAll = disableAll;
	}

	public Validator getNoSelect() {
		return new ValidateZK().getNoSelect();
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		if (waybill == null) {
			waybill = new Twaybill();
		} else {
			//waybill.
		}
		waybill.setDate(new Date());
		waybill.setNumber(serviceWayBill.getMaxNumber());
		listRoute = serviceRoute.listActive();
		listVehiculo = serviceVehicle.listActive();
		listBusinessPartnerRoute = null;
		listOrderFinished = serviceOrderNumber.listOrderFinished();
		select = "--Seleccione--";
		disableAll = false;
	}

	@NotifyChange("listBusinessPartnerRoute")
	@Command
	public void selectingRoute() {
		listBusinessPartnerRoute = new ArrayList<TbusinessPartnerRoute>(serviceRoute.findById(waybill.getTroute().getIdRoute()).getTbusinessPartnerRoutes());
	}

	@NotifyChange("listBusinessPartnerRoute")
	@Command
	public void selectOrder() {
		if (waybill.getTroute() == null) {
		} else {
		}
	}
}