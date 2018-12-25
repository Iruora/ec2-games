package com.atn.demo.mvc.module.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAdminController {
	@RequestMapping(value = {  "/admin/hello**" }, method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security ADMIN Hello World");
		model.addObject("message", "This is welcome page for ADMIN!");
		model.setViewName("admin/hello");
		return model;
	}
}
