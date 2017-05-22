package cartbiz;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Item;

public class CartBiz {
	
	public void addCart(HttpServletRequest request, Item item){
		// Session에 binding되어 있는 정보 받아오기
		ArrayList<Cart> cartList = 
					(ArrayList<Cart>) request.getSession().getAttribute("cartList");
		
		// 장바구니가 비어있을 경우
		if(cartList == null)
			cartList = new ArrayList<Cart>();
		
		boolean addNewCart = true;		// default : Cart에 Item이 없는 경우
		for(Cart c : cartList){
			// 현재 선택한 상품이 Cart에 있는 상품인 경우 > 수량만 증가
			if(c.getName().equals(item.getName())){
				addNewCart = false;
				c.setQuantity(c.getQuantity() + 1);
			} //if
		} //for
		
		// 현재 선택한 상품이 Cart에 없는 경우 > 새로 추가
		if(addNewCart){
			cartList.add(new Cart(item.getUrl(), item.getName(), item.getPrice(), 1));
		}
		
		// binding
		request.getSession().setAttribute("cartList", cartList);
	}// addCart()
	
	public ArrayList<Cart> getCartList(HttpServletRequest request){
		return (ArrayList<Cart>) request.getSession().getAttribute("cartList");
	} // getCartList()
	
	public void upCartQty(HttpServletRequest request, String name){
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		for(Cart c : cartList){
			if(c.getName().equals(name)){
				c.setQuantity(c.getQuantity() + 1);
			}
		}
	} // upCartQty()

	public void downCartQty(HttpServletRequest request, String name){
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		for(Cart c : cartList){
			if(c.getName().equals(name)){
				c.setQuantity(c.getQuantity() - 1);
			}
		}
	} // downCartQty()
	
	public void removeCartItem(HttpServletRequest request, String[] names){
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList  = (ArrayList<Cart>) session.getAttribute("cartList");
		
		for(int i = 0; i < names.length; i++){
			for(int j = 0; j < cartList.size(); j++){
				if(names[i].equals(cartList.get(j))){
					cartList.remove(j);
				}
			}
		}
	} // remoceCartItem()
}
