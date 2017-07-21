package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import item.Item;
import shop.Shop;


public class DetailController implements Controller{
	private Shop shop;

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
											HttpServletResponse response) throws Exception {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		
		Item item_temp = new Item();
		item_temp.setItemId(itemId);
		Item item = shop.findByPrimaryKey(item_temp);
		
		return new ModelAndView("WEB-INF/jsp/detail.jsp", "item", item);
	}
}
