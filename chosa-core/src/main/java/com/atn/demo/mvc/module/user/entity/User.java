package com.atn.demo.mvc.module.user.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.Set;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.user.entity.Role.ROLE;

/**
 * 
 * 
 */
@Entity
@Table(name = "APP_USER", uniqueConstraints = @UniqueConstraint(columnNames = "USER_ID"))
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends ModelObject<Long> {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;

	@Size(max = 255)
	@Column(name = "USER_PASSWORD")
	private String userPassword;

	@Size(max = 255)
	@Column(name = "USER_EMAIL", unique = true)
	private String userEmail;

	@Size(max = 255)
	@Column(name = "USER_NAME")
	private String userName;

	@Size(max = 255)
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(max = 255)
	@Column(name = "LAST_NAME")
	private String lastName;

	@Size(max = 255)
	@Column(name = "ADRESS")
	private String adress;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUNTRY_ID_FK")
	private Country country;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "manager")
	private TrainingCenter trainingCentre;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "member")
	private TrainingCenterMember trainingCentreMember;

	@Size(max = 255)
	@Column(name = "PHONE")
	private String phone;

	@Column(name = "BIRTHDAY")
	private Date birthDay;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = File.class)
	@JoinColumn(name = "PICTURE_ID_FK")
	private File picture;

	@Size(max = 255)
	@Column(name = "GOOGLE_ID")
	private String googleId;
	@Size(max = 255)
	@Column(name = "FACEBOOK_ID")
	private String facebookId;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private STATUS status;

	public enum STATUS {
		SIGNUP("SIGNUP"), VALIDATE("VALIDATE"), SUSPENDED("SUSPENDED");
		protected String value;

		STATUS(String value) {
			this.value = value;
		}
	}

	public String getToken() {
		String token = "XXXXXXXXXXXXXXX";
		if (getUpdatingDate() != null) {
			token = Long.toString(getUpdatingDate().getTime());
			token = token.substring(0, 9);
		}

		return token;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
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

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public TrainingCenter getTrainingCentre() {
		return trainingCentre;
	}

	public void setTrainingCentre(TrainingCenter trainingCentre) {
		this.trainingCentre = trainingCentre;
	}

	public TrainingCenterMember getTrainingCentreMember() {
		return trainingCentreMember;
	}

	public void setTrainingCentreMember(TrainingCenterMember trainingCentreMember) {
		this.trainingCentreMember = trainingCentreMember;
	}

	@Override
	public Long getId() {
		return getUserId();
	}

	public boolean hasRole(ROLE role) {
		for (Role role1 : roles) {
			if (role1.getRole().equals(role))
				return true;
		}

		return false;
	}

}
