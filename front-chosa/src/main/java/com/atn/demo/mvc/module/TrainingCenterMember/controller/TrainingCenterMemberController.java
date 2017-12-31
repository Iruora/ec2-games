 package com.atn.demo.mvc.module.TrainingCenterMember.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.TrainingCenterClass.service.TrainingCenterClassService;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.TrainingCenterMember.service.TrainingCenterMemberService;
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;
import com.atn.demo.mvc.module.TrainingCenterProgram.service.TrainingCenterProgramService;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;
import com.atn.demo.mvc.module.TrainingCenterTheme.service.TrainingCenterThemeService;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.country.service.CountryService;
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.family.service.FamilyService;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.service.UserService;

@Controller
public class TrainingCenterMemberController {

	@Autowired
	TrainingCenterMemberService trainingMemberCenterService;
	@Autowired
	UserService userSevice;
	@Autowired
	CountryService countryService;
	@Autowired
	TrainingCenterService trainingCenterService;
	@Autowired
	UserService userService;
	@Autowired
	TrainingCenterThemeService trainingCenterThemeService;
	
	@Autowired 
	TrainingCenterClassService trainingCenterClasseService;
	@Autowired
	TrainingCenterProgramService trainingcenterProgramService;

	@Autowired
	FamilyService familyService;
	
	@RequestMapping(value = { "/trainingCenter/member" }, method = RequestMethod.GET)
	public ModelAndView listOfAllMembrePage(
			@RequestParam(name = "memberRole", required = false) String memberRole) {
		ModelAndView model = new ModelAndView();
		TrainingCenter trainingCenter = trainingCenterService.getconnectedTrainingCenter();
		List<TrainingCenterMember> listOfMembreBystatus = trainingMemberCenterService.gettrainingCenterMemberByStatus(memberRole, trainingCenter);
		TrainingCenter trainingcenter = trainingCenterService.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.setViewName("connected/trainingCenter/listOfMemberByStatus");
		model.addObject("memberRole", memberRole);
		model.addObject("listOfMembreBystatus", listOfMembreBystatus);

		return model;
	}

	@RequestMapping(value = { "/trainingCenter/classes/teacher" }, method = RequestMethod.GET)
	public ModelAndView listOfTeacherPage(
			@RequestParam("trainingCenterClassId") Long trainingCenterClassId
	) {
		ModelAndView model = new ModelAndView();
		List<TrainingCenterMember> teachers = trainingMemberCenterService
				.getTeacher();
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		TrainingCenterClass tc_class=trainingCenterClasseService.findById(trainingCenterClassId);
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.addObject("tc_class", tc_class);
		model.setViewName("connected/teacher/listOfTeachers");
		model.addObject("listOfteachers", teachers);

		return model;
	}
	
	@RequestMapping(value = { "/teacher/classes" }, method = RequestMethod.GET)
	public ModelAndView listOfClassesByTeacherPage(

	) {
		ModelAndView model = new ModelAndView();
		User userTeacher=userService.getConnectedUser();
		List<TrainingCenterClass> listOfClassesByTeacher = trainingCenterClasseService.getClassByTeacher(userTeacher.getId());
		model.setViewName("connected/teacher/listOfClassesByTeacher");
		model.addObject("listOfClassesByTeacher", listOfClassesByTeacher);
		return model;
	}
	
	@RequestMapping(value = { "/teacher/programByClass" }, method = RequestMethod.GET)
	public ModelAndView getProgramByClassPage(
			@RequestParam("programId") Long programId
	) {
		ModelAndView model = new ModelAndView();
		
		TrainingCenterProgram program=trainingcenterProgramService.findById(programId);
		
		
		List<TrainingCenterTheme> listOftrainingCenterTheme = trainingCenterThemeService
				.getTrainingcenterThemeByProgram(program);

		model.addObject("listOftrainingCenterTheme", listOftrainingCenterTheme);
		
		model.addObject("program", program);
		model.setViewName("connected/teacher/detailProgramByClass");
		
		return model;
	}
	

	@RequestMapping(value = { "/trainingCenter/teacher" }, method = RequestMethod.GET)
	public ModelAndView listOfTeacherByTrainingCenterPage(

	) {
		ModelAndView model = new ModelAndView();
		TrainingCenter trainingCenter = trainingCenterService
				.getconnectedTrainingCenter();
		List<TrainingCenterMember> listOfTeacherByTrainingCenter = trainingMemberCenterService
				.getTeacherByTrainingCenter(trainingCenter.getCenterId());

		model.setViewName("connected/teacher/listOfTeacherByTrainingCenter");
		model.addObject("listOfTeacherByTrainingCenter",
				listOfTeacherByTrainingCenter);

		return model;
	}

