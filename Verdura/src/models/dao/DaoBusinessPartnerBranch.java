package models.dao;

import models.TbusinessPartnerBranch;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoBusinessPartnerBranch {

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
	public Boolean save(TbusinessPartnerBranch businessPartnerBranch) {
		Session session = getCurrentSession();
		try {
			session.save(businessPartnerBranch);
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
	public Boolean update(TbusinessPartnerBranch businessPartnerBranch) {
		Session session = getCurrentSession();
		try {
			session.merge(businessPartnerBranch);
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
	public Boolean delete(TbusinessPartnerBranch businessPartnerBranch) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(businessPartnerBranch));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
}
