package com.atn.demo.mvc.module.TrainingCenterActivity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.persistence.BaseDao.DELETION_STATUS;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.TrainingCenterActivity.dao.TrainingCenterActivityDao;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity.Subject;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;
import com.atn.demo.mvc.module.TrainingCenterTheme.service.TrainingCenterThemeService;
import com.atn.demo.mvc.module.user.service.UserService;

@Component
public class TrainingCenterActivityServiceImpl extends
		MyAbstractService<TrainingCenterActivity, Long> implements
		TrainingCenterActivityService {

	@Autowired
	TrainingCenterService tariningCenterService;
	@Autowired
	TrainingCenterThemeService trainingCenterThemeService;
@Autowired
UserService userService;
@Autowired
TrainingCenterActivityService trainingCenteractivityService;
	public TrainingCenterActivityServiceImpl(
			TrainingCenterActivityDao dataAccessObject) {
		super(dataAccessObject);

	}

	@Override
	public BaseDao<TrainingCenterActivity, Long> getDataAccessObject() {

		return this.dataAccessObject;
	}

	@Override
	@Transactional
	public TrainingCenterActivity createTrainingCenterActivity(
			TrainingCenterActivity trainingCenterActivity) {
		TrainingCenter trainingCenter = tariningCenterService
				.getconnectedTrainingCenter();
		trainingCenterActivity.setTrainingCenter(trainingCenter);
		trainingCenterActivity.setUser(userService.getConnectedUser());
		return save(trainingCenterActivity);
	}

	@Override
	@Transactional
	public TrainingCenterActivity updateTrainingCenterActivity(
			TrainingCenterActivity trainingCenterActivity) {

		return null;
	}

	@Override
	public List<TrainingCenterActivity> getTrainingCenterActivityByTrainingCenter(
			TrainingCenter trainingCenter) {
		Map<String, Object> map = new HashMap<>();
		map.put("=trainingCenter", trainingCenter);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	public List<TrainingCenterActivity> getTrainingCenterActivityByTheme(
			Long trainingCenterThemeID) {
		Map<String, Object> map = new HashMap<>();
		TrainingCenterTheme trainingCenterTheme = trainingCenterThemeService
				.findById(trainingCenterThemeID);
		map.put("=trainingCenter", trainingCenterTheme);
		
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	public List<TrainingCenterActivity> getAllTrainingCenterActivity() {
		Map<String, Object> map = new HashMap<>();
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	public List<TrainingCenterActivity> getTrainingCenterActivityBySubject(
			String subject,TrainingCenter trainingCenter) {
		

		Map<String, Object> map = new HashMap<>();
		if(trainingCenter!=null){

		map.put("=trainingCenter", trainingCenter);
		}
		if(subject.equals("LOGIC")){
			map.put("=subject", Subject.valueOf("LOGIC"));
		}else if (subject.equals("VISUEL")) {
			map.put("=subject", Subject.valueOf("VISUEL"));
		}else if (subject.equals("SCIENCE")) {
			map.put("=subject", Subject.valueOf("SCIENCE"));
		}else if (subject.equals("LANGUAGE")) {
			map.put("=subject", Subject.valueOf("LANGUAGE"));
		}else if (subject.equals("SOCIAL")) {
			map.put("=subject", Subject.valueOf("SOCIAL"));
		}
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	@Transactional
	public void deletTrainingcenterActivity(Long trainingcenterActivityID) {
		TrainingCenterActivity trainingCenterActivity=trainingCenteractivityService.findById(trainingcenterActivityID);
		delete(trainingCenterActivity);
		
	}

	@Override
	public List<TrainingCenterActivity> getTrainingCenterActivityByActivityName(
			String activityname) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("%activityName%", activityname);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

}
