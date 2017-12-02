package com.infotech.myapp.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infotech.myapp.dao.FileEntityDAO;
import com.infotech.myapp.model.FileEntity;
import com.infotech.myapp.model.User;
import com.infotech.myapp.service.FileEntityService;

@Service
public class FileEntityServiceImpl implements FileEntityService{

	@Autowired
	FileEntityDAO fileEntityDaoImpl;
	
	@Override
	public List<FileEntity> getFileList() {
		// TODO Auto-generated method stub
		return fileEntityDaoImpl.getFileList();
	}

	@Override
	public FileEntity getFileById(int id) {
		// TODO Auto-generated method stub
		return fileEntityDaoImpl.getFileById(id);
	}

	@Override
	public void saveOrFile(MultipartFile fileEntity) {
		// TODO Auto-generated method stub
		
		
		
		//fileEntityDaoImpl.saveOrFile(file);
		
	}

	@Override
	public void deleteFile(FileEntity fileEntity) {
		
		fileEntityDaoImpl.deleteFile(fileEntity);
		
	}

}
