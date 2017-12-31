package com.atn.demo.mvc.module.TrainingCenterActivity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.family.service.FamilyService;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.file.service.FileService;

@Controller
public class TrainingCenterActivityController {

	@Autowired
	TrainingCenterActivityService trainingCenterActivityService;
	@Autowired
	TrainingCenterService trainingCenterService;
	@Autowired
	TrainingCenterThemeService trainingCenterThemeService;
	@Autowired
	FileService fileService;
	@Autowired
	FamilyService familyService;
	@Autowired
	TrainingCenterProgramService trainingcenterProgramService;

	@RequestMapping(value = { "/trainingCenter/activity/add" }, method = RequestMethod.GET)
	public ModelAndView saveActivityPage(
			@RequestParam(name = "trainingcenterActivityID", required = false) Long trainingcenterActivityID) {
		ModelAndView model = new ModelAndView();

		if (trainingcenterActivityID == null) {

			model.addObject("trainingCenterActivity",
					new TrainingCenterActivity());
			model.addObject("enum", Subject.values());
			model.setViewName("connected/activity/activityCreate");
		} else {
			TrainingCenterActivity trainingCenterActivity = trainingCenterActivityService
					.findById(trainingcenterActivityID);
			model.addObject("trainingCenterActivity", trainingCenterActivity);
			model.setViewName("connected/activity/activtiyUpdate");
		}
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/activity/addUpdate" }, method = RequestMethod.POST)
	@Transactional
	public ModelAndView saveActivity(
			@ModelAttribute("trainingCenterActivity") TrainingCenterActivity trainingCenterActivity,
			@RequestParam(name = "document_t", required = false) MultipartFile document,
			HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		TrainingCenterActivity activity = trainingCenterActivityService
				.createTrainingCenterActivity(trainingCenterActivity);

		File doc = fileService.saveFile(document, activity.getId(), null);
		activity.setDocument(doc);
		trainingCenterActivityService.save(activity);

		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.setViewName("redirect:/trainingCenter/activities");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/activities" }, method = RequestMethod.GET)
	public ModelAndView listOfActivitybyTrainingcenterPage() {
		ModelAndView model = new ModelAndView();

		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		List<TrainingCenterActivity> listOftrainingCenterActity = trainingCenterActivityService
				.getTrainingCenterActivityByTrainingCenter(trainingcenter);
		model.addObject("listOftrainingCenterActity",
				listOftrainingCenterActity);
		model.setViewName("connected/activity/listOfActivitiesByTrainingCenter");

		model.addObject("connectedTrainingcenter", trainingcenter);
		return model;
	}

	@RequestMapping(value = { "/family/activites", "/activities" }, method = RequestMethod.GET)
	public ModelAndView listOfActivityPage(
			@RequestParam(name = "subject", required = false) String subject) {
		ModelAndView model = new ModelAndView();
		Family family = familyService.getConnectedFamily();

		List<TrainingCenterActivity> listOfAlltrainingCenterActity = trainingCenterActivityService
				.getTrainingCenterActivityBySubject(subject, null);
		model.addObject("listOfAlltrainingCenterActity",
				listOfAlltrainingCenterActity);

		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);

		model.addObject("connectedfamily", family);
		model.setViewName("connected/activity/listOfAllActivities");

		return model;
	}

	@RequestMapping(value = { "/trainingCenter/activitiesBysubject" }, method = RequestMethod.GET)
	public ModelAndView listOfActivitiesBysubject(

	@RequestParam(name = "subject", required = false) String subject) {
		ModelAndView model = new ModelAndView();

		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		List<TrainingCenterActivity> listOfAlltrainingCenterActityBysubject = trainingCenterActivityService
				.getTrainingCenterActivityBySubject(subject, trainingcenter);

		model.addObject("listOfAlltrainingCenterActityBysubject",
				listOfAlltrainingCenterActityBysubject);

		model.addObject("connectedTrainingcenter", trainingcenter);

		model.setViewName("connected/activity/listOfAllActivitiesBySubject");

		return model;
	}

	@RequestMapping(value = { "/teacher/activityDetails" }, method = RequestMethod.GET)
	public ModelAndView themeActivitydetailsPage(
			@RequestParam(name = "trainingcenterActivityID", required = false) Long trainingcenterActivityID,
			@RequestParam(name = "trainingcenterThemeID", required = false) Long trainingcenterThemeID,
			@RequestParam(name="programId", required = false) Long programId) {
		ModelAndView model = new ModelAndView();
		if (trainingcenterThemeID != null) {
			TrainingCenterTheme trainingCenterTheme = trainingCenterThemeService
					.findById(trainingcenterThemeID);
			model.addObject("trainingCenterTheme", trainingCenterTheme);
		}
		TrainingCenterProgram program=trainingcenterProgramService.findById(programId);
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		TrainingCenterActivity trainingCenterActivity = trainingCenterActivityService
				.findById(trainingcenterActivityID);
		model.addObject("trainingCenterActivity", trainingCenterActivity);
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.addObject("program", program);
		model.setViewName("connected/teacher/detailsActivityByTheme");

		return model;
	}
	@RequestMapping(value = { "/trainingCenter/program/theme/activityDelete" }, method = RequestMethod.GET)
	public ModelAndView deleteActivityPage(
			@RequestParam("trainingcenterActivityID") Long trainingcenterActivityID) {
		ModelAndView model = new ModelAndView();

		trainingCenterActivityService
				.deletTrainingcenterActivity(trainingcenterActivityID);

		model.setViewName("redirect:/trainingCenter/activities");

		return model;

}
}
