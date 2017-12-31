package com.atn.demo.mvc.module.family.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.atn.demo.config.AbstractControllerTest;
import com.atn.demo.config.TestsConfig;
import com.atn.demo.mvc.module.user.entity.Role.ROLE;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestsConfig.class })
public class FamilyControllerTest extends AbstractControllerTest {

	@Autowired
	FamilyController familyController;

	@Before
	public void setup() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setSuffix(".jsp");
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(familyController)
				.setViewResolvers(viewResolver).build();
		setMockMvc(mockMvc);
	}

	@Test
	public void myFamilyProfilPageTest() throws Exception {
		/* family exist */
		final UserDetails user = createUser("issam.benbelgacem@esprit.tn",
				ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc()
				.perform(get("/family/profil"))
				.andDo(print())
				.andExpect(model().attributeExists("family"))
				.andExpect(model().attributeExists("connectedfamily"))
				.andExpect(
						model().attribute("message", "Your Family Information"))
				.andExpect(model().attributeExists("countryList"))
				.andExpect(view().name("connected/family/profil"));
		/* family dont exist */
		final UserDetails managerTC = createUser("khayri.ksiksi@allence.tn",
				ROLE.USER);
		final Authentication authenticationManagerTc = new UsernamePasswordAuthenticationToken(
				managerTC, null, managerTC.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(
				authenticationManagerTc);
		getMockMvc().perform(get("/family/profil")).andDo(print())
				.andExpect(model().attributeExists("countryList"))
				.andExpect(model().attribute("message", "Create Your Family"))
				.andExpect(model().attributeExists("family"));

	}

	@Test
	public void familyUpdateProfileTest() throws Exception {
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc()
				.perform(
						post("/family/update").param("centerId", "5")
								.param("familyId", "4")
								.param("familyName", "benhmida")
								.param("adress", "rades")
								.param("country.id", "1")
								.param("phone", "97528486")).andDo(print())
				.andExpect(view().name("redirect:/family/profil"));
	}

	@Test
	public void familyAddPageTest() throws Exception {
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc().perform(get("/family/add")).andDo(print())
				.andExpect(model().attributeExists("countryList"))
				.andExpect(model().attributeExists("family"))
				.andExpect(view().name("connected/family/create"));
	}

	@Test
	public void familyAddTest() throws Exception {
		final UserDetails user = createUser("khayri.ksiksi@esprit.tn",
				ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc()
				.perform(
						post("/family/add").param("familyId", "3")
								.param("familyName", "benhmida")
								.param("adress", "rades")
								.param("country.id", "1")
								.param("phone", "97528486")).andDo(print())
				.andExpect(view().name("redirect:/family/add"));
	}

	@Test
	public void familyMembresPageTest() throws Exception {
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc().perform(get("/family/membres")).andDo(print())
				.andExpect(model().attributeExists("listofMemberByFamily"))
				.andExpect(model().attributeDoesNotExist("family"))
				.andExpect(view().name("connected/family/listOfAllMembre"));
	}

	@Test
	public void familyMembresBynamePageTest() throws Exception {
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc()
				.perform(get("/family/membresByname").param("name", "issam"))
				.andDo(print())
				.andExpect(model().attributeExists("listofMemberByname"))
				.andExpect(view().name("connected/family/listOfAllMembre"));
	}

	@Test
	public void familyAddMembresPageTest() throws Exception {
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc().perform(get("/family/membres/add")).andDo(print())
				.andExpect(model().attributeExists("user"))
				.andExpect(view().name("connected/family/membreCreate"));
	}

	@Test
	public void familyAddMembresTest() throws Exception {
		final UserDetails user = createUser("khayri.ksiksi@esprit.tn",
				ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc()
				.perform(
						post("/family/membres/add")
								.contentType(MediaType.MULTIPART_FORM_DATA)
								.param("userPassword", "password")
								.param("userEmail", "test@email.com")
								.param("userName", "issam")
								.param("firstName", "issam")
								.param("lastName", "issam")
								.param("phone", "23881505")
								.param("birthDay", "1990-07-18")
								.param("country.id", "1")
								.param("adress", "issam")
								.param("confirmPassword", "password")
								.param("familyMemberId", "4")
								.param("role", "CHILD").param("family", "1"))

				.andDo(print()).andExpect(model().attributeExists("user"))
				.andExpect(view().name("redirect:/family/membres"));
	}

	@Test
	public void familyUpdateMembresPageTest() throws Exception {
		final UserDetails user = createUser("3issam901@gmail.com", ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc()
				.perform(
						get("/family/membres/update").param("failyMemberID",
								"2")).andDo(print())
				.andExpect(model().attributeExists("user"))
				.andExpect(model().attributeExists("failyMemberID"))
				.andExpect(model().attributeExists("familyMember"))
				.andExpect(view().name("connected/family/memberUpdate"));
	}

	@Test
	public void familyUpdateMembresTest() throws Exception {
		final UserDetails user = createUser("issam.benbelgacem@esprit.tn",
				ROLE.USER);
		final Authentication authenticationUser = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		SecurityContextHolder.getContext()
				.setAuthentication(authenticationUser);

		getMockMvc()
				.perform(
						post("/family/membres/update").param("userId", "5")
								.param("password", "password")
								.param("userEmail", "test@email.com")
								.param("confirmPassword", "password")
								.param("failyMemberID", "1")
								.param("userName", "issam")
								.param("firstName", "issam")
								.param("lastName", "issam")
								.param("phone", "23881505")
								.param("adress", "issam")
								.param("country.id", "1")
								.param("role", "CHILD").param("failyMemberID", "1")
								.param("role", "CHILD").param("family", "1"))

				.andDo(print()).andExpect(model().attributeExists("user"))
				.andExpect(view().name("redirect:/family/membres"));
	}
}
