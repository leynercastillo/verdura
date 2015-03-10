package models.dao;

import java.util.List;

import models.ToutputMeasureUnit;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoOutputMeasureUnit {

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
	public Boolean save(ToutputMeasureUnit outputMeasureUnit) {
		Session session = getCurrentSession();
		try {
			session.save(outputMeasureUnit);
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
	public Boolean update(ToutputMeasureUnit outputMeasureUnit) {
		Session session = getCurrentSession();
		try {
			session.merge(outputMeasureUnit);
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
	public Boolean delete(ToutputMeasureUnit outputMeasureUnit) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(outputMeasureUnit));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ToutputMeasureUnit> listByField(String field, Object value) {
		Criteria criteria = getCurrentSession().createCriteria(ToutputMeasureUnit.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}
}