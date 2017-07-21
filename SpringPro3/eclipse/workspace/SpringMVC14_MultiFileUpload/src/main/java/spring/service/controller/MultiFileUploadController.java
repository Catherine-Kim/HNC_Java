package spring.service.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.service.domain.MultiFileVO;

@Controller
public class MultiFileUploadController {
	// field
	private String path = "C:\\HNC\\KWJ\\SpringPro3\\eclipse\\workspace\\SpringMVC14_MultiFileUpload\\src\\main\\webapp\\upload\\";
	
	@RequestMapping("multifile.do")
	public ModelAndView multiFileUpload(HttpServletRequest request, 
							HttpServletResponse response, MultiFileVO vo) throws Exception{
		// 1. upload된 파일을 받아오기 (리턴값 주의, 파일 3개 주의)
		List<MultipartFile> mList = vo.getFile();
		String[] nameList = new String[mList.size()];
		
		int index = 0;
	    	for(MultipartFile m : mList){
			System.out.println(index + ". " + m);
			
			// 2. 파일 각각의 이름, 사이즈 출력
			String fileName = m.getOriginalFilename();
			long fileSize = m.getSize();
			System.out.println("- File Name : " + fileName);
			System.out.println("- File Size : " + fileSize);
			
			// 3. 각각의 업로드한 파일들을 특정한 경로로 transfer 시키기
			m.transferTo(new File(path + fileName));
			nameList[index++] = fileName;
		}
		
		// 4. Navigation : multi_upload_result.jsp, Binding : file 이름 세 개
		return new ModelAndView("multi_upload_result", "fileNames", nameList);
	}
	
	@RequestMapping("download.do")
	public ModelAndView multiFileDownload(HttpServletRequest request, 
										HttpServletResponse response) throws Exception{
		System.out.println("File Download :: " + request.getParameter("filename"));
		
		HashMap map = new HashMap();
		map.put("path", path);
		
		return new ModelAndView("downloadView", map);
	}
}
