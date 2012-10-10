package hibernateConnections;

import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.zkoss.zkplus.hibernate.HibernateUtil;

public class GenericDao<Model> {
	
	public Class<Model> domainClass = getDomainClass();
	private Session session;

	protected Session currentSession(){
		return StoreHibernateUtil.openSession();
	}
	
	protected Class getDomainClass(){
		if(domainClass == null){
			ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class) type.getActualTypeArguments()[0];
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
		currentSession().save(model);
		transaction.commit();
		currentSession().close();
	}
	
	public void update(Model model){
		Transaction transaction = currentSession().beginTransaction();
		currentSession().update(model);
		transaction.commit();
		currentSession().close();
	}
	
	public void delete(Model model){
		Transaction transaction = currentSession().beginTransaction();
		currentSession().delete(model);
		transaction.commit();
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