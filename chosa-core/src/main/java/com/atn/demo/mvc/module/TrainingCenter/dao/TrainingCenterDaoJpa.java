package com.atn.demo.mvc.module.TrainingCenter.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;

@Component
public class TrainingCenterDaoJpa extends BaseDaoJpa<TrainingCenter, Long> implements TrainingCenterDao{

	public TrainingCenterDaoJpa() {
		super(TrainingCenter.class);
		
	}

	
}
