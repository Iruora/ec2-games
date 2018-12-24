package com.atn.demo.mvc.module.TrainingCenterMember.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.user.entity.User;

public interface TrainingCenterMemberService extends MyService<TrainingCenterMember, Long>{

	public TrainingCenterMember suscribeTeacherToClass(Long  teacherID,Long trainingcenterClassId);
	public TrainingCenterMember createMember(Long userId,String roleMember,TrainingCenter trainingCenter);
	public List<TrainingCenterMember> getTeacher();
	public List<TrainingCenterMember> getTeacherValidByTrainingCenter();
	public List<TrainingCenterMember> getTeacherByTrainingCenter(Long traniningCenterId);
	
	public void deleteTeacher(Long teacherId);
	public List<TrainingCenterMember> getStudentByTrainingCenter();
	
	public TrainingCenterMember validOrBloquedTrainingCentrerMember(Long memberID,String statusMember);
	public TrainingCenterMember bloquedTrainingCentrerMember(Long memberID);
	public TrainingCenterMember validTeacher(Long teacherId);
	public TrainingCenterMember bloquedTeacher(Long teacherId);
	
	
	public TrainingCenterMember addStudent(Long trainingcenterClassId);
	
	public List<TrainingCenterMember> getAllMember();
	public TrainingCenterMember getMemberConnected();
	
	public List<TrainingCenterMember> gettrainingCenterMemberByStatus(String memberRole,TrainingCenter trainingCenter);
	public List<TrainingCenterMember> gettrainingCenterMemberByUserName(String userName);
	
	public List<TrainingCenterMember> getTrainingCenterSubscribeByMember(Long userId);
}
