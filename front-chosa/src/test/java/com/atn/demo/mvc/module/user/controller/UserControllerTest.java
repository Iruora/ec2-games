package com.atn.demo.mvc.module.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.atn.demo.config.AbstractControllerTest;
import com.atn.demo.config.TestsConfig;
import com.atn.demo.mvc.module.user.entity.Role.ROLE;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestsConfig.class })
 @Transactional
public class UserControllerTest extends AbstractControllerTest{
	
	@Autowired
	UserController userController;
	
	@Before
	public void setup() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setSuffix(".jsp");
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).setViewResolvers(viewResolver).build();
		setMockMvc(mockMvc);
	}

	
	
	
	@Test
	public void err403Test() throws Exception
	{
		getMockMvc().
		perform(get("/403**")).
		andDo(print()).
		andExpect(status().
				isOk())
		.andExpect(view().
				name("403"));
	}
	@Test
	public void forgetPasswordPageTest() throws Exception
	{
		getMockMvc().
		perform(get("/guest/forgetpassword")).
		andDo(print()).
		andExpect(status().
				isOk())
		.andExpect(view().
				name("connected/user/forgetpassword"));
	}
	
	@Test
	public void forgetPasswordPostTest() throws Exception
	{
		getMockMvc().
		perform(post("/guest/forgetpassword").param("userEmail", "test@email.com")).
		andDo(print()).
		andExpect(status().
				is3xxRedirection())
		.andExpect(view().
				name("redirect:/login"));
		
		getMockMvc().
		perform(post("/guest/forgetpassword").param("userEmail", "issam.benbelgacem@esprit.tn")).
		andDo(print()).
		andExpect(status().
				is3xxRedirection())
		.andExpect(view().
				name("redirect:/login"));
	}
	
	@Test
	public void loginPageTest() throws Exception
	{
		getMockMvc().
		perform(get("/login")).
		andDo(print()).
		andExpect(status().
				isOk())
		.andExpect(view().
				name("login"));
	}
	
	@Test
	public void indexPageTest() throws Exception
	{
		
		/**
		 * with User null
		 */
		
		final UserDetails userNull = createUser("null@null.tn", null);
		final Authentication authentication = new UsernamePasswordAuthenticationToken(userNull, null,
				userNull.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		getMockMvc().perform(get("/")).andDo(print()).andExpect(view().name("redirect:/login"));	
		
		
		/*  Role Admin*/
		final UserDetails userAdmin = createUser("issam.benbelgacem@esprit.tn", ROLE.ADMIN);
		final Authentication authenticationAdmin = new UsernamePasswordAuthenticationToken(userAdmin, null,
				userAdmin.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationAdmin);
		getMockMvc().perform(get("/")).andDo(print()).andExpect(view().name("redirect:/admin/users"));
		
		
		/*  Role User*/
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationUser);
		getMockMvc().perform(get("/")).andDo(print()).andExpect(view().name("redirect:/family/profil"));	
	}
	
	@Test
	public void myProfilPageTest() throws Throwable
	{
		/*  Role User*/
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationUser);
		getMockMvc().
		perform(get("/user/myprofil")).
		andDo(print()).
		andExpect(status().
				isOk())
		.andExpect(view().
				name("connected/user/profil"));
	}
	
	@Test
	public void updateMyProfilTest() throws Throwable
	{
		/*  Role User*/
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationUser);
		getMockMvc().
		perform(post("/user/myprofile/update").param("userId", "2").param("password", "password").param("userEmail", "test@email.com")).
		
		andDo(print()).
		andExpect(status().is3xxRedirection()
				)
		.andExpect(view().
				name("redirect:/user/myprofil"));
	}
	
	@Test
	public void registerPageTest() throws Exception
	{
		getMockMvc().
		perform(get("/register")).
		andDo(print()).
		andExpect(status().
				isOk())
		.andExpect(model().attributeExists("user"))
		.andExpect(view().
				name("register"));
	}
	
	@Test
	public void saveOrUpdatePageTest() throws Exception
	{
		/*  Role User*/
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		
		//wrong confirmePAssword
		SecurityContextHolder.getContext().setAuthentication(authenticationUser);
		getMockMvc().
		perform(post("/guest/register").contentType(MediaType.MULTIPART_FORM_DATA).param("userPassword", "password1").param("userEmail", "test@email.com").param("confirmPassword","password")).
		
		andDo(print())
		.andExpect(model().attributeExists("erreurs"))	
		.andExpect(model().attributeExists("countryList"))
		.andExpect(view().
				name("/users/register"));
		
		
		//correct confirmePAssword
		
		getMockMvc().
		perform(post("/guest/register").contentType(MediaType.MULTIPART_FORM_DATA).param("userPassword", "password").
				param("userEmail", "test@email.com").
				param("userName", "issam").  
				param("firstName", "issam").
				param("lastName", "issam").
				param("phone", "23881505").
				param("birthDay", "1990-07-18").
				param("country.id", "1").
				
				
				param("adress", "issam").
				param("confirmPassword","password")).
		andDo(print())
		.andExpect(view().
				name("redirect:/login"));
	}
	
	
	@Test
	public void facebookValidatorpositTest() throws Exception {
		// facebokId exists
		getMockMvc()
				.perform(post("/guest/facebook/callback").param("id", "1").param("first_name", "test")
						.param("last_name", "test").param("email", "test@email.com"))
				.andExpect(view().name("redirect:/"));
		// facebookId indefined
		getMockMvc().perform(post("/guest/facebook/callback").param("id", "2").param("facebookId", ""))
		.andExpect(view().name("register"));

		getMockMvc().perform(post("/guest/facebook/callback").param("id", "6").param("facebookId", ""));
	}

	@Test
	public void googleValidatorpositTest() throws Exception {
		getMockMvc().perform(post("/guest/google/callback").param("ofa", "test").param("wea", "test")
				.param("U3", "issam.benbelgacem@google.fr").param("Eea", "2").param("userEmail", "issam.benbelgacem@esprit.tn").param("googleId", "99"))
			.andExpect(view().name("register"));
		// googleId exists
		getMockMvc().perform(post("/guest/google/callback").param("id", "1").param("googleId", "1"))
				.andExpect(view().name("redirect:/"));
		
		getMockMvc().perform(post("/guest/google/callback").param("ofa", "test").param("wea", "test")
			.param("U3", "issam.benbelgacem@esprit.tn").param("Eea", "2").param("userEmail", "issam.benbelgacem@esprit.tn").param("googleId", "99"))
		.andExpect(view().name("redirect:/"));
		
		// googleId indefined
		getMockMvc().perform(post("/guest/google/callback").param("ofa", "test").param("wea", "test")
				.param("U3", "test").param("Eea", "2")).andExpect(view().name("redirect:/"));
	;

	}
}
