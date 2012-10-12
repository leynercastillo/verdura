package hibernateConnections;

import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

	public void save(Model model){
		Transaction transaction = currentSession().beginTransaction();
		try {
			currentSession().save(model);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		currentSession().close();
	}
	
	public void update(Model model){
		Transaction transaction = currentSession().beginTransaction();
		try {
			currentSession().update(model);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		
		currentSession().close();
	}
	
	public void delete(Model model){
		Transaction transaction = currentSession().beginTransaction();
		try {
			currentSession().delete(model);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		currentSession().close();
	}
	
	public Model findById(Long id){
		Transaction transaction = currentSession().beginTransaction();
		Model model = (Model) currentSession().load(domainClass, id);
		transaction.commit();		
		currentSession().close();
		return model;
	}
}