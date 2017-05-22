package pattern.action;

public class DeleteAction implements Action{
	@Override
	public void execute() {
		
		delete();
	}
	
	private void delete(){
		/*form 값 받기
		DAO 리턴 받기
		Business Logic 호출
		Binding
		Navigation
		
		했다 치자*/

		System.out.println("delete OK");
	}
}
