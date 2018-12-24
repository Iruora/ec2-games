package com.atn.demo.mvc.module.TrainingCenterClass.service;

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
import com.atn.demo.mvc.module.TrainingCenterClass.dao.TrainingCenterClassDao;
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.TrainingCenterMember.service.TrainingCenterMemberService;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.service.UserService;

@Component
public class TrainingCenterClassServiceImpl extends MyAbstractService<TrainingCenterClass, Long>  implements TrainingCenterClassService{

	
	@Autowired
	TrainingCenterService trainingCenterService;
	
	@Autowired
	TrainingCenterMemberService trainingCenterMember;
	
	@Autowired 
	UserService userService
;	
	public TrainingCenterClassServiceImpl(
			TrainingCenterClassDao dataAccessObject) {
		super(dataAccessObject);
		
	}

	@Override
	public BaseDao<TrainingCenterClass, Long> getDataAccessObject() {
		
		return this.dataAccessObject;
	}

	@Override
	@Transactional
	public TrainingCenterClass addClass(TrainingCenterClass tcClass) {
		TrainingCenter tc=trainingCenterService.getconnectedTrainingCenter();
		tcClass.setTrainingCenter(tc);
		
		
		return save(tcClass);
	}

	@Override
	public List<TrainingCenterClass> getClassByTrainingCenter(Long trainingCenterId) {
		Map<String, Object> map =new HashMap<String, Object>();
		TrainingCenter tc=trainingCenterService.findById(trainingCenterId);
		map.put("=trainingCenter", tc);
		List<TrainingCenterClass> classes =findListByCriteria(map, null,0, DELETION_STATUS.ACTIVE);
		return classes;
	}

	@Override
	@Transactional
	public void deleteClass(Long trainingCenterClassId) {
		TrainingCenterClass trainingCenterClass=findById(trainingCenterClassId);
		delete(trainingCenterClass);
		
	}

	@Override
	@Transactional
	public TrainingCenterClass updateClass(Long trainingCenterClassId,String className) {
		TrainingCenterClass trainingCenterClass=findById(trainingCenterClassId);
		if(trainingCenterClass!=null)
		{	
			TrainingCenter tc=trainingCenterService.getconnectedTrainingCenter();
			if(tc!=null){
			
			trainingCenterClass.setTrainingCenter(tc);
			}else{
				
				trainingCenterClass.setTrainingCenter(trainingCenterClass.getTrainingCenter());
			}
		
		trainingCenterClass.setClassName(className);
		return save(trainingCenterClass);}
		return null;
	}

	@Override
	public List<TrainingCenterClass> getClassByTeacher(Long userTeacherId) {
		Map<String, Object> map =new HashMap<String, Object>();
		User userTeacher=userService.findById(userTeacherId);
		map.put("=teacher", userTeacher);
		
		return findListByCriteria(map, null,0, DELETION_STATUS.ACTIVE);
	}


	

}
