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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbusinessPartner generated by hbm2java
 */
@Entity
@Table(name = "tbusiness_partner")
public class TbusinessPartner implements java.io.Serializable {

	private int idBusinessPartner;
	private TbasicData tbasicDataByRifType;
	private TbasicData tbasicDataByType;
	private String name;
	private String rif;
	private String address;
	private char status;
	private Set<TbusinessPartnerBranch> tbusinessPartnerBranches = new HashSet<TbusinessPartnerBranch>(
			0);
	private Set<Titem> titems = new HashSet<Titem>(0);

	public TbusinessPartner() {
	}

	public TbusinessPartner(int idBusinessPartner,
			TbasicData tbasicDataByRifType, TbasicData tbasicDataByType,
			String name, String rif, char status) {
		this.idBusinessPartner = idBusinessPartner;
		this.tbasicDataByRifType = tbasicDataByRifType;
		this.tbasicDataByType = tbasicDataByType;
		this.name = name;
		this.rif = rif;
		this.status = status;
	}

	public TbusinessPartner(int idBusinessPartner,
			TbasicData tbasicDataByRifType, TbasicData tbasicDataByType,
			String name, String rif, String address, char status,
			Set<TbusinessPartnerBranch> tbusinessPartnerBranches,
			Set<Titem> titems) {
		this.idBusinessPartner = idBusinessPartner;
		this.tbasicDataByRifType = tbasicDataByRifType;
		this.tbasicDataByType = tbasicDataByType;
		this.name = name;
		this.rif = rif;
		this.address = address;
		this.status = status;
		this.tbusinessPartnerBranches = tbusinessPartnerBranches;
		this.titems = titems;
	}

	@Id
	@Column(name = "id_business_partner", unique = true, nullable = false)
	public int getIdBusinessPartner() {
		return this.idBusinessPartner;
	}

	public void setIdBusinessPartner(int idBusinessPartner) {
		this.idBusinessPartner = idBusinessPartner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rif_type", nullable = false)
	public TbasicData getTbasicDataByRifType() {
		return this.tbasicDataByRifType;
	}

	public void setTbasicDataByRifType(TbasicData tbasicDataByRifType) {
		this.tbasicDataByRifType = tbasicDataByRifType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type", nullable = false)
	public TbasicData getTbasicDataByType() {
		return this.tbasicDataByType;
	}

	public void setTbasicDataByType(TbasicData tbasicDataByType) {
		this.tbasicDataByType = tbasicDataByType;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "rif", nullable = false, length = 15)
	public String getRif() {
		return this.rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbusinessPartner")
	public Set<TbusinessPartnerBranch> getTbusinessPartnerBranches() {
		return this.tbusinessPartnerBranches;
	}

	public void setTbusinessPartnerBranches(
			Set<TbusinessPartnerBranch> tbusinessPartnerBranches) {
		this.tbusinessPartnerBranches = tbusinessPartnerBranches;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbusines_partner_item", joinColumns = { @JoinColumn(name = "id_business_partner", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_item", nullable = false, updatable = false) })
	public Set<Titem> getTitems() {
		return this.titems;
	}

	public void setTitems(Set<Titem> titems) {
		this.titems = titems;
	}

}
