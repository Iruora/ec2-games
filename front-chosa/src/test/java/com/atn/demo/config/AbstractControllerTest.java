package com.atn.demo.config;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;

import com.atn.demo.mvc.module.user.entity.Role;

/**
 * 
 * @author Mohamed Arbi Ben Slimane
 *
 * @Email benslimane.arbi@gmail.com
 *
 * @Date 15 avr. 2017 at 15:11:36
 */
public class AbstractControllerTest {

	private MockMvc mockMvc;

	@After
	public void tearsDown() throws Exception {
		setMockMvc(null);
	}

	public UserDetails createUser(final String username, final Role.ROLE role) {
		@SuppressWarnings("serial")
		UserDetails details = new UserDetails() {
			@Override
			public boolean isEnabled() {
				return false;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return false;
			}

			@Override
			public boolean isAccountNonLocked() {
				return false;
			}

			@Override
			public boolean isAccountNonExpired() {
				return false;
			}

			@Override
			public String getUsername() {
				return username;
			}

			@Override
			public String getPassword() {
				return null;
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
				@SuppressWarnings("serial")
				GrantedAuthority grantedAuthority = new GrantedAuthority() {
					// anonymous inner type
					public String getAuthority() {
						return role.toString();
					}
				};
				grantedAuthorities.add(grantedAuthority);
				return grantedAuthorities;
			}
		};
		return details;
	}

	public MockMvc getMockMvc() {
		return mockMvc;
	}

	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

}
