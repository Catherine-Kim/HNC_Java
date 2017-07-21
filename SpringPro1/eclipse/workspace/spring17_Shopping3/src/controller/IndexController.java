package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.Shop;

@Controller
public class IndexController{
	// field
	@Autowired
	private Shop shop;

	
	@RequestMapping("/index.do")
	public ModelAndView handleRequest() {
		// 결과 페이지 위치 : WEB-INF/jsp/index.jsp
		// binding 하는 이름은 itemList
		
		List<Item> itemList = shop.getItemList();
		
		return new ModelAndView("WEB-INF/jsp/index.jsp", "itemList", itemList);
	}
}
