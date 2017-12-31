package com.atn.demo.mvc.module.country.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.country.entity.Country;

@Component
public class CountryDaoJpa extends BaseDaoJpa<Country, Long> implements CountryDao {
	public CountryDaoJpa() {
		super(Country.class);
	}
}