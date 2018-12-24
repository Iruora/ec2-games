package com.atn.demo.mvc.module.trainingCenterProgram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.TrainingCenterClass.service.TrainingCenterClassService;
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;
import com.atn.demo.mvc.module.TrainingCenterProgram.service.TrainingCenterProgramService;

@Controller
public class TrainingCenterProgramController {

	@Autowired
	TrainingCenterProgramService trainingCenterProgramService;

	@Autowired
	TrainingCenterService trainingCenterService;
	@Autowired
	TrainingCenterClassService trainingCenterClassService;

	@RequestMapping(value = { "/trainingCenter/program/add" }, method = RequestMethod.GET)
	public ModelAndView saveProgramPage(
			@RequestParam(name = "trainingcenterProgramID", required = false) Long trainingcenterProgramID) {
		ModelAndView model = new ModelAndView();

		if (trainingcenterProgramID != null) {
			TrainingCenterProgram trainingCenterProgram = trainingCenterProgramService
					.findById(trainingcenterProgramID);
			model.addObject("trainingCenterprogram", trainingCenterProgram);
			model.setViewName("connected/program/programUpdate");
		} else {
			model.addObject("trainingCenterprogram",
					new TrainingCenterProgram());
			model.setViewName("connected/program/programCreate");

		}
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/addUpdate" }, method = RequestMethod.POST)
	public ModelAndView saveProgram(
			@ModelAttribute("trainingCenterprogram") TrainingCenterProgram trainingCenterprogram) {

		ModelAndView model = new ModelAndView();
		trainingCenterProgramService.createProgram(trainingCenterprogram);
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.setViewName("redirect:/trainingCenter/programmes");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/attahToClass" }, method = RequestMethod.GET)
	public ModelAndView attachProgramtoThemePage(
			@RequestParam(name = "trainingcenterProgramID") Long trainingcenterProgramID,
			@RequestParam(name = "trainingcenterClassID") Long trainingcenterClassID) {
		ModelAndView model = new ModelAndView();

		trainingCenterProgramService.attachProgramToClass(
				trainingcenterProgramID, trainingcenterClassID);

		model.setViewName("redirect:/trainingCenter/classes");

		return model;
	}

	@RequestMapping(value = { "/trainingCenter/programmes" }, method = RequestMethod.GET)
	public ModelAndView listOfProgramPage(
			@RequestParam(name = "trainingCenterClassId", required = false) Long trainingCenterClassId,
			@RequestParam(name = "className", required = false) String className) {
		ModelAndView model = new ModelAndView();

		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();

		model.addObject("connectedTrainingcenter", trainingcenter);
		if (trainingCenterClassId != null) {
			List<TrainingCenterProgram> listOftrainingCenterProgramNotAttach = trainingCenterProgramService
					.getProgrammesNotAttachToClass(trainingCenterClassId);
			model.addObject("listOftrainingCenterProgramNotAttach",
					listOftrainingCenterProgramNotAttach);
			model.addObject("connectedTrainingcenterClass",
					trainingCenterClassService.findById(trainingCenterClassId));
			model.setViewName("connected/class/listOfProgramClass");
		} else {
			if(className != null){
				List<TrainingCenterProgram> listOftrainingCenterProgramByName = trainingCenterProgramService
						.getProgrammesByName(className);
				model.addObject("listOftrainingCenterProgramByName",
						listOftrainingCenterProgramByName);
				
			} else {
				List<TrainingCenterProgram> listOftrainingCenterProgramByName = trainingCenterProgramService
						.getProgrammesByTrainingCenter(trainingcenter);
				model.addObject("listOftrainingCenterProgramByName",
						listOftrainingCenterProgramByName);
				
			}
			
			model.addObject("className",className);
			model.setViewName("connected/program/listOfProgram");
		}
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/programSearch" }, method = RequestMethod.GET)
	public ModelAndView searchProgram(
			@RequestParam(name = "className", required = false) String className) {

		ModelAndView model = new ModelAndView();
		List<TrainingCenterProgram> listOftrainingCenterProgramByName = trainingCenterProgramService
				.getProgrammesByName(className);
	
		model.addObject("listOftrainingCenterProgramByName", listOftrainingCenterProgramByName);
		model.setViewName("redirect:/trainingCenter/programmes?className="+className);
		return model;
	}

}
