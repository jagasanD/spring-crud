package com.infotech.myapp.dao;

import java.util.List;

import com.infotech.myapp.bean.UserBean;
import com.infotech.myapp.model.FileEntity;
import com.infotech.myapp.model.User;

public interface UserDAO {

	public abstract List<User> getUserList();
	
	public abstract User getUserById(String id);
	
	public abstract UserBean saveOrudate(User user);
	
	public abstract void delete(User user);
	
	
	
	
	
}
