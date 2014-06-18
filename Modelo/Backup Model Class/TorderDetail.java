package models;

// Generated 12/06/2014 09:03:18 AM by Hibernate Tools 4.0.0

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
 * TorderDetail generated by hbm2java
 */
@Entity
@Table(name = "torder_detail", schema = "public")
public class TorderDetail implements java.io.Serializable {

	private static final long serialVersionUID = -8852047133094353830L;
	private int idOrderDetail;
	private Torder torder;
	private TbasicData tbasicData;
	private Titem titem;
	private String itemName;
	private float quantity;
	private char status;

	public TorderDetail() {
	}

	public TorderDetail(int idOrderDetail, Torder torder, TbasicData tbasicData, Titem titem, String itemName, float quantity, char status) {
		this.idOrderDetail = idOrderDetail;
		this.torder = torder;
		this.tbasicData = tbasicData;
		this.titem = titem;
		this.itemName = itemName;
		this.quantity = quantity;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "torder_detail_id_seq")
	@SequenceGenerator(name = "torder_detail_id_seq", sequenceName = "torder_detail_id_seq")
	@Column(name = "id_order_detail", unique = true, nullable = false)
	public int getIdOrderDetail() {
		return this.idOrderDetail;
	}

	public void setIdOrderDetail(int idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
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
	@JoinColumn(name = "unit_measure", nullable = false)
	public TbasicData getTbasicData() {
		return this.tbasicData;
	}

	public void setTbasicData(TbasicData tbasicData) {
		this.tbasicData = tbasicData;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item", nullable = false)
	public Titem getTitem() {
		return this.titem;
	}

	public void setTitem(Titem titem) {
		this.titem = titem;
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

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
