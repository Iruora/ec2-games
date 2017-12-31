package com.atn.demo.mvc.module.TrainingCenterThemeActivity.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity;
import com.atn.demo.mvc.module.TrainingCenterTheme.entity.TrainingCenterTheme;


@Entity
@Table(name = "APP_TRAINING_CENTER_THEME_ACTIVITY", uniqueConstraints = @UniqueConstraint(columnNames = "TRAINING_CENTER_THEME_ACTIVITY_ID"))
public class TrainingCenterThemeActivity extends ModelObject<Long>{


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TRAINING_CENTER_THEME_ACTIVITY_ID", unique = true, nullable = false)
	private Long tcThemeActivityId;
	
	@Column(name = "THEME_ORDRE")
	private int themeOrdre;
	
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = TrainingCenterTheme.class)
	@JoinColumn(name = "THEME_ID_FK")
	private TrainingCenterTheme trainingCenterThemeActivity;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = TrainingCenterActivity.class)
	@JoinColumn(name = "ACTIVITY_ID_FK")
	private TrainingCenterActivity trainingCenterActivity;

	
	
	@Override
	public Long getId() {
		
		return null;
	}



	public TrainingCenterThemeActivity() {
		super();
	}



	public Long getTcThemeActivityId() {
		return tcThemeActivityId;
	}



	public void setTcThemeActivityId(Long tcThemeActivityId) {
		this.tcThemeActivityId = tcThemeActivityId;
	}



	public int getThemeOrdre() {
		return themeOrdre;
	}



	public void setThemeOrdre(int themeOrdre) {
		this.themeOrdre = themeOrdre;
	}



	public TrainingCenterTheme getTrainingCenterThemeActivity() {
		return trainingCenterThemeActivity;
	}



	public void setTrainingCenterThemeActivity(
			TrainingCenterTheme trainingCenterThemeActivity) {
		this.trainingCenterThemeActivity = trainingCenterThemeActivity;
	}



	public TrainingCenterActivity getTrainingCenterActivity() {
		return trainingCenterActivity;
	}



	public void setTrainingCenterActivity(
			TrainingCenterActivity trainingCenterActivity) {
		this.trainingCenterActivity = trainingCenterActivity;
	}



	




}
