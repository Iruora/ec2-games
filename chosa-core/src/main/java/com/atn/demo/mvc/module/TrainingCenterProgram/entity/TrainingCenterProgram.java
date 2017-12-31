package com.atn.demo.mvc.module.TrainingCenterProgram.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;


@Entity
@Table(name = "APP_TRAINING_CENTER_PROGRAM", uniqueConstraints = @UniqueConstraint(columnNames = "TRAINING_CENTER_PROGRAM_ID"))
public class TrainingCenterProgram extends ModelObject<Long> {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TRAINING_CENTER_PROGRAM_ID", unique = true, nullable = false)
	private Long tcProgramId;

	@Column(name = "PROGRAM_DURATION")
	private int programduration;
	
	@Column(name = "PROGRAM_NAME")
	private String programName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAINING_CENTER_PROGRAM_ID_FK")
	private TrainingCenter trainingCenterProgram;
	
	
	@OneToMany(mappedBy = "trainingCenterprogram", fetch = FetchType.LAZY)
	private List<TrainingCenterTheme> listOfTheme;
	
	@OneToMany(mappedBy = "trainingCenterprogramClass", fetch = FetchType.LAZY)
	private List<TrainingCenterClass> listOfClass;
	
	public TrainingCenterProgram() {
		super();
	}




	public TrainingCenterProgram(Long tcProgramId, int programduration,
			String programName) {
		super();
		this.tcProgramId = tcProgramId;
		this.programduration = programduration;
		this.programName = programName;
	}




	public Long getTcProgramId() {
		return tcProgramId;
	}




	public void setTcProgramId(Long tcProgramId) {
		this.tcProgramId = tcProgramId;
	}




	public int getProgramduration() {
		return programduration;
	}




	public void setProgramduration(int programduration) {
		this.programduration = programduration;
	}




	public String getProgramName() {
		return programName;
	}




	public void setProgramName(String programName) {
		this.programName = programName;
	}




	public TrainingCenter getTrainingCenterProgram() {
		return trainingCenterProgram;
	}




	public void setTrainingCenterProgram(TrainingCenter trainingCenterProgram) {
		this.trainingCenterProgram = trainingCenterProgram;
	}




	public List<TrainingCenterTheme> getListOfTheme() {
		return listOfTheme;
	}




	public void setListOfTheme(List<TrainingCenterTheme> listOfTheme) {
		this.listOfTheme = listOfTheme;
	}




	public List<TrainingCenterClass> getListOfClass() {
		return listOfClass;
	}




	public void setListOfClass(List<TrainingCenterClass> listOfClass) {
		this.listOfClass = listOfClass;
	}




	@Override
	public Long getId() {
		
		return getTcProgramId();
	}

}
