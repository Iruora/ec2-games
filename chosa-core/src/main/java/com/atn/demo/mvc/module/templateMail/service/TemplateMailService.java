package com.atn.demo.mvc.module.templateMail.service;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.templateMail.entity.TemplateMail;
import com.atn.demo.mvc.module.templateMail.entity.TemplateMail.EMAIL_TEMPLATE;
import com.atn.demo.mvc.module.user.entity.User;

public interface TemplateMailService extends MyService<TemplateMail, Long> {

	
	
	public void sendHtmlMail(User user,EMAIL_TEMPLATE templateMail);
	public void sendExceptionMessage(String object,String message);
}
