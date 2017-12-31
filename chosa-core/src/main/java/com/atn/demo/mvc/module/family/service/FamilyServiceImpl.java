package com.atn.demo.mvc.module.family.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.persistence.BaseDao.DELETION_STATUS;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.family.dao.FamilyDao;
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.service.UserService;

@Component
public class FamilyServiceImpl extends MyAbstractService<Family, Long> implements FamilyService{

	@Autowired 
	UserService userService;
	
	public FamilyServiceImpl(FamilyDao dataAccessObject) {
		super(dataAccessObject);
	}

	@Override
	public BaseDao<Family, Long> getDataAccessObject() {
		return this.dataAccessObject;
	}

	@Override
	@Transactional
	public Family createFamily(Family family, File file) {
		User user=userService.getConnectedUser();
		family.setUser(user);
		family.setLogo(file);
		return save(family);
	}

	@Override
	@Transactional
	public Family updateFamily(Family family) {
		User user=userService.getConnectedUser();
		family.setUser(user);
		family.setLogo(null);
		
		return save(family);
	}

	@Override
	public Family getConnectedFamily() {
		
		
		User user= userService.getConnectedUser();
		Map<String, Object> map =new HashMap<>();
		map.put("=user", user.getId());
		 Family family=null;
		try {
			
			family=findListByCriteria(map, null,0, DELETION_STATUS.ACTIVE).get(0);
			
		} catch (Exception e) {
			
		}
		
		return family ;
		
	}
	

}
