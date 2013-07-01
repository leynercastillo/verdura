package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.generic.GenericDao;

import models.TbasicData;
import models.TdataType;

@Repository
public class DaoBasicData extends GenericDao<TbasicData> {

    @Autowired
    public DaoBasicData(SessionFactory sessionFactory) {
	super(sessionFactory);
    }

    public List<TbasicData> listByDataType(TdataType dataType) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(TbasicData.class);
	criteria.add(Restrictions.eq("tdataType", dataType));
	return criteria.list();
    }

    public List<TbasicData> listByParent(TbasicData parent) {
	getCurrentSession().beginTransaction();
	Criteria criteria = getCurrentSession().createCriteria(TbasicData.class);
	criteria.add(Restrictions.eq("tbasicData", parent));
	List<TbasicData> list = criteria.list();
	return list;
    }
}
