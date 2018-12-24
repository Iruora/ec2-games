package com.atn.demo.mvc.module.TrainingCenterThemeActivity.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;
import com.atn.demo.mvc.module.TrainingCenterThemeActivity.entity.TrainingCenterThemeActivity;

public interface TrainingCenterThemeActivityService extends MyService<TrainingCenterThemeActivity, Long>{
	
	public List<TrainingCenterThemeActivity> getTrainingCenterActivityByTheme(TrainingCenterTheme trainingCenterTheme);
	public List<TrainingCenterThemeActivity> getTrainingCenterActivityNotAttachToTheme(TrainingCenterTheme trainingCenterTheme);
	public void attachActivityToTheme(Long trainingcenterThemeID,Long trainingcenterActivityID);
	public void deletTrainingcenterThemeActivity(Long trainingcenterThemeActivityID);
}
