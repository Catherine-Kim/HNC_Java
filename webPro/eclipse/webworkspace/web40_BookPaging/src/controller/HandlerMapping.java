package controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return handler;
	}
	
	public Controller createController(String command){
		Controller controller = null;
		if(command.equals("register")){
			controller=  new RegisterController();
		}else if(command.equals("list")){
			controller=  new ListController();			
		}
		
		return controller;
	}
}



//showContentNoHits







