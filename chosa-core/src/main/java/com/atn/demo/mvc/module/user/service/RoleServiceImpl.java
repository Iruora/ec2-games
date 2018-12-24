package com.atn.demo.mvc.module.user.service;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.user.dao.RoleDao;
import com.atn.demo.mvc.module.user.entity.Role;

@Component
public class RoleServiceImpl extends MyAbstractService<Role, Integer> implements RoleService{

	public RoleServiceImpl(RoleDao dataAccessObject) {
		super(dataAccessObject);
		
	}

	@Override
	public void setDataAccessObject(BaseDao<Role, Integer> baseDao) {
		
		
	}

	@Override
	public void persist(Role entity) {
		
		
	}

	@Override
	public void delete(Role entity) {
		
		
	}

	@Override
	public Role save(Role entity) {
		
		return dataAccessObject.save(entity);
	}

	@Override
	public BaseDao<Role, Integer> getDataAccessObject() {
	
		return this.dataAccessObject;
	}

	

}
