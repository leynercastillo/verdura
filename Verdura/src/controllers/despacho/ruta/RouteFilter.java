package controllers.despacho.ruta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Troute;
import models.service.ServiceRoute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RouteFilter {

	private ServiceRoute serviceRoute;
	private List<Troute> listRoute;
	private String code = "";
	private String description = "";

	public RouteFilter() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.serviceRoute = applicationContext.getBean(ServiceRoute.class);
		listRoute = serviceRoute.listAll();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Troute> getFilter(RouteFilter routeFilter) {
		List<Troute> auxListRoute = new ArrayList<Troute>();
		String auxCode = routeFilter.getCode().toLowerCase();
		String auxDescription = routeFilter.getDescription().toLowerCase();
		for (Iterator<Troute> i = listRoute.iterator(); i.hasNext();) {
			Troute auxRoute = i.next();
			if (Integer.toString(auxRoute.getCode()).toLowerCase().contains(auxCode) && auxRoute.getDescription().toLowerCase().contains(auxDescription)) {
				auxListRoute.add(auxRoute);
			}
		}
		return auxListRoute;
	}
}
