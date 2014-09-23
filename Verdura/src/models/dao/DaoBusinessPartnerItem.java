package models.dao;

import models.TbusinesPartnerItem;
import models.TbusinessPartner;
import models.Titem;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoBusinessPartnerItem {

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
	public Boolean save(TbusinesPartnerItem businessPartnerItem) {
		Session session = getCurrentSession();
		try {
			session.save(businessPartnerItem);
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
	public Boolean update(TbusinesPartnerItem businessPartnerItem) {
		Session session = getCurrentSession();
		try {
			session.merge(businessPartnerItem);
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
	public Boolean delete(TbusinesPartnerItem businessPartnerItem) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(businessPartnerItem));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public float findPriceByBusinessPartner(TbusinessPartner businessPartner, Titem item) {
		/*
		 * Aca se hace uso de HQL para poder hacer unos de los inner join, que
		 * ahorran mucha memoria al momento de realizar consultas complejas
		 */
		Session session = getCurrentSession();
		String hql = "select bpi.price from TbusinesPartnerItem bpi where bpi.tbusinessPartner = :businessPartner and bpi.titem =:item";
		Query query = session.createQuery(hql);
		query.setParameter("businessPartner", businessPartner);
		query.setParameter("item", item);
		Object value = query.uniqueResult();
		return value == null ? 0 : (float) value;
	}

	public boolean updatePrice(TbusinessPartner businessPartner, Titem item, float price) {
		/*
		 * Aca se hace uso de HQL para poder hacer unos de los inner join, que
		 * ahorran mucha memoria al momento de realizar consultas complejas
		 */
		Session session = getCurrentSession();
		String hql = "update TbusinesPartnerItem bpi set bpi.price = :price where bpi.tbusinessPartner = :businessPartner and bpi.titem = :item";
		Query query = session.createQuery(hql);
		query.setParameter("price", price);
		query.setParameter("businessPartner", businessPartner);
		query.setParameter("item", item);
		int result = query.executeUpdate();
		return result == 0 ? false : true;
	}
}
