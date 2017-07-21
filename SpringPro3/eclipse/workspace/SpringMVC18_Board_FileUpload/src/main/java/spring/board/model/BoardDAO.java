package spring.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.board.domain.BoardVO;

@Repository
public class BoardDAO {
	// field
	@Autowired
	private SqlSession sqlSession;
	
	public int write(BoardVO bvo) throws Exception{
		return sqlSession.insert("boardMapper.write", bvo);
	}
	
	public String selectByNoForDate(int no) throws Exception{
		return sqlSession.selectOne("boardMapper.selectByNoForDate", no);
	}
	
	public BoardVO showContent(String no) throws Exception{
		return sqlSession.selectOne("boardMapper.showContent", no);
	}
	
	public List<BoardVO> getBoardListByPage(String page) throws Exception{
		return sqlSession.selectList("boardMapper.getBoardList", page);
	}
	
	public void deleteBoard(String no) throws Exception{
		System.out.println(no + " : no from deleteBoard() from BoardDAO");
		sqlSession.delete("boardMapper.deleteBoard", no);
	}
	
	public int totalCount() throws Exception{
		return sqlSession.selectOne("boardMapper.totalCount");
	}
}