package com.atn.demo.mvc.module.TrainingCenterActivity.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity;

@Component
public class TrainingCenterActivityDaoJpa extends BaseDaoJpa<TrainingCenterActivity, Long> implements TrainingCenterActivityDao{

	public TrainingCenterActivityDaoJpa( ) {
		super(TrainingCenterActivity.class);
		
	}

}
