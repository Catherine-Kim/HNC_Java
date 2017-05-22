package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.Cart;
import cartbiz.CartBiz;

public class ItemCartListController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		ModelAndView mv = new ModelAndView();
		
		CartBiz cartbiz = new CartBiz();
		ArrayList<Cart> cartList = cartbiz.getCartList(request);
		System.out.println("[SUCCESS] getcartList() from ItemcartListController");
		
		int sumMoney = 0;
		for(Cart c : cartList){
			sumMoney += c.getPrice() * c.getQuantity();
		}
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("sumMoney", sumMoney);
		
		mv.setUrl("itemCartList.jsp");
		
		return mv;
	}
}
