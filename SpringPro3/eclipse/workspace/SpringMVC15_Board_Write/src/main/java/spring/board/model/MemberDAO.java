package spring.board.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.board.domain.MemberVO;

@Repository
public class MemberDAO {
	// field
	@Autowired
	private SqlSession sqlSession;
	
	public MemberVO login(MemberVO vo) throws Exception{
		return sqlSession.selectOne("memberMapper.login", vo);
	}
}
