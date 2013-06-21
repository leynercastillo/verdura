package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.generic.GenericDao;
import models.TbusinessPartnerBranch;

@Repository
public class DaoBusinessPartnerBranch extends GenericDao<TbusinessPartnerBranch> {

    @Autowired
    public DaoBusinessPartnerBranch(SessionFactory sessionFactory) {
	super(sessionFactory);
    }
}
