package models;

// Generated 12/06/2014 09:35:54 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TbillDetail generated by hbm2java
 */
@Entity
@Table(name = "tbill_detail", schema = "public")
public class TbillDetail implements java.io.Serializable {

	private static final long serialVersionUID = -7117463963951306038L;
	private int idBillDetail;
	private Titem titem;
	private Tbill tbill;
	private String itemName;
	private float quantity;
	private float price;
	private float totalPrice;
	private Short rating;
	private char status;

	public TbillDetail() {
	}

	public TbillDetail(int idBillDetail, Titem titem, Tbill tbill, String itemName, float quantity, float price, float totalPrice, char status) {
		this.idBillDetail = idBillDetail;
		this.titem = titem;
		this.tbill = tbill;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public TbillDetail(int idBillDetail, Titem titem, Tbill tbill, String itemName, float quantity, float price, float totalPrice, Short rating, char status) {
		this.idBillDetail = idBillDetail;
		this.titem = titem;
		this.tbill = tbill;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.rating = rating;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbill_detail_id_seq")
    @SequenceGenerator(name = "tbill_detail_id_seq", sequenceName = "tbill_detail_id_seq")
	@Column(name = "id_bill_detail", unique = true, nullable = false)
	public int getIdBillDetail() {
		return this.idBillDetail;
	}

	public void setIdBillDetail(int idBillDetail) {
		this.idBillDetail = idBillDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item", nullable = false)
	public Titem getTitem() {
		return this.titem;
	}

	public void setTitem(Titem titem) {
		this.titem = titem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bill", nullable = false)
	public Tbill getTbill() {
		return this.tbill;
	}

	public void setTbill(Tbill tbill) {
		this.tbill = tbill;
	}

	@Column(name = "item_name", nullable = false, length = 100)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "quantity", nullable = false, precision = 8, scale = 8)
	public float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	@Column(name = "price", nullable = false, precision = 8, scale = 8)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "total_price", nullable = false, precision = 8, scale = 8)
	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "rating")
	public Short getRating() {
		return this.rating;
	}

	public void setRating(Short rating) {
		this.rating = rating;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
