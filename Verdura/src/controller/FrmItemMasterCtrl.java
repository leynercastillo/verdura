package controller;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zul.Radio;

public class FrmItemMasterCtrl {
	private Boolean activo;

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	@Init
	public void init(){
		activo = false;
	}

	@Command
	public void clickTest(){
		Messagebox.show("Esto esta "+activo);
	}
}
