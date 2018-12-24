package com.atn.demo.mvc.module.TrainingCenterClass.entity;

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
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;
import com.atn.demo.mvc.module.user.entity.User;


@Entity
@Table(name = "APP_TRAINING_CENTER_CLASS", uniqueConstraints = @UniqueConstraint(columnNames = "TRAINING_CENTER_CLASS_ID"))
public class TrainingCenterClass extends ModelObject<Long>{

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TRAINING_CENTER_CLASS_ID", unique = true, nullable = false)
	private Long tcClassId;
	
	@Column(name = "CLASS_NAME")
	private String className;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "TEACHER_USER_ID_FK")
	private User teacher;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TrainingCenter.class)
	@JoinColumn(name = "TRAINING_CENTER_ID_FK")
	private TrainingCenter trainingCenter;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TrainingCenterProgram.class)
	@JoinColumn(name = "PROGRAM_ID_FK")
	private TrainingCenterProgram trainingCenterprogramClass;
	
	public TrainingCenterClass() {
		super();
	}

	
	


	public TrainingCenterClass(Long tcClassId, String className, User teacher,
			TrainingCenter trainingCenter,
			TrainingCenterProgram trainingCenterprogramClass) {
		super();
		this.tcClassId = tcClassId;
		this.className = className;
		this.teacher = teacher;
		this.trainingCenter = trainingCenter;
		this.trainingCenterprogramClass = trainingCenterprogramClass;
	}





	@Override
	public Long getId() {
		
		return getTcClassId();
	}

	public Long getTcClassId() {
		return tcClassId;
	}

	public void setTcClassId(Long tcClassId) {
		this.tcClassId = tcClassId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}


	public TrainingCenter getTrainingCenter() {
		return trainingCenter;
	}


	public void setTrainingCenter(TrainingCenter trainingCenter) {
		this.trainingCenter = trainingCenter;
	}





	public TrainingCenterProgram getTrainingCenterprogramClass() {
		return trainingCenterprogramClass;
	}





	public void setTrainingCenterprogramClass(
			TrainingCenterProgram trainingCenterprogramClass) {
		this.trainingCenterprogramClass = trainingCenterprogramClass;
	}

	
	
	

}
