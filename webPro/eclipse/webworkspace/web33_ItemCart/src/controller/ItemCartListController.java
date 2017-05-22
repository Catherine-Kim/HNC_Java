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
		
		ArrayList<Cart> cartlist = CartBiz.getInstance().getCartList(request);
		System.out.println("[SUCCESS] getCartList() from ItemCartListController");
		
		int totalPrice = 0;
		for(Cart c : cartlist){
			totalPrice += c.getPrice() * c.getQuantity();
		}
		
		request.setAttribute("cartlist", cartlist);
		request.setAttribute("totalPrice", totalPrice);
		
		mv.setUrl("itemCartList.jsp");
		
		return mv;
	}
}
