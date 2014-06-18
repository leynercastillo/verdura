package models;

// Generated 24/01/2013 03:33:32 PM by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SecurityGroup generated by hbm2java
 */
@Entity
@Table(name = "security_group")
public class SecurityGroup implements java.io.Serializable {

    private static final long serialVersionUID = -8439125473481013576L;
    private int idSecurityGroup;
    private String name;
    private short status;
    private Set<SecurityUser> securityUsers = new HashSet<SecurityUser>(0);
    private Set<SecurityRole> securityRoles = new HashSet<SecurityRole>(0);

    public SecurityGroup() {
    }

    public SecurityGroup(int idSecurityGroup, String name, short status) {
	this.idSecurityGroup = idSecurityGroup;
	this.name = name;
	this.status = status;
    }

    public SecurityGroup(int idSecurityGroup, String name, short status, Set<SecurityUser> securityUsers, Set<SecurityRole> securityRoles) {
	this.idSecurityGroup = idSecurityGroup;
	this.name = name;
	this.status = status;
	this.securityUsers = securityUsers;
	this.securityRoles = securityRoles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "security_group_id_seq")
    @SequenceGenerator(name = "security_group_id_seq", sequenceName = "security_group_id_seq")
    @Column(name = "id_security_group", unique = true, nullable = false)
    public int getIdSecurityGroup() {
	return this.idSecurityGroup;
    }

    public void setIdSecurityGroup(int idSecurityGroup) {
	this.idSecurityGroup = idSecurityGroup;
    }

    @Column(name = "name", nullable = false, length = 40)
    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Column(name = "status", nullable = false)
    public short getStatus() {
	return this.status;
    }

    public void setStatus(short status) {
	this.status = status;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "group_user", joinColumns = { @JoinColumn(name = "id_security_group", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_security_user", nullable = false, updatable = false) })
    public Set<SecurityUser> getSecurityUsers() {
	return this.securityUsers;
    }

    public void setSecurityUsers(Set<SecurityUser> securityUsers) {
	this.securityUsers = securityUsers;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "securityGroups")
    public Set<SecurityRole> getSecurityRoles() {
	return this.securityRoles;
    }

    public void setSecurityRoles(Set<SecurityRole> securityRoles) {
	this.securityRoles = securityRoles;
    }

}