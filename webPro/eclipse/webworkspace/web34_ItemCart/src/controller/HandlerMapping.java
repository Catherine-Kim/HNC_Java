package controller;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return factory;
	}
	
	public Controller createController(String command){
		Controller controller = null;
		
		if(command.equals("/itemList.do")){
			controller = new ItemListController();
			System.out.println("ItemListCnotroller 생성 from HandlerMapping");
		}else if(command.equals("/itemView.do")){
			controller = new ItemViewController();
			System.out.println("ItemViewController 생성 from HandlerMapping");
		}else if(command.equals("/itemCartAdd.do")){
			controller = new ItemCartAddController();
			System.out.println("ItemCartAddController 생성 from HandlerMapping");
		}else if(command.equals("/itemCartList.do")){
			controller = new ItemCartListController();
			System.out.println("ItemCartListController 생성 from HandlerMapping");
		}else if(command.equals("/itemCartQtyUp.do")){
			controller = new ItemCartQtyUpController ();
			System.out.println("ItemCartQtyUpController  생성 from HandlerMapping");
		}else if(command.equals("/itemCartQtyDown.do")){
			controller = new ItemCartQtyDownController();
			System.out.println("ItemCartQtyDownController 생성 from HandlerMapping");         
		}else if(command.equals("/itemCartRemove.do")){
			controller = new ItemCartRemoveController();
			System.out.println("ItemCartRemoveController 생성 from HandlerMapping");                   
		}
		
		return controller;
	}
}
