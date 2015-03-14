package models.dao;

import java.util.List;

import models.SecurityGroup;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoSecurityGroup {

	@Autowired
	private SessionFactory sessionFactory;

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @param model
	 *            Object to save in database
	 * @return true if saved / false if not saved
	 */
	public Boolean save(SecurityGroup securityGroup) {
		Session session = getCurrentSession();
		try {
			session.save(securityGroup);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param model
	 *            Object to update in database
	 * @return true if updated / false if not updated
	 */
	public Boolean update(SecurityGroup securityGroup) {
		Session session = getCurrentSession();
		try {
			session.merge(securityGroup);
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
	public Boolean delete(SecurityGroup securityGroup) {
		Session session = getCurrentSession();
		try {
			session.delete(securityGroup);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SecurityGroup> listByField(String field, Object value) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(SecurityGroup.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}
}
