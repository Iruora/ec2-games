package com.atn.demo.mvc.module.TrainingCenterThemeActivity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.persistence.BaseDao.DELETION_STATUS;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity;
import com.atn.demo.mvc.module.TrainingCenterActivity.service.TrainingCenterActivityService;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;
import com.atn.demo.mvc.module.TrainingCenterTheme.service.TrainingCenterThemeService;
import com.atn.demo.mvc.module.TrainingCenterThemeActivity.dao.TrainingCenterThemeActivityDao;
import com.atn.demo.mvc.module.TrainingCenterThemeActivity.entity.TrainingCenterThemeActivity;

@Component
public class TrainingCenterThemeActivityServiceImpl extends
		MyAbstractService<TrainingCenterThemeActivity, Long> implements
		TrainingCenterThemeActivityService {

	@Autowired
	TrainingCenterThemeService trainingCenterThemeService;
	@Autowired
	TrainingCenterActivityService trainingCenteractivityService;

	public TrainingCenterThemeActivityServiceImpl(
			TrainingCenterThemeActivityDao dataAccessObject) {
		super(dataAccessObject);

	}

	@Override
	public BaseDao<TrainingCenterThemeActivity, Long> getDataAccessObject() {

		return this.dataAccessObject;
	}

	@Override
	public List<TrainingCenterThemeActivity> getTrainingCenterActivityByTheme(
			TrainingCenterTheme trainingCenterTheme) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("=trainingCenterThemeActivity", trainingCenterTheme);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	@Transactional
	public void attachActivityToTheme(Long trainingcenterThemeID,
			Long trainingcenterActivityID) {
		TrainingCenterTheme trainingcenterTheme = trainingCenterThemeService
				.findById(trainingcenterThemeID);
		TrainingCenterActivity trainingCenterActivity = trainingCenteractivityService
				.findById(trainingcenterActivityID);
		TrainingCenterThemeActivity trainingCenterThemeActivity = new TrainingCenterThemeActivity();
		trainingCenterThemeActivity
				.setTrainingCenterActivity(trainingCenterActivity);
		trainingCenterThemeActivity
				.setTrainingCenterThemeActivity(trainingcenterTheme);
		save(trainingCenterThemeActivity);

	}

	@Override
	@Transactional
	public void deletTrainingcenterThemeActivity(
			Long trainingcenterThemeActivityID) {
		TrainingCenterThemeActivity trainingcenterThemeActiity = findById(trainingcenterThemeActivityID);
		delete(trainingcenterThemeActiity);

	}

	@Override
	public List<TrainingCenterThemeActivity> getTrainingCenterActivityNotAttachToTheme(
			TrainingCenterTheme trainingCenterTheme) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<TrainingCenterThemeActivity> listofActvityByTheme=getTrainingCenterActivityByTheme(trainingCenterTheme);
		for (TrainingCenterThemeActivity trainingCenterActivity : listofActvityByTheme) {
			map.put("!=trainingCenterActivity", trainingCenterActivity.getTrainingCenterActivity());
			map.put("!=trainingCenterThemeActivity", trainingCenterTheme);
		}
		
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
		
	}

}
