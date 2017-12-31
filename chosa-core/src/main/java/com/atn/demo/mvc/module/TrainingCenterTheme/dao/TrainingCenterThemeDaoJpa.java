package com.atn.demo.mvc.module.TrainingCenterTheme.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;

@Component
public class TrainingCenterThemeDaoJpa extends BaseDaoJpa<TrainingCenterTheme, Long> implements TrainingCenterThemeDao{

	public TrainingCenterThemeDaoJpa() {
		super(TrainingCenterTheme.class);
		
	}

}
