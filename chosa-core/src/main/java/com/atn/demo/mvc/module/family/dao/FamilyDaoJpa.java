package com.atn.demo.mvc.module.family.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.family.entity.Family;
@Component
public class FamilyDaoJpa extends BaseDaoJpa<Family, Long> implements FamilyDao{

	public FamilyDaoJpa() {
		super(Family.class);
		
	}

}
