package api;

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
}
