package com.atn.demo.mvc.module.user.service;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.atn.demo.MockConfig;
import com.atn.demo.mvc.module.user.dao.RoleDao;
import com.atn.demo.mvc.module.user.dao.UserDao;

@Configuration
@ComponentScan({ "com.atn.demo.mvc.module.service", "com.atn.demo.mvc.module.dao"})
public class MockUserConfig extends MockConfig {

//	@Bean
//	public UserDao userDao() {
//		final UserDao userDao = Mockito.mock(UserDao.class);
//		
//		return userDao;
//	}
//	@Bean
//	public RoleDao roleDao() {
//		final RoleDao roleDao = Mockito.mock(RoleDao.class);
//		
//		return roleDao;
//	}
//
//	@Bean
//	public FileService documentService() {
//		return Mockito.mock(FileService.class);
//	}
//
//	@Bean
//	public TemplateMailService emailService() {
//		return Mockito.mock(TemplateMailService.class);
//	}
//
//	@Bean
//	public TrainingCenterMemberService TCService() {
//		return Mockito.mock(TrainingCenterMemberService.class);
//	}
//	@Bean
//	public RoleService RoleService() {
//		return Mockito.mock(RoleService.class);
//	}
}
