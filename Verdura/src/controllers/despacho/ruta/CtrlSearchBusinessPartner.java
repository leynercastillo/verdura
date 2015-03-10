package controllers.despacho.ruta;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import models.TbusinessPartnerBranch;
import models.service.ServiceBusinessPartnerBranch;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

public class CtrlSearchBusinessPartner {

	@WireVariable
	private ServiceBusinessPartnerBranch serviceBusinessPartnerBranch;

	private BusinessPartnerBranchFilter partnerFilter;
	private List<TbusinessPartnerBranch> listCustomers;
	private Set<TbusinessPartnerBranch> listTempCustomers;

	public Set<TbusinessPartnerBranch> getListTempCustomers() {
		return listTempCustomers;
	}

	public void setListTempCustomers(Set<TbusinessPartnerBranch> listTempCustomers) {
		this.listTempCustomers = listTempCustomers;
	}

	public BusinessPartnerBranchFilter getPartnerFilter() {
		return partnerFilter;
	}

	public void setPartnerFilter(BusinessPartnerBranchFilter partnerFilter) {
		this.partnerFilter = partnerFilter;
	}

	public List<TbusinessPartnerBranch> getListCustomers() {
		return listCustomers;
	}

	public void setListCustomers(List<TbusinessPartnerBranch> listCustomers) {
		this.listCustomers = listCustomers;
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		listCustomers = serviceBusinessPartnerBranch.listAllCustomersActive();
		partnerFilter = new BusinessPartnerBranchFilter();
		listTempCustomers = new HashSet<TbusinessPartnerBranch>();
	}

	public String buildRif(TbusinessPartnerBranch branch) {
		TbusinessPartnerBranch auxBranch = serviceBusinessPartnerBranch.findById(branch.getIdBusinessPartnerBranch());
		return auxBranch.getTbusinessPartner().getTbasicDataByRifType().getName() + "-" + auxBranch.getTbusinessPartner().getRif();
	}

	@Command
	public void addCustomers(@BindingParam("window") Window window) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listCustomers", listTempCustomers);
		close(window);
		BindUtils.postGlobalCommand(null, null, "selectedCustomers", map);
	}

	@NotifyChange({ "listCustomers" })
	@Command
	public void dataFilter() {
		listCustomers = partnerFilter.getFilter(partnerFilter);
	}

	@Command
	public void close(@BindingParam("window") Window window) {
		window.detach();
	}
}