package com.atn.demo.mvc.module.templateMail.dao;


import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.templateMail.entity.TemplateMail;

@Component
public class TemplateMailDaoJpa extends BaseDaoJpa<TemplateMail, Long> implements TemplateMailDao {

	public TemplateMailDaoJpa() {
		super(TemplateMail.class);
	}

	

}
