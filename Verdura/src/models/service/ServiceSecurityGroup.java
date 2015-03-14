package models.service;

import java.util.List;

import models.SecurityGroup;
import models.dao.DaoSecurityGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceSecurityGroup {

	@Autowired
	private DaoSecurityGroup daoSecurityGroup;
	
	@Transactional(readOnly = true)
	public List<SecurityGroup> listActive() {
		return daoSecurityGroup.listByField("status", 'A');
	}
}
