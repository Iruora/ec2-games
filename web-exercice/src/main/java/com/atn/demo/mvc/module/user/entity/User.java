package com.atn.demo.mvc.module.user.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.atn.commons.entities.ModelObject;

/**
 * 
 * 
 */
@Entity
@Table(name = "APP_USER", uniqueConstraints = @UniqueConstraint(columnNames = "USER_ID"))
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends ModelObject<Long>  {


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;

	@Column(name = "USER_PASSWORD")
	private String userPassword;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
	private Set<Role> roles;
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	@Override
	public Long getId() {
		return getUserId();
	}

}
