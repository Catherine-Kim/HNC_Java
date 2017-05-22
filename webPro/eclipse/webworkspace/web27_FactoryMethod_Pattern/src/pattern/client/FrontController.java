package pattern.client;

import pattern.action.Action;
import pattern.factory.ActionFactory;

public class FrontController {

	public static void main(String[] args) {
		String comm = "INSERT";
		
		// 1. Factory 리턴받아서 createAction() 호출(comm을 인자로 ㄱ)
		Action action = ActionFactory.getInstance().createAction(comm);
		
		// 2. 넘겨받은 Action의 execute() 호출
		action.execute();
		
		// 3. execute() 수행값을 출력 - 2번에서 출력될거임
	}
}
