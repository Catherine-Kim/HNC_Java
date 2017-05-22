package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao;
import model.NoteBook;

public class ITVProduct implements Product{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		String model = request.getParameter("model");
		// Product가 HttpServletRequest를 hasing하고 있기 때문에 이렇게 쓸 수 있는 거임
		
		NoteBook notebook = Dao.getInstance().findNoteBook(model);
		
		request.setAttribute("notebooe", notebook);
		String path = "find_result.jsp";
		
		return path;
	}
}
