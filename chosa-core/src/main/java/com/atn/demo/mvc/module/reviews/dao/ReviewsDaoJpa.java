package com.atn.demo.mvc.module.reviews.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.reviews.entity.Reviews;

@Component
public class ReviewsDaoJpa extends BaseDaoJpa<Reviews, Long> implements ReviewsDao{

	public ReviewsDaoJpa() {
		super(Reviews.class);
		
	}

}
