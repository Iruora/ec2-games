package com.atn.demo.mvc.module.family.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenter.service.TrainingCenterService;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity;
import com.atn.demo.mvc.module.TrainingCenterActivity.service.TrainingCenterActivityService;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.TrainingCenterMember.service.TrainingCenterMemberService;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;
import com.atn.demo.mvc.module.TrainingCenterTheme.service.TrainingCenterThemeService;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.country.service.CountryService;
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.family.service.FamilyService;
import com.atn.demo.mvc.module.familyMember.entity.FamilyMember;
import com.atn.demo.mvc.module.familyMember.service.FamilyMemberService;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.service.UserService;

@Controller
public class FamilyController {
	@Autowired
	FamilyService familyService;
	@Autowired
	UserService userService;
	@Autowired
	CountryService countryService;
	@Autowired
	FamilyMemberService familyMemberService;
	@Autowired
	TrainingCenterMemberService trainingMemberCenterService;
	@Autowired
	TrainingCenterService trainingCenterService;
	@Autowired
	TrainingCenterActivityService trainingCenterActivityService;
	@Autowired
	TrainingCenterThemeService trainingCenterThemeService;

	
	@Autowired
    private MessageSource messageSource;
	@RequestMapping(value = { "/family/profil" }, method = RequestMethod.GET)
	public ModelAndView myFamilyProfilPage(Locale locale) {
		ModelAndView model = new ModelAndView();

		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		Family family = familyService.getConnectedFamily();
		if (family != null) {
			model.addObject("family", family);
			model.addObject("message", "Your Family Information");
		} else {
			model.addObject("family", new Family());
			model.addObject("message", "Create Your Family");

		}
		Locale currentLocale = LocaleContextHolder.getLocale();
        model.addObject("locale", currentLocale);
		model.addObject("connectedfamily", family);
		model.setViewName("connected/family/profil");
		return model;
	}

	@RequestMapping(value = { "/family/update" }, method = RequestMethod.POST)
	public ModelAndView familyUpdateProfile(
			@ModelAttribute("family") Family family) {
		ModelAndView model = new ModelAndView();
		familyService.updateFamily(family);
		model.setViewName("redirect:/family/profil");
		return model;
	}

	@RequestMapping(value = { "/family/add" }, method = RequestMethod.GET)
	public ModelAndView familyAddPage() {
		ModelAndView model = new ModelAndView();
		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		model.addObject("family", new Family());
		model.setViewName("connected/family/create");
		return model;
	}

	@RequestMapping(value = { "/family/add" }, method = RequestMethod.POST)
	public ModelAndView familyAdd(@ModelAttribute("family") Family family) {
		ModelAndView model = new ModelAndView();
		familyService.createFamily(family, null);
		model.setViewName("redirect:/family/add");
		return model;
	}

	@RequestMapping(value = { "/family/membres" }, method = RequestMethod.GET)
	public ModelAndView familyMembresPage() {
		ModelAndView model = new ModelAndView();
		Family family = familyService.getConnectedFamily();
		List<FamilyMember> listofMemberByFamily = familyMemberService
				.getMemberByFamily(family);
		model.addObject("listofMemberByFamily", listofMemberByFamily);
		model.addObject("connectedfamily", family);
		model.setViewName("connected/family/listOfAllMembre");
		return model;
	}

	@RequestMapping(value = { "/family/membresByname" }, method = RequestMethod.GET)
	public ModelAndView familyMembresBynamePage(
			@RequestParam("name") String name) {
		ModelAndView model = new ModelAndView();

		List<FamilyMember> listofMemberByname = familyMemberService
				.getMemberByName(name);
		model.addObject("listofMemberByname", listofMemberByname);
		model.setViewName("connected/family/listOfAllMembre");
		return model;
	}

	@RequestMapping(value = { "/family/membres/add" }, method = RequestMethod.GET)
	public ModelAndView familyAddMembresPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		model.setViewName("connected/family/membreCreate");
		return model;
	}

	@RequestMapping(value = { "/family/membres/add" }, method = RequestMethod.POST)
	public ModelAndView familyAddMembres(@ModelAttribute("user") User user) {
		ModelAndView model = new ModelAndView();
		User userSave = userService.inscription(user, null,"/CHOSA-FAMILY");
		familyMemberService.createFamilyMember(userSave);
		model.setViewName("redirect:/family/membres");
		return model;
	}

	@RequestMapping(value = { "/family/membres/update" }, method = RequestMethod.GET)
	public ModelAndView familyUpdateMembresPage(
			@RequestParam("failyMemberID") Long failyMemberID) {
		ModelAndView model = new ModelAndView();
		FamilyMember familyMember = familyMemberService.findById(failyMemberID);
		model.addObject("user", familyMember.getUser());
		model.addObject("failyMemberID", failyMemberID);
		model.addObject("familyMember", familyMember);
		model.setViewName("connected/family/memberUpdate");
		return model;
	}

	@RequestMapping(value = { "/family/membres/update" }, method = RequestMethod.POST)
	public ModelAndView familyUpdateMembres(@ModelAttribute("user") User user,
			@RequestParam("failyMemberID") Long failyMemberID) {
		ModelAndView model = new ModelAndView();
		User userSave = userService.updateProfil(user);
		familyMemberService.updateFamilyMember(failyMemberID, userSave);
		model.setViewName("redirect:/family/membres");
		return model;
	}

	@RequestMapping(value = { "/family/trainingCenter/subscription" }, method = RequestMethod.GET)
	public ModelAndView listOftrainingCenterSubscribeByMemberPage(
			@RequestParam(value = "userId", required = false) Long userId) {
		ModelAndView model = new ModelAndView();
		List<TrainingCenterMember> listOfTrainingCenterSubscribeByMember = trainingMemberCenterService
				.getTrainingCenterSubscribeByMember(userId);

		Family family = familyService.getConnectedFamily();
		model.addObject("listOfTrainingCenterSubscribeByMember",
				listOfTrainingCenterSubscribeByMember);
		TrainingCenter trainingcenter = trainingCenterService
				.getconnectedTrainingCenter();
		model.addObject("connectedTrainingcenter", trainingcenter);
		model.addObject("connectedfamily", family);
		model.setViewName("connected/family/listOfTrainingCenterSubscribeByMember");
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
		model.setViewName("connected/family/listOfTrainingCenterValid");
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
	@RequestMapping(value = { "/trainingCenter/program/theme/activity/details", "/family/activity/details" }, method = RequestMethod.GET)
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

}
