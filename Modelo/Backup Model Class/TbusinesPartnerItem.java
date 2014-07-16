package models;

// Generated 10/07/2014 10:58:58 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TbusinesPartnerItem generated by hbm2java
 */
@Entity
@Table(name = "tbusines_partner_item", schema = "public")
public class TbusinesPartnerItem implements java.io.Serializable {

	private static final long serialVersionUID = 6156369380091880597L;
	private TbusinesPartnerItemId id;
	private TbusinessPartner tbusinessPartner;
	private Titem titem;
	private TbasicData tbasicData;
	private float price;

	public TbusinesPartnerItem() {
	}

	public TbusinesPartnerItem(TbusinesPartnerItemId id, TbusinessPartner tbusinessPartner, Titem titem, TbasicData tbasicData, float price) {
		this.id = id;
		this.tbusinessPartner = tbusinessPartner;
		this.titem = titem;
		this.tbasicData = tbasicData;
		this.price = price;
	}

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "idBusinessPartner", column = @Column(name = "id_business_partner", nullable = false)), @AttributeOverride(name = "idItem", column = @Column(name = "id_item", nullable = false)) })
	public TbusinesPartnerItemId getId() {
		return this.id;
	}

	public void setId(TbusinesPartnerItemId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_business_partner", nullable = false, insertable = false, updatable = false)
	public TbusinessPartner getTbusinessPartner() {
		return this.tbusinessPartner;
	}

	public void setTbusinessPartner(TbusinessPartner tbusinessPartner) {
		this.tbusinessPartner = tbusinessPartner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item", nullable = false, insertable = false, updatable = false)
	public Titem getTitem() {
		return this.titem;
	}

	public void setTitem(Titem titem) {
		this.titem = titem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "measure_unit", nullable = false)
	public TbasicData getTbasicData() {
		return this.tbasicData;
	}

	public void setTbasicData(TbasicData tbasicData) {
		this.tbasicData = tbasicData;
	}

	@Column(name = "price", nullable = false, precision = 8, scale = 8)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
