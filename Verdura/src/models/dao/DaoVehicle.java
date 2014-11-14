package models.dao;

import java.util.List;

import models.Tvehicle;

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
public class DaoVehicle {

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
	public Boolean save(Tvehicle vehicle) {
		Session session = getCurrentSession();
		try {
			session.save(vehicle);
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
	public Boolean update(Tvehicle vehicle) {
		Session session = getCurrentSession();
		try {
			session.merge(vehicle);
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
	public Boolean delete(Tvehicle vehicle) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(vehicle));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Tvehicle> listAll() {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Tvehicle.class);
		criteria.addOrder(Order.asc("idVehicle"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tvehicle> listByField(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Tvehicle.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}
	
	/**
	 * @param field
	 *            database field to search.
	 * @return List of String that result. It is empty if find nothing.
	 */
	@SuppressWarnings("unchecked")
	public List<String> listStringByField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Tvehicle.class);
		criteria.setProjection(Projections.distinct(Projections.property(field)));
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}
}
