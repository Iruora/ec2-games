package com.atn.demo.mvc.module.TrainingCenterClass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.TrainingCenterClass.service.TrainingCenterClassService;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.TrainingCenterMember.service.TrainingCenterMemberService;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.country.service.CountryService;
import com.atn.demo.mvc.module.user.entity.User;

@Controller
public class TrainingCenterClassController {
	@Autowired
	TrainingCenterMemberService trainingCenterMemberService;

	@Autowired
	TrainingCenterClassService trainingCenterClasseService;
	@Autowired
	TrainingCenterService trainingCenterService;

	@Autowired
	CountryService countryService;

	@RequestMapping(value = { "/trainingCenter/class/add" }, method = RequestMethod.GET)
	public ModelAndView saveClassPage(
			@RequestParam(name = "trainingCenterId", required = false) Long trainingCenterId) {
		ModelAndView model = new ModelAndView();
		List<TrainingCenterMember> listOfTeachers = trainingCenterMemberService
				.getTeacherValidByTrainingCenter();
		model.addObject("listOfTeacherValid", listOfTeachers);
		model.addObject("trainingCenterclass", new TrainingCenterClass());
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.setViewName("connected/class/addClass");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/class/add" }, method = RequestMethod.POST)
	public ModelAndView saveClass(
			@RequestParam(name = "className") String className,
			@RequestParam(name = "trainingCenterId", required = false) Long trainingCenterId

	) {

		ModelAndView model = new ModelAndView();
		TrainingCenterClass trainingCenterclass = new TrainingCenterClass();

		trainingCenterclass.setClassName(className);
		trainingCenterClasseService.addClass(trainingCenterclass);
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.setViewName("redirect:/trainingCenter/classes");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/classes" }, method = RequestMethod.GET)
	public ModelAndView listOfClassPage(

	) {
		ModelAndView model = new ModelAndView();
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		List<TrainingCenterClass> classes = trainingCenterClasseService
				.getClassByTrainingCenter(trainingcenter.getCenterId());

		model.setViewName("connected/class/listOfClass");
		model.addObject("listOfclasses", classes);

		model.addObject("connectedTrainingcenter", trainingcenter);

		return model;
	}

	@RequestMapping(value = { "/trainingCenter/class/remove" }, method = RequestMethod.GET)
	public ModelAndView removeClassPage(
			@RequestParam("trainingCenterClassId") Long trainingCenterClassId) {
		ModelAndView model = new ModelAndView();
		trainingCenterClasseService.deleteClass(trainingCenterClassId);
		model.setViewName("redirect:/class");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/class/update" }, method = RequestMethod.GET)
	public ModelAndView updateClassPage(
			@RequestParam("trainingCenterClassId") Long trainingCenterClassId) {
		ModelAndView model = new ModelAndView();

		TrainingCenterClass trainingCenterClass = trainingCenterClasseService
				.findById(trainingCenterClassId);
		List<TrainingCenterMember> listOfTeachers = trainingCenterMemberService
				.getTeacherValidByTrainingCenter();
		model.addObject("listOfTeacherValid", listOfTeachers);

		model.addObject("trainingCenterClassId", trainingCenterClassId);
		model.addObject("trainingCenterClass", trainingCenterClass);

		model.setViewName("connected/class/updateClass");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/class/update" }, method = RequestMethod.POST)
	public ModelAndView updateClass(
			@RequestParam(name = "trainingCenterClassId") Long trainingCenterClassId,
			@RequestParam(name = "className") String className,
			@RequestParam(name = "teacher") Long teacher) {

		ModelAndView model = new ModelAndView();
		User userTeacher = trainingCenterMemberService.findById(teacher)
				.getMember();

		trainingCenterClasseService.updateClass(trainingCenterClassId,
				className);
		model.setViewName("redirect:/trainingCenter/classes");
		return model;
	}

	@RequestMapping(value = { "/class/detail" }, method = RequestMethod.GET)
	public ModelAndView detailClassPage(
			@RequestParam("trainingCenterClassId") Long trainingCenterClassId) {
		ModelAndView model = new ModelAndView();

		TrainingCenterClass trainingCenterClass = trainingCenterClasseService
				.findById(trainingCenterClassId);

		model.addObject("trainingCenterClassId", trainingCenterClassId);
		model.addObject("trainingCenterClass", trainingCenterClass);

		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();

		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		model.addObject("trainingcenter", trainingcenter);

		model.setViewName("connected/class/detailClass");
		return model;
	}

}
