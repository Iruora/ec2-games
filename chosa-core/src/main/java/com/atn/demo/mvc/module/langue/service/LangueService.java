package com.atn.demo.mvc.module.langue.service;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.langue.entity.Langue;

public interface LangueService extends MyService<Langue, Integer>{
	
	public Langue getLangueByLibelle(String langueLibelle);

}
