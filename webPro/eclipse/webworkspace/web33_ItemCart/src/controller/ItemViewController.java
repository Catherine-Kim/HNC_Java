package controller;

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
		
		mv.setUrl("itemView.jsp");
		return mv;
	}
}
