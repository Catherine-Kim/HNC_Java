package model;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface MemberDao {
	
	public MemberVO findMemberById(String id)throws SQLException;
	public List<String> getAddressKindList() throws SQLException;
	public int getMemberCountByAddress(String address)throws SQLException;
	public List<MemberVO> getMemberListByAddress(String address)throws SQLException;
}
