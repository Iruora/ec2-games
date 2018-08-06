package com.atn.demo.cookies.controller;

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
public class CookiesController {

	private Cookie myCookie;
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
		
		//System.out.println("getting Session : " +operation+firstNumber +"...");
	
		//session.getAttribute(operation+firstNumber);
		if(session.getAttribute(operation+firstNumber) == null) {
			//System.out.println("Session not Found !\nProceed to creation !");
			session.setAttribute(operation+firstNumber, 0);
			//System.out.println("Session created with attribute=> "+session.getAttribute(operation+firstNumber));
		}
		else {
			//System.out.println("Session Found with success !");
			//System.out.println("Session (" +operation+firstNumber+")  "+session.getAttribute(operation+firstNumber));
		}
		

		Integer sessAttr = (Integer) session.getAttribute(operation+firstNumber);
		//System.out.println("sessAttr (before) : "+sessAttr);
		sessAttr++;
		//System.out.println("sessAttr (after) : "+sessAttr);
		//System.out.println("score : "+sessAttr);
		
		model.addObject("score", sessAttr);
				
		//System.out.println("=========Setting session attribute to score============= ");
		
		session.setAttribute(operation+firstNumber, sessAttr);
		
		//System.out.println("seesion attribute becomes : "+session.getAttribute("operation+firstNumber"));		
		//System.out.println("====================== ");
		
		// ----------------------------------------------

		//response.addCookie(myCookie);

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
		//System.out.println(operation+firstNumber);
		if (session.getAttribute(operation+firstNumber) == null) {
			
			model.addObject("score",0);
			System.out.println(operation + firstNumber+"Null");
		}
		else {
			System.out.println("Not Null"+session.getAttribute(operation+firstNumber));
			model.addObject("score",session.getAttribute(operation+firstNumber));
		}
		return model;
	}
	
	
	
	
	
	// ===========================================================
	private Cookie getCookieByName(String cookieName, HttpServletRequest request) {
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(cookieName)) {

					return cookie;
				}
			}
		}
		return null;
	}
}
