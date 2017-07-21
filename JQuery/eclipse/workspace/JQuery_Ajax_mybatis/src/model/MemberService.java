package model;

import java.sql.SQLException;
import java.util.List;

public interface MemberService {
	public MemberVO findMemberById(String id)throws SQLException;
	public List<String> getAddressKindList() throws SQLException;
	public int getMemberCountByAddress(String address)throws SQLException;
	public List<MemberVO> getMemberListByAddress(String address)throws SQLException;
}
