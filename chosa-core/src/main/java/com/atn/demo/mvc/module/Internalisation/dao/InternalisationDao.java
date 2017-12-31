package com.atn.demo.mvc.module.Internalisation.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.atn.commons.persistence.BaseDao;
import com.atn.demo.mvc.module.Internalisation.entity.Internalisation;

public interface InternalisationDao extends BaseDao<Internalisation, Long> {

	
	public String getMessage(String messageKey, String language) throws NoResultException;
	public List<Internalisation> findMessagesByCriteria(String value);
	public List<Internalisation> getMessages(String messageKey);
}
