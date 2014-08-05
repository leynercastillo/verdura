package general;

import java.util.ArrayList;
import java.util.List;

import models.TbasicData;
import models.TbusinesPartnerItem;
import models.TbusinesPartnerItemId;
import models.TbusinessPartner;
import models.TinputMeasureUnit;
import models.Titem;

public class BusinessPartnerItemCustom {

	private TbusinesPartnerItemId id;
	private TbusinessPartner tbusinessPartner;
	private Titem titem;
	private TbasicData tbasicData;
	private List<TbasicData> listMeasurUnits;
	private float price;

	public BusinessPartnerItemCustom(TbusinesPartnerItem businessPartnerItem, Titem item) {
		this.id = businessPartnerItem.getId();
		this.tbusinessPartner = businessPartnerItem.getTbusinessPartner();
		this.titem = businessPartnerItem.getTitem();
		this.tbasicData = businessPartnerItem.getTbasicData();
		this.price = businessPartnerItem.getPrice();
		listMeasurUnits = new ArrayList<TbasicData>();
		for (TinputMeasureUnit measureUnit : item.getTinputMeasureUnits()) {
			listMeasurUnits.add(measureUnit.getTbasicData());
		}
	}

	public List<TbasicData> getListMeasurUnits() {
		return listMeasurUnits;
	}

	public void setListMeasurUnits(List<TbasicData> listMeasurUnits) {
		this.listMeasurUnits = listMeasurUnits;
	}
	
	public TbusinesPartnerItemId getId() {
		return id;
	}
	public void setId(TbusinesPartnerItemId id) {
		this.id = id;
	}
	public TbusinessPartner getTbusinessPartner() {
		return tbusinessPartner;
	}
	public void setTbusinessPartner(TbusinessPartner tbusinessPartner) {
		this.tbusinessPartner = tbusinessPartner;
	}
	public Titem getTitem() {
		return titem;
	}
	public void setTitem(Titem titem) {
		this.titem = titem;
	}
	public TbasicData getTbasicData() {
		return tbasicData;
	}
	public void setTbasicData(TbasicData tbasicData) {
		this.tbasicData = tbasicData;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
