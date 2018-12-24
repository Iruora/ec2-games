package com.atn.demo.mvc.module.TrainingCenterClass.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.user.entity.User;

public interface TrainingCenterClassService extends MyService<TrainingCenterClass, Long>{
	public TrainingCenterClass addClass(TrainingCenterClass trainingcneterclass);
	public List<TrainingCenterClass> getClassByTrainingCenter(Long trainingCenterId);
	public void deleteClass(Long trainingCenterClassId);
	public TrainingCenterClass updateClass(Long trainingCenterClassId,String className);
	public List<TrainingCenterClass> getClassByTeacher(Long teacherId);
}
