package dao;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import models.TdataType;
import hibernateConnections.GenericDao;

public class DaoDataType extends GenericDao<TdataType> {
	public TdataType findByName(String name){
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(TdataType.class);
		criteria.add(Restrictions.eq("name", name));
		return (TdataType)criteria.uniqueResult();
	}
}
