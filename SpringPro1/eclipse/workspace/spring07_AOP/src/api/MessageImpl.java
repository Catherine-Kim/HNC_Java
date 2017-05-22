package api;

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
}
