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

    public List<TbusinessPartner> listByString(String field, String value) {
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

    /**
     * @param field
     *            database field to search.
     * @return List of String that result. It is empty if find nothing.
     */
    public List<String> listStringByField(String field) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(TbusinessPartner.class);
	criteria.setProjection(Projections.distinct(Projections.property(field)));
	criteria.addOrder(Order.asc(field));
	List<String> list = criteria.list();
	return list;
    }
}