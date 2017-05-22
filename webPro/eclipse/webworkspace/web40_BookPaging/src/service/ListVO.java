package service;

import java.util.ArrayList;

import model.BookVO;
import model.PagingBean;

/*
 * 페이징 처리에서 사용될 VO
 * Service Layer에서 특정한 페이지(1PAGE)의 게시물을 저장하는  VO 객체
 * 해당 VO클래스는 특정한 페이지 정보와 / 특정 페이지의 책 리스트정보를 저장하는 클래스
 */
public class ListVO {
	private ArrayList<BookVO> list;
	private PagingBean pb;
	
	public ListVO(ArrayList<BookVO> list, PagingBean pb) {
		super();
		this.list = list;
		this.pb = pb;
	}
	public ListVO() {	}
	public ArrayList<BookVO> getList() {
		return list;
	}
	public void setList(ArrayList<BookVO> list) {
		this.list = list;
	}
	public PagingBean getPb() {
		return pb;
	}
	public void setPb(PagingBean pb) {
		this.pb = pb;
	}
	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pb=" + pb + "]";
	}	
}


















