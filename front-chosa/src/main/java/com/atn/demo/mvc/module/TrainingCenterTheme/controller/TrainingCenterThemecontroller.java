package com.atn.demo.mvc.module.TrainingCenterTheme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity.Subject;
import com.atn.demo.mvc.module.TrainingCenterActivity.service.TrainingCenterActivityService;
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;
import com.atn.demo.mvc.module.TrainingCenterProgram.service.TrainingCenterProgramService;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;
import com.atn.demo.mvc.module.TrainingCenterTheme.service.TrainingCenterThemeService;
import com.atn.demo.mvc.module.TrainingCenterThemeActivity.entity.TrainingCenterThemeActivity;
import com.atn.demo.mvc.module.TrainingCenterThemeActivity.service.TrainingCenterThemeActivityService;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.file.service.FileService;

@Controller
public class TrainingCenterThemecontroller {

	@Autowired
	TrainingCenterProgramService trainingCenterProgramService;

	@Autowired
	TrainingCenterThemeService trainingCenterThemeService;
	@Autowired
	TrainingCenterThemeActivityService trainingCenterActivityThemeService;

	@Autowired
	TrainingCenterActivityService trainingCenterActivityService;

	@Autowired
	TrainingCenterService trainingCenterService;
	@Autowired
	FileService fileService;
	@Autowired
	TrainingCenterProgramService trainingcenterProgramService;

