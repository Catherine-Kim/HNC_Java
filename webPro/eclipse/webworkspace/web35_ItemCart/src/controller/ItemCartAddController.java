package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.Cart;
import cartbiz.CartBiz;
import model.Item;
import model.ItemDao;

public class ItemCartAddController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		ModelAndView mv = new ModelAndView();
		// itemView.jsp에서 넘어온 itemnumber 받기
		int itemnumber = Integer.parseInt(request.getParameter("itemnumber"));
		
		// itemnumber로 Item 찾아서 cartlist에 추가
		Item item = ItemDao.getInstance().getItem(itemnumber);
		CartBiz cartbiz = new CartBiz();
		cartbiz.addCart(request, item);
		System.out.println("[SUCCESS] addCart() from ItemCartAddController");
		
		mv.setUrl("itemCartList.do");
		mv.setRedirect(true);
		
		return mv;
	}
}
