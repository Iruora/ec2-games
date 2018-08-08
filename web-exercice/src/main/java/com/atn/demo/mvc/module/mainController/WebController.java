package com.atn.demo.mvc.module.mainController;

import java.time.Period;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
	//private Cookie myCookie;
	//String operationString ;
	//int result = 0;
	static HashMap<String, Object> map = new HashMap<>() ; 
	/************************************
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * ============================HOME ROUTE==================================
	 */
	 
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	protected ModelAndView welcomeGame(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView();
		//=======setting view name--------------
		model.setViewName("home");
		return model;

	}

	/************************************
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * ============================Unity Game Route==================================
	 */
	@RequestMapping(value = { "/geomirror" }, method = RequestMethod.GET)
	protected ModelAndView playGame(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView();
		//=======setting view name--------------
		model.setViewName("index");
		return model;

	}

	/************************************
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * ============================Exercices Route (+ - * /)==================================
	 */
	@RequestMapping(value = { "/exercice" }, method = RequestMethod.GET)
	protected ModelAndView loadExercicesPage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView model = new ModelAndView();
		//--------adding objects
		model.addObject("greet", "Hello ! choose operation and a number");
		//=======setting view name--------------
		model.setViewName("exercice");
		return model;

	}

	/***********************************************
	 * 
	 * @param operation
	 * @param firstNumber
	 * @return
	 * ============================Numbers Route ROUTE==================================
	 */
	@RequestMapping(value = "/exercice/{operation}", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView loadNumbersPage(@PathVariable("operation") String operation) {

		int goldNumber = 7;
		int silverNumber = 5;
		
		ModelAndView model = new ModelAndView();
		//--------adding objects
		model.addObject("title", operation);
		model.addObject("maxNumberForGeneration", 30);
		model.addObject("goldNumber", goldNumber);
		model.addObject("silverNumber", silverNumber);
		//------------setting view name--------------
		model.setViewName("numbers");
		//-------------------------------------------
		if (operation.equals("addition") || operation.equals("soustraction") || operation.equals("multiplication")
				|| operation.equals("division")) {
			return model;
		} else {
			//=======setting view name--------------
			model.setViewName("exercice");
			return model;
		}
	}



	/***********************************************
	 * 
	 * @param operation
	 * @param firstNumber
	 * @return
	 *============================== operation bloc Route================================================
	 */
	@RequestMapping(value = "/exercice/{operation}/{firstNumber}", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView loadOperationPage(@PathVariable("operation") String operation,
			@PathVariable("firstNumber") int firstNumber, HttpServletResponse response, HttpServletRequest request
	
	) {

		//ModelAndView model = loadResultPage(operation, firstNumber, response, request);
		ModelAndView model = new ModelAndView();
		int countDownStart = 90;
		
		//=======setting view name--------------
		model.setViewName("show-result");
		//---------------------------------
		
		//--------adding objects
		model.addObject("operation", operation);
		model.addObject("firstNumber", firstNumber);
		model.addObject("countDownStart", countDownStart);
		
		model.addObject("operationString", map.get("operationString"));
		model.addObject("result", map.get("result"));	
		
		
		
		return model;
	}
	/***********************************************
	 * 
	 * @param operation
	 * @param firstNumber
	 * @return
	 *============================== result as Text Route===================================
	 */
	@RequestMapping(value = "/exercice/{operation}/{firstNumber}/result", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView loadResultPage(@PathVariable("operation") String operation,
			@PathVariable("firstNumber") int firstNumber, HttpServletResponse response, HttpServletRequest request
	
	) {

		ModelAndView model = load(operation, firstNumber);
		
		
		//--------getting objects from load model
		
		//=======setting view name--------------
		model.setViewName("result");
		//model.setViewName("result");
		
		//--------adding objects
		model.addObject("operation", operation);
		model.addObject("firstNumber", firstNumber);
		model.addObject("operationString", map.get("operationString"));
		model.addObject("result", map.get("result"));	
		return model;
	}
	/*****************************************
	 * 
	 * **
	 * @param operation
	 * @param firstNumber
	 * @return
	 *============================== load operation and result===================================
	 */
	ModelAndView load(String operation, int firstNumber) {
		ModelAndView model = new ModelAndView();
		
		//-----adding to hashMap
		map.put("operation", operation);
		map.put("firstNumber", firstNumber);
		//--------adding objects
		model.addObject("operation", operation);
		model.addObject("firstNumber", firstNumber);
		
		Random rand = new Random();
		int result = 0;
		int pickedNumber;
		String operationString;
		//*************************************************************
		switch (operation) {
		
		case "addition": 
			pickedNumber = rand.nextInt(100) + 1;
			operationString = pickedNumber + " + " + firstNumber + " = ";
			
			result = (int) (pickedNumber + firstNumber);
			//-----adding to hashMap
			map.put("operationString", operationString);
			map.put("result", result);
			//--------adding objects
			model.addObject("operationString", operationString);
			model.addObject("result", result);
			//----------------
			System.out.println("load :: op 1st num pickedNumber : "+operation+" "+firstNumber+" "+pickedNumber+" op => "+operationString);
			//---------------
			
			return model;
		

		case "soustraction":
			pickedNumber = rand.nextInt(100) + (firstNumber + 1);
			operationString = pickedNumber + " - " + firstNumber + " = ";
			
			result = (int) (pickedNumber - firstNumber);
			//-----adding to hashMap
			map.put("operationString", operationString);
			map.put("result", result);
			//--------adding objects
			model.addObject("operationString", operationString);
			model.addObject("result", result);
			//----------------
			System.out.println("load ::op 1st num pickedNumber : "+operation+" "+firstNumber+" "+pickedNumber+" op => "+operationString);
			//---------------
			
			return model;

		case "multiplication":
			pickedNumber = rand.nextInt(11);

			operationString = pickedNumber + " X " + firstNumber + " = ";
			result = (int) (pickedNumber * firstNumber);
			
			//-----adding to hashMap
			map.put("operationString", operationString);
			map.put("result", result);
			//--------adding objects
			model.addObject("operationString", operationString);
			model.addObject("result", result);
		
			//----------------
			System.out.println("load :: op 1st num pickedNumber : "+operation+" "+firstNumber+" "+pickedNumber+" op => "+operationString);
			//---------------
			return model;

		case "division":

			pickedNumber = (rand.nextInt(9) + 1) * firstNumber;
			operationString = pickedNumber + " / " + firstNumber + " = ";
			
			result = (int) (pickedNumber / firstNumber);
			
			//-----adding to hashMap
			map.put("operationString", operationString);
			map.put("result", result);
			//--------adding objects
			model.addObject("operationString", operationString);
			model.addObject("result", result);
		
			//----------------
			System.out.println("load :: op 1st num pickedNumber : "+operation+" "+firstNumber+" "+pickedNumber+" op => "+operationString);
			//---------------
			return model;

		default:
			//---------Setting view name-----------
			model.setViewName("exercice");
			//-------------------------------
			//----------------
			System.out.println("load :: op 1st num pickedNumber : "+operation+" "+firstNumber+" "+"none");
			//---------------
			return model;
		}
		
	}
}