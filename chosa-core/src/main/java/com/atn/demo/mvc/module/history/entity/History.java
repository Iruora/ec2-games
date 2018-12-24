package com.atn.demo.mvc.module.history.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.exercice.entity.Exercice;
import com.atn.demo.mvc.module.user.entity.User;

@Entity
@Table(name = "APP_HISTORY", uniqueConstraints = @UniqueConstraint(columnNames = "HISTORY_ID"))
public class History extends ModelObject<Long> {

	public enum Status {

		PLANED("PLANED"), STARTED("STARTED"), HOLD("HOLD"), CLOSE("CLOSE");

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
	@Column(name = "HISTORY_ID", unique = true, nullable = false)
	private Long historyId;

	@Column(name = "SCORE")
	private float score;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_STUDENT_ID_FK")
	private User student;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EXERCICE_ID_FK")
	private Exercice exercice;

	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	private Status status;

	public History() {
		super();
	}

	

	public History(Long historyId, float score, User student, Exercice exercice,
			Status status) {
		super();
		this.historyId = historyId;
		this.score = score;
		this.student = student;
		this.exercice = exercice;
		this.status = status;
	}



	@Override
	public Long getId() {
		return getHistoryId();
	}

	public Long getHistoryId() {
		return historyId;
	}
	

	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public User getUser() {
		return student;
	}

	public void setUser(User student) {
		this.student = student;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

}
