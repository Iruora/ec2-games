//package com.atn.demo.mvc.module.user.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import com.atn.demo.config.AbstractControllerTest;
//import com.atn.demo.config.TestsConfig;
//import com.atn.demo.mvc.module.user.entity.Role.ROLE;
//
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestsConfig.class })
//
//public class AdminControllerTest extends AbstractControllerTest {
//	@Autowired
//	AdminController adminController;
//		@Before
//	public void setup() throws Exception {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//
//		viewResolver.setSuffix(".jsp");
//		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(adminController).setViewResolvers(viewResolver).build();
//		setMockMvc(mockMvc);
//	}
//
//	@Test
//	public void adminUserPage() throws Exception {
//
//		final UserDetails userAdmin = createUser("issam.benbelgacem@esprit.tn", ROLE.ADMIN);
//		final Authentication authenticationAdmin = new UsernamePasswordAuthenticationToken(userAdmin, null,
//				userAdmin.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(authenticationAdmin);
//
//		getMockMvc().perform(get("/admin/index")).andDo(print()).andExpect(status().isOk())
//				.andExpect(view().name("admin/index"));
//	}
//
//	@Test
//	public void usersPageTest() throws Throwable {
//		getMockMvc().perform(get("/admin/users").param("page", "1")).andDo(print())
//				.andExpect(model().attributeExists("page", "countryList", "listAllUsers", "maxNumberPage"))
//
//				.andExpect(status().isOk()).andExpect(view().name("admin/users"));
//	}
//
//	@Test
//	public void userDeleteTest() throws Exception {
//		getMockMvc().perform(get("/admin/users/delete").param("idUser", "1")).andDo(print())
//				.andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/admin/users"));
//	}
//
//	@Test
//	public void userUpdateTest() throws Exception {
//		getMockMvc().perform(post("/admin/users/update").param("userId", "1")
//				.param("userEmail", "issam.benbelgacem@esprit.tn").param("userName", "issam.benbelgacem@esprit.tn")
//				.param("firstName", "issam.benbelgacem@esprit.tn").param("lastName", "issam.benbelgacem@esprit.tn")
//				.param("userAdress", "issam.benbelgacem@esprit.tn").param("userPhone", "12547896")
//				.param("countryId", "1").param("userStatus", "VALIDATE")
//
//		).andDo(print())
//
//				.andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/admin/users"));
//	}
//
//	@Test
//	public void trainingCentrePageTest() throws Exception {
//		getMockMvc().perform(get("/admin/centers")).andDo(print())
//				.andExpect(model().attributeExists("page", "countryList", "listAllCenters", "maxNumberPage"))
//				.andExpect(status().isOk()).andExpect(view().name("admin/centers"));
//	}
//
//	@Test
//	public void trainingCenterUpdateTest() throws Exception {
//		getMockMvc().perform(post("/admin/centers/update").param("centerId", "1")
//				.param("centerName", "issam.benbelgacem@esprit.tn").param("centerAdress", "issam.benbelgacem@esprit.tn")
//				.param("centerPhone", "14257896").param("countryId", "1").param("centerStatus", "VALIDATE"))
//				.andDo(print())
//
//				.andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/admin/centers"));
//	}
//
//	@Test
//	public void centreDeleteTest() throws Exception {
//		getMockMvc().perform(get("/admin/centers/delete").param("idCenter", "2")
//
//		).andDo(print()).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/admin/centers"));
//	}
//
//	@Test
//	public void classesUpdateTest() throws Exception {
//		getMockMvc().perform(post("/admin/classes/update").param("centerId", "2").param("centerName", "test"))
//				.andDo(print()).andExpect(status().is3xxRedirection())
//				.andExpect(view().name("redirect:/admin/classes"));
//	}
//
//	@Test
//	public void classDeleteTest() throws Exception {
//		getMockMvc().perform(get("/admin/classes/delete").param("idClass", "15")
//
//		).andDo(print()).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/admin/classes"));
//	}
//
//	@Test
//	public void classesPageTest() throws Exception {
//
//		getMockMvc().perform(get("/admin/classes")
//
//		).andDo(print()).andExpect(status().isOk())
//				.andExpect(model().attributeExists("page", "countryList", "listAllClasses", "maxNumberPage"))
//
//				.andExpect(view().name("admin/classes"));
//	}
//}