	@RequestMapping(value = { "/teacher/validateAccount" }, method = RequestMethod.GET)
	public ModelAndView valideAccountTeacherPage(
			@RequestParam("teacherId") Long teacherId) {
		ModelAndView model = new ModelAndView();
		trainingMemberCenterService.validTeacher(teacherId);
		model.setViewName("redirect:/teacher");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/teacher/subscribeClasse" }, method = RequestMethod.GET)
	public ModelAndView subscribeTeacherToClassePage(
			@RequestParam("trainingcenterClassId") Long trainingcenterClassId,
			@RequestParam("teacherID") Long  teacherID) {
		ModelAndView model = new ModelAndView();
		trainingMemberCenterService.suscribeTeacherToClass(teacherID,trainingcenterClassId);
		model.setViewName("redirect:/trainingCenter/classes");
		return model;
	}

	@RequestMapping(value = { "/teacher/bloquedAccount" }, method = RequestMethod.GET)
	public ModelAndView bloquedAccountTeacherPage(
			@RequestParam("teacherId") Long teacherId) {
		ModelAndView model = new ModelAndView();
		trainingMemberCenterService.bloquedTeacher(teacherId);
		model.setViewName("redirect:/teacher");
		return model;
	}

	@RequestMapping(value = { "/teacher/remove" }, method = RequestMethod.GET)
	public ModelAndView removeTeacherPage(
			@RequestParam("teacherId") Long teacherId) {
		ModelAndView model = new ModelAndView();
		trainingMemberCenterService.deleteTeacher(teacherId);
		model.setViewName("redirect:/teacher");
		return model;
	}

	@RequestMapping(value = { "/student" }, method = RequestMethod.GET)
	public ModelAndView listOfStudentPage(

	) {
		ModelAndView model = new ModelAndView();
		List<TrainingCenterMember> listOfStudents = trainingMemberCenterService
				.getStudentByTrainingCenter();

		model.setViewName("connected/student/listOfStudent");
		model.addObject("listOfStudents", listOfStudents);

		return model;
	}

	@RequestMapping(value = { "/student/subscribe" }, method = RequestMethod.GET)
	public ModelAndView subscribeStudentPage(
			@RequestParam("trainingcenterClassId") Long trainingcenterClassId) {
		ModelAndView model = new ModelAndView();
		trainingMemberCenterService.addStudent(trainingcenterClassId);
		model.setViewName("redirect:/trainingCenter");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/member/ValidorBloquedAccount" }, method = RequestMethod.GET)
	public ModelAndView ValidorBloquedAccountMemberPage(
			@RequestParam("memberId") Long memberId,
			@RequestParam("statusMember") String statusMember
			) {
		ModelAndView model = new ModelAndView();
		trainingMemberCenterService.validOrBloquedTrainingCentrerMember(memberId, statusMember);
		model.setViewName("redirect:/trainingCenter/member?memberRole="+statusMember);
		return model;
	}



	
	@RequestMapping(value = { "/trainingCenter/member/profil" }, method = RequestMethod.GET)
	public ModelAndView profilMemberPage() {
		ModelAndView model = new ModelAndView();
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();

		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		model.addObject("trainingcenter", trainingcenter);
		model.setViewName("redirect:/trainingCenter/member?memberRole=REQUEST");
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/member/invite" }, method = RequestMethod.GET)
	public ModelAndView inviteMemberPage(
			@RequestParam(value = "roleMember", required = false) String roleMember) {
		ModelAndView model = new ModelAndView();
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();

		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		model.addObject("user", new User());

		model.addObject("connectedTrainingcenter", trainingcenter);
		model.addObject("roleMember", roleMember);
		if (roleMember.equals("TEACHER")) {
			model.setViewName("connected/trainingCenter/createTeacher");
		} else if (roleMember.equals("STUDENT")) {
			model.setViewName("connected/trainingCenter/createStudent");
		}
		return model;
	}

	@RequestMapping(value = { "/trainingCenter/member/register" }, method = RequestMethod.POST)
	public ModelAndView saveOrUpdateMemberPage(
			@ModelAttribute("user") @Validated User user,
			BindingResult result,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam("confirmPassword") String confirmPassword,
			HttpServletRequest request,
			@RequestParam(value = "roleMember", required = false) String roleMember) {
		ModelAndView model = new ModelAndView();

		if (!user.getUserPassword().contentEquals(confirmPassword)) {
			result.addError(new ObjectError("confirmPassword",
					"Passwords do not match, please retype!"));
		}
		if (result.hasErrors()) {
			List<ObjectError> erreurs = result.getAllErrors();
			model.addObject("erreurs", erreurs);
			model.addObject("user", user);
			List<Country> countryList = countryService.getAllCountry();
			model.addObject("countryList", countryList);
			model.setViewName("/users/register");
			return model;
		}
		User userSave = userService.inscription(user, file,"/CHOSA-FAMILY");
		TrainingCenter trainingCenter = trainingCenterService
				.getconnectedTrainingCenter();
		trainingMemberCenterService.createMember(userSave.getId(), roleMember,
				trainingCenter);
		model.setViewName("redirect:/trainingCenter/member?memberRole=REQUEST");
		return model;
	}
	@RequestMapping(value = { "/family/trainingCenter/subscription" }, method = RequestMethod.GET)
	public ModelAndView listOftrainingCenterSubscribeByMemberPage(
			@RequestParam(value = "userId", required = false) Long userId
	) {
		ModelAndView model = new ModelAndView();
		List<TrainingCenterMember> listOfTrainingCenterSubscribeByMember = trainingMemberCenterService.getTrainingCenterSubscribeByMember(userId);
		
		Family family=familyService.getConnectedFamily();
		model.addObject("listOfTrainingCenterSubscribeByMember",listOfTrainingCenterSubscribeByMember );
		TrainingCenter trainingcenter=trainingCenterService.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter",trainingcenter );
		model.addObject("connectedfamily", family);
		model.setViewName("connected/family/listOfTrainingCenterSubscribeByMember");
		return model;
	}
}
