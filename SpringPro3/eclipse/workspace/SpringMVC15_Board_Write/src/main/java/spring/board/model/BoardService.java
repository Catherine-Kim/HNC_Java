package spring.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.board.domain.BoardVO;

@Service
public class BoardService {
	// field
	@Autowired
	private BoardDAO boardDAO;
	
	public void write(BoardVO bvo) throws Exception{
		System.out.println("no before write() : " + bvo.getNo());
		boardDAO.write(bvo);
		System.out.println("no after write() : " + bvo.getNo());
		bvo.setWriteDate(selectByNoForDate(bvo.getNo()));
	}
	
	public String selectByNoForDate(int no) throws Exception{
		return boardDAO.selectByNoForDate(no);
	}
	
	public BoardVO showContent(String no) throws Exception{
		return boardDAO.showContent(no);
	}
	
	public List<BoardVO> getBoardListByPage(String page) throws Exception{
		if(page==null || page=="") page = "1";	// 페이지를 정해주지 않을 경우 default는 첫페이지
		return boardDAO.getBoardListByPage(page);
	}
}
