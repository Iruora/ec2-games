package com.atn.demo.mvc.module.Internalisation.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;


import com.atn.commons.service.MyAbstractService;

import com.atn.demo.mvc.module.Internalisation.dao.InternalisationDao;
import com.atn.demo.mvc.module.Internalisation.entity.Internalisation;
import com.atn.demo.mvc.module.Internalisation.entity.Internalisation.MESSAGEKEY;
import com.atn.demo.mvc.module.langue.entity.Langue;

@Component
public class InternalisationServiceImpl extends
		MyAbstractService<Internalisation, Long> implements
		InternalisationService {

	public InternalisationServiceImpl(InternalisationDao internalisationDao) {
		super(internalisationDao);
		
	}

	@Override
	public InternalisationDao getDataAccessObject() {
		return (InternalisationDao) this.dataAccessObject;
	}
	
	
	
	@Override
	public String getMessage(String messageKey) {
		return getMessage(messageKey, LocaleContextHolder.getLocale().getLanguage());
	}

	@Override
	public String getMessage(String messageKey, String language) {
		String result = null;
		try {
			result = getDataAccessObject().getMessage(messageKey, language);
			
			 
			String encrypted=result;
			encrypted=encrypted.replace("Ã ", "&agrave;");
			encrypted=encrypted.replace("Ã¢", "&acirc;");
			encrypted=encrypted.replace("Ã§", "&ccedil;");
			encrypted=encrypted.replace("Ã¨", "&egrave;");
			encrypted=encrypted.replace("Ã©", "&eacute;");
			encrypted=encrypted.replace("Ãª", "&ecirc;");
			encrypted=encrypted.replace("Å“", "&oelig;");
			encrypted=encrypted.replace("Ã¹", "&ugrave;");
			encrypted=encrypted.replace("Ã»", "&ucirc;");
			result = encrypted;
		} catch (NoResultException e) {
			result = "(" + messageKey + "," + LocaleContextHolder.getLocale().getLanguage() + ")";
			
		}
		return result;
	}

	@Override
	public List<Internalisation> findMessagesByCriteria(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMessage(String text, String messageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMessageExist(MESSAGEKEY messageKey, Langue langue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Internalisation> getMessages(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
