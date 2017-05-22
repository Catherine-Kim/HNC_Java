package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cartbiz.CartBiz;

public class ItemCartRemoveController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		String[] names = request.getParameterValues("delete");
		
		CartBiz cartbiz = new CartBiz();
		cartbiz.removeCartItem(request, names);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.do");
		mv.setRedirect(true);
		
		return mv;
	}
}
