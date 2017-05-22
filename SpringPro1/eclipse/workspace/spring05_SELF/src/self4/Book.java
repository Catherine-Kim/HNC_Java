package self4;

public class Book {
	// field
	private String title;
	private String writer;
	
	// constructor
	public Book() {	}
	
	// getter & setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "Book: " + title + "(" + writer + ")";
	}
}
