package database;

// Generated 10-oct-2012 10:59:39 by Hibernate Tools 3.6.0

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

	private int idb;
	private Tbasicdata tbasicdata;
	private Torder torder;
	private Tbusinesspartneraddress tbusinesspartneraddress;
	private String billnumber;
	private String bpname;
	private String controlnumber;
	private Date billdate;
	private Date deliverydate;
	private String rif;
	private String address;
	private int type;
	private float billtotal;
	private float taxtotal;
	private Set tbilldetails = new HashSet(0);

	public Tbill() {
	}

	public Tbill(int idb, Tbasicdata tbasicdata, Torder torder,
			Tbusinesspartneraddress tbusinesspartneraddress, String billnumber,
			String bpname, String controlnumber, Date billdate,
			Date deliverydate, String rif, String address, int type,
			float billtotal, float taxtotal) {
		this.idb = idb;
		this.tbasicdata = tbasicdata;
		this.torder = torder;
		this.tbusinesspartneraddress = tbusinesspartneraddress;
		this.billnumber = billnumber;
		this.bpname = bpname;
		this.controlnumber = controlnumber;
		this.billdate = billdate;
		this.deliverydate = deliverydate;
		this.rif = rif;
		this.address = address;
		this.type = type;
		this.billtotal = billtotal;
		this.taxtotal = taxtotal;
	}

	public Tbill(int idb, Tbasicdata tbasicdata, Torder torder,
			Tbusinesspartneraddress tbusinesspartneraddress, String billnumber,
			String bpname, String controlnumber, Date billdate,
			Date deliverydate, String rif, String address, int type,
			float billtotal, float taxtotal, Set tbilldetails) {
		this.idb = idb;
		this.tbasicdata = tbasicdata;
		this.torder = torder;
		this.tbusinesspartneraddress = tbusinesspartneraddress;
		this.billnumber = billnumber;
		this.bpname = bpname;
		this.controlnumber = controlnumber;
		this.billdate = billdate;
		this.deliverydate = deliverydate;
		this.rif = rif;
		this.address = address;
		this.type = type;
		this.billtotal = billtotal;
		this.taxtotal = taxtotal;
		this.tbilldetails = tbilldetails;
	}

	@Id
	@Column(name = "idb", unique = true, nullable = false)
	public int getIdb() {
		return this.idb;
	}

	public void setIdb(int idb) {
		this.idb = idb;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbasic", nullable = false)
	public Tbasicdata getTbasicdata() {
		return this.tbasicdata;
	}

	public void setTbasicdata(Tbasicdata tbasicdata) {
		this.tbasicdata = tbasicdata;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ido", nullable = false)
	public Torder getTorder() {
		return this.torder;
	}

	public void setTorder(Torder torder) {
		this.torder = torder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbpa", nullable = false)
	public Tbusinesspartneraddress getTbusinesspartneraddress() {
		return this.tbusinesspartneraddress;
	}

	public void setTbusinesspartneraddress(
			Tbusinesspartneraddress tbusinesspartneraddress) {
		this.tbusinesspartneraddress = tbusinesspartneraddress;
	}

	@Column(name = "billnumber", nullable = false, length = 12)
	public String getBillnumber() {
		return this.billnumber;
	}

	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}

	@Column(name = "bpname", nullable = false, length = 100)
	public String getBpname() {
		return this.bpname;
	}

	public void setBpname(String bpname) {
		this.bpname = bpname;
	}

	@Column(name = "controlnumber", nullable = false, length = 12)
	public String getControlnumber() {
		return this.controlnumber;
	}

	public void setControlnumber(String controlnumber) {
		this.controlnumber = controlnumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "billdate", nullable = false, length = 29)
	public Date getBilldate() {
		return this.billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deliverydate", nullable = false, length = 29)
	public Date getDeliverydate() {
		return this.deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	@Column(name = "rif", nullable = false, length = 15)
	public String getRif() {
		return this.rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	@Column(name = "address", nullable = false, length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "type", nullable = false)
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "billtotal", nullable = false, precision = 8, scale = 8)
	public float getBilltotal() {
		return this.billtotal;
	}

	public void setBilltotal(float billtotal) {
		this.billtotal = billtotal;
	}

	@Column(name = "taxtotal", nullable = false, precision = 8, scale = 8)
	public float getTaxtotal() {
		return this.taxtotal;
	}

	public void setTaxtotal(float taxtotal) {
		this.taxtotal = taxtotal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbill")
	public Set getTbilldetails() {
		return this.tbilldetails;
	}

	public void setTbilldetails(Set tbilldetails) {
		this.tbilldetails = tbilldetails;
	}

}
