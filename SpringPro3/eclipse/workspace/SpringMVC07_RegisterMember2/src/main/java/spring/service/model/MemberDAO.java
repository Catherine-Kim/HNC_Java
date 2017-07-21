package spring.service.model;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberDAO {
	void registerMember(MemberVO vo);
	Object idcheck(String id);
	MemberVO login(MemberVO vo);
	void updateMember(MemberVO vo);
	List<MemberVO> findByAddress(String address);
	List<String> getAddressKind();
	List<MemberVO> getAllMember();
}
