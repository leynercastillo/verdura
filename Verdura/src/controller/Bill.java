/**
 * 
 */
package controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

/**
 * @author leyner.castillo
 *
 */
public class Bill extends GenericForwardComposer {

	private Button btnCancel;
	private Button btnSave;
	private Radio radioInactiveItem;
	private Radio radioActiveItem;
	private Textbox txtPriceItem;
	private Textbox txtCostItem;
	private Radio radioNotWashableItem;
	private Radio radioWashableItem;
	private Combobox txtTypeItem;
	private Textbox txtWeightUnitItem;
	private Combobox txtUnitCarItem;
	private Tab tabBuys;
	private Tab tabSales;
	private Tab tabGeneral;
	private Combobox txtNameItem;
	private Combobox txtCodItem;
	private Radiogroup washable;
	private Radiogroup status;

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub

	}

}
