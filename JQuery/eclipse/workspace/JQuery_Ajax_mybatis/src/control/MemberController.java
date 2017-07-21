package control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberService;
import model.MemberVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController{
	private MemberService memberService;
	
	public MemberController(MemberService memberService){
		this.memberService = memberService;
	}
	
	//findMemberById
	public ModelAndView findMemberById(HttpServletRequest reqeust, HttpServletResponse response)
					throws Exception{
		String id=reqeust.getParameter("id");
		MemberVO rvo=memberService.findMemberById(id);
		return new ModelAndView("find_result","mvo",rvo);
	}
	//getAddressList
	public ModelAndView getAddressList(HttpServletRequest reqeust, HttpServletResponse response)
			throws Exception{
		List<String> list=memberService.getAddressKindList();
		return new ModelAndView("address","addressList",list);
	}
	//getMemberCountByAddress
	public ModelAndView getMemberCountByAddress(HttpServletRequest reqeust, HttpServletResponse response)
			throws Exception{
		String address=reqeust.getParameter("address");
		int count=memberService.getMemberCountByAddress(address);
		System.out.println("count : " + count);
		return new ModelAndView("JsonView","count",count);
	}
	//getAddressKindList
	public ModelAndView getAddressKindList(HttpServletRequest reqeust, HttpServletResponse response)
			throws Exception{
		String address=reqeust.getParameter("address");
		List<MemberVO> list=memberService.getMemberListByAddress(address);
		return new ModelAndView("JsonView","memList",list);
	}
	
	//getAddressKindList
	public ModelAndView getMemberListByAddress(HttpServletRequest reqeust, HttpServletResponse response)
																		throws Exception{
		String address=reqeust.getParameter("address");
		System.out.println("address : " + address);
		List<MemberVO> list=memberService.getMemberListByAddress(address);
		System.out.println(list);
		return new ModelAndView("JsonView","memList",list);
	}
}















