package spring.service.model;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberService {
	void registerMember(MemberVO vo);
	boolean idcheck(String id);
	MemberVO login(MemberVO vo);
	void updateMember(MemberVO vo);
	List<MemberVO> findByAddress(String address);
	List<String> getAddressKind();
	List<MemberVO> getAllMember();
}
