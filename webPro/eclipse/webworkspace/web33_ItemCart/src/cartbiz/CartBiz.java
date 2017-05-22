package cartbiz;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Item;

public class CartBiz {
	private static CartBiz cartbiz = new CartBiz();
	private CartBiz(){}
	public static CartBiz getInstance(){
		return cartbiz;
	}
	
	public void addCart(HttpServletRequest request, Item item){
		// Session에 binding되어 있는 정보 받아오기
		ArrayList<Cart> cartlist = 
					(ArrayList<Cart>) request.getSession().getAttribute("cartlist");
		
		
		// 장바구니가 비어있을 경우
		if(cartlist == null)
			cartlist = new ArrayList<Cart>();
		
		boolean addNewCart = true;		// default : Cart에 Item이 없는 경우
		for(Cart c : cartlist){
			// 현재 선택한 상품이 Cart에 있는 상품인 경우 > 수량만 증가
			if(c.getName().equals(item.getName())){
				addNewCart = false;
				c.setQuantity(c.getQuantity() + 1);
			} //if
		} //for
		
		// 현재 선택한 상품이 Cart에 없는 경우 > 새로 추가
		if(addNewCart){
			cartlist.add(new Cart(item.getUrl(), item.getName(), item.getPrice(), 1));
		}
		
		// binding
		request.getSession().setAttribute("cartlist", cartlist);
	}// addCart()
	
	public ArrayList<Cart> getCartList(HttpServletRequest request){
		return (ArrayList<Cart>) request.getSession().getAttribute("cartlist");
	}
}
