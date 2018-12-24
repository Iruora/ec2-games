package com.atn.demo.mvc.module.TrainingCenterAgenda.entity;

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
import com.atn.demo.mvc.module.TrainingCenterActivity.entity.TrainingCenterActivity;
import com.atn.demo.mvc.module.TrainingCenterClass.entity.TrainingCenterClass;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.exercice.entity.Exercice;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.user.entity.User;


@Entity
@Table(name = "APP_TRAINING_CENTER_AGENDA", uniqueConstraints = @UniqueConstraint(columnNames = "TRAINING_CENTER_AGENDA_ID"))
public class TrainingCenterAgenda extends ModelObject<Long>{

	public enum StatusAgenda {

		PLANNED("PLANNED"), STARTED("STARTED"), HOLD(
				"HOLD"), STOPPED("STOPPED");

		protected String value;

		StatusAgenda(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}
	
	
	public enum Subject {

		LOGIC("LOGIC"), VISUEL("VISUEL"), SCIENCE(
				"SCIENCE"), LANGUAGE("LANGUAGE"),SOCIAL("SOCIAL");

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
	@Column(name = "TRAINING_CENTER_AGENDA_ID", unique = true, nullable = false)
	private Long tcAgendaId;
	
	@Column(name = "EVENT_DATE")
	private Date  eventDate;
	
	@Column(name = "START_HOUR")
	private Date  startHour;
	
	@Column(name = "END_HOUR")
	private Date  endHour;
	
	@Column(name = "PLANNED_Number")
	private int  plannedNumber;
	
	@Column(name = "MIN_AGE")
	private int  minAge;
	
	@Column(name = "MAX_AGE")
	private int  maxAge;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_AGENDA")
	private StatusAgenda status;
	
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "USER_AGENDA_ID_FK")
	private User user;
	
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = TrainingCenterMember.class)
	@JoinColumn(name = "TEACHER_AGENDA_ID_FK")
	private TrainingCenterMember teacher;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = File.class)
	@JoinColumn(name = "DOCUMENT_AGENDA_ID_FK")
	private File document;
	
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = TrainingCenterActivity.class)
	@JoinColumn(name = "ACTIVITY_ID_FK")
	private TrainingCenterActivity activity;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = TrainingCenterClass.class)
	@JoinColumn(name = "CLASS_ID_FK")
	private TrainingCenterClass classe;
	
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "EXERCICE_AGENDA_ID_FK")
	private Exercice exercice;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = File.class)
	@JoinColumn(name = "FILE_AGENDA_ID_FK")
	private File video;
	
	
	
	
	public TrainingCenterAgenda() {
		super();
	}


	@Override
	public Long getId() {
		
		return getTcAgendaId();
	}


	public Long getTcAgendaId() {
		return tcAgendaId;
	}


	public void setTcAgendaId(Long tcAgendaId) {
		this.tcAgendaId = tcAgendaId;
	}


	public Date getEventDate() {
		return eventDate;
	}


	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}


	public Date getStartHour() {
		return startHour;
	}


	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}


	public Date getEndHour() {
		return endHour;
	}


	public void setEndHour(Date endHour) {
		this.endHour = endHour;
	}


	public int getPlannedNumber() {
		return plannedNumber;
	}


	public void setPlannedNumber(int plannedNumber) {
		this.plannedNumber = plannedNumber;
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


	public StatusAgenda getStatus() {
		return status;
	}


	public void setStatus(StatusAgenda status) {
		this.status = status;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	


	public TrainingCenterMember getTeacher() {
		return teacher;
	}


	public void setTeacher(TrainingCenterMember teacher) {
		this.teacher = teacher;
	}


	public File getDocument() {
		return document;
	}


	public void setDocument(File document) {
		this.document = document;
	}


	public TrainingCenterActivity getActivity() {
		return activity;
	}


	public void setActivity(TrainingCenterActivity activity) {
		this.activity = activity;
	}


	public TrainingCenterClass getClasse() {
		return classe;
	}


	public void setClasse(TrainingCenterClass classe) {
		this.classe = classe;
	}


	public Exercice getExercice() {
		return exercice;
	}


	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}


	public File getVideo() {
		return video;
	}


	public void setVideo(File video) {
		this.video = video;
	}

	
}
