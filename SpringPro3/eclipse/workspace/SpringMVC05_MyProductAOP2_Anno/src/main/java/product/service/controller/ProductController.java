package product.service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import product.service.model.MyProductService;
import product.service.vo.MyProduct;

public class ProductController extends MultiActionController{
	// field
	private MyProductService myProductService;
	
	// setter
	public void setMyProductService(MyProductService myProductService) {
		this.myProductService = myProductService;
	}
	
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response,
															MyProduct vo) throws Exception{
		System.out.println("1. form으로부터 받은 VO의 id (BEFORE) : " + vo.getId());
		myProductService.insertMyProduct(vo);
		System.out.println("2. form으로부터 받은 VO의 id (AFTER) : " + vo.getId());
		
		return new ModelAndView("insert_result", "vo", vo);
	}
	
	public ModelAndView findByProductName(HttpServletRequest request, 
										HttpServletResponse response) throws Exception{
		String word = request.getParameter("word");
		return new ModelAndView("find_result", "list", 
												myProductService.findByProductName(word));
	}
	
	public ModelAndView findByMaker(HttpServletRequest request, 
										HttpServletResponse response) throws Exception{
		String word = request.getParameter("word");
		return new ModelAndView("find_result", "list", 
													myProductService.findByMaker(word));
	}
}
