package models;

// Generated 18/01/2013 04:18:26 PM by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * SecurityUser generated by hbm2java
 */
@Entity
@Table(name = "security_user")
public class SecurityUser implements java.io.Serializable {

	private int idSecurityUser;
	private String name;
	private String email;
	private String password;
	private short status;
	private Set<SecurityGroup> securityGroups = new HashSet<SecurityGroup>(0);

	public SecurityUser() {
	}

	public SecurityUser(int idSecurityUser, String name, String email,
			String password, short status) {
		this.idSecurityUser = idSecurityUser;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public SecurityUser(int idSecurityUser, String name, String email,
			String password, short status, Set<SecurityGroup> securityGroups) {
		this.idSecurityUser = idSecurityUser;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.securityGroups = securityGroups;
	}

	@Id
	@Column(name = "id_security_user", unique = true, nullable = false)
	public int getIdSecurityUser() {
		return this.idSecurityUser;
	}

	public void setIdSecurityUser(int idSecurityUser) {
		this.idSecurityUser = idSecurityUser;
	}

	@Column(name = "name", nullable = false, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "status", nullable = false)
	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "group_user", joinColumns = { @JoinColumn(name = "id_suser", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_sgroup", nullable = false, updatable = false) })
	public Set<SecurityGroup> getSecurityGroups() {
		return this.securityGroups;
	}

	public void setSecurityGroups(Set<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}

}
