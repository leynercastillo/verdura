package models.dao;

import java.util.List;

import models.TbusinessPartnerRoute;
import models.TbusinessPartnerRouteId;
import models.Troute;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoBusinessPartnerRoute {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @param model
	 *            Object to save in database
	 * @return true if deleted / false if not deleted
	 */
	public Boolean save(TbusinessPartnerRoute businessPartnerRoute) {
		Session session = getCurrentSession();
		try {
			session.save(businessPartnerRoute);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param model
	 *            Object to update in database
	 * @return true if deleted / false if not deleted
	 */
	public Boolean update(TbusinessPartnerRoute businessPartnerRoute) {
		Session session = getCurrentSession();
		try {
			session.merge(businessPartnerRoute);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param model
	 *            Object to delete in database
	 * @return true if deleted / false if not deleted
	 */
	public Boolean delete(TbusinessPartnerRoute businessPartnerRoute) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(businessPartnerRoute));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public TbusinessPartnerRoute findByKey(TbusinessPartnerRouteId partnerRouteId) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartnerRoute.class);
		criteria.add(Restrictions.eq("id", partnerRouteId));
		Object bpRoute = criteria.uniqueResult();
		return bpRoute != null ? (TbusinessPartnerRoute) bpRoute : null;
	}

	@SuppressWarnings("unchecked")
	public List<TbusinessPartnerRoute> listPartnersByRoute(Troute route) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartnerRoute.class);
		criteria.add(Restrictions.eq("troute", route));
		criteria.add(Restrictions.eq("status", 'A'));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
}