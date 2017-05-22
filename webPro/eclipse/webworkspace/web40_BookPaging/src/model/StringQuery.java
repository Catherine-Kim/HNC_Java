package model;

public interface StringQuery {
	//Book Inert...
	String INSERT_BOOK=
			"insert into book(book_no, title, price) values(book_seq.nextval, ?, ?)";
			
	//현재 no를 조회
	String CURRENT_NO="select book_seq.currval from dual";

	//특정 페이지당 Book List가져오기....CommonConstants.CONTENT_NUMBER_PER_PAGE사용해서 작성
	String BOOK_LIST="SELECT book_no, title, price FROM ("
			+ "SELECT book_no, title, price, CEIL(rownum/"
			+ CommonConstants.CONTENT_NUMBER_PER_PAGE + ") Page FROM (SELECT book_no, title, price FROM book "	
			+ "ORDER BY book_no DESC))WHERE page = ?";

	//전체 책 수량
	String TOTAL_COUNT="select count(-1) from book;";									
}











