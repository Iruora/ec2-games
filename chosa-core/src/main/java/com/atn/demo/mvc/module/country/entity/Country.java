package com.atn.demo.mvc.module.country.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.user.entity.User;

@Entity
@Table(name = "APP_COUNTRY", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
public class Country extends ModelObject<Long> {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Size(max = 50)
	@Column(name = "NAME")
	private String name;

	@Size(max = 50)
	@Column(name = "NAME_FR")
	private String nameFR;

	@Size(max = 3)
	@Column(name = "ISO")
	private String iso;

	@Size(max = 5)
	@Column(name = "ISO3")
	private String iso3;

	@Size(max = 3)
	@Column(name = "FIPS")
	private String fips;

	@Size(max = 3)
	@Column(name = "CONTINENT")
	private String continent;

	@Size(max = 45)
	@Column(name = "PHONE_PREFIX")
	private String phonePrefix;

	@Size(max = 45)
	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Size(max = 45)
	@Column(name = "LANGUAGES")
	private String languages;

	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private Set<User> users;
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private Set<TrainingCenter> trainingCenters;
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private Set<Family> families;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Family> getFamilies() {
		return families;
	}

	public void setFamilies(Set<Family> families) {
		this.families = families;
	}

	public Set<TrainingCenter> getTrainingCenters() {
		return trainingCenters;
	}

	public void setTrainingCenters(Set<TrainingCenter> trainingCenters) {
		this.trainingCenters = trainingCenters;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameFR() {
		return nameFR;
	}

	public void setNameFR(String nameFR) {
		this.nameFR = nameFR;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getFips() {
		return fips;
	}

	public void setFips(String fips) {
		this.fips = fips;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getPhonePrefix() {
		return phonePrefix;
	}

	public void setPhonePrefix(String phonePrefix) {
		this.phonePrefix = phonePrefix;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}