package com.atn.demo.mvc.module.file.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.atn.commons.entities.ModelObject;
import com.atn.demo.mvc.module.user.entity.User;


@Entity
@Table(name = "APP_FILE", uniqueConstraints = @UniqueConstraint(columnNames = "FILE_ID"))
public class File extends ModelObject<Long>{

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FILE_ID", unique = true, nullable = false)
	private long fileId;
	
	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "PATH")
	private String path;
	
		
	public File() {
		super();
	}

	public File(long fileId, String fileName, String path, User user) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.path = path;
	}

	@Override
	public Long getId() {
		return getFileId();
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	

}
