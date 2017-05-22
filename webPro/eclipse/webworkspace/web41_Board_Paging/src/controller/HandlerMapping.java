package controller;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return factory;
	}
	
	public Controller createController(String command){
		Controller controller = null;
		
		if(command.equals("showContent")){
			controller = new ShowContentController();
			System.out.println("ShowContentController 생성 from HandlerMapping");
		}
		else if(command.equals("write")){
			controller = new WriteController();
			System.out.println("WriteController 생성 from HandlerMapping");
		}
		else if(command.equals("list")){
			controller = new ListController();
			System.out.println("ListController 생성 from HandlerMapping");
		}
		else if (command.equals("deleteCheckPassword")) {
			controller = new DeleteCheckPasswordController();
			System.out.println("DeleteCheckPasswordController 생성 from HandlerMapping");
		}
		else if (command.equals("deletePosting")) {
			controller = new DeletePostingController();
			System.out.println("DeletePostingController 생성 from HandlerMapping");
		}
		else if (command.equals("updateCheckPassword")) {
			controller = new UpdateCheckPasswordController();
			System.out.println("UpdateCheckPasswordController 생성 from HandlerMapping");
		}
		else if (command.equals("updateView")) {
			controller = new UpdateViewController();
			System.out.println("UpdateViewController 생성 from HandlerMapping");
		}
		else if (command.equals("updatePosting")) {
			controller = new UpdatePostingController();
			System.out.println("UpdatePostingController 생성 from HandlerMapping");
		}
		return controller;
	}
}
