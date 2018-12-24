package com.atn.demo.mvc.module.langue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.atn.commons.entities.ModelObject;


@Entity
@Table(name="APP_LANGUAGE",uniqueConstraints=@UniqueConstraint(columnNames="ID_LANGUE"))
public class Langue extends ModelObject<Integer>{

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Size(max=20)
	@Column(name="ID_LANGUE")
	private Integer idLangue;
	
	@Column(name="LANGUE_LIBELLE")
	@Size(max=50)
	private String langueLibelle ;
	
	
	
	@Override
	public Integer getId() {
		return getId();
	}



	public Integer getIdLangue() {
		return idLangue;
	}



	public void setIdLangue(Integer idLangue) {
		this.idLangue = idLangue;
	}



	public String getLangueLibelle() {
		return langueLibelle;
	}



	public void setLangueLibelle(String langueLibelle) {
		this.langueLibelle = langueLibelle;
	}
	

}
