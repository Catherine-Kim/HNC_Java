package spring.board.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.board.domain.BoardVO;
import spring.board.domain.ListVO;
import spring.board.domain.MemberVO;
import spring.board.model.BoardDAO;
import spring.board.model.BoardService;
import spring.board.model.MemberService;

@Controller
public class BoardMemberController {
	// field
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	// file path 필드 추가
	private String path = "C:\\HNC\\KWJ\\SpringPro3\\eclipse\\workspace\\SpringMVC18_Board_FileUpload\\src\\main\\webapp\\upload\\";
	
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, 
										HttpSession session) throws Exception{
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		MemberVO rvo = memberService.login(vo);
		if(rvo != null)
			session.setAttribute("mvo", rvo);
		
		return new ModelAndView("member/login_result");
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, 
													HttpSession session) throws Exception{
		if(session.getAttribute("mvo") != null)
			session.invalidate();
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/writeBoard.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response, 
										HttpSession session, BoardVO vo) throws Exception{
		// file upload 부분 추가
		MultipartFile mFile = vo.getUploadFile(); 
		System.out.println("File Size : " + mFile.getSize());
		
		// 업로드한 파일이 있는 경우
		if(!mFile.isEmpty()){
			// orgfilename과 newfilename 구해놓기
			String orgfilename = mFile.getOriginalFilename();
			String newfilename = System.currentTimeMillis() + "_" + orgfilename;
			
			// vo에 주입
			vo.setOrgfilename(orgfilename);
			vo.setNewfilename(newfilename);
			
			// transferTo()
			File copyFile = new File(path + newfilename); //  orgfilename아니고 newfilename
			mFile.transferTo(copyFile);	
		}
		
		vo.setMemberVO((MemberVO)session.getAttribute("mvo"));
		System.out.println(vo);
		
		boardService.write(vo); // 모든 게시물의 정보가 이 때 DB에 들어감
		
		return new ModelAndView("board/write_result", "bvo", vo);
	}
	
	@RequestMapping("/showList.do")
	public ModelAndView showBoardList(HttpServletRequest request, 
										HttpServletResponse response) throws Exception{
		ListVO lvo = boardService.getBoardListByPage(request.getParameter("pageNo"));
		return new ModelAndView("board/show_list", "lvo", lvo);
	}

	@RequestMapping("/showBoard.do")
	public ModelAndView showBoard(HttpServletRequest request, HttpServletResponse response, 
													HttpSession session) throws Exception {
		if (session.getAttribute("mvo") == null)
			return new ModelAndView("redirect:/index.jsp");
		String no = request.getParameter("no");
		BoardVO rvo = boardService.showContent(no);

		return new ModelAndView("board/show_content", "bvo", rvo);
	}

	@RequestMapping("/deleteBoard.do")
	public ModelAndView deleteBoard(HttpServletRequest request, 
											HttpServletResponse response) throws Exception {
		// upload 폴더에 있는 파일 삭제
		String newfilename = request.getParameter("newfilename");
		
		if(newfilename != null){
			boardService.deleteFile(path + newfilename);
		}
		
		String no = request.getParameter("no");
		System.out.println(no + " : no from deleteBoard()");
		boardService.deleteBoard(no);
		// 특정판 뷰페이지로 연결되는 것이 아니라, 하나의 게시글이 빠진 전체 목록을 봐야함
		return new ModelAndView("redirect:/showList.do");
	}
	
	@RequestMapping("/boardDownload.do")
	public ModelAndView boardDownload(HttpServletRequest request, HttpServletResponse response) 
																				throws Exception {
		HashMap map = new HashMap();
		map.put("path", path);
		
		return new ModelAndView("downloadView", map);
		// 별도의 view 페이지가 필요한 게 아니므로 BeanNameViewResolver 사용
	}
	
	@RequestMapping("/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		String newfilename = request.getParameter("newfilename");
		System.out.println("Ajax Call...");
		
		if(newfilename != null)
			boardService.deleteFile(path + newfilename);
		
		return new ModelAndView("JsonView");
	}
}
