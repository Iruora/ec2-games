package com.atn.demo.mvc.module.familyMember.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.familyMember.entity.FamilyMember;

@Component
public class FamilyMemberDaoJpa extends BaseDaoJpa< FamilyMember, Long> implements FamilyMemberDao {

	public FamilyMemberDaoJpa() {
		super(FamilyMember.class);
		
	}

}
