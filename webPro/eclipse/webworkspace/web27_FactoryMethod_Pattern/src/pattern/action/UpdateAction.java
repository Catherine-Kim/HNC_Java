package pattern.action;

public class UpdateAction implements Action{
	@Override
	public void execute() {
		
		update();
	}
	
	private void update(){
		/*form 값 받기
		DAO 리턴 받기
		Business Logic 호출
		Binding
		Navigation
		
		했다 치자*/

		System.out.println("update OK");
	}
}
