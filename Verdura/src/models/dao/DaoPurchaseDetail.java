package models.dao;

import models.TpurchaseDetail;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPurchaseDetail {

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
	public Boolean save(TpurchaseDetail purchaseDetail) {
		Session session = getCurrentSession();
		try {
			session.save(purchaseDetail);
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
	public Boolean update(TpurchaseDetail purchaseDetail) {
		Session session = getCurrentSession();
		try {
			session.merge(purchaseDetail);
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
	public Boolean delete(TpurchaseDetail purchaseDetail) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(purchaseDetail));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public TpurchaseDetail findByField(Object value, String field) {
		Criteria criteria = getCurrentSession().createCriteria(TpurchaseDetail.class);
		criteria.add(Restrictions.eq(field, value));
		Object bp = criteria.uniqueResult();
		return bp != null ? (TpurchaseDetail) bp : null;
	}
}
