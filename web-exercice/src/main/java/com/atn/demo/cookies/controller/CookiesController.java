package com.atn.demo.cookies.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/exercice/{operation}/{firstNumber}/score", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView loadScorePage(
			@PathVariable("operation") String operation,
			@PathVariable("firstNumber") int firstNumber, 
			@RequestParam("success") boolean success,
			HttpServletRequest request) {

		int score = 0;

		ModelAndView model = new ModelAndView();
		model.addObject("operation", operation);
		model.addObject("firstNumber", firstNumber);

		model.addObject("score", score);

		model.setViewName("score");

		myCookie = getCookieByName(operation + "" + firstNumber, request);

		if (myCookie == null) {

			// System.out.println("$% /!EXIST/ %$ :" + start);

			myCookie = new Cookie(operation + "" + firstNumber, "");

			myCookie.setMaxAge(3600 * 24);
		}
		score = Integer.parseInt(myCookie.getValue()) + 1;
		myCookie.setValue(score + "");

		// ----------------------------------------------

		// response.addCookie(cookie);

		if (operation.equals("addition") || operation.equals("soustraction") || operation.equals("multiplication")
				|| operation.equals("division")) {
			return model;
		} else {
			model.setViewName("exercice");
			return model;
		}
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
