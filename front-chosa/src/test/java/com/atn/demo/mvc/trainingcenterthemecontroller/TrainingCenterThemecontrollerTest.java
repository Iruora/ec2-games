package com.atn.demo.mvc.trainingcenterthemecontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import com.atn.demo.mvc.module.TrainingCenterTheme.controller.TrainingCenterThemecontroller;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;
import com.atn.demo.mvc.module.user.entity.Role.ROLE;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestsConfig.class })
public class TrainingCenterThemecontrollerTest extends AbstractControllerTest {
@Autowired
TrainingCenterThemecontroller centerThemecontroller;

@Before
public void setup() throws Exception {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

	viewResolver.setSuffix(".jsp");
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(centerThemecontroller).setViewResolvers(viewResolver).build();
	setMockMvc(mockMvc);
}

@Test
public void savethemePageTest()throws Exception
{
	final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
	final Authentication authenticationAdmin = new UsernamePasswordAuthenticationToken(user, null,
			user.getAuthorities());
	SecurityContextHolder.getContext().setAuthentication(authenticationAdmin);

		getMockMvc().perform(get("/trainingCenter/program/theme/add").param("trainingcenterProgramID", "1")).andDo(print())
		.andExpect(status().isOk()).
		andExpect(model().attributeExists("trainingCentertheme"))
		.andExpect(model().attribute("trainingcenterProgramID", 1l))
		.andExpect(view().name("connected/theme/themeCreate"));
		
		
	

			getMockMvc().perform(get("/trainingCenter/program/theme/add").param("trainingcenterProgramID", "1").
			param("trainingcenterThemeID", "6"))
			.andDo(print())
			.andExpect(status().isOk()).
			andExpect(model().attributeExists("trainingCentertheme"))
			.andExpect(model().attribute("trainingcenterProgramID", 1l))
			.andExpect(view().name("connected/theme/themeUpdate"));	
		
}
}
