package models.dao;

import models.TorderDetail;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoOrderDetail {

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
	public Boolean save(TorderDetail orderDetail) {
		Session session = getCurrentSession();
		try {
			session.save(orderDetail);
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
	public Boolean update(TorderDetail orderDetail) {
		Session session = getCurrentSession();
		try {
			session.merge(orderDetail);
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
	public Boolean delete(TorderDetail orderDetail) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(orderDetail));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public TorderDetail findByField(Object value, String field) {
		Criteria criteria = getCurrentSession().createCriteria(TorderDetail.class);
		criteria.add(Restrictions.eq(field, value));
		Object bp = criteria.uniqueResult();
		return bp != null ? (TorderDetail) bp : null;
	}
}
