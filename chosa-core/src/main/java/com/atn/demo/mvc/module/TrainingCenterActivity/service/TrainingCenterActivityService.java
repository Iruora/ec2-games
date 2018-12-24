package com.atn.demo.mvc.module.TrainingCenterActivity.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity;

public interface TrainingCenterActivityService extends MyService<TrainingCenterActivity, Long>{
	
	public TrainingCenterActivity createTrainingCenterActivity(TrainingCenterActivity trainingCenterActivity);
	public TrainingCenterActivity updateTrainingCenterActivity(TrainingCenterActivity trainingCenterActivity);
	public List<TrainingCenterActivity> getTrainingCenterActivityByTrainingCenter(TrainingCenter trainingCenter);
	public List<TrainingCenterActivity> getTrainingCenterActivityByTheme(Long trainingCenterThemeID);
	public List<TrainingCenterActivity> getAllTrainingCenterActivity();
	public List<TrainingCenterActivity> getTrainingCenterActivityByActivityName(String activityName);
	public List<TrainingCenterActivity> getTrainingCenterActivityBySubject(String subject,TrainingCenter trainingCenter);
	public void deletTrainingcenterActivity(Long trainingcenterActivityID);
	
}
