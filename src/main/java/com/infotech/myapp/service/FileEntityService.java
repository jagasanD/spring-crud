package com.infotech.myapp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.infotech.myapp.model.FileEntity;
import com.infotech.myapp.model.User;

public interface FileEntityService {
	
   public List<FileEntity> getFileList();
    public abstract FileEntity getFileById(int id);
	
	public abstract void saveOrFile(MultipartFile fileEntity);
	
	public abstract void deleteFile(FileEntity fileEntity);
	

}
