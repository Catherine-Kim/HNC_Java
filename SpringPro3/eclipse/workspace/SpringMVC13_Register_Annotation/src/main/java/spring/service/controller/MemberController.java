package spring.service.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import spring.service.domain.MemberVO;
import spring.service.model.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, MemberVO vo)
			throws Exception {
		memberService.registerMember(vo);
		return new ModelAndView("redirect:/member.do?command=getAllMember");
	}
	
	@RequestMapping("")
	public ModelAndView idcheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean flag = memberService.idcheck(request.getParameter("id"));
		return new ModelAndView("idcheck", "flag", flag);
	}

	// idcheckAjax
	@RequestMapping("")
	public ModelAndView idcheckAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean flag = memberService.idcheck(request.getParameter("id"));
		return new ModelAndView("JsonView", "flag", flag);
	}
	
	@RequestMapping("")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			MemberVO vo) throws Exception {
		String path = "login_fail";

		MemberVO rvo = memberService.login(vo);
		System.out.println("vo :: " + vo);// name, address는 null
		System.out.println("rvo :: " + rvo);// 전부 다 값이 있다

		// 이 부분이 중요
		if (rvo != null) {// 로그인이 됬다면
			session.setAttribute("vo", rvo);
			path = "login_ok";
		}
		return new ModelAndView(path);
	}
	
	@RequestMapping("")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		if (session.getAttribute("vo") != null)
			session.invalidate();

		return new ModelAndView("index");
	}

	@RequestMapping("")
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response, MemberVO vo)
			throws Exception {
		memberService.updateMember(vo);
		request.getSession().setAttribute("vo", vo);
		return new ModelAndView("update_result");
	}

	@RequestMapping("")
	public ModelAndView findByAddress(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MemberVO> list = memberService.findByAddress(request.getParameter("address"));
		return new ModelAndView("findByAddress_result", "memList", list);
	}

	@RequestMapping("")
	public ModelAndView getAddressKind(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<String> list = memberService.getAddressKind();

		return new ModelAndView("findByAddress", "list", list);
	}

	@RequestMapping("")
	public ModelAndView getAllMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MemberVO> list = memberService.getAllMember();
		return new ModelAndView("allMember_result", "allList", list);
	}
}
