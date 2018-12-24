package com.atn.demo.mvc.module.TrainingCenterStudent.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.TrainingCenterStudent.entity.TrainingCenterStudent;


@Component
public class TrainingCenterStudentDaoJpa extends BaseDaoJpa<TrainingCenterStudent, Long> implements TrainingCenterStudentDao{

	public TrainingCenterStudentDaoJpa() {
		super(TrainingCenterStudent.class);
		
	}

}
