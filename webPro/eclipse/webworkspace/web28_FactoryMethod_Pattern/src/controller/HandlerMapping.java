package controller;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return factory;
	}
	
	public Controller createController(String command){
		Controller controller = null;
		
		if(command.equals("find")){
			controller = new FindController();
		}
		
		return controller;
	}
}
