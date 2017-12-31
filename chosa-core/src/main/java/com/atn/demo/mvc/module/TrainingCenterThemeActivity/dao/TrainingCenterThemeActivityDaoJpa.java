package com.atn.demo.mvc.module.TrainingCenterThemeActivity.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.TrainingCenterThemeActivity.entity.TrainingCenterThemeActivity;

@Component
public class TrainingCenterThemeActivityDaoJpa extends
		BaseDaoJpa<TrainingCenterThemeActivity, Long> implements
		TrainingCenterThemeActivityDao {

	public TrainingCenterThemeActivityDaoJpa() {
		super(TrainingCenterThemeActivity.class);

	}

}
