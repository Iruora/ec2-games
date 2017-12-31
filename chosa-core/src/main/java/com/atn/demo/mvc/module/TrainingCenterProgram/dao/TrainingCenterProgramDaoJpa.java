package com.atn.demo.mvc.module.TrainingCenterProgram.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;

@Component
public class TrainingCenterProgramDaoJpa extends BaseDaoJpa<TrainingCenterProgram, Long> implements TrainingCenterProgramDao {

	public TrainingCenterProgramDaoJpa() {
		super(TrainingCenterProgram.class);
		
	}

}
