package controllers;

import models.SecurityUser;
import models.service.security.ServiceSecurityUser;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class FrmIndex {

	private SecurityUser user;
	private String page;
	@WireVariable
	private ServiceSecurityUser serviceSecurityUser;

	public SecurityUser getUser() {
		return user;
	}

	public void setUser(SecurityUser user) {
		this.user = user;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Init
	public void init() {
		page = new String();
		User auxUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		/*
		 * Se busca por nombre, porque el objeto "auxUser" tipo "User" no
		 * almacena email
		 */
		user = serviceSecurityUser.findByEmail(auxUser.getUsername());
	}

	@NotifyChange("page")
	@GlobalCommand
	public void selectedPage(@BindingParam("page") String page) {
		this.page = page;
	}
}
