package com.atn.demo.mvc.module.TrainingCenterTheme.entity;

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
import com.atn.demo.mvc.module.TrainingCenterProgram.entity.TrainingCenterProgram;
import com.atn.demo.mvc.module.TrainingCenterThemeActivity.entity.TrainingCenterThemeActivity;


@Entity
@Table(name = "APP_TRAINING_CENTER_THEME", uniqueConstraints = @UniqueConstraint(columnNames = "TRAINING_CENTER_THEME_ID"))
public class TrainingCenterTheme extends ModelObject<Long>{

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TRAINING_CENTER_THEME_ID", unique = true, nullable = false)
	private Long tcThemeId;

	
	
	@Column(name = "THEME_NAME")
	private String themeName;
	
	
	@Column(name = "THEME_DESCRIPTION")
	private String themeDescription;

	@Column(name = "THEME_ORDRE")
	private int  themeOrdre;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TrainingCenterProgram.class)
	@JoinColumn(name = "PROGRAM_THEME_ID_FK")
	private TrainingCenterProgram trainingCenterprogram;
	
	@OneToMany(mappedBy = "trainingCenterThemeActivity", fetch = FetchType.LAZY)
	private List<TrainingCenterThemeActivity> listOfThemeActivites;
	
	
	public TrainingCenterTheme() {
		super();
	}




	public Long getTcThemeId() {
		return tcThemeId;
	}








	public void setTcThemeId(Long tcThemeId) {
		this.tcThemeId = tcThemeId;
	}




	public String getThemeName() {
		return themeName;
	}




	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}








	public List<TrainingCenterThemeActivity> getListOfThemeActivites() {
		return listOfThemeActivites;
	}




	public void setListOfThemeActivites(
			List<TrainingCenterThemeActivity> listOfThemeActivites) {
		this.listOfThemeActivites = listOfThemeActivites;
	}




	public String getThemeDescription() {
		return themeDescription;
	}




	public void setThemeDescription(String themeDescription) {
		this.themeDescription = themeDescription;
	}




	public int getThemeOrdre() {
		return themeOrdre;
	}




	public void setThemeOrdre(int themeOrdre) {
		this.themeOrdre = themeOrdre;
	}




//	public TrainingCenterProgram getTrainingCenterTheme() {
//		return trainingCenterprogram;
//	}
//
//
//
//
//	public void setTrainingCenterTheme(TrainingCenterProgram trainingCenterprogram) {
//		this.trainingCenterprogram = trainingCenterprogram;
//	}




	@Override
	public Long getId() {
		
		return getTcThemeId();
	}




	public TrainingCenterProgram getTrainingCenterprogram() {
		return trainingCenterprogram;
	}




	public void setTrainingCenterprogram(TrainingCenterProgram trainingCenterprogram) {
		this.trainingCenterprogram = trainingCenterprogram;
	}

}
