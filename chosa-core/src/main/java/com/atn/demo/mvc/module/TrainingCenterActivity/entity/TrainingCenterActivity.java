package com.atn.demo.mvc.module.TrainingCenterActivity.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.TrainingCenter.entity.TrainingCenter;
import com.atn.demo.mvc.module.TrainingCenterThemeActivity.entity.TrainingCenterThemeActivity;
import com.atn.demo.mvc.module.exercice.entity.Exercice;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.user.entity.User;

@Entity
@Table(name = "APP_TRAINING_CENTER_ACTIVITY", uniqueConstraints = @UniqueConstraint(columnNames = "TRAINING_CENTER_ACTIVITY_ID"))
public class TrainingCenterActivity extends ModelObject<Long> {

	public enum Subject {

		LOGIC("Activity_LOGIC"), VISUEL("Activity_VISUEL"), SCIENCE(
				"Activity_SCIENCE"), LANGUAGE("Activity_LANGUAGE"), SOCIAL(
				"Activity_SOCIAL");

		protected String value;

		Subject(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TRAINING_CENTER_ACTIVITY_ID", unique = true, nullable = false)
	private Long tcActivityId;

	@Column(name = "ACTIVITY_NAME")
	private String activityName;

	@Column(name = "MIN_NUMBER")
	private int minNumber;

	@Column(name = "MAX_NUMBER")
	private int maxNumber;

	@Column(name = "URL_VIDEO")
	private String urlVideo;

	@Column(name = "MIN_AGE")
	private int minAge;

	@Column(name = "MAX_AGE")
	private int maxAge;

	@Column(name = "DURATION_ACTIVITY")
	private int durationActivity;
	
	@Column(name = "DESCRIPTION_ACTIVITY")
	private String descriptionActivity;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SUBJECT")
	private Subject subject;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXERCICE_ACTIVITY_ID_FK")
	private Exercice exercice;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = File.class)
	@JoinColumn(name = "DOCUMENT_ID_FK")
	private File document;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "USER_ACTIVITY_ID_FK")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TrainingCenter.class)
	@JoinColumn(name = "TRAINING_CENTER_ACTIVITY_ID_FK")
	private TrainingCenter trainingCenter;

	@OneToMany(mappedBy = "trainingCenterActivity", fetch = FetchType.LAZY)
	private List<TrainingCenterThemeActivity> listOfActivitiesThemes;

	public TrainingCenterActivity() {
		super();
	}

	@Override
	public Long getId() {

		return getTcActivityId();
	}

	public Long getTcActivityId() {
		return tcActivityId;
	}

	public void setTcActivityId(Long tcActivityId) {
		this.tcActivityId = tcActivityId;
	}

	
	
	public Subject getSubject() {
		return subject;
	}

	public String getDescriptionActivity() {
		return descriptionActivity;
	}

	public void setDescriptionActivity(String descriptionActivity) {
		this.descriptionActivity = descriptionActivity;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<TrainingCenterThemeActivity> getListOfActivitiesThemes() {
		return listOfActivitiesThemes;
	}

	public void setListOfActivitiesThemes(
			List<TrainingCenterThemeActivity> listOfActivitiesThemes) {
		this.listOfActivitiesThemes = listOfActivitiesThemes;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public int getMinNumber() {
		return minNumber;
	}

	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public int getDuration() {
		return durationActivity;
	}

	public void setDuration(int durationActivity) {
		this.durationActivity = durationActivity;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public File getDocument() {
		return document;
	}

	public void setDocument(File document) {
		this.document = document;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDurationActivity() {
		return durationActivity;
	}

	public void setDurationActivity(int durationActivity) {
		this.durationActivity = durationActivity;
	}

	public TrainingCenter getTrainingCenter() {
		return trainingCenter;
	}

	public void setTrainingCenter(TrainingCenter trainingCenter) {
		this.trainingCenter = trainingCenter;
	}

}
