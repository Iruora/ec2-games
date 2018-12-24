package com.atn.demo.mvc.module.TrainingCenterMember.service;

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
import com.atn.demo.mvc.module.TrainingCenterMember.dao.TrainingCenterMemberDao;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember.RoleTrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember.Status;
import com.atn.demo.mvc.module.TrainingCenterStudent.entity.TrainingCenterStudent;
import com.atn.demo.mvc.module.TrainingCenterStudent.service.TrainingCenterStudentService;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.entity.User.STATUS;
import com.atn.demo.mvc.module.user.service.UserService;

@Component
public class TrainingCenterMemberServiceImpl extends MyAbstractService<TrainingCenterMember, Long>
		implements TrainingCenterMemberService {

	@Autowired
	UserService userService;
	@Autowired
	TrainingCenterService trainingCenterservice;

	@Autowired
	TrainingCenterClassService trainingCenterserviceclass;

	@Autowired
	TrainingCenterStudentService trainingCenterStudentService;
	
	

	public TrainingCenterMemberServiceImpl(TrainingCenterMemberDao dataAccessObject) {
		super(dataAccessObject);

	}

	@Override
	public BaseDao<TrainingCenterMember, Long> getDataAccessObject() {

		return this.dataAccessObject;
	}
	

	@Override
	@Transactional
	public TrainingCenterMember suscribeTeacherToClass(Long  teacherID,Long trainingcenterClassId) {

		TrainingCenterMember teacher=findById(teacherID);
		User userTeacher= teacher.getMember();
		TrainingCenterClass trainingCenterClass = trainingCenterserviceclass.findById(trainingcenterClassId);	
		trainingCenterClass.setTeacher(userTeacher);
		trainingCenterserviceclass.save(trainingCenterClass);
		return teacher;
	}

	@Override
	public List<TrainingCenterMember> getTeacher() {

		TrainingCenter trainingCenter = trainingCenterservice.getconnectedTrainingCenter();
		Map<String, Object> map = new HashMap<>();
		map.put("=role", RoleTrainingCenter.valueOf("TEACHER"));
		map.put("=status", Status.valueOf("VALIDATE"));
		map.put("=trainingCenter", trainingCenter);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);

	}

	@Override
	@Transactional
	public TrainingCenterMember validTeacher(Long teacherId) {
		TrainingCenterMember teacher = findById(teacherId);
		teacher.setStatus(Status.VALIDATE);

		return save(teacher);
	}

	@Override
	@Transactional
	public TrainingCenterMember bloquedTeacher(Long teacherId) {
		TrainingCenterMember teacher = findById(teacherId);
		teacher.setStatus(Status.BLOQUED);
		return save(teacher);
	}

	@Override
	@Transactional
	public void deleteTeacher(Long teacherId) {
		TrainingCenterMember teacher = findById(teacherId);
		delete(teacher);
	}

	@Override
	public List<TrainingCenterMember> getTeacherValidByTrainingCenter() {
		Map<String, Object> map = new HashMap<>();
		map.put("=role", RoleTrainingCenter.valueOf("TEACHER"));
		map.put("=status", Status.valueOf("VALIDATE"));
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);

	}

	@Override
	public List<TrainingCenterMember> getStudentByTrainingCenter() {
		Map<String, Object> map = new HashMap<String, Object>();
		TrainingCenter trainingCenter = trainingCenterservice.getconnectedTrainingCenter();
		map.put("=role", RoleTrainingCenter.valueOf("STUDENT"));
		map.put("=trainingCenter", trainingCenter);
		List<TrainingCenterMember> listOfStudentByTreainingCenter = findListByCriteria(map, null, 0,
				DELETION_STATUS.ACTIVE);
		return listOfStudentByTreainingCenter;
	}

	@Override
	@Transactional
	public TrainingCenterMember validOrBloquedTrainingCentrerMember(Long memberID,String statusMember) {
		TrainingCenterMember member = findById(memberID);
		if( statusMember.equals("REQUEST")||statusMember.equals("BLOQUED")){
			member.setStatus(Status.VALIDATE);
		}else if ( statusMember.equals("VALIDATE")){
			member.setStatus(Status.BLOQUED);
		}
		
		return save(member);
	}

	@Override
	@Transactional
	public TrainingCenterMember bloquedTrainingCentrerMember(Long memberID) {
		TrainingCenterMember student = findById(memberID);
		student.setStatus(Status.VALIDATE);

		return save(student);
	}

	@Override
	@Transactional
	public TrainingCenterMember addStudent(Long trainingcenterClassId) {
		TrainingCenterMember student = new TrainingCenterMember();
		student.setStatus(Status.REQUEST);
		student.setRole(RoleTrainingCenter.STUDENT);
		User user = userService.getConnectedUser();

		student.setMember(user);

		TrainingCenterClass trainingCenterClass = trainingCenterserviceclass.findById(trainingcenterClassId);
		student.setTrainingCenter(trainingCenterClass.getTrainingCenter());

		student.setStartDate(new java.util.Date());
		TrainingCenterMember saveStudent = save(student);

		trainingCenterClass.setTeacher(saveStudent.getMember());
		trainingCenterserviceclass.save(trainingCenterClass);

		TrainingCenterStudent tariningcenterStudent = new TrainingCenterStudent();
		tariningcenterStudent.setStudent(user);
		tariningcenterStudent.setTcClasse(trainingCenterClass);

		trainingCenterStudentService.save(tariningcenterStudent);

		return saveStudent;
	}

	@Override
	public List<TrainingCenterMember> getTeacherByTrainingCenter(Long traniningCenterId) {
		Map<String, Object> map = new HashMap<String, Object>();
		TrainingCenter trainingCenter = trainingCenterservice.findById(traniningCenterId);
		map.put("=role", RoleTrainingCenter.valueOf("TEACHER"));
		map.put("=trainingCenter", trainingCenter);
		map.put("=status", Status.valueOf("VALIDATE"));
		List<TrainingCenterMember> listOfTeacherByTreainingCenter = findListByCriteria(map, null, 0,
				DELETION_STATUS.ACTIVE);
		return listOfTeacherByTreainingCenter;

	}

	@Override
	public List<TrainingCenterMember> getAllMember() {
		Map<String, Object> map = new HashMap<String, Object>();
		TrainingCenter trainingCenter = trainingCenterservice.getconnectedTrainingCenter();
		// map.put("=status", Status.valueOf("VALIDATE"));
		map.put("=trainingCenter", trainingCenter);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	public TrainingCenterMember getMemberConnected() {
		User user= userService.getConnectedUser();
		Map<String, Object> map =new HashMap<>();
		map.put("=member", user.getId());
		 TrainingCenterMember tcmember=null;
		try {
			
			tcmember=findListByCriteria(map, null,0, DELETION_STATUS.ACTIVE).get(0);
			
		} catch (Exception e) {
			
		}
		
		return tcmember ;
	}

	@Override
	@Transactional
	public TrainingCenterMember createMember(Long userId,String roleMember,TrainingCenter trainingCenter) {
		User user=userService.findById(userId);
		user.setStatus(STATUS.VALIDATE);
		User userSave=userService.save(user);
		TrainingCenterMember trainingCentermember = new TrainingCenterMember();
		trainingCentermember.setMember(userSave);
		trainingCentermember.setTrainingCenter(trainingCenter);
		trainingCentermember.setStatus(Status.REQUEST);
		trainingCentermember.setStartDate(new java.util.Date());
		if(roleMember.equals("TEACHER")){
			trainingCentermember.setRole(RoleTrainingCenter.TEACHER);
			
		}
		else if(roleMember.equals("STUDENT")){
			trainingCentermember.setRole(RoleTrainingCenter.STUDENT);
		}
		return save(trainingCentermember);
	}

	@Override
	public List<TrainingCenterMember> gettrainingCenterMemberByStatus(
			String memberRole,TrainingCenter trainingCenter) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("=trainingCenter", trainingCenter);
		if(memberRole.equals("REQUEST")){
			map.put("=status", Status.valueOf("REQUEST"));
		}else if (memberRole.equals("VALIDATE")) {
			map.put("=status", Status.valueOf("VALIDATE"));
		}else if (memberRole.equals("BLOQUED")) {
			map.put("=status", Status.valueOf("BLOQUED"));
		}
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	public List<TrainingCenterMember> getTrainingCenterSubscribeByMember(
			Long userId) {
		User user=userService.getConnectedUser();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("=member", user);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

	@Override
	public List<TrainingCenterMember> gettrainingCenterMemberByUserName(
			String userName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("%member.userName%", userName);
		return findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
	}

}
