package com.atn.demo.mvc.module.TrainingCenter.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.country.entity.Country;

public interface TrainingCenterService extends MyService<TrainingCenter, Long> {
	
	public TrainingCenter addTrainingCenter(TrainingCenter tc);
	public List<TrainingCenter> getAllTrainingCenter();
	public List<TrainingCenter> getAllTrainingCentervalid();
	public TrainingCenter updateTrainingCenter(TrainingCenter tc);
	public TrainingCenter getconnectedTrainingCenter();
	public TrainingCenter adminUpdate(Long centerId, String centerName, String centerAdress, String centerPhone, String centerStatus,
			Country centerCountry);
	

}
