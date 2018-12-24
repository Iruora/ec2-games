package com.atn.demo.mvc.module.file.controller;


import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity;
import com.atn.demo.mvc.module.TrainingCenterActivity.service.TrainingCenterActivityService;
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.family.service.FamilyService;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.file.service.FileService;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.service.UserService;


@Controller
public class FileController {

	@Autowired
	FileService fileService;
	@Autowired
	FamilyService familyService;
	@Autowired
	TrainingCenterService trainingCentreService;
	@Autowired
	UserService userService;
	@Autowired
	TrainingCenterActivityService trainingCenterActivityService;

	@RequestMapping(value = { "/family/updatePicture" }, method = RequestMethod.POST)
	@Transactional
	public ModelAndView setFamilyPicture(
			@RequestParam(name = "picture") MultipartFile picture,
			@RequestParam(name = "idFamily") Long id) {
		Family family = familyService.findById(id);
		File image = fileService.saveFile(picture, id, null);
		family.setLogo(image);
		familyService.save(family);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/family/profil");
		return model;
	}

	@RequestMapping(value = { "/user/updatePicture" }, method = RequestMethod.POST)
	@Transactional
	public ModelAndView setUserPicture(
			@RequestParam(name = "picture") MultipartFile picture,
			@RequestParam(name = "idUser") Long id) {
		User user = userService.getConnectedUser();
		File image = fileService.saveFile(picture, id, null);
		user.setPicture(image);
		userService.save(user);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/user/myprofil");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/updatePicture" }, method = RequestMethod.POST)
	@Transactional
	public ModelAndView setTrainingCenterPicture(
			@RequestParam(name = "picture") MultipartFile picture,
			@RequestParam(name = "centerId") Long id) {
		TrainingCenter trainingCenter = trainingCentreService.findById(id);
		File image = fileService.saveFile(picture, id, null);
		trainingCenter.setLogo(image);
		trainingCentreService.save(trainingCenter);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/trainingCenter/update");
		return model;
	}

	@RequestMapping(value = "/getTcPicture", method = RequestMethod.GET)
	public @ResponseBody
	byte[] getTrainingCenterPicture(
			@RequestParam(name = "centerId", required = false) Long familyId)
			throws IOException {
		TrainingCenter user;
		if (familyId != null) {

			user = trainingCentreService.findById(familyId);
		} else {
			user = trainingCentreService.getconnectedTrainingCenter();
		}
		String picturePath;
		File file;
		try {
			file = user.getLogo();

		} catch (Exception e) {
			file = null;
		}
		if (file != null) {
			picturePath = file.getPath() + java.io.File.separator
					+ file.getFileName();
		} else {
			picturePath = fileService.getUploadPath() + java.io.File.separator
					+ "defaultProfilePicture.png";
		}
		return fileService.getFileAsByte(picturePath);

	}

	@RequestMapping(value = "/getUserPicture", method = RequestMethod.GET)
	public @ResponseBody
	byte[] getUserPicture(
			@RequestParam(name = "userId", required = false) Long id)
			throws IOException {
		User user = userService.getConnectedUser();

		String picturePath;
		File file = user.getPicture();
		if (file != null) {
			picturePath = file.getPath() + java.io.File.separator
					+ file.getFileName();
		} else {
			picturePath = fileService.getUploadPath() + java.io.File.separator
					+ "defaultProfilePicture.png";
		}
		return fileService.getFileAsByte(picturePath);

	}

	@RequestMapping(value = "/getFamilyPicture", method = RequestMethod.GET)
	public @ResponseBody
	byte[] getFamilyPicture(
			@RequestParam(name = "familyId", required = false) Long familyId)
			throws IOException {
		Family user;
		if (familyId != null) {

			user = familyService.findById(familyId);
		} else {
			user = familyService.getConnectedFamily();
		}
		String picturePath;
		File file = user.getLogo();
		if (file != null) {
			picturePath = file.getPath() + java.io.File.separator
					+ file.getFileName();
		} else {
			picturePath = fileService.getUploadPath() + java.io.File.separator
					+ "defaultProfilePicture.png";
		}

		return fileService.getFileAsByte(picturePath);
	}

	@RequestMapping(value = "/getActivityDocument", method = RequestMethod.GET)
	public @ResponseBody
	byte[] getActivityDocument(HttpServletResponse response,
			@RequestParam(name = "activityId", required = false) Long activityId)
			throws IOException {

		TrainingCenterActivity activity = trainingCenterActivityService
				.findById(activityId);

		String documentPath;
		File file = activity.getDocument();

		documentPath = file.getPath() + java.io.File.separator
				+ file.getFileName();

		
		return fileService.getFileAsByte(documentPath);
	}

	@RequestMapping(value = { "/trainingCenter/activity/updateDocument" }, method = RequestMethod.POST)
	@Transactional
	public ModelAndView updateDocument(
			@RequestParam(name = "document") MultipartFile document,
			@RequestParam(name = "activityId") Long activityId,
			@RequestParam(name = "trainingcenterThemeID") Long trainingcenterThemeID) {
		TrainingCenterActivity activity = trainingCenterActivityService.findById(activityId);
		File activityDocument = fileService.saveFile(document, activityId, null);
		activity.setDocument(activityDocument);
		trainingCenterActivityService.save(activity);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/trainingCenter/program/theme/activity/details?trainingcenterActivityID="+activityId
				+ "&&trainingcenterThemeID="+trainingcenterThemeID);
		return model;
	}
	
	
	@RequestMapping(value = { "/downloadDocument" }, method = RequestMethod.GET)
    public void downloadDocument(HttpServletRequest request, HttpServletResponse response
    		,@RequestParam(name = "activityId", required = false) Long activityId)
            throws  IOException {
		TrainingCenterActivity activity = trainingCenterActivityService
				.findById(activityId);
        
		File file = activity.getDocument();
        String path = file.getPath()+java.io.File.separator+ file.getFileName()  ;
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getFileName());
        OutputStream os = response.getOutputStream();
        fileService.downloadFile( os, path);
    }

}
