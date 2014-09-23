package models.service;

import models.TbusinesPartnerItem;
import models.TbusinesPartnerItemId;
import models.TbusinessPartner;
import models.Titem;
import models.TpurchaseDetail;
import models.dao.DaoBusinessPartnerItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBusinessPartnerItem {

	@Autowired
	private DaoBusinessPartnerItem daoBusinessPartnerItem;
	@Autowired
	private ServicePurchaseDetail servicePurchaseDetail;

	@Transactional
	public boolean save(TbusinesPartnerItem businessPartnerItem) {
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
	public boolean updatePrice(TpurchaseDetail purchaseDetail) {
		return daoBusinessPartnerItem.updatePrice(purchaseDetail.getTpurchase().getTbusinessPartnerBranch().getTbusinessPartner(), purchaseDetail.getTitem(), purchaseDetail.getPrice());
	}

	@Transactional
	public boolean delete(TbusinesPartnerItem businessPartnerItem) {
		if (businessPartnerItem.getId() != null) {
			return daoBusinessPartnerItem.delete(businessPartnerItem);
		} else
			return true;
	}

	@Transactional(readOnly = true)
	public float findPriceItem(TbusinessPartner businessPartner, Titem item) {
		return daoBusinessPartnerItem.findPriceByBusinessPartner(businessPartner, item);
	}
}
