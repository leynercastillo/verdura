package models.service;

import models.TbusinesPartnerItem;
import models.TbusinesPartnerItemId;
import models.dao.DaoBusinessPartnerItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBusinessPartnerItem {
	
	@Autowired
	private DaoBusinessPartnerItem daoBusinessPartnerItem;
	
	@Transactional
	public boolean save(TbusinesPartnerItem businessPartnerItem){
		if (businessPartnerItem.getId() == null) {
			TbusinesPartnerItemId tbusinesPartnerItemId = new TbusinesPartnerItemId();
			tbusinesPartnerItemId.setIdBusinessPartner(businessPartnerItem.getTbusinessPartner().getIdBusinessPartner());
			tbusinesPartnerItemId.setIdItem(businessPartnerItem.getTitem().getIdItem());
			businessPartnerItem.setId(tbusinesPartnerItemId);
			return daoBusinessPartnerItem.save(businessPartnerItem);
		}
			return daoBusinessPartnerItem.update(businessPartnerItem);
	}
	
	@Transactional
	public boolean delete(TbusinesPartnerItem businessPartnerItem) {
		if (businessPartnerItem.getId() != null) {
			return daoBusinessPartnerItem.delete(businessPartnerItem);			
		} else
			return true;
		
	}
}
