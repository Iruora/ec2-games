package com.atn.demo.mvc.module.TrainingCenterTheme.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;

public interface TrainingCenterThemeService extends MyService<TrainingCenterTheme, Long>{
	
	public TrainingCenterTheme createTheme(TrainingCenterTheme trainingcenterTheme , Long trainingcenterProgramID);
	public List<TrainingCenterTheme> getTrainingcenterThemeByProgram(TrainingCenterProgram trainingcenterProgram);

}
