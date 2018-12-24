package com.atn.demo.mvc.module.TrainingCenterStudent.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.TrainingCenterStudent.dao.TrainingCenterStudentDao;
import com.atn.demo.mvc.module.TrainingCenterStudent.entity.TrainingCenterStudent;

@Component
public class TrainingCenterStudentServiceImpl  extends MyAbstractService<TrainingCenterStudent, Long> implements TrainingCenterStudentService{

	public TrainingCenterStudentServiceImpl(
			TrainingCenterStudentDao dataAccessObject) {
		super(dataAccessObject);
	
	}

	@Override
	public BaseDao<TrainingCenterStudent, Long> getDataAccessObject() {
		
		return this.dataAccessObject;
	}

	@Override
	public List<TrainingCenterStudent> getTrainingCenterStudentbyTrainingCenter() {
		// TODO Auto-generated method stub
		return null;
	}

}
