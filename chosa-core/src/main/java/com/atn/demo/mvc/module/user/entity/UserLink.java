package com.atn.demo.mvc.module.user.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.atn.commons.entities.ModelObject;
@Entity
@Table(name = "APP_USER_LINK", uniqueConstraints = @UniqueConstraint(columnNames = "LINK_ID"))
@Inheritance(strategy = InheritanceType.JOINED)
public class UserLink extends ModelObject<Long>{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "LINK_ID", unique = true, nullable = false)
	private Long linkId;
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	private TYPE type;
	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "USER_ID_FK1")
	private User user1;
	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "USER_ID_FK2")
	private User user2;
	public enum TYPE {

		FRIEND("FRIEND"), FATHER("FATHER"),TEACHER("TEACHER");

		protected String value;

		TYPE(String value) {
			this.value = value;
		}
	}
	
	
	public Long getLinkId() {
		return linkId;
	}


	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}


	public TYPE getType() {
		return type;
	}


	public void setType(TYPE type) {
		this.type = type;
	}


	public User getUser1() {
		return user1;
	}


	public void setUser1(User user1) {
		this.user1 = user1;
	}


	public User getUser2() {
		return user2;
	}


	public void setUser2(User user2) {
		this.user2 = user2;
	}


	@Override
	public Long getId() {
		return linkId;
	}
	
}
