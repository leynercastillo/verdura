package controllers;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class FrmMenu {

	@NotifyChange()
	@Command
	public void optionSelected(@BindingParam("optionSelected") String optionSelected){
		if (!optionSelected.isEmpty()){
			Map map = new HashMap();
			map.put("page", optionSelected);
			BindUtils.postGlobalCommand(null, null, "selectedPage", map);
		}
	}
}
