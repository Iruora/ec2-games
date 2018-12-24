package com.atn.demo.mvc.module.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping(value = { "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("notconnected/index");
		return model;
	}
	@RequestMapping(value = {  "/notconnected/login**" }, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("notconnected/login");
		return model;
	}
	@RequestMapping(value = {  "/notconnected/logout**" }, method = RequestMethod.GET)
	public ModelAndView logoutPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("notconnected/login");
		return model;
	}
	@RequestMapping(value = {  "/notconnected/403**" }, method = RequestMethod.GET)
	public ModelAndView err403() {
		ModelAndView model = new ModelAndView();
		model.setViewName("notconnected/403");
		return model;
	}
}
