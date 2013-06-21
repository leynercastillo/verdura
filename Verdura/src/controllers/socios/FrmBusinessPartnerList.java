package controllers.socios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.TbusinessPartner;

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

public class FrmBusinessPartnerList {
	@Wire("#window")
	private Window window;
	
	private List<TbusinessPartner> listBusinessPartner;
	private TbusinessPartner selectedBusinessPartner;

	public TbusinessPartner getSelectedBusinessPartner() {
		return selectedBusinessPartner;
	}

	public void setSelectedBusinessPartner(TbusinessPartner selectedBusinessPartner) {
		this.selectedBusinessPartner = selectedBusinessPartner;
	}

	public List<TbusinessPartner> getListBusinessPartner() {
		return listBusinessPartner;
	}

	public void setListBusinessPartner(List<TbusinessPartner> listBusinessPartner) {
		this.listBusinessPartner = listBusinessPartner;
	}

	@Init
	public void init(@ExecutionArgParam("listBusinessPartner") List<TbusinessPartner> listBusinessPartner, @ContextParam(ContextType.VIEW) Component view){
		this.listBusinessPartner = listBusinessPartner;
		Selectors.wireComponents(view, this, false);
	}
	
	@Command
	public void closeWindow(){
		window.detach();
	}

	public String fullRif(String rifType, String rif){
		return rifType+"-"+rif;
	}
	
	@NotifyChange("selectedBusinessPartner")
	@Command
	public void sendBusinessPartner(){
		Map map = new HashMap();
		map.put("businessPartner", selectedBusinessPartner);
		window.detach();
		BindUtils.postGlobalCommand(null, null, "selectedBusinessPartner", map);
	}
}
