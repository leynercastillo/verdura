package models.service;

import java.util.HashSet;
import java.util.Set;

import models.TbusinessPartnerRoute;
import models.TbusinessPartnerRouteId;
import models.Troute;
import models.dao.DaoBusinessPartnerRoute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBusinessPartnerRoute {

	@Autowired
	private DaoBusinessPartnerRoute daoBusinessPartnerRoute;

	@Transactional
	public Boolean deleteBusinessPartnerRoute(TbusinessPartnerRoute businessPartnerRoute) {
		businessPartnerRoute.setStatus('E');
		return daoBusinessPartnerRoute.update(businessPartnerRoute);
	}

	@Transactional
	public Boolean save(TbusinessPartnerRoute businessPartnerRoute) {
		if (businessPartnerRoute.getId() == null) {
			TbusinessPartnerRouteId partnerRouteId = new TbusinessPartnerRouteId();
			partnerRouteId.setIdBusinessPartnerBranch(businessPartnerRoute.getTbusinessPartnerBranch().getIdBusinessPartnerBranch());
			partnerRouteId.setIdRoute(businessPartnerRoute.getTroute().getIdRoute());
			businessPartnerRoute.setId(partnerRouteId);
			// If partnerId already exist in db
			if (daoBusinessPartnerRoute.findByKey(partnerRouteId) != null) {
				return daoBusinessPartnerRoute.update(businessPartnerRoute);
			} else
				return daoBusinessPartnerRoute.save(businessPartnerRoute);
		} else
			return daoBusinessPartnerRoute.update(businessPartnerRoute);
	}

	@Transactional
	public Set<TbusinessPartnerRoute> listPartnerByRoute(Troute route) {
		return new HashSet<TbusinessPartnerRoute>(daoBusinessPartnerRoute.listPartnersByRoute(route));
	}
}