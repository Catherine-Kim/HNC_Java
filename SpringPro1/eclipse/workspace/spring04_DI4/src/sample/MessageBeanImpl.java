package sample;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean{
	// field
	private String name;		// ������ ����
	private String greeting;	// setter ����
	
	// field �߰�
	private Outputter outputter;	// setter ����
	
	public MessageBeanImpl(String name){
		this.name = name;
	}
	
	public void setGreeting(String greeting){
		this.greeting = greeting;
	}

	@Override
	public void sayMessage() {
		String message = greeting + ", " + name + " :D";
		try {
			outputter.output(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(message);
	}

	// Outputter setter �߰�
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
}

