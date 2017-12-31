package com.atn.demo.mvc.module.exercice.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.exercice.entity.Exercice;

@Component
public class ExerciceDaoJpa extends BaseDaoJpa<Exercice, Long> implements ExerciceDao{

	public ExerciceDaoJpa() {
		super(Exercice.class);
		
	}

}
