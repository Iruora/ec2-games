package com.atn.demo.mvc.module.family.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = { "/family/profil" }, method = RequestMethod.GET)
	public ModelAndView myFamilyProfilPage() {
		ModelAndView model = new ModelAndView();

		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		Family family=familyService.getConnectedFamily();
		if(family!=null)
		{
		model.addObject("family", family);
		model.addObject("message","Your Family Information");
		}
		else 
			{
			model.addObject("family", new Family());
			model.addObject("message","Create Your Family");
		
			}
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
		Family family=familyService.getConnectedFamily();
		List<FamilyMember> listofMemberByFamily= familyMemberService.getMemberByFamily(family);
		model.addObject("listofMemberByFamily", listofMemberByFamily);
		model.addObject("connectedfamily", family);
		model.setViewName("connected/family/listOfAllMembre");
		return model;
	}
	@RequestMapping(value = { "/family/membresByname" }, method = RequestMethod.GET)
	public ModelAndView familyMembresBynamePage(@RequestParam("name") String name) {
		ModelAndView model = new ModelAndView();
		
		List<FamilyMember> listofMemberByname= familyMemberService.getMemberByName(name);
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
		User userSave=userService.inscription(user, null,"/CHOSA-FAMILY");
		familyMemberService.createFamilyMember( userSave);
		model.setViewName("redirect:/family/membres");
		return model;
	}
	
	
	@RequestMapping(value = { "/family/membres/update" }, method = RequestMethod.GET)
	public ModelAndView familyUpdateMembresPage(@RequestParam("failyMemberID") Long failyMemberID) {
		ModelAndView model = new ModelAndView();
		FamilyMember familyMember =familyMemberService.findById(failyMemberID);
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
		User userSave=userService.updateProfil(user);
		familyMemberService.updateFamilyMember( failyMemberID,userSave);
		model.setViewName("redirect:/family/membres");
		return model;
	}


	

}
