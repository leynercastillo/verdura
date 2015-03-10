package models.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.Titem;

@Repository
public class DaoItem {

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
	public Boolean save(Titem item) {
		Session session = getCurrentSession();
		try {
			session.save(item);
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
	public Boolean update(Titem item) {
		Session session = getCurrentSession();
		try {
			session.merge(item);
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
	public Boolean delete(Titem item) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(item));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Titem> listAll() {
		Criteria criteria = getCurrentSession().createCriteria(Titem.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Titem> listActiveOrderedByField(String field) {
		Criteria criteria = getCurrentSession().createCriteria(Titem.class);
		criteria.add(Restrictions.eq("status", 'A'));
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Titem> listOrderedByField(String field) {
		Criteria criteria = getCurrentSession().createCriteria(Titem.class);
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Titem> listByString(String field, String value) {
		Criteria criteria = getCurrentSession().createCriteria(Titem.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}

	public Titem findByString(String string, String field) {
		Criteria criteria = getCurrentSession().createCriteria(Titem.class);
		criteria.add(Restrictions.eq(field, string));
		Object bp = criteria.uniqueResult();
		return bp != null ? (Titem) bp : null;
	}

	@SuppressWarnings("unchecked")
	public List<String> listStringByFields(String field) {
		Criteria criteria = getCurrentSession().createCriteria(Titem.class);
		criteria.setProjection(Projections.distinct(Projections.property(field)));
		criteria.addOrder(Order.asc(field));
		List<String> list = criteria.list();
		return list;
	}
}