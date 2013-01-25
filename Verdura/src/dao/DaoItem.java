package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import models.TbasicData;
import models.TbusinessPartner;
import models.Titem;
import hibernateConnections.GenericDao;

public class DaoItem extends GenericDao<Titem> {

	public List<Titem> listOrderedByField(String field) {
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(Titem.class);
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	public List<Titem> findByString(String field, String value) {
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(Titem.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}

	public Titem findByCode(String code) {
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq("code", code));
		Object bp = criteria.uniqueResult();
		return bp != null ? (Titem)bp : null;
	}
}