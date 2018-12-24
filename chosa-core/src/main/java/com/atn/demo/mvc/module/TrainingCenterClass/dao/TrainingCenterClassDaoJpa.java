package com.atn.demo.mvc.module.TrainingCenterClass.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;

@Component
public class TrainingCenterClassDaoJpa extends BaseDaoJpa<TrainingCenterClass, Long> implements TrainingCenterClassDao{

	public TrainingCenterClassDaoJpa() {
		super(TrainingCenterClass.class);
	
	}

}
