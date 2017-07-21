package spring.board.model;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.board.domain.BoardVO;
import spring.board.domain.ListVO;
import spring.board.domain.PagingBean;

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
	
	public ListVO getBoardListByPage(String page) throws Exception{
		if(page==null || page=="") page = "1";	// 페이지를 정해주지 않을 경우 default는 첫페이지
		List<BoardVO> list = boardDAO.getBoardListByPage(page);
		int totalCount = boardDAO.totalCount();
		PagingBean pb = new PagingBean(totalCount, Integer.parseInt(page));
		
		return new ListVO(list, pb);
	}
	
	public void deleteBoard(String no) throws Exception{
		boardDAO.deleteBoard(no);
	}
	
	// 서버의 upload 폴더의 파일을 삭제하는 메소드
	public void deleteFile(String newfile){
		File f = new File(newfile);
		System.out.println("Delete File(" + newfile + ") :: " + f.delete());
		
	}
}
