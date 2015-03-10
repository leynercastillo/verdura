package models.dao;

import java.util.List;

import models.SecurityUser;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoSecurityUser {

	@Autowired
	private SessionFactory sessionFactory;

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @param model
	 *                Object to save in database
	 * @return true if saved / false if not saved
	 */
	public Boolean save(SecurityUser securityUser) {
		Session session = getCurrentSession();
		try {
			session.save(securityUser);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param model
	 *                Object to update in database
	 * @return true if updated / false if not updated
	 */
	public Boolean update(SecurityUser securityUser) {
		Session session = getCurrentSession();
		try {
			session.merge(securityUser);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param model
	 *                Object to delete in database
	 * @return true if deleted / false if not deleted
	 */
	public Boolean delete(SecurityUser securityUser) {
		Session session = getCurrentSession();
		try {
			session.delete(securityUser);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public SecurityUser findByField(String field, String value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(SecurityUser.class);
		criteria.add(Restrictions.eq(field, value).ignoreCase());
		Object su = criteria.uniqueResult();
		return su != null ? (SecurityUser) su : null;
	}

	@SuppressWarnings("unchecked")
	public List<SecurityUser> listAll() {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(SecurityUser.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<SecurityUser> listByGroup(int idGroup) {
		/*
		 * Aca se hace uso de HQL para poder hacer unos de los inner join, que ahorran mucha memoria al momento
		 * de realizar consultas complejas
		 */
		Session session = getCurrentSession();
		String hql = "select distinct user from SecurityGroup securityGroup inner join securityGroup.securityUsers user where securityGroup.id = :idGroup order by user.name";
		Query query = session.createQuery(hql);
		query.setParameter("idGroup", idGroup);
		return query.list();
	}
}
