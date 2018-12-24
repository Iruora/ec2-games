package com.atn.demo.mvc.module.trainingCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.country.service.CountryService;
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.family.service.FamilyService;

@Controller
public class TrainingCenterController {

	@Autowired
	TrainingCenterService trainingCenterService;
	@Autowired
	CountryService countryService;
	@Autowired
	FamilyService familyService;

	@RequestMapping(value = { "/trainingCenter" }, method = RequestMethod.GET)
	public ModelAndView listOftrainingCenterPage(

	) {
		ModelAndView model = new ModelAndView();
		List<TrainingCenter> listOfTrainingCenter = trainingCenterService
				.getAllTrainingCenter();

		model.addObject("listOfTrainingCenter", listOfTrainingCenter);
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.setViewName("connected/trainingCenter/listOfTrainingCenter");

		return model;
	}

	@RequestMapping(value = { "/family/trainingCenter/Valid" }, method = RequestMethod.GET)
	public ModelAndView listOftrainingCenterValidPage(

	) {
		ModelAndView model = new ModelAndView();
		List<TrainingCenter> listOfTrainingCenterValid = trainingCenterService
				.getAllTrainingCentervalid();

		Family family = familyService.getConnectedFamily();
		model.addObject("listOfTrainingCenterValid", listOfTrainingCenterValid);
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.addObject("connectedfamily", family);
		model.setViewName("connected/trainingCenter/listOfTrainingCenterValid");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/save" }, method = RequestMethod.GET)
	public ModelAndView saveOrUpdateTrainingCenterPage() {
		ModelAndView model = new ModelAndView();
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		if (trainingcenter != null) {
			model.setViewName("redirect:/trainingCenter/update");
			return model;
		}
		model.setViewName("connected/trainingCenter/addTrainingCenter");
		model.addObject("trainingCenter", new TrainingCenter());

		List<Country> countryList = countryService.getAllCountry();

		model.addObject("countryList", countryList);

		model.addObject("connectedTrainingcenter", trainingcenter);

		return model;
	}

	@RequestMapping(value = { "/trainingCenter/save" }, method = RequestMethod.POST)
	public ModelAndView saveTrainingCenter(
			@ModelAttribute("trainingCenter") TrainingCenter trainingCenter) {

		ModelAndView model = new ModelAndView();

		trainingCenterService.addTrainingCenter(trainingCenter);

		model.setViewName("redirect:/trainingCenter/save");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/update" }, method = RequestMethod.GET)
	public ModelAndView saveTrainingCenter() {
		ModelAndView model = new ModelAndView();
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);

		model.setViewName("connected/trainingCenter/updateTrainingCenter");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/update" }, method = RequestMethod.POST)
	public ModelAndView updateTrainingCenterPage(
			@ModelAttribute("trainingcenter") TrainingCenter trainingcenter) {
		ModelAndView model = new ModelAndView();
		trainingCenterService.updateTrainingCenter(trainingcenter);
		model.setViewName("redirect:/trainingCenter/update");
		return model;
	}

}
