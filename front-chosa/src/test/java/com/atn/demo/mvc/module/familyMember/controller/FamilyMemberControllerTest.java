package com.atn.demo.mvc.module.familyMember.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import com.atn.demo.mvc.module.user.entity.Role.ROLE;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestsConfig.class })

public class FamilyMemberControllerTest extends AbstractControllerTest {

	
	@Autowired
	FamilyMemberController familyMemberController;
	@Before
	public void setup() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setSuffix(".jsp");
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(familyMemberController).setViewResolvers(viewResolver).build();
		setMockMvc(mockMvc);
	}
@Test
	public void subscribeStudentPageTest()throws Exception
	{
	final UserDetails userAdmin = createUser("3issam901@gmail.com", ROLE.USER);
	final Authentication authenticationAdmin = new UsernamePasswordAuthenticationToken(userAdmin, null,
			userAdmin.getAuthorities());
	SecurityContextHolder.getContext().setAuthentication(authenticationAdmin);

	getMockMvc().perform(get("/family/subscribeMember").param("trainingcenterId", "1")).andDo(print())
	.andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/trainingCenter/Valid"));
	}
}
