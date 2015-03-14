package controllers.usuarios;

import models.SecurityUser;

/**
 * Clase desarrollada para lograr editar los objetos Security User dentro de un
 * grid de zk. Todo segun el demo publicado en la pagina oficial del framework:
 * http://www.zkoss.org/zkdemo/grid/inline_row_editing
 * 
 * @author Leyner Castillo
 *
 */
public class SecurityUserStatus {

	private SecurityUser user;
	private Boolean editUser;
	private Boolean modified;

	public Boolean getModified() {
		return modified;
	}

	public void setModified(Boolean modified) {
		this.modified = modified;
	}

	public Boolean getEditUser() {
		return editUser;
	}

	public void setEditUser(Boolean editUser) {
		this.editUser = editUser;
	}

	public SecurityUser getUser() {
		return user;
	}

	public void setUser(SecurityUser user) {
		this.user = user;
	}

	public SecurityUserStatus(SecurityUser user, Boolean editUser) {
		this.user = user;
		this.editUser = editUser;
		this.modified = null;
	}
}
