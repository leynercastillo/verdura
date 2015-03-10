package controllers.despacho.ruta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import general.ValidateZK;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import models.TbusinessPartnerBranch;
import models.TbusinessPartnerRoute;
import models.Troute;
import models.service.ServiceBasicData;
import models.service.ServiceBusinessPartnerBranch;
import models.service.ServiceBusinessPartnerRoute;
import models.service.ServiceRoute;

public class CtrlTruckRoute {

	@WireVariable
	private ServiceRoute serviceRoute;
	@WireVariable
	private ServiceBusinessPartnerBranch serviceBusinessPartnerBranch;
	@WireVariable
	private ServiceBasicData serviceBasicData;
	@WireVariable
	private ServiceBusinessPartnerRoute serviceBusinessPartnerRoute;

	private Troute route;
	private Boolean disableAll;
	private ListModel<Object> listBusinessPartnerName;
	private List<TbusinessPartnerRoute> listPartnerBranchForDelete;

	public List<TbusinessPartnerRoute> getListPartnerBranchForDelete() {
		return listPartnerBranchForDelete;
	}

	public void setListPartnerBranchForDelete(List<TbusinessPartnerRoute> listPartnerBranchForDelete) {
		this.listPartnerBranchForDelete = listPartnerBranchForDelete;
	}

	public ListModel<Object> getListBusinessPartnerName() {
		return listBusinessPartnerName;
	}

	public void setListBusinessPartnerName(ListModel<Object> listBusinessPartnerName) {
		this.listBusinessPartnerName = listBusinessPartnerName;
	}

	public Boolean getDisableAll() {
		return disableAll;
	}

	public void setDisableAll(Boolean disableAll) {
		this.disableAll = disableAll;
	}

	public Troute getRoute() {
		return route;
	}

	public void setRoute(Troute route) {
		this.route = route;
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		route = new Troute();
		route.setCode(serviceRoute.getMaxPurchaseNumber());
		route.setStatus('A');
		disableAll = false;
		listBusinessPartnerName = new ListModelList<Object>();
		listPartnerBranchForDelete = new ArrayList<TbusinessPartnerRoute>();
	}

	@Command
	public void searchPartnerBranch() {
		Executions.createComponents("system/despacho/rutas/frmSearchBusinessPartner.zul", null, null);
	}

	@Command
	public void search() {
		Executions.createComponents("system/despacho/rutas/frmSearchRoute.zul", null, null);
	}

	@NotifyChange({ "disableAll" })
	@Command
	public void edit() {
		disableAll = false;
	}

	@NotifyChange("*")
	@Command
	public void save(@BindingParam("lbx") Component component) {
		if (route.getTbusinessPartnerRoutes().isEmpty()) {
			throw new WrongValueException(component, "Debe asignar al menos una sucursal por ruta");
		} else {
			if (!serviceRoute.save(route)) {
				Clients.showNotification("Fallo guardado de la ruta", "error", null, "middle_center", 2000);
				return;
			}
			for (TbusinessPartnerRoute tbusinessPartnerRoute : listPartnerBranchForDelete) {
				if (!serviceBusinessPartnerRoute.deleteBusinessPartnerRoute(tbusinessPartnerRoute)) {
					Clients.showNotification("Fallo eliminado de las sucursales", "error", null, "middle_center", 2000);
					return;
				}
			}
			for (TbusinessPartnerRoute tbusinessPartnerRoute : route.getTbusinessPartnerRoutes()) {
				tbusinessPartnerRoute.setTroute(route);
				if (!serviceBusinessPartnerRoute.save(tbusinessPartnerRoute)) {
					Clients.showNotification("Fallo guardando de las sucursales", "error", null, "middle_center", 2000);
					return;
				}
			}
		}
		Clients.showNotification("Ruta guardada correctamente", "info", null, "middle_center", 2000);
		restartForm();
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}

	@Command
	public void removePartner(@BindingParam("partner") TbusinessPartnerRoute partner) {
		for (TbusinessPartnerRoute auxBusinessPartnerRoute : route.getTbusinessPartnerRoutes()) {
			if (auxBusinessPartnerRoute.getTbusinessPartnerBranch().getIdBusinessPartnerBranch() == partner.getTbusinessPartnerBranch().getIdBusinessPartnerBranch()) {
				listPartnerBranchForDelete.add(auxBusinessPartnerRoute);
				route.getTbusinessPartnerRoutes().remove(auxBusinessPartnerRoute);
				break;
			}
		}
		BindUtils.postNotifyChange(null, null, route, "tbusinessPartnerRoutes");
	}

	@GlobalCommand
	public void selectedCustomers(@BindingParam("listCustomers") Set<TbusinessPartnerBranch> listSelectedCustomers) {
		List<TbusinessPartnerRoute> auxList = new ArrayList<TbusinessPartnerRoute>();
		for (TbusinessPartnerBranch auxBusinessPartnerBranch : listSelectedCustomers) {
			if (route.getTbusinessPartnerRoutes().size() != 0) {
				boolean found = false;
				for (TbusinessPartnerRoute routeBusinessPartnerBranch : route.getTbusinessPartnerRoutes()) {
					if (auxBusinessPartnerBranch.getIdBusinessPartnerBranch() == routeBusinessPartnerBranch.getTbusinessPartnerBranch().getIdBusinessPartnerBranch()) {
						found = true;
					}
				}
				if (!found) {
					auxBusinessPartnerBranch.setTbasicData(serviceBasicData.findById(auxBusinessPartnerBranch.getTbasicData().getIdBasicData()));
					TbusinessPartnerRoute businessPartnerRoute = new TbusinessPartnerRoute();
					businessPartnerRoute.setStatus('A');
					businessPartnerRoute.setTbusinessPartnerBranch(auxBusinessPartnerBranch);
					businessPartnerRoute.setTroute(route);
					auxList.add(businessPartnerRoute);
				}
			} else {
				auxBusinessPartnerBranch.setTbasicData(serviceBasicData.findById(auxBusinessPartnerBranch.getTbasicData().getIdBasicData()));
				TbusinessPartnerRoute businessPartnerRoute = new TbusinessPartnerRoute();
				businessPartnerRoute.setStatus('A');
				businessPartnerRoute.setTbusinessPartnerBranch(auxBusinessPartnerBranch);
				businessPartnerRoute.setTroute(route);
				auxList.add(businessPartnerRoute);
			}
		}
		route.getTbusinessPartnerRoutes().addAll(auxList);
		BindUtils.postNotifyChange(null, null, route, "tbusinessPartnerRoutes");
	}

	@NotifyChange({ "route", "disableAll" })
	@GlobalCommand
	public void selectedRoute(@BindingParam("route") Troute selectedRoute) {
		route = selectedRoute;
		route.setTbusinessPartnerRoutes(serviceBusinessPartnerRoute.listPartnerByRoute(selectedRoute));
		disableAll = true;
	}
}