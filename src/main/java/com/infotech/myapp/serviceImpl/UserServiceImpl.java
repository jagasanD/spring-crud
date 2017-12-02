package com.infotech.myapp.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infotech.myapp.bean.UserBean;
import com.infotech.myapp.dao.FileEntityDAO;
import com.infotech.myapp.dao.UserDAO;
import com.infotech.myapp.model.FileEntity;
import com.infotech.myapp.model.User;
import com.infotech.myapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDaoImpl;
	@Autowired
	FileEntityDAO fileEntityDao;
	
	@Override
	public List<UserBean> getUserList() {
		// TODO Auto-generated method stub
		List<UserBean>userList =new ArrayList<UserBean>();
		
		for(User user : userDaoImpl.getUserList()) {
			UserBean bean = new UserBean();
			bean.setUserId(user.getUserId());
			bean.setEmail(user.getEmail());
			bean.setPassword(user.getPassword());
			bean.setUserName(user.getUserName());
			
			FileEntity enity = user.getFileEntity();
			if(enity!=null) {
				bean.setFileId(enity.getFileId());
			}
			
			userList.add(bean);
			
		}
		
		return userList;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUserById(id);
	}

	@Override
	public UserBean saveOrudate(User user,MultipartFile fileEntity) {
		System.out.println("save udate call service---");
		try {
		if(fileEntity!=null && fileEntity.getBytes().length>1) {
			
		
		FileEntity file = new FileEntity();
		file.setFileName(fileEntity.getName());
		file.setMimeType(fileEntity.getContentType());
		user.setFileEntity(file);
		
			file.setSizeInBytes(fileEntity.getBytes());
		}
		}catch (IOException e) {
				
				e.printStackTrace();
			}
		 
		
		return userDaoImpl.saveOrudate(user);
		
	}

	@Override
	public void delete(User user) {
		userDaoImpl.delete(user);
		
	}

}
