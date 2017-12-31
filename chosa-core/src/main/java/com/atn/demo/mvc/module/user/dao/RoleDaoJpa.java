package com.atn.demo.mvc.module.user.dao;

import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.user.entity.Role;

@Component
public class RoleDaoJpa extends BaseDaoJpa<Role, Integer> implements  RoleDao{

	public RoleDaoJpa() {
		super(Role.class);
		}

}
