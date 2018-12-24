package com.atn.demo.mvc.module.country.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.BaseDao.DELETION_STATUS;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.country.dao.CountryDao;
import com.atn.demo.mvc.module.country.entity.Country;

@Component
public class CountryServiceImpl extends MyAbstractService<Country, Long> implements CountryService {	
	
	public CountryServiceImpl(CountryDao dataAccessObject) {
		super(dataAccessObject);
	}

	@Override
	public CountryDao getDataAccessObject() {
		return (CountryDao) dataAccessObject;
	}
	
	@Override
	public List<Country> getAllCountry() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Country> countries = findListByCriteria(map, null, 0, DELETION_STATUS.ACTIVE);
		return countries;
	}
}