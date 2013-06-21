package dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.generic.GenericDao;

import models.TdataType;

@Repository
public class DaoDataType extends GenericDao<TdataType> {

    @Autowired
    public DaoDataType(SessionFactory sessionFactory) {
	super(sessionFactory);
    }

    public TdataType findByName(String name) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(TdataType.class);
	criteria.add(Restrictions.eq("name", name));
	return (TdataType) criteria.uniqueResult();
    }
}
