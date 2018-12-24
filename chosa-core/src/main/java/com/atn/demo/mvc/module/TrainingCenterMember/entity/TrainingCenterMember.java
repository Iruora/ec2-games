package com.atn.demo.mvc.module.TrainingCenterMember.entity;

import static javax.persistence.GenerationType.IDENTITY;




import java.util.Date;

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
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.user.entity.User;




@Entity
@Table(name = "APP_TRAINING_CENTER_MEMBER", uniqueConstraints = @UniqueConstraint(columnNames = "TRAINING_CENTER_MEMBER_ID"))
public class TrainingCenterMember extends ModelObject<Long>{

	public enum RoleTrainingCenter {

		DIRECTOR("ROLE_DIRECTOR"), TEACHER("ROLE_TEACHER"), STUDENT(
				"ROLE_STUDENT"), PARENT("ROLE_PARENT");
	
		protected String value;

		RoleTrainingCenter(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}
	public enum Status {

		REQUEST("REQUEST"), BLOQUED("BLOQUED"), VALIDATE(
				"VALIDATE");
	
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
	@Column(name = "TRAINING_CENTER_MEMBER_ID", unique = true, nullable = false)
	private Long tcMemberId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE")
	private RoleTrainingCenter role;
	
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "RELEASE_DATE")
	private Date releaseDate;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "MEMBER_USER_ID_FK")
	private User member;
	

	@OneToOne(fetch = FetchType.EAGER, targetEntity = TrainingCenter.class)
	@JoinColumn(name = "TRAINING_CENTER_ID_FK")
	private TrainingCenter trainingCenter;

	public TrainingCenterMember() {
		super();
	}

	
	

	

	public TrainingCenterMember(Long tcMemberId, Status status,
			RoleTrainingCenter role, Date startDate, Date releaseDate,
			User member, TrainingCenter trainingCenter) {
		super();
		this.tcMemberId = tcMemberId;
		this.status = status;
		this.role = role;
		this.startDate = startDate;
		this.releaseDate = releaseDate;
		this.member = member;
		this.trainingCenter = trainingCenter;
	}






	public TrainingCenter getTrainingCenter() {
		return trainingCenter;
	}





	public void setTrainingCenter(TrainingCenter trainingCenter) {
		this.trainingCenter = trainingCenter;
	}





	





	@Override
	public Long getId() {
		
		return getTcMemberId();
	}

	public Long getTcMemberId() {
		return tcMemberId;
	}

	public void setTcMemberId(Long tcMemberId) {
		this.tcMemberId = tcMemberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	public RoleTrainingCenter getRole() {
		return role;
	}

	public void setRole(RoleTrainingCenter role) {
		this.role = role;
	}

	
	public Date getStartDate() {
		return startDate;
	}





	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}





	public Date getReleaseDate() {
		return releaseDate;
	}





	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}





	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}

	
}
