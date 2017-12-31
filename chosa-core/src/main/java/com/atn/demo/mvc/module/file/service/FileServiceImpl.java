package com.atn.demo.mvc.module.file.service;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.commons.utils.FileManager;
import com.atn.demo.mvc.module.file.dao.FileDao;
import com.atn.demo.mvc.module.file.entity.File;


@Component
public class FileServiceImpl extends MyAbstractService<File, Long> implements FileService{

	
	@Value("${user.file.folder}")
	private String fileOutputFolder;
	public FileServiceImpl(FileDao dataAccessObject) {
		super(dataAccessObject);
	
	}

	@Override
	public BaseDao<File, Long> getDataAccessObject() {
		
		return this.dataAccessObject;
	}
	
	@Override
	@Transactional
	public File saveFile(MultipartFile file, Long id, String label) {
		File document = null;
		if ((file != null) && (file.getOriginalFilename() != null) && (file.getOriginalFilename().length() > 0)) {
			try {
				String path = createPath(id);
				java.io.File dir = new java.io.File(fileOutputFolder + path);
				dir.mkdirs();
				java.io.File serverFile;
				String fileExtention = FileManager.getExtension(file.getOriginalFilename());
				String name=fileOutputFolder + path+file.getOriginalFilename();
				document = createFile(path,name);
				
				document.setPath(dir.getAbsolutePath());
				if ((label != null) && (!label.trim().equals(""))) {
					document.setFileName(label.trim() + "." + fileExtention);
				} else {
					document.setFileName(file.getOriginalFilename());
				}
				name= String.format("%04d", document.getId())
						+ "." + fileExtention;
				serverFile = new java.io.File(dir.getAbsolutePath() + java.io.File.separator +name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				
				document.setFileName(name);
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				System.out.println("Error Write file: " + file.getOriginalFilename());
			}
			return save(document);
		}
		return null;
	}

	


	
	public File createFile(String path,String name) {
		File document = new File();
		document.setFileName(name);
		document.setPath(path);
		return save(document);
	}
	public String createPath(Long id) {
		String name =  java.io.File.separator + String.format("%04d", id);
		Calendar now = Calendar.getInstance();
		String path = java.io.File.separator + now.get(Calendar.YEAR) + java.io.File.separator + (int) (now.get(Calendar.MONTH) + 1)
				+ java.io.File.separator + now.get(Calendar.DAY_OF_MONTH) + java.io.File.separator + name+java.io.File.separator;
		return path;
	}

	@Override
	public String getUploadPath() {
		return fileOutputFolder;
	}
	@Override
	public byte[] getFileAsByte(String filePath) throws IOException{
		Path path = Paths.get(filePath);
		byte[] picture = Files.readAllBytes(path);
		return picture;
	}

	@Override
	public void downloadFile(OutputStream os, String path) throws IOException {
		 java.io.File file = new java.io.File(path);
	        InputStream is = new FileInputStream(file);
	        byte[] buffer = new byte[1024];
	        int len;
	        while ((len = is.read(buffer)) != -1) {
	            os.write(buffer, 0, len);
	        }
	        os.flush();
	        os.close();
	        is.close();
		
	}
}
