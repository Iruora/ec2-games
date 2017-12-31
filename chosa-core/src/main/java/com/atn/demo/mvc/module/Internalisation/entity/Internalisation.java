package com.atn.demo.mvc.module.Internalisation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.langue.entity.Langue;

@Entity
@Table(name = "APP_INTERNALISATION", uniqueConstraints = @UniqueConstraint(columnNames = "ID_INTERNALISATION"))
public class Internalisation extends ModelObject<Long> implements Serializable{

	/**
	 * 
	 */
	public enum MESSAGEKEY{
		
	}
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_INTERNALISATION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInternalisation;

	
	@Column( name ="MESSAGE_KEY")
	private String messageKey;

	@OneToOne
	@JoinColumn(name = "LANGUE_ID_FK")
	private Langue langue;

	@Column(name = "TEXT")
	@Size(max = 100)
	private String text;

	private transient MESSAGEKEY messageKeyEnum;
	
	public MESSAGEKEY getMessageKey() {
		if(messageKeyEnum == null){
			setMessageKey(messageKey);
		}
		return messageKeyEnum;
	}
	
	public void setMessageKey(MESSAGEKEY messageKey) {
		this.messageKeyEnum=messageKey;
		this.messageKey = messageKey.toString();
	}
	public void setMessageKey(String messageKeyValue) {
		for(MESSAGEKEY messageKey : MESSAGEKEY.values()){
			if(messageKey.toString().equals(messageKeyValue)){
				this.messageKeyEnum=messageKey;
				this.messageKey = messageKey.toString();
			}
		}
		
	}
	
	@Override
	public Long getId() {
		
		return getId();
	}

}
