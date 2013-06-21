package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.generic.GenericDao;

import models.Titem;

@Repository
public class DaoItem extends GenericDao<Titem> {

    @Autowired
    public DaoItem(SessionFactory sessionFactory) {
	super(sessionFactory);
    }

    public List<Titem> listOrderedByField(String field) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(Titem.class);
	criteria.addOrder(Order.asc(field));
	return criteria.list();
    }

    public List<Titem> findByString(String field, String value) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(Titem.class);
	criteria.add(Restrictions.eq(field, value));
	return criteria.list();
    }

    public Titem findByCode(String code) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(Titem.class);
	criteria.add(Restrictions.eq("code", code));
	Object bp = criteria.uniqueResult();
	return bp != null ? (Titem) bp : null;
    }

    public List<String> listStringByFields(String field) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(Titem.class);
	criteria.setProjection(Projections.distinct(Projections.property(field)));
	criteria.addOrder(Order.asc(field));
	List<String> list = criteria.list();
	return list;
    }
}