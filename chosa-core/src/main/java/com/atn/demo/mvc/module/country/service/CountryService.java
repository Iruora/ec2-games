package com.atn.demo.mvc.module.country.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.country.entity.Country;

public interface CountryService extends MyService<Country, Long> {

	List<Country> getAllCountry();
}