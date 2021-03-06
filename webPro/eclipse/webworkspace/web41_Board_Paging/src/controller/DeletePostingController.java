package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;

public class DeletePostingController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response)
																	 {
		int no = Integer.parseInt(request.getParameter("no"));
		try {
			BoardDao.getInstance().deletePosting(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String path = "DispatcherServlet?command=list";
		return new ModelAndView(path, true);
	}
}
