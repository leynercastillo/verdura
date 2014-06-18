package models;

// Generated 12/06/2014 12:11:57 AM by Hibernate Tools 4.0.0

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * Torder generated by hbm2java
 */
@Entity
@Table(name = "torder", schema = "public")
public class Torder implements java.io.Serializable {

	private static final long serialVersionUID = -1159856163715035470L;
	private int idOrder;
	private TbusinessPartnerBranch tbusinessPartnerBranch;
	private int orderNumber;
	private String bpName;
	private Date orderDate;
	private Date deliveryDate;
	private String rif;
	private String bpBranchAddress;
	private int type;
	private float orderTotal;
	private float taxTotal;
	private char status;
	private Set<Tbill> tbills = new HashSet<Tbill>(0);
	private Set<TorderDetail> torderDetails = new HashSet<TorderDetail>(0);

	public Torder() {
	}

	public Torder(int idOrder, TbusinessPartnerBranch tbusinessPartnerBranch, int orderNumber, String bpName, Date orderDate, Date deliveryDate, String rif, String bpBranchAddress, int type, float orderTotal, float taxTotal, char status) {
		this.idOrder = idOrder;
		this.tbusinessPartnerBranch = tbusinessPartnerBranch;
		this.orderNumber = orderNumber;
		this.bpName = bpName;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.rif = rif;
		this.bpBranchAddress = bpBranchAddress;
		this.type = type;
		this.orderTotal = orderTotal;
		this.taxTotal = taxTotal;
		this.status = status;
	}

	public Torder(int idOrder, TbusinessPartnerBranch tbusinessPartnerBranch, int orderNumber, String bpName, Date orderDate, Date deliveryDate, String rif, String bpBranchAddress, int type, float orderTotal, float taxTotal, char status, Set<Tbill> tbills, Set<TorderDetail> torderDetails) {
		this.idOrder = idOrder;
		this.tbusinessPartnerBranch = tbusinessPartnerBranch;
		this.orderNumber = orderNumber;
		this.bpName = bpName;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.rif = rif;
		this.bpBranchAddress = bpBranchAddress;
		this.type = type;
		this.orderTotal = orderTotal;
		this.taxTotal = taxTotal;
		this.status = status;
		this.tbills = tbills;
		this.torderDetails = torderDetails;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "torder_id_seq")
    @SequenceGenerator(name = "torder_id_seq", sequenceName = "torder_id_seq")
	@Column(name = "id_order", unique = true, nullable = false)
	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bp_branch", nullable = false)
	public TbusinessPartnerBranch getTbusinessPartnerBranch() {
		return this.tbusinessPartnerBranch;
	}

	public void setTbusinessPartnerBranch(TbusinessPartnerBranch tbusinessPartnerBranch) {
		this.tbusinessPartnerBranch = tbusinessPartnerBranch;
	}

	@Generated(GenerationTime.ALWAYS)
	@Column(name = "order_number", nullable = false)
	public int getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "bp_name", nullable = false, length = 100)
	public String getBpName() {
		return this.bpName;
	}

	public void setBpName(String bpName) {
		this.bpName = bpName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false, length = 29)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delivery_date", nullable = false, length = 29)
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = "rif", nullable = false, length = 15)
	public String getRif() {
		return this.rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	@Column(name = "bp_branch_address", nullable = false, length = 200)
	public String getBpBranchAddress() {
		return this.bpBranchAddress;
	}

	public void setBpBranchAddress(String bpBranchAddress) {
		this.bpBranchAddress = bpBranchAddress;
	}

	@Column(name = "type", nullable = false)
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "order_total", nullable = false, precision = 8, scale = 8)
	public float getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Column(name = "tax_total", nullable = false, precision = 8, scale = 8)
	public float getTaxTotal() {
		return this.taxTotal;
	}

	public void setTaxTotal(float taxTotal) {
		this.taxTotal = taxTotal;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "torder")
	public Set<Tbill> getTbills() {
		return this.tbills;
	}

	public void setTbills(Set<Tbill> tbills) {
		this.tbills = tbills;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "torder")
	public Set<TorderDetail> getTorderDetails() {
		return this.torderDetails;
	}

	public void setTorderDetails(Set<TorderDetail> torderDetails) {
		this.torderDetails = torderDetails;
	}

}