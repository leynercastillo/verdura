package hibernateConnections;

import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppCleanup;
import org.zkoss.zk.ui.util.WebAppInit;

public class HibernateListeners implements WebAppInit, WebAppCleanup {

	@Override
	public void cleanup(WebApp arg0) throws Exception {
		// TODO Auto-generated method stub
		StoreHibernateUtil.getSessionFactory();
	}

	@Override
	public void init(WebApp arg0) throws Exception {
		// TODO Auto-generated method stub
		StoreHibernateUtil.getSessionFactory().close();
	}

}
