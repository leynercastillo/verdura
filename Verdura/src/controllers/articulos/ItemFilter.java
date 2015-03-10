package controllers.articulos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Titem;
import models.service.ServiceBasicData;
import models.service.ServiceItem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemFilter {

	private ServiceItem serviceItem;
	private ServiceBasicData serviceBasicData;
	private List<Titem> listItems;
	private String code = "";
	private String name = "";

	public ItemFilter() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.serviceItem = applicationContext.getBean(ServiceItem.class);
		this.serviceBasicData = applicationContext.getBean(ServiceBasicData.class);
		listItems = serviceItem.listAll();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Titem> getFilter(ItemFilter itemFilter) {
		List<Titem> auxListItems = new ArrayList<Titem>();
		String auxCode = itemFilter.getCode().toLowerCase();
		String auxName = itemFilter.getName().toLowerCase();
		for (Iterator<Titem> i = listItems.iterator(); i.hasNext();) {
			Titem auxItem = i.next();
			if (auxItem.getCode().toLowerCase().contains(auxCode) && auxItem.getName().toLowerCase().contains(auxName)) {
				auxItem.setTbasicData(serviceBasicData.findById(auxItem.getTbasicData().getIdBasicData()));
				auxListItems.add(auxItem);
			}
		}
		return auxListItems;
	}
}