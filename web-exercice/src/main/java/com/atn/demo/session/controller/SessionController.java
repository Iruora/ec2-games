package com.atn.demo.session.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController {

	HttpSession session;
	
	@RequestMapping(value = "/exercice/{operation}/{firstNumber}/score", method = RequestMethod.POST)
	@ResponseBody
	protected ModelAndView loadScorePage(
			
			@PathVariable("operation") String operation,
			@PathVariable("firstNumber") int firstNumber, 
			@RequestParam("success") boolean success,
			HttpServletRequest request,
			HttpServletResponse response
		) {

		

		ModelAndView model = new ModelAndView();
		model.addObject("operation", operation);
		model.addObject("firstNumber", firstNumber);

		

		model.setViewName("score");
		
		session = request.getSession();

		if(session.getAttribute(operation+firstNumber) == null) {
			session.setAttribute(operation+firstNumber, 0);
		}
		
		

		Integer sessAttr = (Integer) session.getAttribute(operation+firstNumber);
		sessAttr++;
		
		model.addObject("score", sessAttr);
		session.setAttribute(operation+firstNumber, sessAttr);
		
		if (operation.equals("addition") || operation.equals("soustraction") || operation.equals("multiplication")
				|| operation.equals("division")) {
			return model;
		} else {
			model.setViewName("exercice");
			return model;
		}
	}
	
	@RequestMapping(value = "/exercice/{operation}/{firstNumber}/sc", method = RequestMethod.POST)
	@ResponseBody
	protected ModelAndView loadScore(
			
			@PathVariable("operation") String operation,
			@PathVariable("firstNumber") int firstNumber, 
			@RequestParam("success") boolean success,
			HttpServletRequest request,
			HttpServletResponse response
		) {

		ModelAndView model = new ModelAndView();
		model.addObject("operation", operation);
		model.addObject("firstNumber", firstNumber);

		model.setViewName("score");
		
		session = request.getSession();
		session.setMaxInactiveInterval(60*60*24*365);
		if(session.getAttribute(operation+firstNumber) == null) {
			session.setAttribute(operation+firstNumber, 0);
		}
		
		Integer sessAttr = (Integer) session.getAttribute(operation+firstNumber);
		model.addObject("score", sessAttr);
		
		if (operation.equals("addition") || operation.equals("soustraction") || operation.equals("multiplication")
				|| operation.equals("division")) {
			return model;
		} else {
			model.setViewName("exercice");
			return model;
		}
	}
	// ===========================================================
	@RequestMapping(value = "/exercice/{operation}/{firstNumber}/totscore", method = RequestMethod.POST)
	@ResponseBody
	protected ModelAndView loadScoreForEachNumber(
			
			@PathVariable("operation") String operation,
			@PathVariable("firstNumber") int firstNumber,
			HttpServletRequest request,
			HttpServletResponse response
		) {
		
		
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("totscore");
		
		model.addObject("operation",operation);
		model.addObject("firstNumber",firstNumber);
		
		session = request.getSession();
		session.setMaxInactiveInterval(60*60*24*365);

		if (session.getAttribute(operation+firstNumber) == null) {	
			model.addObject("score",0);
		}
		else {
			model.addObject("score",session.getAttribute(operation+firstNumber));
		}
		return model;
	}

}
