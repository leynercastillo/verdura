package models.dao;

import java.util.List;

import models.Torder;

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
public class DaoOrder {

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
	public Boolean save(Torder order) {
		Session session = getCurrentSession();
		try {
			session.save(order);
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
	public Boolean update(Torder order) {
		Session session = getCurrentSession();
		try {
			session.merge(order);
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
	public Boolean delete(Torder order) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(order));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Torder findByField(Object value, String field) {
		Criteria criteria = getCurrentSession().createCriteria(Torder.class);
		criteria.add(Restrictions.eq(field, value));
		Object bp = criteria.uniqueResult();
		return bp != null ? (Torder) bp : null;
	}

	public Object getMaxField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Torder.class);
		criteria.setProjection(Projections.max(field));
		return criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Torder> listAll() {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Torder.class);
		criteria.addOrder(Order.asc("torderNumber"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Torder> listOrderByField(Object value, String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Torder.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}
}