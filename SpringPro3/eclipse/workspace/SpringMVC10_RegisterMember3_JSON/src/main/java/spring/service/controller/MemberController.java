package spring.service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import spring.service.domain.MemberVO;
import spring.service.model.MemberService;

public class MemberController extends MultiActionController {
	// field
	private MemberService memberService;

	// setter
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, 
														MemberVO vo) throws Exception {
		memberService.registerMember(vo);
		return new ModelAndView("redirect:/member.do?command=getAllMember");
		// 회원가입한 애를 포함해서 회원 정보 모두 보여주는 페이지로 이동 : 전형적인 redirect 방식
	}

	public ModelAndView idcheck(HttpServletRequest request, HttpServletResponse response) 
																		throws Exception {
		return new ModelAndView("idcheck.jsp", "flag", 
										memberService.idcheck(request.getParameter("id")));
	}

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, 
									HttpSession session, MemberVO vo) throws Exception {
		String path = "login_fail.jsp";
		
		MemberVO rvo = memberService.login(vo);
		System.out.println("vo :: " + vo);		// name, address가 null
		System.out.println("rvo :: " + rvo);	// 모든 필드 다 값이 차 있는 VO
		
		if(rvo != null){	// 로그인 가능한 상태
			path = "login_ok.jsp";
			session.setAttribute("vo", rvo);
		}
		
		return new ModelAndView(path);
	}

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, 
													HttpSession session) throws Exception {
		if(session.getAttribute("vo") != null) session.invalidate();
		return new ModelAndView("index.jsp");
	}

	public ModelAndView updateMember(HttpServletRequest request, 
							HttpServletResponse response, MemberVO vo) throws Exception {
		memberService.updateMember(vo);
		request.getSession().setAttribute("vo", vo);	// 로그인되있는 사람의 정보도 바꿔야함
		return new ModelAndView("update_result.jsp");
	}
	
	public ModelAndView findByAddress(HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		return new ModelAndView("findByAddress_result.jsp", "memList", 
							memberService.findByAddress(request.getParameter("address")));
	}
	
	public ModelAndView getAddressKind(HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		return new ModelAndView("findByAddress.jsp", "list", 
														memberService.getAddressKind());
	}
	
	public ModelAndView getAllMember(HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		return new ModelAndView("allMember_result.jsp", "allList", 
															memberService.getAllMember());
	}

	public ModelAndView idcheckAjax(HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		return new ModelAndView("JsonView", "flag", 
									memberService.idcheck(request.getParameter("id")));
	}
}
