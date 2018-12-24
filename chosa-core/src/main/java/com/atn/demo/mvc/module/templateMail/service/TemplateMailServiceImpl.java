package com.atn.demo.mvc.module.templateMail.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.atn.commons.email.EmailManager;
import com.atn.commons.email.EmailSenderFacade;
import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.templateMail.dao.TemplateMailDao;
import com.atn.demo.mvc.module.templateMail.entity.TemplateMail;
import com.atn.demo.mvc.module.templateMail.entity.TemplateMail.EMAIL_TEMPLATE;
import com.atn.demo.mvc.module.user.entity.User;


@Component
public class TemplateMailServiceImpl extends MyAbstractService<TemplateMail, Long> implements TemplateMailService {
	



	@Autowired
	private EmailSenderFacade emailSenderFacade;
	
	
	@Value(value = "${app.url.value}")
	private String chosaUrl;

	public TemplateMailServiceImpl(TemplateMailDao dataAccessObject) {
		super(dataAccessObject);

	}

	@Override
	public TemplateMailDao getDataAccessObject() {

		return (TemplateMailDao) dataAccessObject;
	}

	

	private TemplateMail getTemplateMail(EMAIL_TEMPLATE emailName) {
		Map<String, Object> map = new HashMap<>();
			
		map.put("=emailKey", emailName);
		try {
			TemplateMail templateMail = findListByCriteria(map, 1, 0, BaseDao.DELETION_STATUS.ACTIVE).get(0);
			return templateMail;
		} catch (IndexOutOfBoundsException e) {
			map.put("=language.langueLibelle", "fr");
			TemplateMail templateMail =findListByCriteria(map, 1, 0, BaseDao.DELETION_STATUS.ACTIVE).get(0);
			return templateMail;
		}
	}


	@Override
	public void sendHtmlMail(User user, EMAIL_TEMPLATE emailName
			) {

		TemplateMail templateMail = getTemplateMail(emailName);
		
		String mailObjet = templateMail.getObject();
		String message = "";
	
		String	destinataire = user.getUserEmail();
		
		/** if type email is Email Confirmation **/
		if (templateMail.getEmailKey().equals(EMAIL_TEMPLATE.EmailConfirmation)) {
			String token=user.getToken();
			message = getMailFromUrl("/guest/mailregister?email="+destinataire+"&token="+token);
			
			
			
		}

		

		/** if type email is forget password **/
		if (templateMail.getEmailKey().equals(EMAIL_TEMPLATE.MotPassPerdu)) {
			message = getMailFromUrl("/guest/mailforget?email="+destinataire);
		
			try {
				message = message.replaceAll("#link#", getChosaUrl());
				message = message.replaceAll("#mailUser#", destinataire + "&token=" + user.getToken());

			} catch (Exception e) {
				e.printStackTrace();
			}

			

		}
		emailSenderFacade.sendHtmlEmail(destinataire, null, null, mailObjet, message, null, new EmailManager() {
			@Override
			public void onSucessDo() {
				System.err.println("success sendMail");
			}
			@Override
			public void onFailureDo(Exception e) {
				System.err.println("failure sendMail");
			}
		});

	}

//	private String buildHtmlMessage(String content, String title) {
//		String htmlEmail = "";
//		try {
//			File file = getFileFromClassPath("templateMail/chosa.html");
//			String html = FileManager.readFile(file);
//			htmlEmail = html.replace("#emailContent#", content);
//			htmlEmail = htmlEmail.replace("#emailSubject#", title);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return htmlEmail;
//	}

//	private static File getFileFromClassPath(String path) {
//		try {
//			ClassLoader classLoader = FileManager.class.getClassLoader();
//			return new File(classLoader.getResource(path).toURI());
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	public String getChosaUrl() {
		return chosaUrl;
	}

	
	
//	private String getHtmlEmail(String path) {
//		String htmlEmail=null; 
//		try {
//			File file = getFileFromClassPath(path);
//			htmlEmail = FileManager.readFile(file);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return htmlEmail;
//	}
	
	public String getMailFromUrl(String path)
	{
		URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line="",message="";

	    try {
	        url = new URL(chosaUrl+path);
	        is = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(is));

	        while ((line = br.readLine()) != null) {
	            message+=line;
	        }
	        return message;
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {
	        try {
	            if (is != null) is.close();
	        } catch (IOException ioe) {
	            // nothing to see here
	        }
	    }
	    return message;
	}
	@Override
	public void sendExceptionMessage(String object, String message) {
		// TODO Auto-generated method stub
		
	}


}
