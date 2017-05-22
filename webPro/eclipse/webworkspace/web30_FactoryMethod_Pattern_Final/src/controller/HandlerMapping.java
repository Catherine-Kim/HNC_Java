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
		}else if(command.equals("register")){
			controller = new RegisterController();
		}else if(command.equals("allView")){
			controller = new AllViewController();
		}else if(command.equals("update")){
			controller = new UpdateController();
		}else if(command.equals("login")){
			controller = new LoginController();
		}else if(command.equals("logout")){
			controller = new LogoutController();
		}else if(command.equals("")){
			controller = new IdCheckController();
		}
		
		return controller;
	}
}
