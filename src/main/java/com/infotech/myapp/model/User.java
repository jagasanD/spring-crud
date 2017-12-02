package com.infotech.myapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.infotech.myapp.bean.UserBean;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int userId;
	
	private  String userName;
	
	private String password;
	
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	private FileEntity fileEntity;
	
	public User() {
		
	}
	
	
	public User(UserBean bean) {
		
		this.userId=bean.getUserId();
		this.userName=bean.getUserName();
		this.email=bean.getEmail();
		this.password=bean.getPassword();
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
	
	public FileEntity getFileEntity() {
		return fileEntity;
	}


	public void setFileEntity(FileEntity fileEntity) {
		this.fileEntity = fileEntity;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
	

}
