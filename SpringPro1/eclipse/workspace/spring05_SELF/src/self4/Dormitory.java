package self4;

import java.util.ArrayList;

public class Dormitory implements Residence{
	// field
	private String schoolName;
	private ArrayList<Book> library;
	
	// constructor
	public Dormitory() { }

	// getter & setter
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public ArrayList<Book> getLibrary() {
		return library;
	}

	public void setLibrary(ArrayList<Book> library) {
		this.library = library;
	}

	@Override
	public void reside() {
		System.out.println("Dormitory School :: " + schoolName);
		System.out.println("- Library :: \n" + library);
	}
}
