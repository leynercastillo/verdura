package hibernateConnections;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class GenericDao<Model> {
	
	public Class<Model> domainClass = getDomainClass();	

	protected Session currentSession(){
		return StoreHibernateUtil.openSession();
	}
	
	protected Class<Model> getDomainClass(){
		if(domainClass == null){
			ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class<Model>) type.getActualTypeArguments()[0];
		}
		return domainClass;
	}
	
	@SuppressWarnings("unchecked")
	public Model load(Long id){
		Transaction transaction = currentSession().beginTransaction();
		Model returnvalue = (Model) currentSession().load(domainClass, id);
		transaction.commit();
		currentSession().close();
		return returnvalue;
	}

	public Boolean save(Model model){
		Transaction transaction = null;
		try {
			transaction = currentSession().beginTransaction();
			currentSession().saveOrUpdate(model);
			transaction.commit();
			currentSession().close();
			return true;
		} catch (HibernateException e) {
			try {
				transaction.rollback();
				currentSession().close();
				return false;
			} catch (RuntimeException e2) {
				System.out.println("No se pudo guardar ni realizar el rollback: "+e2);
				return false;
			}
		}
	}

	public Boolean delete(Model model){
		Transaction transaction = null;
		try {
			transaction = currentSession().beginTransaction();
			currentSession().delete(model);
			transaction.commit();
			currentSession().close();
			return true;
		} catch (HibernateException e) {
			try {
				transaction.rollback();
				currentSession().close();
				return false;
			} catch (RuntimeException e2) {
				System.out.println("No se pudo guardar ni realizar el rollback: "+e2);
				return false;
			}
		}
	}
	
	public Model findById(Long id){
		Transaction transaction = currentSession().beginTransaction();
		Model model = (Model) currentSession().load(domainClass, id);
		transaction.commit();		
		currentSession().close();
		return model;
	}
	
	public List<Model> list(Class c){
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(c);
		return criteria.list();
	}
	
	public List<Model> listActive(Class c){
		Transaction transaction = currentSession().beginTransaction();
		Criteria criteria = currentSession().createCriteria(c);
		criteria.add(Restrictions.eq("status", 'A'));
		return criteria.list();
	}
}