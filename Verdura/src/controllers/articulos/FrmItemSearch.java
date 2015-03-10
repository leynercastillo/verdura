package controllers.articulos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Titem;
import models.service.ServiceItem;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

public class FrmItemSearch {

	@WireVariable
	private ServiceItem serviceItem;

	private List<Titem> listItems;

	private Titem selectedItem;
	private ItemFilter itemFilter;

	public ItemFilter getItemFilter() {
		return itemFilter;
	}

	public void setItemFilter(ItemFilter itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<Titem> getListItems() {
		return listItems;
	}

	public void setListItems(List<Titem> listItems) {
		this.listItems = listItems;
	}

	public Titem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Titem selectedItem) {
		this.selectedItem = selectedItem;
	}

	@Init
	public void init() {
		restarForm();
	}

	@NotifyChange("*")
	@Command
	public void restarForm() {
		listItems = serviceItem.listAll();
		itemFilter = new ItemFilter();
	}

	@NotifyChange("selectedItem")
	@Command
	public void sendItem(@BindingParam("window") Window window) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item", selectedItem);
		window.detach();
		BindUtils.postGlobalCommand(null, null, "selectedItem", map);
	}

	@NotifyChange({ "listItems" })
	@Command
	public void dataFilter() {
		listItems = itemFilter.getFilter(itemFilter);
	}

	@Command
	public void close(@BindingParam("window") Window window) {
		window.detach();
	}
}