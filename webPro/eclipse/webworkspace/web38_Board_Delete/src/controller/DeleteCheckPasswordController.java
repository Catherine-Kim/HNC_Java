package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;

public class DeleteCheckPasswordController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response)
																	{
		int no = Integer.parseInt(request.getParameter("no"));
		String pass = request.getParameter("password");

		boolean flag = false;
		try {
			flag = BoardDao.getInstance().checkPassword(no, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("flag from DeleteCheckPasswordController :: " + flag);

		request.setAttribute("flag", flag);

		return new ModelAndView("delete_checkpass_result.jsp");
	}
}
