package controllers.socios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.TbusinessPartnerBranch;
import models.service.ServiceBusinessPartner;
import models.service.ServiceBusinessPartnerBranch;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

public class FrmBusinessPartnerSearch {

	@WireVariable
	private ServiceBusinessPartner serviceBusinessPartner;
	@WireVariable
	private ServiceBusinessPartnerBranch serviceBusinessPartnerBranch;

	private TbusinessPartnerBranch selectedBusinessPartner;
	private BusinessPartnerFilter businessPartnerFilter;
	private List<TbusinessPartnerBranch> listBusinessPartnerBranch;

	public BusinessPartnerFilter getBusinessPartnerFilter() {
		return businessPartnerFilter;
	}

	public void setBusinessPartnerFilter(BusinessPartnerFilter businessPartnerFilter) {
		this.businessPartnerFilter = businessPartnerFilter;
	}

	public TbusinessPartnerBranch getSelectedBusinessPartner() {
		return selectedBusinessPartner;
	}

	public void setSelectedBusinessPartner(TbusinessPartnerBranch selectedBusinessPartner) {
		this.selectedBusinessPartner = selectedBusinessPartner;
	}

	public List<TbusinessPartnerBranch> getListBusinessPartnerBranch() {
		return listBusinessPartnerBranch;
	}

	public void setListBusinessPartnerBranch(List<TbusinessPartnerBranch> listBusinessPartnerBranch) {
		this.listBusinessPartnerBranch = listBusinessPartnerBranch;
	}

	@Init
	public void init() {
		restarForm();
	}

	@NotifyChange("*")
	@Command
	public void restarForm() {
		listBusinessPartnerBranch = serviceBusinessPartnerBranch.listPartnerBySearch(null, null, null, null);
		businessPartnerFilter = new BusinessPartnerFilter();
	}

	public String fullRif(String rifType, String rif) {
		return rifType + "-" + rif;
	}

	@NotifyChange("selectedBusinessPartner")
	@Command
	public void sendBusinessPartner(@BindingParam("window") Window window) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("businessPartner", selectedBusinessPartner);
		window.detach();
		BindUtils.postGlobalCommand(null, null, "selectedBusinessPartner", map);
	}

	@NotifyChange({ "listBusinessPartnerBranch" })
	@Command
	public void dataFilter() {
		listBusinessPartnerBranch = businessPartnerFilter.getFilter(businessPartnerFilter);
	}

	@Command
	public void close(@BindingParam("window") Window window) {
		window.detach();
	}
}