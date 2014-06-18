package models.dao;

import models.Torder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoOrder {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Object getMaxField(String field) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Torder.class);
		criteria.setProjection(Projections.max(field));
		return criteria.uniqueResult();
	}

}
