package com.infotech.myapp.dao;

import java.util.List;

import com.infotech.myapp.model.FileEntity;

public interface FileEntityDAO {

public abstract List<FileEntity> getFileList();
	
	public abstract FileEntity getFileById(int id);
	
	public abstract void saveOrFile(FileEntity fileEntity);
	
	public abstract void deleteFile(FileEntity fileEntity);
	
	
}
