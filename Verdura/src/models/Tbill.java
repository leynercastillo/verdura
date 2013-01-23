package models;

// Generated 23/01/2013 04:05:43 PM by Hibernate Tools 3.6.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tbill generated by hbm2java
 */
@Entity
@Table(name = "tbill")
public class Tbill implements java.io.Serializable {

	private int idBill;
	private Torder torder;
	private TbusinessPartnerBranch tbusinessPartnerBranch;
	private TbasicData tbasicData;
	private String controlNumber;
	private String billNumber;
	private String bpName;
	private String bpRif;
	private String bpAddress;
	private Date billDate;
	private float billTotal;
	private float taxTotal;
	private Date deliveryDate;
	private char printed;
	private char status;
	private Set<TbillDetail> tbillDetails = new HashSet<TbillDetail>(0);

	public Tbill() {
	}

	public Tbill(int idBill, Torder torder,
			TbusinessPartnerBranch tbusinessPartnerBranch,
			TbasicData tbasicData, String controlNumber, String billNumber,
			String bpName, String bpRif, String bpAddress, Date billDate,
			float billTotal, float taxTotal, char printed, char status) {
		this.idBill = idBill;
		this.torder = torder;
		this.tbusinessPartnerBranch = tbusinessPartnerBranch;
		this.tbasicData = tbasicData;
		this.controlNumber = controlNumber;
		this.billNumber = billNumber;
		this.bpName = bpName;
		this.bpRif = bpRif;
		this.bpAddress = bpAddress;
		this.billDate = billDate;
		this.billTotal = billTotal;
		this.taxTotal = taxTotal;
		this.printed = printed;
		this.status = status;
	}

	public Tbill(int idBill, Torder torder,
			TbusinessPartnerBranch tbusinessPartnerBranch,
			TbasicData tbasicData, String controlNumber, String billNumber,
			String bpName, String bpRif, String bpAddress, Date billDate,
			float billTotal, float taxTotal, Date deliveryDate, char printed,
			char status, Set<TbillDetail> tbillDetails) {
		this.idBill = idBill;
		this.torder = torder;
		this.tbusinessPartnerBranch = tbusinessPartnerBranch;
		this.tbasicData = tbasicData;
		this.controlNumber = controlNumber;
		this.billNumber = billNumber;
		this.bpName = bpName;
		this.bpRif = bpRif;
		this.bpAddress = bpAddress;
		this.billDate = billDate;
		this.billTotal = billTotal;
		this.taxTotal = taxTotal;
		this.deliveryDate = deliveryDate;
		this.printed = printed;
		this.status = status;
		this.tbillDetails = tbillDetails;
	}

	@Id
	@Column(name = "id_bill", unique = true, nullable = false)
	public int getIdBill() {
		return this.idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order", nullable = false)
	public Torder getTorder() {
		return this.torder;
	}

	public void setTorder(Torder torder) {
		this.torder = torder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bp_branch", nullable = false)
	public TbusinessPartnerBranch getTbusinessPartnerBranch() {
		return this.tbusinessPartnerBranch;
	}

	public void setTbusinessPartnerBranch(
			TbusinessPartnerBranch tbusinessPartnerBranch) {
		this.tbusinessPartnerBranch = tbusinessPartnerBranch;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bp_rif_type", nullable = false)
	public TbasicData getTbasicData() {
		return this.tbasicData;
	}

	public void setTbasicData(TbasicData tbasicData) {
		this.tbasicData = tbasicData;
	}

	@Column(name = "control_number", nullable = false, length = 12)
	public String getControlNumber() {
		return this.controlNumber;
	}

	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	@Column(name = "bill_number", nullable = false, length = 12)
	public String getBillNumber() {
		return this.billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	@Column(name = "bp_name", nullable = false, length = 100)
	public String getBpName() {
		return this.bpName;
	}

	public void setBpName(String bpName) {
		this.bpName = bpName;
	}

	@Column(name = "bp_rif", nullable = false, length = 15)
	public String getBpRif() {
		return this.bpRif;
	}

	public void setBpRif(String bpRif) {
		this.bpRif = bpRif;
	}

	@Column(name = "bp_address", nullable = false, length = 200)
	public String getBpAddress() {
		return this.bpAddress;
	}

	public void setBpAddress(String bpAddress) {
		this.bpAddress = bpAddress;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bill_date", nullable = false, length = 29)
	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	@Column(name = "bill_total", nullable = false, precision = 8, scale = 8)
	public float getBillTotal() {
		return this.billTotal;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}

	@Column(name = "tax_total", nullable = false, precision = 8, scale = 8)
	public float getTaxTotal() {
		return this.taxTotal;
	}

	public void setTaxTotal(float taxTotal) {
		this.taxTotal = taxTotal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delivery_date", length = 29)
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = "printed", nullable = false, length = 1)
	public char getPrinted() {
		return this.printed;
	}

	public void setPrinted(char printed) {
		this.printed = printed;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbill")
	public Set<TbillDetail> getTbillDetails() {
		return this.tbillDetails;
	}

	public void setTbillDetails(Set<TbillDetail> tbillDetails) {
		this.tbillDetails = tbillDetails;
	}

}
