package models.dao;

import java.util.List;

import models.Tpurchase;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPurchase {

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
	public Boolean save(Tpurchase purchase) {
		Session session = getCurrentSession();
		try {
			session.save(purchase);
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
	public Boolean update(Tpurchase purchase) {
		Session session = getCurrentSession();
		try {
			session.merge(purchase);
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
	public Boolean delete(Tpurchase purchase) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(purchase));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Integer getMaxField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Tpurchase.class);
		criteria.setProjection(Projections.max(field));
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (Integer)obj;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tpurchase> listPurchaseByField(Object value, String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Tpurchase.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}
}
