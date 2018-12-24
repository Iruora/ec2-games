package com.atn.demo.mvc.module.Internalisation.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.Internalisation.entity.Internalisation;
import com.atn.demo.mvc.module.Internalisation.entity.Internalisation.MESSAGEKEY;
import com.atn.demo.mvc.module.langue.entity.Langue;

public interface InternalisationService extends MyService<Internalisation, Long>{

	
	public String getMessage(String messageKey);
	public String getMessage(String messageKey,String language);
	public List<Internalisation> findMessagesByCriteria(String value);
	public void updateMessage(String text, String messageId);
	public boolean isMessageExist(MESSAGEKEY messageKey, Langue langue);
	public List<Internalisation> getMessages(String code);
}
