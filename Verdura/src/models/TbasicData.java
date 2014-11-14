package models;

// Generated 02/11/2014 09:38:14 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TbasicData generated by hbm2java
 */
@Entity
@Table(name = "tbasic_data", schema = "public")
public class TbasicData implements java.io.Serializable {

	private static final long serialVersionUID = -2448051825994937962L;
	private int idBasicData;
	private TdataType tdataType;
	private TbasicData tbasicData;
	private String name;
	private String description;
	private boolean editable;
	private char status;
	private Set<ToutputMeasureUnit> toutputMeasureUnits = new HashSet<ToutputMeasureUnit>(0);
	private Set<TbusinesPartnerItem> tbusinesPartnerItems = new HashSet<TbusinesPartnerItem>(0);
	private Set<TbasicData> tbasicDatas = new HashSet<TbasicData>(0);
	private Set<TinputMeasureUnit> tinputMeasureUnits = new HashSet<TinputMeasureUnit>(0);
	private Set<TpurchaseDetail> tpurchaseDetails = new HashSet<TpurchaseDetail>(0);
	private Set<Tvehicle> tvehicles = new HashSet<Tvehicle>(0);
	private Set<Titem> titems = new HashSet<Titem>(0);
	private Set<TbusinessPartnerBranch> tbusinessPartnerBranches = new HashSet<TbusinessPartnerBranch>(0);
	private Set<TorderDetail> torderDetails = new HashSet<TorderDetail>(0);
	private Set<TbusinessPartner> tbusinessPartnersForRifType = new HashSet<TbusinessPartner>(0);
	private Set<TbusinessPartner> tbusinessPartnersForType = new HashSet<TbusinessPartner>(0);

	public TbasicData() {
	}

	public TbasicData(int idBasicData, TdataType tdataType, String name, boolean editable, char status) {
		this.idBasicData = idBasicData;
		this.tdataType = tdataType;
		this.name = name;
		this.editable = editable;
		this.status = status;
	}

	public TbasicData(int idBasicData, TdataType tdataType, TbasicData tbasicData, String name, String description, boolean editable, char status, Set<ToutputMeasureUnit> toutputMeasureUnits, Set<TbusinesPartnerItem> tbusinesPartnerItems, Set<TbasicData> tbasicDatas, Set<TinputMeasureUnit> tinputMeasureUnits, Set<TpurchaseDetail> tpurchaseDetails, Set<Tvehicle> tvehicles, Set<Titem> titems, Set<TbusinessPartnerBranch> tbusinessPartnerBranches, Set<TorderDetail> torderDetails, Set<TbusinessPartner> tbusinessPartnersForRifType, Set<TbusinessPartner> tbusinessPartnersForType) {
		this.idBasicData = idBasicData;
		this.tdataType = tdataType;
		this.tbasicData = tbasicData;
		this.name = name;
		this.description = description;
		this.editable = editable;
		this.status = status;
		this.toutputMeasureUnits = toutputMeasureUnits;
		this.tbusinesPartnerItems = tbusinesPartnerItems;
		this.tbasicDatas = tbasicDatas;
		this.tinputMeasureUnits = tinputMeasureUnits;
		this.tpurchaseDetails = tpurchaseDetails;
		this.tvehicles = tvehicles;
		this.titems = titems;
		this.tbusinessPartnerBranches = tbusinessPartnerBranches;
		this.torderDetails = torderDetails;
		this.tbusinessPartnersForRifType = tbusinessPartnersForRifType;
		this.tbusinessPartnersForType = tbusinessPartnersForType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbasic_data_id_seq")
	@SequenceGenerator(name = "tbasic_data_id_seq", sequenceName = "tbasic_data_id_seq")
	@Column(name = "id_basic_data", unique = true, nullable = false)
	public int getIdBasicData() {
		return this.idBasicData;
	}

	public void setIdBasicData(int idBasicData) {
		this.idBasicData = idBasicData;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_data_type", nullable = false)
	public TdataType getTdataType() {
		return this.tdataType;
	}

	public void setTdataType(TdataType tdataType) {
		this.tdataType = tdataType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id_basic")
	public TbasicData getTbasicData() {
		return this.tbasicData;
	}

	public void setTbasicData(TbasicData tbasicData) {
		this.tbasicData = tbasicData;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 300)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "editable", nullable = false)
	public boolean isEditable() {
		return this.editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicData")
	public Set<ToutputMeasureUnit> getToutputMeasureUnits() {
		return this.toutputMeasureUnits;
	}

	public void setToutputMeasureUnits(Set<ToutputMeasureUnit> toutputMeasureUnits) {
		this.toutputMeasureUnits = toutputMeasureUnits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicData")
	public Set<TbusinesPartnerItem> getTbusinesPartnerItems() {
		return this.tbusinesPartnerItems;
	}

	public void setTbusinesPartnerItems(Set<TbusinesPartnerItem> tbusinesPartnerItems) {
		this.tbusinesPartnerItems = tbusinesPartnerItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicData")
	public Set<TbasicData> getTbasicDatas() {
		return this.tbasicDatas;
	}

	public void setTbasicDatas(Set<TbasicData> tbasicDatas) {
		this.tbasicDatas = tbasicDatas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicData")
	public Set<TinputMeasureUnit> getTinputMeasureUnits() {
		return this.tinputMeasureUnits;
	}

	public void setTinputMeasureUnits(Set<TinputMeasureUnit> tinputMeasureUnits) {
		this.tinputMeasureUnits = tinputMeasureUnits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicData")
	public Set<TpurchaseDetail> getTpurchaseDetails() {
		return this.tpurchaseDetails;
	}

	public void setTpurchaseDetails(Set<TpurchaseDetail> tpurchaseDetails) {
		this.tpurchaseDetails = tpurchaseDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicData")
	public Set<Tvehicle> getTvehicles() {
		return this.tvehicles;
	}

	public void setTvehicles(Set<Tvehicle> tvehicles) {
		this.tvehicles = tvehicles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicData")
	public Set<Titem> getTitems() {
		return this.titems;
	}

	public void setTitems(Set<Titem> titems) {
		this.titems = titems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicData")
	public Set<TbusinessPartnerBranch> getTbusinessPartnerBranches() {
		return this.tbusinessPartnerBranches;
	}

	public void setTbusinessPartnerBranches(Set<TbusinessPartnerBranch> tbusinessPartnerBranches) {
		this.tbusinessPartnerBranches = tbusinessPartnerBranches;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicData")
	public Set<TorderDetail> getTorderDetails() {
		return this.torderDetails;
	}

	public void setTorderDetails(Set<TorderDetail> torderDetails) {
		this.torderDetails = torderDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicDataByRifType")
	public Set<TbusinessPartner> getTbusinessPartnersForRifType() {
		return this.tbusinessPartnersForRifType;
	}

	public void setTbusinessPartnersForRifType(Set<TbusinessPartner> tbusinessPartnersForRifType) {
		this.tbusinessPartnersForRifType = tbusinessPartnersForRifType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbasicDataByType")
	public Set<TbusinessPartner> getTbusinessPartnersForType() {
		return this.tbusinessPartnersForType;
	}

	public void setTbusinessPartnersForType(Set<TbusinessPartner> tbusinessPartnersForType) {
		this.tbusinessPartnersForType = tbusinessPartnersForType;
	}

}
