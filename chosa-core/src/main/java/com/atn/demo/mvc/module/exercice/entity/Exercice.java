package com.atn.demo.mvc.module.exercice.entity;

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
import com.atn.demo.mvc.module.category.entity.Category;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.user.entity.User;


@Entity
@Table(name = "APP_EXERCICE", uniqueConstraints = @UniqueConstraint(columnNames = "EXERCICE_ID"))
public class Exercice extends ModelObject<Long> {

	public enum StatusExercice {

		ACTIF("EXERCICE_ACTIF"), INACTIF("EXERCICE_IACTIF"), DRAFT(
				"EXERCICE_DRAFT");

		protected String value;

		StatusExercice(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}
	public enum Visibility {

		PUBLIC("VISIBILITY_PUBLIC"), PRIVATE("VISIBILITY_PRIVATE");

		protected String value;

		Visibility(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EXERCICE_ID", unique = true, nullable = false)
	private Long exerciceId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LEVEL")
	private float level;

	@Column(name = "URL")
	private String url;

	@Column(name = "URL_CALLBACK")
	private String urlCallback;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	private StatusExercice status;

	@Enumerated(EnumType.STRING)
	@Column(name = "VISIBILITY")
	private Visibility visibility;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_EXECICE_ID_FK")
	private User user;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PICTURE_ID_FK")
	private File  picture;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXERCICE_FILE_ID_FK")
	private File  fileExecrice;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID_FK")
	private Category  categtory;
	
	
	
	
	
	public Exercice() {
		super();
	}

	public Exercice(Long exerciceId, String name, float level, String url,
			String urlCallback, StatusExercice status, User user, File picture,
			File fileExecrice, Category categtory) {
		super();
		this.exerciceId = exerciceId;
		this.name = name;
		this.level = level;
		this.url = url;
		this.urlCallback = urlCallback;
		this.status = status;
		this.user = user;
		this.picture = picture;
		this.fileExecrice = fileExecrice;
		this.categtory = categtory;
	}

	@Override
	public Long getId() {

		return getExerciceId();
	}

	public Long getExerciceId() {
		return exerciceId;
	}

	public void setExerciceId(Long exerciceId) {
		this.exerciceId = exerciceId;
	}

	
	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLevel() {
		return level;
	}

	public void setLevel(float level) {
		this.level = level;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlCallback() {
		return urlCallback;
	}

	public void setUrlCallback(String urlCallback) {
		this.urlCallback = urlCallback;
	}

	public StatusExercice getStatus() {
		return status;
	}

	public void setStatus(StatusExercice status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public File getFileExecrice() {
		return fileExecrice;
	}

	public void setFileExecrice(File fileExecrice) {
		this.fileExecrice = fileExecrice;
	}

	public Category getCategtory() {
		return categtory;
	}

	public void setCategtory(Category categtory) {
		this.categtory = categtory;
	}

	
}
