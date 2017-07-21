package model;

import java.sql.SQLException;
import java.util.List;

public class MemberServiceImpl implements MemberService{
	private MemberDao memberDao;
	public MemberServiceImpl(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	@Override
	public MemberVO findMemberById(String id) throws SQLException {
		return memberDao.findMemberById(id);
	}
	@Override
	public List<String> getAddressKindList() throws SQLException {
		return memberDao.getAddressKindList();
	}
	@Override
	public int getMemberCountByAddress(String address) throws SQLException {
		return memberDao.getMemberCountByAddress(address);
	}
	@Override
	public List<MemberVO> getMemberListByAddress(String address)
			throws SQLException {
		return memberDao.getMemberListByAddress(address);
	}
		
}










