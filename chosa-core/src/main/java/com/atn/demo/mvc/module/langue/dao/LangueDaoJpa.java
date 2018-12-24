package com.atn.demo.mvc.module.langue.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.langue.entity.Langue;


@Component
public class LangueDaoJpa extends BaseDaoJpa<Langue, Integer> implements LangueDao{

	public LangueDaoJpa() {
		super(Langue.class);
		
	}

}
