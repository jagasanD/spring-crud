package com.infotech.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file_entity")
public class FileEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int fileId;
	/*@Column(unique = true)
	private String documentId;*/

	private String fileName;

	@Column(columnDefinition="mediumblob")
	private byte[] sizeInBytes;

	private String mimeType;

	private Boolean isDeleted = Boolean.FALSE;

/*	@ManyToOne
	private User uploadedBy;*/

	public long getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getSizeInBytes() {
		return sizeInBytes;
	}

	public void setSizeInBytes(byte[] bs) {
		this.sizeInBytes = bs;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/*public User getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(User uploadedBy) {
		this.uploadedBy = uploadedBy;
	}*/
	
	

	
	

}
