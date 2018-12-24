package com.atn.demo.mvc.module.reviews.entity;

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
import javax.validation.constraints.Size;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.exercice.entity.Exercice;
import com.atn.demo.mvc.module.user.entity.User;


@Entity
@Table(name = "APP_REVIEWS", uniqueConstraints = @UniqueConstraint(columnNames = "REVIEWS_ID"))

public class Reviews extends ModelObject<Long>{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "REVIEWS_ID", unique = true, nullable = false)
	private Long reviewsId;
	
	@Size(max = 1)
	@Column(name = "SCORE")
	private int score;
	
	
	@Column(name = "MESSAGE")
	private String message;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID_FK")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EXERCICE_ID_FK")
	private Exercice exercice;

	
	
	
	
	public Reviews() {
		super();
	}

	public Reviews(long reviewsId, int score, User user, Exercice exercice) {
		super();
		this.reviewsId = reviewsId;
		this.score = score;
		this.user = user;
		this.exercice = exercice;
	}

	@Override
	public Long getId() {
		return getReviewsId();
	}

	public Long getReviewsId() {
		return reviewsId;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setReviewsId(Long reviewsId) {
		this.reviewsId = reviewsId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	
}
