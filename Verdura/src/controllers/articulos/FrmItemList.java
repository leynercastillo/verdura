package controllers.articulos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Titem;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

public class FrmItemList {

    @Wire("#window")
    private Window window;

    private List<Titem> listItems;
    private Titem selectedItem;

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
    public void init(@ExecutionArgParam("listItem") List<Titem> listItems, @ContextParam(ContextType.VIEW) Component view) {
	this.listItems = listItems;
	Selectors.wireComponents(view, this, false);
    }

    @NotifyChange("selectedItem")
    @Command
    public void sendItem() {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("item", selectedItem);
	window.detach();
	BindUtils.postGlobalCommand(null, null, "selectedItem", map);
    }

    public String weightUnitDescription(String unit, int measure) {
	return measure + " - " + unit;
    }

    @Command
    public void close() {
	window.detach();
    }
}