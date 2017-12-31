package com.atn.demo.mvc.module.trainingCenter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.atn.demo.config.AbstractControllerTest;
import com.atn.demo.config.TestsConfig;
import com.atn.demo.mvc.module.TrainingCenter.controller.TrainingCenterController;
import com.atn.demo.mvc.module.user.entity.Role.ROLE;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestsConfig.class })
public class TrainingCenterControllerTest extends AbstractControllerTest {
	@Autowired
	TrainingCenterController trainingCenterController;
	
	
	@Before
	public void setup() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setSuffix(".jsp");
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(trainingCenterController).setViewResolvers(viewResolver).build();
		setMockMvc(mockMvc);
	}

	@Test
	public void listOftrainingCenterPageTest()throws Exception{
		/*Role Director of training Center */
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationUser);
		
		getMockMvc().
		perform(get("/trainingCenter")).
		andDo(print())
		.andExpect(view().
				name("connected/trainingCenter/listOfTrainingCenter"));
		
	}
	@Test
	public void listOftrainingCenterValidPageTest()throws Exception{
		
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationUser);
		
		getMockMvc().
		perform(get("/family/trainingCenter/Valid")).
		andDo(print())
		.andExpect(view().
				name("connected/trainingCenter/listOfTrainingCenterValid"));
		
	}
	@Test
	public void saveOrUpdateTrainingCenterPageTest()throws Exception{
		/*Role Director of training Center */
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationUser);
		
		getMockMvc().
		perform(get("/trainingCenter/update")).
		andDo(print())
		.andExpect(view().
				name("connected/trainingCenter/updateTrainingCenter"));
		
	}
	
	@Test
	public void saveTrainingCenterPageTest() throws Exception{
		/*Role user didn't have training Center */
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationUser);
		
		getMockMvc().
		perform(get("/trainingCenter/save")).
		andDo(print())
		.andExpect(model().attributeExists("countryList"))
		.andExpect(model().attributeExists("trainingCenter"))
		.andExpect(model().attributeDoesNotExist("connectedTrainingcenter"))
		.andExpect(view().
				name("connected/trainingCenter/addTrainingCenter"));
		/*Role Director of training Center */
		final UserDetails managerTC = createUser("issam.benbelgacem@esprit.tn", ROLE.USER);
		final Authentication authenticationManagerTc = new UsernamePasswordAuthenticationToken(managerTC, null,
				managerTC.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationManagerTc);
		
		getMockMvc().
		perform(get("/trainingCenter/save")).
		andDo(print())
		
		.andExpect(view().
				name("redirect:/trainingCenter/update"));
	}
	@Test
	public void saveTrainingCenterTest() throws Exception {
		final UserDetails managerTC = createUser("issam.benbelgacem@esprit.tn", ROLE.USER);
		final Authentication authenticationManagerTc = new UsernamePasswordAuthenticationToken(managerTC, null,
				managerTC.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationManagerTc);
		
		getMockMvc().perform(post("/trainingCenter/save").param("centerId", "5")
				.param("name", "3t").param("adress", "montplaisir")
				.param("phone", "24456788").param("country.id", "1")
				

		).andDo(print())
		
		.andExpect(view().name("redirect:/trainingCenter/save"));
	}
	@Test
	public void updateTrainingCenterPageTest() throws Exception {
		final UserDetails managerTC = createUser("issam.benbelgacem@esprit.tn", ROLE.USER);
		final Authentication authenticationManagerTc = new UsernamePasswordAuthenticationToken(managerTC, null,
				managerTC.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationManagerTc);
		
		getMockMvc().perform(post("/trainingCenter/update").param("centerId", "1")
				.param("name", "3t").param("country.id", "1").param("adress", "montplaisir")
				.param("phone", "24456788")
				)
		
		.andDo(print())
		
		.andExpect(view().name("redirect:/trainingCenter/"));
	}
	
	
}
