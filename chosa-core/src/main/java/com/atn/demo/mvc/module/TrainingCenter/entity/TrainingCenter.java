package com.atn.demo.mvc.module.TrainingCenter.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

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
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.user.entity.User;

@Entity
@Table(name = "APP_TRAINING_CENTER", uniqueConstraints = @UniqueConstraint(columnNames = "CENTER_ID"))
@Inheritance(strategy = InheritanceType.JOINED)
public class TrainingCenter extends ModelObject<Long> {

	public enum Status {

		REQUEST("REQUEST"), SUSPENDED("SUSPENDED"), VALIDATE("VALIDATE");

		protected String value;

		Status(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CENTER_ID", unique = true, nullable = false)
	private Long centerId;

	@Size(max = 255)
	@Column(name = "NAME")
	private String name;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = File.class)
	@JoinColumn(name = "LOGO_FILE_ID_FK")
	private File logo;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "MANAGER_USER_ID_FK", unique = true)
	private User manager;

	@Size(max = 255)
	@Column(name = "ADRESS")
	private String adress;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TRAINING_CENTER_COUNTRY_ID_FK")
	private Country country;

	@Size(max = 255)
	@Column(name = "PHONE")
	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status;

	@OneToMany(mappedBy = "trainingCenter", fetch = FetchType.EAGER)
	private List<TrainingCenterClass> listOfClass;

	public TrainingCenter() {
		super();
	}

	public List<TrainingCenterClass> getListOfClass() {
		return listOfClass;
	}

	public void setListOfClass(List<TrainingCenterClass> listOfClass) {
		this.listOfClass = listOfClass;
	}

	public TrainingCenter(Long centerId, String name, File logo, User manager, String adress, Country country,
			String phone, Status status) {
		super();
		this.centerId = centerId;
		this.name = name;
		this.logo = logo;
		this.manager = manager;
		this.adress = adress;
		this.country = country;
		this.phone = phone;
		this.status = status;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public Long getId() {
		return centerId;
	}

	public Long getCenterId() {
		return centerId;
	}

	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
