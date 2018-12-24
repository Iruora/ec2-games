package com.atn.demo.mvc.module.TrainingCenterProgram.service;

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
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.TrainingCenterClass.service.TrainingCenterClassService;
import com.atn.demo.mvc.module.TrainingCenterProgram.dao.TrainingCenterProgramDao;
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;

@Component
public class TrainingCenterProgramServiceImpl extends
		MyAbstractService<TrainingCenterProgram, Long> implements
		TrainingCenterProgramService {

	public TrainingCenterProgramServiceImpl(
			TrainingCenterProgramDao dataAccessObject) {
		super(dataAccessObject);

	}

	@Autowired
	TrainingCenterService trainingCenterService;
	@Autowired
	TrainingCenterClassService trainingCenterClassService;

	@Override
	public BaseDao<TrainingCenterProgram, Long> getDataAccessObject() {

		return this.dataAccessObject;
	}

	@Override
	@Transactional
	public TrainingCenterProgram createProgram(TrainingCenterProgram program) {
		TrainingCenter trainingCenter = trainingCenterService
				.getconnectedTrainingCenter();
		program.setTrainingCenterProgram(trainingCenter);
		return save(program);
	}

	@Override
	public List<TrainingCenterProgram> getProgrammesByTrainingCenter(
			TrainingCenter trainingCenter) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("=trainingCenterProgram", trainingCenter);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	public TrainingCenterProgram updateProgram(TrainingCenterProgram program) {

		return null;
	}

	@Override
	@Transactional
	public TrainingCenterProgram attachProgramToClass(
			Long trainingcenterProgramID, Long trainingcenterClassID) {
		TrainingCenterProgram program = findById(trainingcenterProgramID);
		TrainingCenterClass tc_class = trainingCenterClassService
				.findById(trainingcenterClassID);
		tc_class.setTrainingCenterprogramClass(program);
		return null;
	}

	@Override
	public List<TrainingCenterProgram> getProgrammesNotAttachToClass(
			Long IdClass) {
		Map<String, Object> map = new HashMap<String, Object>();
		TrainingCenterClass TC_class = trainingCenterClassService
				.findById(IdClass);
		TrainingCenterProgram programm = TC_class
				.getTrainingCenterprogramClass();
		map.put("!=tcProgramId", programm.getId());
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	public List<TrainingCenterProgram> getProgrammesByName(String className) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("%programName%", className);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
		
	}

}
