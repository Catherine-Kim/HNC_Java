package controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import model.UploadDataVO;

public class UploadController extends MultiActionController{
	// field
	private String path;

	// setter
	public void setPath(String path) {
		this.path = path;
	}
	
	public ModelAndView FileUpload(HttpServletRequest request, 
							HttpServletResponse response, UploadDataVO vo) throws Exception{
		
		// 1. upload된 파일을 받아온다.
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("File(vo.getUploadFile()) :: " + mFile);
		
		// 2. 업로드된 파일이 있다면
		if(!mFile.isEmpty()){	
			// mFile의 원래 이름과 사이즈를 출력해보자
			System.out.println("File Name :: " + mFile.getName());
			System.out.println("File Name(Original File Name) :: " + mFile.getOriginalFilename());
			System.out.println("File Size :: " + mFile.getSize());
		}
		
		// 3. 업로드된 파일을 별도의 경로(webapp/upload/)로 이동
		File copyFile = new File(path + mFile.getOriginalFilename());
		mFile.transferTo(copyFile);		// 원래 내가 업로드한 파일이
		System.out.println("Path :: " + path);
		
		return new ModelAndView("upload_result", "uploadFile", mFile.getOriginalFilename());
		// 파일 이름 한 번 찍어보려고 
	}
	
	public ModelAndView fileDown(HttpServletRequest request, 
											HttpServletResponse response) throws Exception{
		System.out.println("File Download 실행 :: " + request.getParameter("filename"));
		
		HashMap map = new HashMap();
		map.put("path", path);	// upload 폴더에 저장된 파일 다운로드
		
		return new ModelAndView("downloadView", map);
	}
	
}
