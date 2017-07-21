package spring.service.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import spring.service.domain.MemberVO;
import spring.service.model.MemberDAO;

public class MemberDAOImpl implements MemberDAO{
	// field
	private SqlSession sqlSession;

	// setter
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void registerMember(MemberVO vo) {
		sqlSession.insert("memberMapper.registerMember", vo);
	}

	@Override
	public Object idcheck(String id) {
		return sqlSession.selectOne("memberMapper.idcheck", id);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return sqlSession.selectOne("memberMapper.login", vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("memberMapper.updateMember", vo);
	}

	@Override
	public List<MemberVO> findByAddress(String address) {
		return sqlSession.selectList("memberMapper.findByAddress", address);
	}

	@Override
	public List<String> getAddressKind() {		 
		return sqlSession.selectList("memberMapper.getAddressKind");
	}

	@Override
	public List<MemberVO> getAllMember() {
		return sqlSession.selectList("memberMapper.getAllMember");
	}

}
