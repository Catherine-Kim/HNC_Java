package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import item.Item;
import shop.Shop;

@Controller
public class IndexController{
	// field
	@Autowired
	private Shop shop;
	
	/*// setter
	public void setShop(Shop shop) {
		this.shop = shop;
	}*/
	@RequestMapping("/index.do")
	public ModelAndView handleRequest(HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		// ��� ������ ��ġ : WEB-INF/jsp/index.jsp
		// binding �ϴ� �̸��� itemList
		
		List<Item> itemList = shop.getItemList();
		System.out.println(itemList + " from indexcontroller");
		
		return new ModelAndView("WEB-INF/jsp/index.jsp", "itemList", itemList);
	}
}
