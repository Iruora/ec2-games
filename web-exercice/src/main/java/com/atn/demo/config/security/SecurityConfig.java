package com.atn.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
				passwordEncoder());
		
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()                                                                
			.antMatchers("/static/**", "/notconnected/login","/**").permitAll()
			//.antMatchers("/admin/**").hasRole("ADMIN")
			//	.antMatchers("/connected/**").hasRole("USER")
			//.antMatchers("/connected/**").access("hasRole('ADMIN') and hasRole('USER')")
			//.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/notconnected/login").usernameParameter("username")
				.passwordParameter("password").and().logout()
				.logoutSuccessUrl("/notconnected/login?logout").and().exceptionHandling()
				.accessDeniedPage("/notconnected/403").and().csrf();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**"); // #3
	}
}
