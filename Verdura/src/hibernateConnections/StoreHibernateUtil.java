package hibernateConnections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StoreHibernateUtil {

	public static final SessionFactory SESSION_FACTORY;
	
	static{
		try {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("No se pudo inicializar SESSION_FACTORY." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return SESSION_FACTORY;
	}
	
	public static Session openSession(){
		if (SESSION_FACTORY.isClosed())
			return SESSION_FACTORY.openSession();
		else
			return SESSION_FACTORY.getCurrentSession();
	}
}
