package model;

import org.springframework.web.multipart.MultipartFile;

public class UploadDataVO {
	// field
	private MultipartFile uploadFile;
	private String userName;
	
	public UploadDataVO(){};
	
	public UploadDataVO(MultipartFile uploadFile, String userName) {
		super();
		this.uploadFile = uploadFile;
		this.userName = userName;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
