package product.service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import product.service.model.MyProductService;
import product.service.vo.MyProductVO;

@Controller
public class ProductController{
	@Autowired
	private MyProductService myProductService;
	
	public void setMyProductService(MyProductService myProductService) {
		this.myProductService = myProductService;
	}

	@RequestMapping("register.do")
	public ModelAndView register(HttpServletRequest request, 
			HttpServletResponse response, MyProductVO vo)throws Exception{
		
		System.out.println("1. 폼으로 부터 받은 vo의 no : Before: "+vo.getId());
		myProductService.insertMyProduct(vo);//
		System.out.println("2. 폼으로 부터 받은 vo의 no : After: "+vo.getId());
		return new ModelAndView("insert_result", "info", vo);
	}
}

/*
 * insert_result
 * find_result : table형식으로 출력되도록 : forEach
 */



















