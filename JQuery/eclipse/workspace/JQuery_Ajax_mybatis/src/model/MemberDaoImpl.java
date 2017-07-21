package model;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDaoImpl implements MemberDao{
	
	private SqlSessionTemplate sqlSession;

	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public MemberVO findMemberById(String id) throws SQLException {
		return (MemberVO)sqlSession.selectOne("Member.findMemberById",id);
	}

	@Override
	public List<String> getAddressKindList() throws SQLException {
		return sqlSession.selectList("Member.getAddressKindList");
	}

	@Override
	public int getMemberCountByAddress(String address) throws SQLException {
		return (int)sqlSession.selectOne("Member.getMemberCountByAddress",address);
	}

	@Override
	public List<MemberVO> getMemberListByAddress(String address)
			throws SQLException {
		return sqlSession.selectList("Member.getMemberListByAddress",address);
	}

	
		
}













