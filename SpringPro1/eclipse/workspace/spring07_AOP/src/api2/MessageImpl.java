package api2;

public class MessageImpl implements Message{
	// field
	private String message;
	
	// constructor
	public MessageImpl() {
		message = "������ �ָ���";
	}
	
	@Override
	public String print() {
		System.out.println("Message Value :: " + message);
		return "������ �ݿ�";
	}

	@Override
	public String message() {
		return message;
	}
	
	// �߰�
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
