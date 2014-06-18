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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TdataType generated by hbm2java
 */
@Entity
@Table(name = "tdata_type")
public class TdataType implements java.io.Serializable {

    private static final long serialVersionUID = -2339967787537685645L;
    private int idDataType;
    private String name;
    private String description;
    private char status;
    private Set<TbasicData> tbasicDatas = new HashSet<TbasicData>(0);

    public TdataType() {
    }

    public TdataType(int idDataType, String name, String description, char status) {
	this.idDataType = idDataType;
	this.name = name;
	this.description = description;
	this.status = status;
    }

    public TdataType(int idDataType, String name, String description, char status, Set<TbasicData> tbasicDatas) {
	this.idDataType = idDataType;
	this.name = name;
	this.description = description;
	this.status = status;
	this.tbasicDatas = tbasicDatas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tdata_type_id_seq")
    @SequenceGenerator(name = "tdata_type_id_seq", sequenceName = "tdata_type_id_seq")
    @Column(name = "id_data_type", unique = true, nullable = false)
    public int getIdDataType() {
	return this.idDataType;
    }

    public void setIdDataType(int idDataType) {
	this.idDataType = idDataType;
    }

    @Column(name = "name", nullable = false, length = 150)
    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Column(name = "description", nullable = false, length = 200)
    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Column(name = "status", nullable = false, length = 1)
    public char getStatus() {
	return this.status;
    }

    public void setStatus(char status) {
	this.status = status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tdataType")
    public Set<TbasicData> getTbasicDatas() {
	return this.tbasicDatas;
    }

    public void setTbasicDatas(Set<TbasicData> tbasicDatas) {
	this.tbasicDatas = tbasicDatas;
    }

}
