package models.dao;

import java.util.List;

import models.Troute;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoRoute {

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
	public Boolean save(Troute route) {
		Session session = getCurrentSession();
		try {
			session.save(route);
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
	public Boolean update(Troute route) {
		Session session = getCurrentSession();
		try {
			session.merge(route);
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
	public Boolean delete(Troute route) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(route));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Integer getMaxField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Troute.class);
		criteria.setProjection(Projections.max(field));
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (Integer) obj;
	}

	public Troute findByField(Object value, String field) {
		Criteria criteria = getCurrentSession().createCriteria(Troute.class);
		criteria.add(Restrictions.eq(field, value));
		Object bp = criteria.uniqueResult();
		return bp != null ? (Troute) bp : null;
	}

	@SuppressWarnings("unchecked")
	public List<Troute> listAll() {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Troute.class);
		criteria.addOrder(Order.asc("idRoute"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Troute> listByField(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Troute.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}
}