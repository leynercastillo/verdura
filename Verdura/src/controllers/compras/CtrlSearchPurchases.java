package controllers.compras;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

import models.Tpurchase;
import models.service.ServicePurchase;

public class CtrlSearchPurchases {

	@WireVariable
	private ServicePurchase servicePurchase;
	private List<Tpurchase> listPurchases;
	private Tpurchase selectedPurchase;
	private PurchasesFilter purchasesFilter;

	public List<Tpurchase> getListPurchases() {
		return listPurchases;
	}

	public void setListPurchases(List<Tpurchase> listPurchases) {
		this.listPurchases = listPurchases;
	}

	public PurchasesFilter getPurchasesFilter() {
		return purchasesFilter;
	}

	public void setPurchasesFilter(PurchasesFilter purchasesFilter) {
		this.purchasesFilter = purchasesFilter;
	}

	public Tpurchase getSelectedPurchase() {
		return selectedPurchase;
	}

	public void setSelectedPurchase(Tpurchase selectedPurchase) {
		this.selectedPurchase = selectedPurchase;
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		listPurchases = servicePurchase.listAll();
		selectedPurchase = new Tpurchase();
		purchasesFilter = new PurchasesFilter();
	}

	@NotifyChange({ "selectedPurchase" })
	@Command
	public void backToPurchase(@BindingParam("window") Window window) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchase", selectedPurchase);
		close(window);
		BindUtils.postGlobalCommand(null, null, "selectedPurchase", map);
	}

	@NotifyChange({ "listPurchases" })
	@Command
	public void dataFilter() {
		listPurchases = purchasesFilter.getFilter(purchasesFilter);
	}

	@Command
	public void close(@BindingParam("window") Window window) {
		window.detach();
	}

}
