package spring.board.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.board.domain.MemberVO;

@Service
public class MemberService {
	// field
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberVO login(MemberVO vo) throws Exception{
		return memberDAO.login(vo);
	}
}
