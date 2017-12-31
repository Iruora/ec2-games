package com.atn.demo.mvc.module.familyMember.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.familyMember.entity.FamilyMember;
import com.atn.demo.mvc.module.user.entity.User;

public interface FamilyMemberService extends MyService<FamilyMember, Long> {
	public FamilyMember createFamilyMember( User user);
	public List<FamilyMember> getMemberByFamily(Family family);
	public List<FamilyMember> getMemberByName(String name);
	public FamilyMember updateFamilyMember( Long failyMemberID,User user);
	
}
