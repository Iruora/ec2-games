package com.atn.demo.mvc.module.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember.RoleTrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterMember.service.TrainingCenterMemberService;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.country.service.CountryService;
import com.atn.demo.mvc.module.templateMail.entity.TemplateMail.EMAIL_TEMPLATE;
import com.atn.demo.mvc.module.templateMail.service.TemplateMailService;
import com.atn.demo.mvc.module.user.entity.Role;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.entity.User.STATUS;
import com.atn.demo.mvc.module.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailsService detailsService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private TrainingCenterMemberService tariningCenterMemberService;
	@Autowired
	TemplateMailService emailService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		User user = userService.getConnectedUser();
		ModelAndView model = new ModelAndView();

		if (user == null) {
			model.setViewName("redirect:/login");
			return model;
		}
		if (user.hasRole(Role.ROLE.USER)) {
	
			model.setViewName("redirect:/trainingCenter/update");

		} else {
			model.setViewName("redirect:/login");
		}

		return model;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView loginPage(
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = { "/user/myprofil" }, method = RequestMethod.GET)
	public ModelAndView myProfilPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", userService.getConnectedUser());
		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		model.setViewName("connected/user/profil");
		return model;
	}

	@RequestMapping(value = { "/user/myprofile/update" }, method = RequestMethod.POST)
	public ModelAndView updateMyProfil(@ModelAttribute User user) {
		ModelAndView model = new ModelAndView();

		userService.updateProfil(user);
		model.setViewName("redirect:/user/myprofil");
		return model;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView registerPage(User user) {
		ModelAndView model = new ModelAndView();
		model.setViewName("register");
		if (user == null)
			user = new User();
		model.addObject("user", user);
		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);

		return model;
	}

	@RequestMapping(value = { "/guest/register", "/register" }, method = RequestMethod.POST)
	public ModelAndView saveOrUpdatePage(
			@ModelAttribute("user") @Validated User user, BindingResult result,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam("confirmPassword") String confirmPassword,
			HttpServletRequest request) {
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

		userService.inscription(user, file,"/CHOSA-TC");
		model.setViewName("redirect:/login");
		return model;
	}

	@RequestMapping(value = { "/guest/google/callback" }, method = RequestMethod.POST)
	@Transactional
	public ModelAndView googleValidatorposit(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String email = request.getParameter("U3");
		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		String googleId = request.getParameter("Eea");
		String firstName = request.getParameter("ofa");
		String lastName = request.getParameter("wea");
		User user = userService.findByGoogleId(googleId);
		if (user == null) {
			user = userService.findByEmail(email);
			if (user != null) {
				user.setGoogleId(googleId);
				user.setStatus(STATUS.VALIDATE);
				userService.save(user);
			}
		}
		if (user != null) {
			UserDetails userDetails = detailsService.loadUserByUsername(user
					.getUserEmail());
			Authentication auth = new UsernamePasswordAuthenticationToken(
					userDetails, userDetails.getPassword(),
					userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
			model.setViewName("redirect:/");
			return model;
		} else {
			User newUser = new User();
			newUser.setStatus(STATUS.VALIDATE);
			newUser.setUserEmail(email);
			newUser.setFirstName(firstName);
			newUser.setLastName(lastName);
			newUser.setGoogleId(googleId);

			return registerPage(newUser);
		}
	}

	@RequestMapping(value = { "guest/facebook/callback" }, method = RequestMethod.POST)
	public ModelAndView facebookValidatorposit(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String id = request.getParameter("id");
		User user = userService.findByFacebookId(id);
		List<Country> countryList = countryService.getAllCountry();
		model.addObject("countryList", countryList);
		if (user != null) {
			UserDetails userDetails = detailsService.loadUserByUsername(user
					.getUserEmail());
			Authentication auth = new UsernamePasswordAuthenticationToken(
					userDetails, userDetails.getPassword(),
					userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
			model.setViewName("redirect:/");
			return model;
		} else {
			User newUser = new User();
			newUser.setFirstName(request.getParameter("first_name"));
			newUser.setLastName(request.getParameter("last_name"));
			newUser.setUserEmail(request.getParameter("email"));

			newUser.setFacebookId(id);
			return registerPage(newUser);
		}
	}

	@RequestMapping(value = { "/403**" }, method = RequestMethod.GET)
	public ModelAndView err403() {
		ModelAndView model = new ModelAndView();
		model.setViewName("403");
		return model;
	}

	@RequestMapping(value = { "/guest/forgetpassword" }, method = RequestMethod.GET)
	public ModelAndView forgetPasswordPage() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("connected/user/forgetpassword");
		return model;
	}

	@RequestMapping(value = { "/guest/forgetpassword" }, method = RequestMethod.POST)
	public ModelAndView forgetPasswordActionPage(
			@ModelAttribute("user") User user, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		User exist = userService.findByEmail(user.getUserEmail());
		if (exist != null) {
			emailService.sendHtmlMail(exist, EMAIL_TEMPLATE.MotPassPerdu);
		}
		model.setViewName("redirect:/login");
		return model;
	}

}
