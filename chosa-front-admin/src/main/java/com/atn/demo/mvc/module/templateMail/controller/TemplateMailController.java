package com.atn.demo.mvc.module.templateMail.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atn.commons.persistence.BaseDao;
import com.atn.demo.mvc.module.templateMail.entity.TemplateMail;
import com.atn.demo.mvc.module.templateMail.entity.TemplateMail.EMAIL_TEMPLATE;
import com.atn.demo.mvc.module.templateMail.service.TemplateMailService;


@Controller
public class TemplateMailController{

	
	@Autowired
	private TemplateMailService templateMailService;

	@Value(value = "${app.url.value}")
	private String chosaUrl;

	@RequestMapping(value = { "/admin/templatemail/", "/admin/templatemail" }, method = RequestMethod.GET)
	public ModelAndView showManageTemplatePage(@RequestParam(name = "page", required = false) Integer page) {
		ModelAndView model = new ModelAndView();
		List<TemplateMail> listOfTemplates = null;
		Map<String, Object> modelMap = new HashMap<>();
		Map<String, Object> map = new HashMap<>();
	
		if ((page == null) || (page == 1)) {
			map.put("creationDate#D", "");
			listOfTemplates = templateMailService.findListByCriteria(map, 3, 0, BaseDao.DELETION_STATUS.ACTIVE);
			modelMap.put("page", 1);
		} else {
			map.put("creationDate#D", "");
			listOfTemplates = templateMailService.findListByCriteria(map, 3, ((page - 1) * 3) + 1,
					BaseDao.DELETION_STATUS.ACTIVE);
			modelMap.put("page", page);
		}
		modelMap.put("listAllTemplate", listOfTemplates);
		listOfTemplates = templateMailService.findListByCriteria(map, null, 0, BaseDao.DELETION_STATUS.ACTIVE);

		int maxNumberPage = listOfTemplates.size() % 3 != 0 ? (listOfTemplates.size()) / 3 + 1
				: (listOfTemplates.size());
		modelMap.put("maxNumberPage", maxNumberPage);
		modelMap.put("templateMail", new TemplateMail());
		modelMap.put("emailKeys", new ArrayList<>(Arrays.asList(EMAIL_TEMPLATE.values())));

		model.addAllObjects(modelMap);
		model.setViewName("admin/manage_templates");
		return model;
	}

	@Transactional
	@RequestMapping(value = { "/admin/templatemail/save" }, method = RequestMethod.POST)
	public ModelAndView saveOrUpdateTemplate(@ModelAttribute("templateMail") TemplateMail templateMail) {
		ModelAndView model = new ModelAndView();
		templateMailService.save(templateMail);
		model.setViewName("redirect:../../admin/templatemail/");
		return model;
	}

	@RequestMapping(value = { "/admin/templatemail/update**" }, method = RequestMethod.POST)
	@Transactional
	public ModelAndView updateTemplate(@RequestParam("object") String object, @RequestParam("body") String body,
			 @RequestParam("templateId") String templateId) {
		ModelAndView model = new ModelAndView();
		TemplateMail templateMail = templateMailService.findById(new Long(templateId));
		if (templateMail != null) {
			templateMail.setObject(object);
			templateMail.setBody(body);
			templateMailService.save(templateMail);
		}
		model.setViewName("redirect:/admin/templatemail/");
		return model;
	}

	@RequestMapping(value = { "/admin/templatemail/delete**" }, method = RequestMethod.GET)
	@Transactional
	public ModelAndView deleteTemplate(@RequestParam("templateId") String templateId) {
		ModelAndView model = new ModelAndView();
		TemplateMail template = templateMailService.findById(new Long(templateId));
		if (template != null) {
			templateMailService.delete(template);
		}
		model.setViewName("redirect:/admin/templatemail/");
		return model;
	}

	@RequestMapping(value = { "/guest/mailregister" }, method = RequestMethod.GET)
	public ModelAndView showMail(@RequestParam("email") String email,
			@RequestParam("token") String token) {
		ModelAndView model = new ModelAndView();
		model.addObject("link",chosaUrl+"/validateAccount?email="+email+"&token="+token);
		model.setViewName("emails/EmailConfirmation");
		return model;
	}
	
	@RequestMapping(value = { "/guest/mailforget" }, method = RequestMethod.GET)
	public ModelAndView forgetPasswordEmail(@RequestParam("email") String email) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("link",chosaUrl);
		model.addObject("email",email);
		
		model.setViewName("emails/MotPassPerdu");
		return model;
	}
	

}
