package com.atn.demo.mvc.module.category.service;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.category.dao.CategoryDao;
import com.atn.demo.mvc.module.category.entity.Category;

@Component
public class CategoryServiceImpl extends MyAbstractService<Category, Long>implements CategoryService{

	public CategoryServiceImpl(CategoryDao dataAccessObject) {
		super(dataAccessObject);
		
	}

	@Override
	public BaseDao<Category, Long> getDataAccessObject() {
		
		return this.dataAccessObject;
	}

}
