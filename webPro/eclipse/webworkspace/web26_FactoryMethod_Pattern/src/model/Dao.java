package model;

import java.sql.SQLException;

public class Dao {
	private static Dao  dao = new Dao();
	private Dao(){}
	public static Dao getInstance(){
		return dao;
	}
	
	public NoteBook findNoteBook(String model) throws SQLException{
		System.out.println(model);
		NoteBook nb = new NoteBook(model, 120);
		return nb;
	}	
}



















