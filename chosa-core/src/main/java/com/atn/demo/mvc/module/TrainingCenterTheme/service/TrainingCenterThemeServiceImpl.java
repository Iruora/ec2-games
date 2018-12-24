package com.atn.demo.mvc.module.TrainingCenterTheme.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.persistence.BaseDao.DELETION_STATUS;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;
import com.atn.demo.mvc.module.TrainingCenterProgram.service.TrainingCenterProgramService;
import com.atn.demo.mvc.module.TrainingCenterTheme.dao.TrainingCenterThemeDao;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;

@Component
public class TrainingCenterThemeServiceImpl extends
		MyAbstractService<TrainingCenterTheme, Long> implements
		TrainingCenterThemeService {

	@Autowired
	TrainingCenterProgramService trainingCenterProgramService;

	public TrainingCenterThemeServiceImpl(
			TrainingCenterThemeDao dataAccessObject) {
		super(dataAccessObject);

	}

	@Override
	public BaseDao<TrainingCenterTheme, Long> getDataAccessObject() {

		return this.dataAccessObject;
	}

	@Override
	@Transactional
	public TrainingCenterTheme createTheme(
			TrainingCenterTheme trainingcenterTheme,
			Long trainingcenterProgramID) {

		TrainingCenterProgram trainingCenterProgram = trainingCenterProgramService
				.findById(trainingcenterProgramID);
		trainingcenterTheme.setTrainingCenterprogram(trainingCenterProgram);

		return save(trainingcenterTheme);
	}

	@Override
	public List<TrainingCenterTheme> getTrainingcenterThemeByProgram(
			TrainingCenterProgram trainingcenterProgram) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("=trainingCenterprogram", trainingcenterProgram);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

}
