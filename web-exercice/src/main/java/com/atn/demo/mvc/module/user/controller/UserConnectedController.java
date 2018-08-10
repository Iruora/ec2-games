package com.atn.demo.mvc.module.user.controller;

import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.service.UserService;
import com.atn.demo.mvc.module.user.dto.ConnectedHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class UserConnectedController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = {  "/connected/home" }, method = RequestMethod.GET)
	public ModelAndView hello() {
		ConnectedHome connectedHome = new ConnectedHome();

		User user = userService.getConnectedUser();
		connectedHome.setUser(user);
		connectedHome.setTitle("Spring Security Hello Normal Conencted World");
		ModelAndView model = new ModelAndView();
		model.addObject("connectedHome", connectedHome);
		model.setViewName("connected/home");
		return model;
	}
}
