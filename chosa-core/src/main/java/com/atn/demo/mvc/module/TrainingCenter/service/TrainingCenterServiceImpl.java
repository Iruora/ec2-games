package com.atn.demo.mvc.module.TrainingCenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.persistence.BaseDao.DELETION_STATUS;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.TrainingCenter.dao.TrainingCenterDao;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter.Status;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember.RoleTrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterMember.service.TrainingCenterMemberService;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.service.UserService;

@Component
public class TrainingCenterServiceImpl extends MyAbstractService<TrainingCenter, Long> implements TrainingCenterService{

	@Autowired
	UserService userservice;
	
	@Autowired
	TrainingCenterMemberService trainingMemberService;
	
	public TrainingCenterServiceImpl(
			TrainingCenterDao dataAccessObject) {
		super(dataAccessObject);
		
	}

	@Override
	public BaseDao<TrainingCenter, Long> getDataAccessObject() {
		
		return this.dataAccessObject;
	}

	@Override
	@Transactional
	public TrainingCenter addTrainingCenter(TrainingCenter tc) {
		
		User user=userservice.getConnectedUser();
		tc.setManager(user);
		tc.setStatus(Status.REQUEST);
		
		TrainingCenterMember director = new TrainingCenterMember();
		director.setStatus(com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember.Status.REQUEST);
		director.setRole(RoleTrainingCenter.DIRECTOR);
		director.setMember(user);
		director.setStartDate(new java.util.Date());
		TrainingCenter tcsaved=save(tc);
		director.setTrainingCenter(tcsaved);
		trainingMemberService.save(director);
		return tcsaved;
	}

	@Override
	public List<TrainingCenter> getAllTrainingCenter() {
		Map<String, Object> map =new HashMap<>();
		return findListByCriteria(map, null,0, DELETION_STATUS.ACTIVE);
	}

	@Override
	@Transactional
	public TrainingCenter updateTrainingCenter(TrainingCenter tc) {
		
		User manager=userservice.getConnectedUser();
		tc.setManager(manager);
		tc.setStatus(Status.REQUEST);
		return save(tc);
	}

	@Override
	public TrainingCenter getconnectedTrainingCenter() {
		User user= userservice.getConnectedUser();
		Map<String, Object> map =new HashMap<>();
		map.put("=manager", user.getId());
		 TrainingCenter tc=null;
		try {
			
			tc=findListByCriteria(map, null,0, DELETION_STATUS.ACTIVE).get(0);
			
		} catch (Exception e) {
			
		}
		
		return tc ;
	}
	@Override
	@Transactional
	public TrainingCenter adminUpdate(Long userId, String userName, String userAdress, String userPhone, String userStatus,
			Country userCountry) {
		TrainingCenter center=findById(userId);
		if(center!=null){
		center.setName(userName);
		center.setAdress(userAdress);
		center.setPhone(userPhone);
		center.setStatus(TrainingCenter.Status.valueOf(userStatus));
		center.setCountry(userCountry);
		return save(center);
		}
		return null;
	}

	@Override
	public List<TrainingCenter> getAllTrainingCentervalid() {
		Map<String, Object> map =new HashMap<>();
		map.put("=status", Status.valueOf("VALIDATE"));
		return findListByCriteria(map, null,0, DELETION_STATUS.ACTIVE);
	}

	

	
	
	
	
	
	
	

}
