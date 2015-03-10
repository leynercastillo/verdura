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

import models.TbasicData;
import models.TbusinessPartner;

@Repository
public class DaoBusinessPartner {

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
	public Boolean save(TbusinessPartner businessPartner) {
		Session session = getCurrentSession();
		try {
			session.save(businessPartner);
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
	public Boolean update(TbusinessPartner businessPartner) {
		Session session = getCurrentSession();
		try {
			session.merge(businessPartner);
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
	public Boolean delete(TbusinessPartner businessPartner) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(businessPartner));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TbusinessPartner> listAll() {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(TbusinessPartner.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<TbusinessPartner> listAllActiveByType(TbasicData type) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq("status", 'A'));
		criteria.add(Restrictions.eq("tbasicDataByType", type));
		criteria.addOrder(Order.asc("idBusinessPartner"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<TbusinessPartner> listOrderedbyField(String field) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<TbusinessPartner> listByString(String field, String value) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<TbusinessPartner> listByStringAndTypeBusinessPartner(String field, String value, TbasicData type) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq(field, value));
		criteria.add(Restrictions.eq("tbasicDataByType", type));
		return criteria.list();
	}

	public TbusinessPartner findByRif(String value, TbasicData type) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq("rif", value));
		criteria.add(Restrictions.eq("tbasicDataByType", type));
		Object bp = criteria.uniqueResult();
		return bp != null ? (TbusinessPartner) bp : null;
	}

	public TbusinessPartner findByString(Object value, String field) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq(field, value));
		Object bp = criteria.uniqueResult();
		return bp != null ? (TbusinessPartner) bp : null;
	}

	public TbusinessPartner findTypeBusinessPartnerByString(String value, String field, TbasicData type) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq(field, value));
		criteria.add(Restrictions.eq("tbasicDataByType", type));
		Object bp = criteria.uniqueResult();
		return bp != null ? (TbusinessPartner) bp : null;
	}

	@SuppressWarnings("unchecked")
	/**
	 * @param field
	 *            database field to search.
	 * @return List of String that result. It is empty if find nothing.
	 */
	public List<String> listStringByField(String field) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
		criteria.setProjection(Projections.distinct(Projections.property(field)));
		criteria.addOrder(Order.asc(field));
		List<String> list = criteria.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	/**
	 * @param field
	 *            database field to search.
	 * @return List of String that result. It is empty if find nothing.
	 */
	public List<String> listStringByFieldAndType(String field, TbasicData type) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq("tbasicDataByType", type));
		criteria.setProjection(Projections.distinct(Projections.property(field)));
		criteria.addOrder(Order.asc(field));
		List<String> list = criteria.list();
		return list;
	}
}