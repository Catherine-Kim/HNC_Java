package model;

public interface StringQuery {

	// 게시글 작성하는 쿼리문
	String INSERT_POSTING = 
	"insert into board (no, title, writer, password, content, time_Posted)"	// hits 제외
	+ " values(board_seq.nextval, ?, ?, ?, ?, sysdate)";
	
	// 현재 게시글의 no 받아오는 쿼리문
	String CURRENT_NO = "select board_seq.currval from dual";
	
	// 특정한 게시글의 내용을 받아오는 쿼리문
	String SELECT_POSTING = "select no, title, writer, content, hits, time_posted"
														+ " from board where no = ?";
	
	String PAGE_LIST = "select no, title, writer, "
						+ "to_char(time_posted, 'yyyy.mm.dd') time_posted, "
					    + "hits from board";
	
	String PASS_CHECK = "select count(-1) from board where no = ? and password = ?";
	// 해당하는 row 수 리턴
	
	String DELETE_POSTING = "delete from board where no = ?";
}


















