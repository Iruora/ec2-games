package com.atn.demo.mvc.module.langue.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.langue.dao.LangueDao;
import com.atn.demo.mvc.module.langue.entity.Langue;

@Component
public class LangueServiceImpl extends MyAbstractService<Langue, Integer>
		implements LangueService {

	public LangueServiceImpl(LangueDao dataAccessObject) {
		super(dataAccessObject);

	}

	@Override
	public BaseDao<Langue, Integer> getDataAccessObject() {
		return this.dataAccessObject;
	}

	@Override
	public Langue getLangueByLibelle(String langueLibelle) { 
		 
		Map<String, Object> map = new HashMap<>();
		map.put("=langueLibelle", langueLibelle);
		
		Langue langue = findListByCriteria(map, 1, 0,
				BaseDao.DELETION_STATUS.ACTIVE).get(0);
		
		return langue;
	}

}
