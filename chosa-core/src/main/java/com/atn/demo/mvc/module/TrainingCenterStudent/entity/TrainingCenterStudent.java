package com.atn.demo.mvc.module.TrainingCenterStudent.entity;

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

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.user.entity.User;


@Entity
@Table(name = "APP_TRAINING_CENTER_STUDENT", uniqueConstraints = @UniqueConstraint(columnNames = "TRAINING_CENTER_STUDENT_ID"))
public class TrainingCenterStudent extends ModelObject<Long>{

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TRAINING_CENTER_STUDENT_ID", unique = true, nullable = false)
	private Long tcStudentId;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "STUDENT_USER_ID_FK")
	private User student;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TRAINING_CENTER_CLASS_ID_FK")
	private TrainingCenterClass tcClasse;
	
	
	
	
	public TrainingCenterStudent() {
		super();
	}

	public TrainingCenterStudent(Long tcStudentId, User student,
			TrainingCenterClass tcClasse) {
		super();
		this.tcStudentId = tcStudentId;
		this.student = student;
		this.tcClasse = tcClasse;
	}

	@Override
	public Long getId() {
		
		return getTcStudentId();
	}
	
	public Long getTcStudentId() {
		return tcStudentId;
	}



	public void setTcStudentId(Long tcStudentId) {
		this.tcStudentId = tcStudentId;
	}



	public User getStudent() {
		return student;
	}



	public void setStudent(User student) {
		this.student = student;
	}



	public TrainingCenterClass getTcClasse() {
		return tcClasse;
	}



	public void setTcClasse(TrainingCenterClass tcClasse) {
		this.tcClasse = tcClasse;
	}



	

}
