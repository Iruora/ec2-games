package com.atn.demo.mvc.module.TrainingCenterProgram.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;

public interface TrainingCenterProgramService extends
		MyService<TrainingCenterProgram, Long> {

	public TrainingCenterProgram createProgram(TrainingCenterProgram program);

	public List<TrainingCenterProgram> getProgrammesByTrainingCenter(
			TrainingCenter trainingCenter);

	public TrainingCenterProgram updateProgram(TrainingCenterProgram program);

	public TrainingCenterProgram attachProgramToClass(
			Long trainingcenterProgramID, Long trainingcenterClassID);

	public List<TrainingCenterProgram> getProgrammesNotAttachToClass(
			Long IdClass);
	public List<TrainingCenterProgram> getProgrammesByName(
			String className);

}
