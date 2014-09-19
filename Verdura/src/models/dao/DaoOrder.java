package models.dao;

import java.util.List;

import models.Torder;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoOrder {

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
	public Boolean save(Torder order) {
		Session session = getCurrentSession();
		try {
			session.save(order);
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
	public Boolean update(Torder order) {
		Session session = getCurrentSession();
		try {
			session.merge(order);
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
	public Boolean delete(Torder order) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(order));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Torder findByField(Object value, String field) {
		Criteria criteria = getCurrentSession().createCriteria(Torder.class);
		criteria.add(Restrictions.eq(field, value));
		Object bp = criteria.uniqueResult();
		return bp != null ? (Torder) bp : null;
	}

	public Integer getMaxField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Torder.class);
		criteria.setProjection(Projections.max(field));
		Object obj = criteria.uniqueResult();
		return obj == null ? null : (Integer)obj;
	}

	@SuppressWarnings("unchecked")
	public List<Torder> listAll() {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Torder.class);
		criteria.addOrder(Order.asc("torderNumber"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Torder> listOrderByField(Object value, String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Torder.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}
	
	public float getQuantityRemainingByItem(int idItem, int idOrderNumber) {
		/*
		 * Aca se hace uso de HQL para poder hacer unos de los inner join, que ahorran mucha memoria al momento
		 * de realizar consultas complejas
		 */
		Session session = getCurrentSession();
		String hql = "select cast((case when sum(od.quantity) is null then 0 else sum(od.quantity) end - case when sum(pd.quantity) is null then 0 else sum(pd.quantity) end) as float) from Torder o inner join o.torderDetails od inner join o.torderNumber onu left join onu.tpurchases p left join p.tpurchaseDetails pd where od.titem.idItem = :idItem and onu.idOrderNumber = :idOrderNumber";
		//String hql = "select distinct branchs from TbusinessPartner partner inner join partner.tbusinessPartnerBranches branchs where partner.id = :idPartner order by branchs.addressDefault desc, branchs.name";
		Query query = session.createQuery(hql);
		query.setParameter("idItem", idItem);
		query.setParameter("idOrderNumber", idOrderNumber);
		Object value = query.uniqueResult();
		return value == null ? 0 : (float)value;
	}
}