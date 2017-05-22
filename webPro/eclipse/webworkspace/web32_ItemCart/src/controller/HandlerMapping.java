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
		}                                                                                                
		
		return controller;
	}
}
