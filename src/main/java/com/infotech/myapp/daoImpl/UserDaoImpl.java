package com.infotech.myapp.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infotech.myapp.bean.UserBean;
import com.infotech.myapp.dao.UserDAO;
import com.infotech.myapp.model.FileEntity;
import com.infotech.myapp.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		User user = (User) sessionFactory.getCurrentSession().load(User.class,Integer.parseInt(id));
		System.out.println(user);
		return user;
	}

	@Override
	public UserBean saveOrudate(User user) {
		//user.setFileEntity(file);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		Query query = sessionFactory.getCurrentSession().createQuery("from User order by id DESC");
		query.setMaxResults(1);
		User last = (User) query.uniqueResult();
		UserBean bean = new UserBean();
		bean.setUserId(last.getUserId());
		bean.setUserName(last.getUserName());
		bean.setEmail(last.getEmail());
		bean.setPassword(last.getPassword());
		if(last.getFileEntity()!=null) {
		bean.setFileId(last.getFileEntity().getFileId());
		}
		return bean;
		
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		
	}

}
