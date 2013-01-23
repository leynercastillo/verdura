package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import models.TbasicData;
import models.TbusinessPartner;
import hibernateConnections.GenericDao;

public class DaoBusinessPartner extends GenericDao<TbusinessPartner> {

	public List<TbusinessPartner> listOrderedbyField(String field) {
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(TbusinessPartner.class);
		criteria.addOrder(Order.asc(field));
		return criteria.list();
	}

	public List<TbusinessPartner> findByString(String field, String value) {
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}

	public TbusinessPartner findByRif(String value, TbasicData type) {
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(TbusinessPartner.class);
		criteria.add(Restrictions.eq("rif", value));
		criteria.add(Restrictions.eq("tbasicDataByType", type));
		Object bp = criteria.uniqueResult();
		return bp != null ? (TbusinessPartner)bp : null;
	}
}