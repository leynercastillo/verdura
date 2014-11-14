package models;

// Generated 02/11/2014 09:38:14 PM by Hibernate Tools 4.0.0

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * Twaybill generated by hbm2java
 */
@Entity
@Table(name = "twaybill", schema = "public")
public class Twaybill implements java.io.Serializable {

	private static final long serialVersionUID = 6191906386280270102L;
	private int idWaybill;
	private Tvehicle tvehicle;
	private TorderNumber torderNumber;
	private Troute troute;
	private int number;
	private Date date;
	private float vehicleCapacity;
	private String vehicleModel;
	private char status;

	public Twaybill() {
	}

	public Twaybill(int idWaybill, Tvehicle tvehicle, TorderNumber torderNumber, Troute troute, int number, Date date, float vehicleCapacity, String vehicleModel, char status) {
		this.idWaybill = idWaybill;
		this.tvehicle = tvehicle;
		this.torderNumber = torderNumber;
		this.troute = troute;
		this.number = number;
		this.date = date;
		this.vehicleCapacity = vehicleCapacity;
		this.vehicleModel = vehicleModel;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "twaybill_id_seq")
	@SequenceGenerator(name = "twaybill_id_seq", sequenceName = "twaybill_id_waybill_seq")
	@Column(name = "id_waybill", unique = true, nullable = false)
	public int getIdWaybill() {
		return this.idWaybill;
	}

	public void setIdWaybill(int idWaybill) {
		this.idWaybill = idWaybill;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vehicle", nullable = false)
	public Tvehicle getTvehicle() {
		return this.tvehicle;
	}

	public void setTvehicle(Tvehicle tvehicle) {
		this.tvehicle = tvehicle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order_number", nullable = false)
	public TorderNumber getTorderNumber() {
		return this.torderNumber;
	}

	public void setTorderNumber(TorderNumber torderNumber) {
		this.torderNumber = torderNumber;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_route", nullable = false)
	public Troute getTroute() {
		return this.troute;
	}

	public void setTroute(Troute troute) {
		this.troute = troute;
	}

	/**
	* <b>@Generated</B> con generationTime.ALWAYS es la forma de autoincrementar el campo cuando el campo no es
	* primario, y la base de datos le ha asignado una secuencia incrementable.
	*
	* @return
	*/
	@Generated(GenerationTime.ALWAYS)
	@Column(name = "number", nullable = false)
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false, length = 29)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "vehicle_capacity", nullable = false, precision = 8, scale = 8)
	public float getVehicleCapacity() {
		return this.vehicleCapacity;
	}

	public void setVehicleCapacity(float vehicleCapacity) {
		this.vehicleCapacity = vehicleCapacity;
	}

	@Column(name = "vehicle_model", nullable = false, length = 100)
	public String getVehicleModel() {
		return this.vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}