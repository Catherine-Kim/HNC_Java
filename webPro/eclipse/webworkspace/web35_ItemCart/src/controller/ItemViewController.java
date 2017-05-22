package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemViewController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		ModelAndView mv = new ModelAndView();
		int itemnumber = Integer.parseInt(request.getParameter("itemnumber"));

		System.out.println("count++ :: " + 
								ItemDao.getInstance().updateRecordCount(itemnumber));

		Item item = ItemDao.getInstance().getItem(itemnumber);
		request.setAttribute("item", item);
		
		// ***************** 관심있는 상품 등록  *****************
		// Cookie를 생성하고 Client에게 보냄
		// Cookie cookie = new Cookie(itemnumber+"", item.getUrl());
		// itemnumber를 String으로 바꿔서 넣음
		Cookie cookie = new Cookie("fruits" + itemnumber, item.getUrl());
		// 사이트를 구분하기 위해 fruits라는 사이트를 구별할 수 있는 이름을 붙임
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);                                                          
		
		mv.setUrl("itemView.jsp");
		return mv;
	}
}
