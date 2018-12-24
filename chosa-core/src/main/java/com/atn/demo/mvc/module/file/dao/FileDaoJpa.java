package com.atn.demo.mvc.module.file.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.file.entity.File;

@Component
public class FileDaoJpa extends BaseDaoJpa<File, Long> implements FileDao{

	public FileDaoJpa() {
		super(File.class);
		
	}

}
