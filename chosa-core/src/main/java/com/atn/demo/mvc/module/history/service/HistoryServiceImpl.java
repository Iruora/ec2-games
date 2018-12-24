package com.atn.demo.mvc.module.history.service;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.history.dao.HistoryDao;
import com.atn.demo.mvc.module.history.entity.History;

@Component
public class HistoryServiceImpl extends MyAbstractService<History, Long> implements HistoryService{

	public HistoryServiceImpl(HistoryDao dataAccessObject) {
		super(dataAccessObject);
		
	}

	@Override
	public BaseDao<History, Long> getDataAccessObject() {
		
		return this.dataAccessObject;
	}

}
