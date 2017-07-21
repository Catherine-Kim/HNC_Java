package spring.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.board.domain.BoardVO;
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
		vo.setMemberVO((MemberVO)session.getAttribute("mvo"));
		System.out.println(vo);
		boardService.write(vo);
		
		return new ModelAndView("board/write_result", "bvo", vo);
	}
	
	@RequestMapping("/showList.do")
	public ModelAndView showBoardList(HttpServletRequest request, 
										HttpServletResponse response) throws Exception{
		List<BoardVO> list = boardService.getBoardListByPage(request.getParameter("page"));
		System.out.println(list + " : list from showBoardList()");
		return new ModelAndView("board/show_list", "list", list);
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
}
