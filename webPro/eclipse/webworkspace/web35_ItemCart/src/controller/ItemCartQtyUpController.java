package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;

public class ItemCartQtyUpController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		String name = request.getParameter("cartName");
		CartBiz cartbiz = new CartBiz();
		cartbiz.upCartQty(request, name);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.do");
		// 바로 jsp로 가지 않고 또 하나의 Controller를 거쳐서 jsp로 가야하므로 redirect 선택
		mv.setRedirect(true);
		
		return mv;
	}
}
