package com.atn.demo.mvc.module.templateMail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.atn.commons.entities.ModelObject;

@Entity
@Table(name = "APP_TEMPLATE_MAIL", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
public class TemplateMail extends ModelObject<Long> {
	
	public enum EMAIL_TEMPLATE {

		EmailConfirmation("EmailConfirmation"),	MotPassPerdu("MotPassePerdu")
		;

		protected String value;

		EMAIL_TEMPLATE (String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Size(max = 20)
	private Long id;
    
	@Enumerated(EnumType.STRING)
	@Column(unique = true, name = "EMAIL_KEY")
	private EMAIL_TEMPLATE emailKey;
	
	@Column(name = "OBJECT")
	@Size(max = 100)
	private String object;



	@Column(name = "BODY")
	@Size(max = 100)
	private String body;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}


	public String getBody() {
		if(body!=null)
		{
	
		String encrypted=body;
		encrypted=encrypted.replace("à", "&agrave;");
		encrypted=encrypted.replace("â", "&acirc;");
		encrypted=encrypted.replace("ç", "&ccedil;");
		encrypted=encrypted.replace("è", "&egrave;");
		encrypted=encrypted.replace("é", "&eacute;");
		encrypted=encrypted.replace("ê", "&ecirc;");
		encrypted=encrypted.replace("œ", "&oelig;");
		encrypted=encrypted.replace("ù", "&ugrave;");
		encrypted=encrypted.replace("û", "&ucirc;");
		body=encrypted;
	    }
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	
	public EMAIL_TEMPLATE getEmailKey() {
		return emailKey;
	}

	public void setEmailKey(EMAIL_TEMPLATE emailKey) {
		this.emailKey = emailKey;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {

		return id;
	}

}
