package com.atn.demo.mvc.module.familyMember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.family.entity.Family;

import com.atn.demo.mvc.module.user.entity.User;

@Entity
@Table(name = "APP_FAMILY_MEMBER", uniqueConstraints = @UniqueConstraint(columnNames = "FAMILY_MEMBER_ID"))
public class FamilyMember extends ModelObject<Long> {

	public enum RoleFamily {

		CHILD("CHILD"), PARENT("PARENT");

		protected String value;

		RoleFamily(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FAMILY_MEMBER_ID", unique = true, nullable = false)
	private long familyMemberId;

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE")
	private RoleFamily role;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID_FK")
	private User user;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAMILY_ID_FK")
	private Family family;

	public FamilyMember() {
		super();
	}

	public FamilyMember(long familyMemberId, RoleFamily role, User user,
			Family family) {
		super();
		this.familyMemberId = familyMemberId;
		this.role = role;
		this.user = user;
		this.family = family;
	}

	@Override
	public Long getId() {
		return getFamilyMemberId();
	}

	public long getFamilyMemberId() {
		return familyMemberId;
	}

	public void setFamilyMemberId(long familyMemberId) {
		this.familyMemberId = familyMemberId;
	}

	public RoleFamily getRole() {
		return role;
	}

	public void setRole(RoleFamily role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

}
