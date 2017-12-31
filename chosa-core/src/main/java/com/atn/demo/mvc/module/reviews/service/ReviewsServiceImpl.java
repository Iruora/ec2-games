package com.atn.demo.mvc.module.reviews.service;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.reviews.dao.ReviewsDao;
import com.atn.demo.mvc.module.reviews.entity.Reviews;

@Component
public class ReviewsServiceImpl extends MyAbstractService<Reviews, Long> implements ReviewsService{

	public ReviewsServiceImpl(ReviewsDao dataAccessObject) {
		super(dataAccessObject);
		
	}

	@Override
	public BaseDao<Reviews, Long> getDataAccessObject() {
		
		return this.dataAccessObject;
	}

}
