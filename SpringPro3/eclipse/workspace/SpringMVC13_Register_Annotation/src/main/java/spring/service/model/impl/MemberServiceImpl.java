package spring.service.model.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.service.domain.MemberVO;
import spring.service.model.MemberDAO;
import spring.service.model.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	// field
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		 memberDAO.registerMember(vo);
	}

	@Override
	public boolean idcheck(String id) throws SQLException {
		boolean flag = false;
		
		if(memberDAO.idcheck(id) != null) flag = true;
		
		return flag;
	}

	@Override
	public MemberVO login(MemberVO vo) throws SQLException {
		return memberDAO.login(vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		memberDAO.updateMember(vo);
	}

	@Override
	public List<MemberVO> findByAddress(String address) throws SQLException {
		return memberDAO.findByAddress(address);
	}

	@Override
	public List<String> getAddressKind() throws SQLException {
		return memberDAO.getAddressKind();
	}

	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		return memberDAO.getAllMember();
	}

}
