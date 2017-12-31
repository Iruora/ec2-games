package com.atn.demo.mvc.module.file.service;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.file.entity.File;


public interface FileService extends MyService<File, Long>{

	public File saveFile(MultipartFile file, Long id, String label);
	public String getUploadPath();
	public byte[] getFileAsByte(String filePath) throws IOException;
	public void downloadFile(OutputStream os, String path) throws IOException;

}
