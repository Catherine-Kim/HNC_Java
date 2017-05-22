package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookDao;
import model.BookVO;

public class RegisterController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// 1. form에 입력된 값 받기
		// 2. BookVO 생성
		// 3. BookDAO의 posting() 호출 (여기서는 Service Layer를 거칠 필요가 없음)
		// 4. binding
		// 5. navigation
		
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookVO vo = new BookVO(title, price);
		
		BookDao.getInstance().posting(vo);
		
		request.setAttribute("bvo", vo);
		
		return new ModelAndView("register_result.jsp");			
	}
}













