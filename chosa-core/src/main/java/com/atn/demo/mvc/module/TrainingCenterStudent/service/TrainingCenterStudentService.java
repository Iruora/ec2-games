package com.atn.demo.mvc.module.TrainingCenterStudent.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.TrainingCenterStudent.entity.TrainingCenterStudent;

public interface TrainingCenterStudentService extends MyService<TrainingCenterStudent, Long>{
	
	public List<TrainingCenterStudent> getTrainingCenterStudentbyTrainingCenter();
	

}
