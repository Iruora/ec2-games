package com.atn.demo.mvc.module.category.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.category.entity.Category;

@Component
public class CategryDaoJpa extends BaseDaoJpa<Category, Long> implements CategoryDao{

	public CategryDaoJpa() {
		super(Category.class);
		
	}

}
