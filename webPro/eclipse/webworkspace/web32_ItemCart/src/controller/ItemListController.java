package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemListController implements Controller{
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		ArrayList<Item> list = ItemDao.getInstance().getAllItems();
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemList.jsp");
		//mv.setRedirect(false);		default가 false라 굳이 안 해도 되는 부분
		request.setAttribute("list", list);
		
		return mv;
	}
}
