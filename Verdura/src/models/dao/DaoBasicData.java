package models.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.TbasicData;
import models.TdataType;

@Repository
public class DaoBasicData {

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
	public Boolean save(TbasicData basicData) {
		Session session = getCurrentSession();
		try {
			session.save(basicData);
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
	public Boolean update(TbasicData basicData) {
		Session session = getCurrentSession();
		try {
			session.merge(basicData);
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
	public Boolean delete(TbasicData basicData) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(basicData));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public TbasicData findById(int id) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(TbasicData.class);
		criteria.add(Restrictions.eq("idBasicData", id));
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (TbasicData) obj;
	}
	
	public TbasicData findTypeByString(String value, String field, TdataType type) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(TbasicData.class);
		criteria.add(Restrictions.eq(field, value));
		criteria.add(Restrictions.eq("tdataType", type));
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (TbasicData) obj;
	}

	@SuppressWarnings("unchecked")
	public List<TbasicData> listByDataType(TdataType dataType) {
		Criteria criteria = getCurrentSession().createCriteria(TbasicData.class);
		criteria.add(Restrictions.eq("tdataType", dataType));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<TbasicData> listByParent(TbasicData parent) {
		Criteria criteria = getCurrentSession().createCriteria(TbasicData.class);
		criteria.add(Restrictions.eq("tbasicData", parent));
		List<TbasicData> list = criteria.list();
		return list;
	}
}
