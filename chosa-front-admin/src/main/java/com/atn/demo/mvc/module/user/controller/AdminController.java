package com.atn.demo.mvc.module.user.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atn.commons.persistence.BaseDao.DELETION_STATUS;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.TrainingCenterClass.service.TrainingCenterClassService;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.country.service.CountryService;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private TrainingCenterService trainingCenterService;
	@Autowired
	private TrainingCenterClassService trainingCenterClassService;
	
	@RequestMapping(value = { "/admin", "/admin/index" }, method = RequestMethod.GET)
	public ModelAndView adminUserPage() {
		ModelAndView model = new ModelAndView();

		model.setViewName("admin/index");

		return model;
	}
/*
 * user Management
 * User list page
 * 
 */
	@RequestMapping(value = {  "/admin/users" }, method = RequestMethod.GET)
	public ModelAndView usersPage(@RequestParam(name="page",defaultValue="1") int page) {
		ModelAndView model = new ModelAndView();
		

		List<User> listOfUsers = userService.findListByCriteria(new HashMap<String, Object>(), 5, (((page - 1) * 5) ),
				DELETION_STATUS.ACTIVE);
		int maxNumberPage = listOfUsers.size() % 5 != 0 ? (listOfUsers.size()) / 5 + 1 : (listOfUsers.size());

		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		model.addObject("page", page);
		model.addObject("listAllUsers", listOfUsers);
		model.addObject("maxNumberPage", maxNumberPage);
		model.setViewName("admin/users");

		return model;
	}

	@RequestMapping(value = { "/admin/users/delete" }, method = RequestMethod.GET)
	@Transactional
	public ModelAndView userDelete(@RequestParam(name = "idUser") Long idUser) {
		ModelAndView model = new ModelAndView();

		userService.delete(userService.findById(idUser));

		model.setViewName("redirect:/admin/users");

		return model;
	}
	
	@RequestMapping(value = { "/admin/users/update" }, method = RequestMethod.POST)

	public ModelAndView userUpdate(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		Long userId = new Long(request.getParameter("userId"));
			String userEmail = request.getParameter("userEmail");
			String userName = request.getParameter("userName");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String userAdress = request.getParameter("userAdress");
			String userPhone = request.getParameter("userPhone");
			String userStatus = request.getParameter("userStatus");
			Country userCountry = countryService.findById(new Long(request.getParameter("countryId")));
			userService.update(userId,userEmail,userName,firstName,lastName,userAdress,userPhone,userStatus,userCountry);
			
		
		model.setViewName("redirect:/admin/users");

		return model;
	}
	@RequestMapping(value = { "/admin/centers" }, method = RequestMethod.GET)
	public ModelAndView trainingCentrePage(@RequestParam(name="page",defaultValue="1")int page) {
		ModelAndView model = new ModelAndView();

		List<TrainingCenter> listOfCenters = trainingCenterService.findListByCriteria(new HashMap<String, Object>(), 5,((page - 1) * 5) ,
				DELETION_STATUS.ACTIVE);
		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		model.addObject("page", page);
		int maxNumberPage = listOfCenters.size() % 5 != 0 ? (listOfCenters.size()) / 5 + 1 : (listOfCenters.size());
		model.addObject("listAllCenters", listOfCenters);
		model.addObject("maxNumberPage", maxNumberPage);
		model.setViewName("admin/centers");

		return model;
	}
	
	
	@RequestMapping(value = { "/admin/centers/update" }, method = RequestMethod.POST)
	public ModelAndView trainingCenterUpdate(@RequestParam(name = "centerId") String userId,
			@RequestParam(name = "centerName") String centerName,
			@RequestParam(name = "centerAdress") String centerAdress,
			@RequestParam(name = "centerPhone") String centerPhone,
			@RequestParam(name = "centerStatus") String centerStatus,
			@RequestParam(name = "countryId") String countryId
			) {
		ModelAndView model = new ModelAndView();
		
			
			Country userCountry = countryService.findById(new Long(countryId));
			trainingCenterService.adminUpdate(new Long(userId),centerName,centerAdress,centerPhone,centerStatus,userCountry);
			
		
		model.setViewName("redirect:/admin/centers");

		return model;
	}

	@RequestMapping(value = { "/admin/centers/delete" }, method = RequestMethod.GET)
	@Transactional
	public ModelAndView centreDelete(@RequestParam(name = "idCenter") Long idCenter) {
		ModelAndView model = new ModelAndView();

		trainingCenterService.delete(trainingCenterService.findById(idCenter));

		model.setViewName("redirect:/admin/centers");

		return model;
	}
	@RequestMapping(value = { "/admin/classes/update" }, method = RequestMethod.POST)
	public ModelAndView classesUpdate(
			@RequestParam(name = "tcClassId") Long tcClassId,
			
			@RequestParam(name = "className") String className,
			HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		
			trainingCenterClassService.updateClass(tcClassId,className);
			
		
		model.setViewName("redirect:/admin/classes");

		return model;
	}
	@RequestMapping(value = { "/admin/classes/delete" }, method = RequestMethod.GET)
	@Transactional
	public ModelAndView classeDelete(@RequestParam(name = "idClass") Long idClass) {
		ModelAndView model = new ModelAndView();

		trainingCenterClassService.delete(trainingCenterClassService.findById(idClass));

		model.setViewName("redirect:/admin/classes");

		return model;
	}
	
	

	@RequestMapping(value = { "/admin/classes" }, method = RequestMethod.GET)
	public ModelAndView classesPage(@RequestParam(name="page",defaultValue="1")int page) {
		ModelAndView model = new ModelAndView();

		List<TrainingCenterClass> listOfClasses = trainingCenterClassService.findListByCriteria(new HashMap<String, Object>(), 5,((page - 1) * 5) ,
				DELETION_STATUS.ACTIVE);
		int maxNumberPage = listOfClasses.size() % 5 != 0 ? (listOfClasses.size()) / 5 + 1 : (listOfClasses.size());

		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		model.addObject("page", page);
		model.addObject("listAllClasses", listOfClasses);
		model.addObject("maxNumberPage", maxNumberPage);
		model.setViewName("admin/classes");

		return model;
	}
	

}
