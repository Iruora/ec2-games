package com.atn.demo.mvc.module.history.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.history.entity.History;

@Component
public class HistoryDaoJpa extends BaseDaoJpa<History, Long> implements HistoryDao{

	public HistoryDaoJpa() {
		super(History.class);
		
	}

}
