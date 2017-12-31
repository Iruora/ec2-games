package com.atn.demo.mvc.module.familyMember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.TrainingCenterMember.service.TrainingCenterMemberService;
import com.atn.demo.mvc.module.familyMember.service.FamilyMemberService;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.service.UserService;

@Controller
public class FamilyMemberController {
	@Autowired
	FamilyMemberService familyMemberService;
	@Autowired
	UserService userService;
	@Autowired
	TrainingCenterMemberService trainingMemberCenterService;
	@Autowired
	TrainingCenterService trainingCenterService;
	
	@RequestMapping(value = { "/family/subscribeMember" }, method = RequestMethod.GET)
	public ModelAndView subscribeStudentPage(
			@RequestParam("trainingcenterId") Long trainingcenterId) {
		ModelAndView model = new ModelAndView();
		User user=userService.getConnectedUser();
		TrainingCenter trainingCenter=trainingCenterService.findById(trainingcenterId);
		trainingMemberCenterService.createMember(user.getId(),"STUDENT",trainingCenter);
		model.setViewName("redirect:/trainingCenter/Valid");
		return model;
	}
	
	

}
