package com.infotech.myapp.bean;

import org.springframework.web.multipart.MultipartFile;

public class UserBean {

	
	private int userId;
	
	private  String userName;
	
	private String password;
	
	private String email;
	
	private long fileId;
	
	public long getFileId() {
		return fileId;
	}

	public void setFileId(long l) {
		this.fileId = l;
	}

	private MultipartFile file;
	
	
	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
