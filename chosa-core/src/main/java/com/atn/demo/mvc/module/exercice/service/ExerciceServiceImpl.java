package com.atn.demo.mvc.module.exercice.service;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.exercice.dao.ExerciceDao;
import com.atn.demo.mvc.module.exercice.entity.Exercice;

@Component
public class ExerciceServiceImpl extends MyAbstractService<Exercice, Long> implements ExerciceSevice{

	public ExerciceServiceImpl(ExerciceDao dataAccessObject) {
		super(dataAccessObject);
		
	}

	@Override
	public BaseDao<Exercice, Long> getDataAccessObject() {
		
		return this.dataAccessObject;
	}

}
