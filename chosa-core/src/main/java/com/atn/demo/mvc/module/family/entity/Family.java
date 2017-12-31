package com.atn.demo.mvc.module.family.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.user.entity.User;

@Entity
@Table(name = "APP_FAMILY", uniqueConstraints = @UniqueConstraint(columnNames = "FAMILY_ID"))
public class Family extends ModelObject<Long> {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FAMILY_ID", unique = true, nullable = false)
	private long familyId;

	@Column(name = "FAMILY_NAME")
	private String familyName;

	@Size(max = 100)
	@Column(name = "ADRESS")
	private String adress;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUNTRY_ID_FK")
	private Country country;

	@Size(max = 30)
	@Column(name = "PHONE")
	private String phone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANAGER_USER_ID_FK")
	private User user;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOGO_FILE_ID_FK")
	private File logo;

	public Family() {
		super();
	}

	public Family(long familyId, String familyName, String adress,
			Country country, String phone, User user, File logo) {
		super();
		this.familyId = familyId;
		this.familyName = familyName;
		this.adress = adress;
		this.country = country;
		this.phone = phone;
		this.user = user;
		this.logo = logo;
	}

	@Override
	public Long getId() {

		return getFamilyId();
	}

	public long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
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

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}

}
