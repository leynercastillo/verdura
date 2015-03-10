package models.dao;

import java.util.List;

import models.TinputMeasureUnit;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoInputMeasureUnit {

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
	public Boolean save(TinputMeasureUnit inputMeasureUnit) {
		Session session = getCurrentSession();
		try {
			session.save(inputMeasureUnit);
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
	public Boolean update(TinputMeasureUnit inputMeasureUnit) {
		Session session = getCurrentSession();
		try {
			session.merge(inputMeasureUnit);
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
	public Boolean delete(TinputMeasureUnit inputMeasureUnit) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(inputMeasureUnit));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TinputMeasureUnit> listByField(String field, Object value) {
		Criteria criteria = getCurrentSession().createCriteria(TinputMeasureUnit.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}
}
