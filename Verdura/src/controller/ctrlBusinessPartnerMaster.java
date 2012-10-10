package controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class ctrlBusinessPartnerMaster extends SelectorComposer<Window> {
	
	@Wire
	private Textbox txtCodBP, txtNameBP, txtRifBP, txtContactPerson, txtContactPhone, 
	txtNameBPA, txtAddressBPA, txtEmailBPA, txtPhoneBPA, txtFaxBPA;
	
	@Wire
	private Button btnAdd, btnSave, btnCancel;
	
	@Wire
	private Combobox  cmbCountryBPA, cmbCityBPA, cmbStateBPA;
}