	@RequestMapping(value = { "/trainingCenter/program/theme/add" }, method = RequestMethod.GET)
	public ModelAndView savethemePage(
			@RequestParam("trainingcenterProgramID") Long trainingcenterProgramID,
			@RequestParam(name = "trainingcenterThemeID", required = false) Long trainingcenterThemeID) {
		ModelAndView model = new ModelAndView();

		if (trainingcenterThemeID == null) {
			model.addObject("trainingCentertheme", new TrainingCenterTheme());
			model.addObject("trainingcenterProgramID", trainingcenterProgramID);
			model.setViewName("connected/theme/themeCreate");
		} else {
			TrainingCenterTheme trainingCenterTheme = trainingCenterThemeService
					.findById(trainingcenterThemeID);
			model.addObject("trainingCentertheme", trainingCenterTheme);
			model.addObject("trainingcenterProgramID", trainingcenterProgramID);
			model.setViewName("connected/theme/themeUpdate");
		}
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/theme/add" }, method = RequestMethod.POST)
	public ModelAndView savetheme(
			@ModelAttribute("trainingCentertheme") TrainingCenterTheme trainingCentertheme,
			@RequestParam("trainingcenterProgramID") Long trainingcenterProgramID) {

		ModelAndView model = new ModelAndView();

		trainingCenterThemeService.createTheme(trainingCentertheme,
				trainingcenterProgramID);
		model.setViewName("redirect:/trainingCenter/program/themes?trainingcenterProgramID="
				+ trainingcenterProgramID);
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/themes" }, method = RequestMethod.GET)
	public ModelAndView listOfthemePage(
			@RequestParam(name = "trainingcenterProgramID", required = false) Long trainingcenterProgramID) {
		ModelAndView model = new ModelAndView();

		TrainingCenterProgram trainingCenterProgram = trainingCenterProgramService
				.findById(trainingcenterProgramID);
		List<TrainingCenterTheme> listOftrainingCenterTheme = trainingCenterThemeService
				.getTrainingcenterThemeByProgram(trainingCenterProgram);

		model.addObject("listOftrainingCenterTheme", listOftrainingCenterTheme);
		model.addObject("trainingCenterProgram", trainingCenterProgram);

		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.setViewName("connected/theme/listOfTheme");

		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/theme/activities","theme/activities" }, method = RequestMethod.GET)
	public ModelAndView listOfactivitiesByThemPage(
			@RequestParam(name = "trainingcenterThemeID", required = false) Long trainingcenterThemeID,
			@RequestParam(name = "role", required = false) String role,
			@RequestParam(name="programId", required = false) Long programId
			) {
		ModelAndView model = new ModelAndView();

		TrainingCenterTheme trainingCenterTheme = trainingCenterThemeService
				.findById(trainingcenterThemeID);
		if(programId!=null){
		TrainingCenterProgram program=trainingcenterProgramService.findById(programId);
		model.addObject("program", program);}
		List<TrainingCenterThemeActivity> listOftrainingCenterActivitiesByTheme = trainingCenterActivityThemeService
				.getTrainingCenterActivityByTheme(trainingCenterTheme);
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("listOftrainingCenterActivitiesByTheme",
				listOftrainingCenterActivitiesByTheme);
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.addObject("trainingCenterTheme", trainingCenterTheme);
		
		if(role.equals("director")){
			model.setViewName("connected/theme/listOfActivitiesByTheme");
		}else if(role.equals("teacher")){
			model.setViewName("connected/teacher/listOfActivitiesBythemeTeacher");
		}
		
		
	

		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/theme/activitiesNotAttach" }, method = RequestMethod.GET)
	public ModelAndView listOfactivitiesNotAttachToThemePage(
			@RequestParam(name = "trainingcenterThemeID", required = false) Long trainingcenterThemeID) {
		ModelAndView model = new ModelAndView();

		TrainingCenterTheme trainingCenterTheme = trainingCenterThemeService
				.findById(trainingcenterThemeID);

		List<TrainingCenterThemeActivity> listOfactivitiesNotAttachToTheme = trainingCenterActivityThemeService
				.getTrainingCenterActivityNotAttachToTheme(trainingCenterTheme);

		model.addObject("listOfactivitiesNotAttachToTheme",
				listOfactivitiesNotAttachToTheme);
		model.addObject("trainingCenterTheme", trainingCenterTheme);
		model.setViewName("connected/theme/listOfActivtiesNotAttach");
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/theme/attachActivity" }, method = RequestMethod.GET)
	public ModelAndView attachActivityToTheme(
			@RequestParam("trainingcenterThemeID") Long trainingcenterThemeID,
			@RequestParam("trainingcenterActivityID") Long trainingcenterActivityID) {
		ModelAndView model = new ModelAndView();
		trainingCenterActivityThemeService.attachActivityToTheme(
				trainingcenterThemeID, trainingcenterActivityID);
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.setViewName("redirect:/trainingCenter/program/theme/activities?trainingcenterThemeID="
				+ trainingcenterThemeID);
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/theme/activity/add" }, method = RequestMethod.GET)
	public ModelAndView saveThemeActivityPage(
			@RequestParam(name = "trainingcenterActivityID", required = false) Long trainingcenterActivityID,
			@RequestParam("trainingcenterThemeID") Long trainingcenterThemeID) {
		ModelAndView model = new ModelAndView();
		TrainingCenterTheme trainingCenterTheme = trainingCenterThemeService
				.findById(trainingcenterThemeID);

		if (trainingcenterActivityID == null) {

			model.addObject("trainingCenterActivity",
					new TrainingCenterActivity());
			model.addObject("enum", Subject.values());
			model.addObject("trainingCenterTheme", trainingCenterTheme);
			model.setViewName("connected/activity/activityThemeCreate");
		} else {
			TrainingCenterActivity trainingCenterActivity = trainingCenterActivityService
					.findById(trainingcenterActivityID);
			model.addObject("trainingCenterActivity", trainingCenterActivity);
			model.addObject("trainingCenterTheme", trainingCenterTheme);
			model.setViewName("connected/activity/activityThemeUpdate");
		}
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);

		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/theme/activity/details", "/activity/details" }, method = RequestMethod.GET)
	public ModelAndView themeActivitydetailsPage(
			@RequestParam(name = "trainingcenterActivityID", required = false) Long trainingcenterActivityID,
			@RequestParam(name ="trainingcenterThemeID", required = false) Long trainingcenterThemeID) {
		ModelAndView model = new ModelAndView();
		if (trainingcenterThemeID != null) {
			TrainingCenterTheme trainingCenterTheme = trainingCenterThemeService
					.findById(trainingcenterThemeID);
			model.addObject("trainingCenterTheme", trainingCenterTheme);
		}

		TrainingCenterActivity trainingCenterActivity = trainingCenterActivityService
				.findById(trainingcenterActivityID);
		model.addObject("trainingCenterActivity", trainingCenterActivity);
		if (trainingCenterActivity.getDocument() != null) {
		model.addObject("document", trainingCenterActivity.getDocument());
		}
		if (trainingCenterActivity.getUrlVideo() != null) {
			model.addObject("lienYoutube", trainingCenterActivity.getUrlVideo());
			}
		model.setViewName("connected/activity/detailsActivity");

		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		

		return model;
	}

	@RequestMapping(value = { "/theme/activity/addUpdate" }, method = RequestMethod.POST)
	@Transactional
	public ModelAndView saveThemeActivity(
			@ModelAttribute("trainingCenterActivity") TrainingCenterActivity trainingCenterActivity,
			@RequestParam("trainingcenterThemeID") Long trainingcenterThemeID,
			@RequestParam(name = "role", required = false) String role,
			@RequestParam(name = "document_t", required = false) MultipartFile document) {

		ModelAndView model = new ModelAndView();
		if (trainingCenterActivity.getId() == null) {

			TrainingCenterActivity trainingCenteractivity = trainingCenterActivityService
					.createTrainingCenterActivity(trainingCenterActivity);
			File doc = fileService.saveFile(document,
					trainingCenteractivity.getId(), null);
			trainingCenteractivity.setDocument(doc);
			trainingCenterActivityService.save(trainingCenteractivity);
			trainingCenterActivityThemeService.attachActivityToTheme(
					trainingcenterThemeID, trainingCenteractivity.getId());
			model.setViewName("redirect:/trainingCenter/program/theme/activities?trainingcenterThemeID="
					+ trainingcenterThemeID+"&&role=director");
		} else {

			trainingCenterActivityService
					.createTrainingCenterActivity(trainingCenterActivity);
			model.setViewName("redirect:/trainingCenter/program/theme/activities?trainingcenterThemeID="
					+ trainingcenterThemeID+"&&role=director");
		}
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/program/theme/activityThemeDelete" }, method = RequestMethod.GET)
	public ModelAndView saveActivityPage(
			@RequestParam(name = "trainingcenterActivityThemeID",required=false) Long trainingcenterActivityThemeID,
			@RequestParam("trainingcenterThemeID") Long trainingcenterThemeID) {
		ModelAndView model = new ModelAndView();

		trainingCenterActivityThemeService
				.deletTrainingcenterThemeActivity(trainingcenterActivityThemeID);

		model.setViewName("redirect:/trainingCenter/program/theme/activities?trainingcenterThemeID="
				+ trainingcenterThemeID+"&&role=director");

		return model;
	}
}
