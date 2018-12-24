package com.atn.demo.mvc.module.familyMember.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.persistence.BaseDao.DELETION_STATUS;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.family.service.FamilyService;
import com.atn.demo.mvc.module.familyMember.dao.FamilyMemberDao;
import com.atn.demo.mvc.module.familyMember.entity.FamilyMember;
import com.atn.demo.mvc.module.familyMember.entity.FamilyMember.RoleFamily;
import com.atn.demo.mvc.module.user.entity.User;

@Component
public class FamilyMemberServiceImpl extends MyAbstractService<FamilyMember, Long> implements FamilyMemberService{

	@Autowired
	FamilyService familyService;
	
	
	
	public FamilyMemberServiceImpl(FamilyMemberDao dataAccessObject) {
		super(dataAccessObject);
		
	}

	@Override
	public BaseDao<FamilyMember, Long> getDataAccessObject() {
		
		return this.dataAccessObject;
	}

	@Override
	@Transactional
	public FamilyMember createFamilyMember( User user) {
		Family family=familyService.getConnectedFamily();
		FamilyMember familyMember=new FamilyMember();
		familyMember.setUser(user);
		familyMember.setFamily(family);
		familyMember.setRole(RoleFamily.CHILD);
		
		return save(familyMember);
	}

	

	@Override
	public List<FamilyMember> getMemberByFamily(Family family) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("=family", family);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	public List<FamilyMember> getMemberByName(String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("=user.userName", name);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	@Transactional
	public FamilyMember updateFamilyMember(Long failyMemberID,User user) {
		FamilyMember familyMember=findById(failyMemberID);
		familyMember.setUser(user);
		Family family=familyService.getConnectedFamily();
		familyMember.setFamily(family);
		familyMember.setRole(RoleFamily.CHILD);
		return save(familyMember);
	}

	

}
