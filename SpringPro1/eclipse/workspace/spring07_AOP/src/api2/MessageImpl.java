package api2;

public class MessageImpl implements Message{
	// field
	private String message;
	
	// constructor
	public MessageImpl() {
		message = "내일은 주말임";
	}
	
	@Override
	public String print() {
		System.out.println("Message Value :: " + message);
		return "오늘은 금욜";
	}

	@Override
	public String message() {
		return message;
	}
	
	// 추가
	@Override
	public void searchName() {
		System.out.println("searchName() has been called.");		
	}

	@Override
	public void searchMemberById(String id) {
		System.out.println("searchMemberById() has been called.");				
	}

	@Override
	public void searchAddress(String address) {
		System.out.println("searchAddress() has been called.");		
	}
		
}
