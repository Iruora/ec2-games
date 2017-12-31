package com.atn.demo.mvc.module.TrainingCenterMember.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;

@Component
public class TrainingCenterMemberDaoJpa extends BaseDaoJpa<TrainingCenterMember, Long> implements TrainingCenterMemberDao{

	public TrainingCenterMemberDaoJpa() {
		super(TrainingCenterMember.class);
		
	}

}
