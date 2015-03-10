package controllers.despacho.ruta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Troute;
import models.service.ServiceRoute;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

public class CtrlSearchRoute {

	@WireVariable
	private ServiceRoute serviceRoute;
	private List<Troute> listRoute;
	private Troute selectedRoute;
	private RouteFilter routeFilter;

	public RouteFilter getRouteFilter() {
		return routeFilter;
	}

	public void setRouteFilter(RouteFilter routeFilter) {
		this.routeFilter = routeFilter;
	}

	public Troute getSelectedRoute() {
		return selectedRoute;
	}

	public void setSelectedRoute(Troute selectedRoute) {
		this.selectedRoute = selectedRoute;
	}

	public List<Troute> getListRoute() {
		return listRoute;
	}

	public void setListRoute(List<Troute> listRoute) {
		this.listRoute = listRoute;
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		listRoute = serviceRoute.listAll();
		selectedRoute = new Troute();
		routeFilter = new RouteFilter();
	}

	@NotifyChange({ "selectedRoute" })
	@Command
	public void backToForm(@BindingParam("window") Window window) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("route", selectedRoute);
		close(window);
		BindUtils.postGlobalCommand(null, null, "selectedRoute", map);
	}

	@NotifyChange({ "listRoute" })
	@Command
	public void dataFilter() {
		listRoute = routeFilter.getFilter(routeFilter);
	}

	@Command
	public void close(@BindingParam("window") Window window) {
		window.detach();
	}
}
