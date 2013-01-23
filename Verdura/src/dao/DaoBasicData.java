package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import models.TbasicData;
import models.TdataType;
import hibernateConnections.GenericDao;

public class DaoBasicData extends GenericDao<TbasicData> {
	
	public List<TbasicData> listByDataType(TdataType dataType){
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(TbasicData.class);
		criteria.add(Restrictions.eq("tdataType", dataType));
		return criteria.list();
	}

	public List<TbasicData> listByParent(TbasicData parent){
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(TbasicData.class);
		criteria.add(Restrictions.eq("tbasicData", parent));
		return criteria.list();
	}
}
