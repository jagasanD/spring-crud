package com.infotech.myapp.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infotech.myapp.dao.FileEntityDAO;
import com.infotech.myapp.model.FileEntity;
import com.infotech.myapp.model.User;

@Repository
@Transactional
public class FileEntityDaoImpl implements FileEntityDAO{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<FileEntity> getFileList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from file_entity").list();
	}

	@Override
	public FileEntity getFileById(int id) {
		// TODO Auto-generated method stub
		return (FileEntity)sessionFactory.getCurrentSession().load(FileEntity.class, id);
	}

	@Override
	public void saveOrFile(FileEntity fileEntity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(fileEntity);
	}

	@Override
	public void deleteFile(FileEntity fileEntity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(fileEntity);
	}
	

}
