package spring.service.model.impl;

import java.util.List;

import spring.service.domain.MemberVO;
import spring.service.model.MemberDAO;
import spring.service.model.MemberService;

public class MemberServiceImpl implements MemberService{
	// field
	private MemberDAO memberDAO;

	// setter
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void registerMember(MemberVO vo) {
		memberDAO.registerMember(vo);
	}

	@Override
	public boolean idcheck(String id) {
		boolean result = false;
		if(memberDAO.idcheck(id) != null) result = true;
		return result;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return memberDAO.login(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		 memberDAO.updateMember(vo);
	}

	@Override
	public List<MemberVO> findByAddress(String address) {
		return memberDAO.findByAddress(address);
	}

	@Override
	public List<String> getAddressKind() {
		return memberDAO.getAddressKind();
	}

	@Override
	public List<MemberVO> getAllMember() {
		return memberDAO.getAllMember();
	}

}
