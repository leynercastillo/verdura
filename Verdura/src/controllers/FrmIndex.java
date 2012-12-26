package controllers;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class FrmIndex {

	private String page;
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Init
	public void init(){
		page = new String();
	}
	@NotifyChange("page")
	@GlobalCommand
	public void selectedPage(@BindingParam("page") String page){
		this.page = page;
	}
}
