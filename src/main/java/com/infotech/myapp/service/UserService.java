package com.infotech.myapp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.infotech.myapp.bean.UserBean;
import com.infotech.myapp.model.User;

public interface UserService {

public abstract List<UserBean> getUserList();
	
	public abstract User getUserById(String id);
	
	public abstract UserBean saveOrudate(User user,MultipartFile file);
	
	public abstract void delete(User user);
}
