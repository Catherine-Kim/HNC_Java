package model;

public class BookVO {
	private int bookNo;
	private String title;
	private int price;
	
	public BookVO(int bookNo, String title, int price) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.price = price;
	}
	public BookVO() {		
	}
	public BookVO(String title, int price) {
		super();		
		this.title = title;
		this.price = price;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookVO [bookNo=" + bookNo + ", title=" + title + ", price="
				+ price + "]";
	}
	
}










