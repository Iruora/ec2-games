package com.atn.demo.mvc.module.mainController;

import java.time.Period;
import java.util.Date;
import java.util.Random;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import antlr.collections.List;

@Controller
public class WebController {
	private Cookie myCookie;

	/************************************
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	protected ModelAndView welcomeGame(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView();

		model.setViewName("home");
		return model;

	}

	/************************************
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/geomirror" }, method = RequestMethod.GET)
	protected ModelAndView playGame(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView();
		// model = initData(model);
		// model.addObject("pageName", "index");
		model.setViewName("index");
		return model;

	}

	/************************************
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/exercice" }, method = RequestMethod.GET)
	protected ModelAndView loadExercicesPage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView model = new ModelAndView();
		// model = initData(model);
		model.addObject("greet", "Hello ! choose operation and a number");
		model.setViewName("exercice");
		return model;

	}

	/***********************************************
	 * 
	 * @param operation
	 * @param firstNumber
	 * @return
	 */
	@RequestMapping(value = "/exercice/{operation}", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView loadNumbersPage(@PathVariable("operation") String operation) {

		ModelAndView model = new ModelAndView();
		model.addObject("title", operation);
		model.addObject("maxNumberForGeneration", 30);
		model.setViewName("numbers");

		if (operation.equals("addition") || operation.equals("soustraction") || operation.equals("multiplication")
				|| operation.equals("division")) {
			return model;
		} else {
			model.setViewName("exercice");
			return model;
		}
	}



	/***********************************************
	 * 
	 * @param operation
	 * @param firstNumber
	 * @return
	 */
	@RequestMapping(value = "/exercice/{operation}/{firstNumber}", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView loadOperationPage(@PathVariable("operation") String operation,
			@PathVariable("firstNumber") int firstNumber, HttpServletResponse response, HttpServletRequest request
	// ,@RequestParam boolean success
	) {

		// int scoreStep = 0;
		ModelAndView model = new ModelAndView();
		model.setViewName("result");
		model.addObject("operation", operation);
		model.addObject("firstNumber", firstNumber);
		// =======================================
		// final long start = new Date().getTime();

		// System.out.println("$%start%$ :" + start);
		// ----------------------------------------------
		// =======================================
		float result;
		Random rand = new Random();
		int pickedNumber;

		switch (operation) {
		case "addition": {
			pickedNumber = rand.nextInt(100) + 1;
			model.addObject("operationString", pickedNumber + " + " + firstNumber + " = ");

			result = (int) (pickedNumber + firstNumber);
			model.addObject("result", result);

			
			return model;
		}

		case "soustraction":
			pickedNumber = rand.nextInt(100) + (firstNumber + 1);
			model.addObject("operationString", pickedNumber + " - " + firstNumber + " = ");
			result = (int) (pickedNumber - firstNumber);
			model.addObject("result", result);

			return model;

		case "multiplication":
			pickedNumber = rand.nextInt(11);
			model.addObject("operationString", pickedNumber + " X " + firstNumber + " = ");
			result = (int) (pickedNumber * firstNumber);
			model.addObject("result", result);

			return model;

		case "division":

			pickedNumber = (rand.nextInt(9) + 1) * firstNumber;
			// int t[] = { 1, firstNumber / 2, firstNumber };
			model.addObject("operationString", pickedNumber + " / " + firstNumber + " = ");
			result = (float) (pickedNumber / firstNumber);
			model.addObject("result", result);

			return model;

		default:
			model.setViewName("exercice");
			return model;

		}

	}	
}
