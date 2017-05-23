package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Item;
import logic.Shop;

public class IndexController implements Controller{
	// field
	private Shop shop;
	
	// setter
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		// ��� ������ ��ġ : WEB-INF/jsp/index.jsp
		// binding �ϴ� �̸��� itemList
		
		List<Item> itemList = shop.getItemList();
		
		return new ModelAndView("WEB-INF/jsp/index.jsp", "itemList", itemList);
	}
}
