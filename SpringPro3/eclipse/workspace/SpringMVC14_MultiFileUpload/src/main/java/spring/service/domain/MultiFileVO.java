package spring.service.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MultiFileVO {
	// field
	private List<MultipartFile> file;
	private String userName;
	
	// setters & getters
	public String getUserName() {
		return userName;
	}
	
	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
