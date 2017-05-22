package pattern.factory;

import pattern.action.Action;
import pattern.action.DeleteAction;
import pattern.action.InsertAction;
import pattern.action.UpdateAction;

public class ActionFactory {
	private static ActionFactory factory = new ActionFactory();
	
	private ActionFactory(){};
	
	public static ActionFactory getInstance(){
		return factory;
	}
	
	public Action createAction(String comm){
		Action action = null;
		
		if(comm.equals("INSERT")){
			action = new InsertAction();
		}else if(comm.equals("DELETE")){
			action = new DeleteAction();
		}else if(comm.equals("UPDATE")){
			action = new UpdateAction();
		}
		
		return action;
	}
}
