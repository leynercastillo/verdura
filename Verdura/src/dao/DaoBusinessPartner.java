package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.generic.GenericDao;

import models.TbasicData;
import models.TbusinessPartner;

@Repository
public class DaoBusinessPartner extends GenericDao<TbusinessPartner> {

    @Autowired
    public DaoBusinessPartner(SessionFactory sessionFactory) {
	super(sessionFactory);
    }

    public List<TbusinessPartner> listOrderedbyField(String field) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
	criteria.addOrder(Order.asc(field));
	return criteria.list();
    }

    public List<TbusinessPartner> findByString(String field, String value) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
	criteria.add(Restrictions.eq(field, value));
	return criteria.list();
    }

    public TbusinessPartner findByRif(String value, TbasicData type) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
	criteria.add(Restrictions.eq("rif", value));
	criteria.add(Restrictions.eq("tbasicDataByType", type));
	Object bp = criteria.uniqueResult();
	return bp != null ? (TbusinessPartner) bp : null;
    }
}