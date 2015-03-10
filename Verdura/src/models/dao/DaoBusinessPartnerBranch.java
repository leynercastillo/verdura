package models.dao;

import java.util.ArrayList;
import java.util.List;

import models.TbasicData;
import models.TbusinessPartnerBranch;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoBusinessPartnerBranch {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @param model
	 *            Object to save in database
	 * @return true if deleted / false if not deleted
	 */
	public Boolean save(TbusinessPartnerBranch businessPartnerBranch) {
		Session session = getCurrentSession();
		try {
			session.save(businessPartnerBranch);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param model
	 *            Object to update in database
	 * @return true if deleted / false if not deleted
	 */
	public Boolean update(TbusinessPartnerBranch businessPartnerBranch) {
		Session session = getCurrentSession();
		try {
			session.merge(businessPartnerBranch);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param model
	 *            Object to delete in database
	 * @return true if deleted / false if not deleted
	 */
	public Boolean delete(TbusinessPartnerBranch businessPartnerBranch) {
		Session session = getCurrentSession();
		try {
			/*
			 * Hacemos merge sobre el objeto, ya que este se encuentra en otra
			 * session de hibernate (Al realizar la consulta).
			 */
			session.delete(session.merge(businessPartnerBranch));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TbusinessPartnerBranch> listAllActiveByType(TbasicData type) {
		Session session = getCurrentSession();
		String hql = "select branchs from TbusinessPartner partner inner join partner.tbusinessPartnerBranches branchs where partner.tbasicDataByType = :type and partner.status = 'A' order by partner.idBusinessPartner asc";
		Query query = session.createQuery(hql);
		query.setParameter("type", type);
		return query.list();
	}

	public TbusinessPartnerBranch findByField(Object value, String field) {
		Criteria criteria = getCurrentSession().createCriteria(TbusinessPartnerBranch.class);
		criteria.add(Restrictions.eq(field, value));
		Object bp = criteria.uniqueResult();
		return bp != null ? (TbusinessPartnerBranch) bp : null;
	}

	@SuppressWarnings("unchecked")
	public List<TbusinessPartnerBranch> listSearch(String rif, String partnerName, String branchName, String branchContactName) {
		Session session = getCurrentSession();
		String hql = "select branchs, rifType, partnerType from TbusinessPartner partner inner join partner.tbusinessPartnerBranches branchs inner join partner.tbasicDataByRifType rifType inner join partner.tbasicDataByType partnerType where lower(partner.rif) like :partnerRif and lower(partner.name) like :partnerName and lower(branchs.name) like :branchsName and lower(branchs.contactName) like :branchsContact order by partner.name asc";
		Query query = session.createQuery(hql);
		query.setParameter("partnerRif", '%' + rif.toLowerCase() + '%');
		query.setParameter("partnerName", '%' + partnerName.toLowerCase() + '%');
		query.setParameter("branchsName", '%' + branchName.toLowerCase() + '%');
		query.setParameter("branchsContact", '%' + branchContactName.toLowerCase() + '%');
		List<Object[]> listParner = (List<Object[]>) query.list();
		List<TbusinessPartnerBranch> listBranch = new ArrayList<TbusinessPartnerBranch>();
		for (Object[] objects : listParner) {
			TbusinessPartnerBranch partnerBranch = (TbusinessPartnerBranch) objects[0];
			partnerBranch.getTbusinessPartner().setTbasicDataByRifType((TbasicData) objects[1]);
			partnerBranch.getTbusinessPartner().setTbasicDataByType((TbasicData) objects[2]);
			listBranch.add(partnerBranch);
		}
		return listBranch;
	}
}