package models.dao;

import models.TorderNumber;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoOrderNumber {

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
	public Boolean save(TorderNumber orderNumber) {
		Session session = getCurrentSession();
		try {
			session.save(orderNumber);
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
	public Boolean update(TorderNumber orderNumber) {
		Session session = getCurrentSession();
		try {
			session.merge(orderNumber);
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
	public Boolean delete(TorderNumber orderNumber) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(orderNumber));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public TorderNumber getWithMaxField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(TorderNumber.class);
		criteria.addOrder(Order.desc(field));
		criteria.setMaxResults(1);
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (TorderNumber) obj;
	}

	public Object getMaxField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(TorderNumber.class);
		criteria.setProjection(Projections.max(field));
		return criteria.uniqueResult();
	}
}
