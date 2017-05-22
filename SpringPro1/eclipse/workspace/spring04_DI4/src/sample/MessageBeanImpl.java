package sample;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean{
	// field
	private String name;		// 생성자 주입
	private String greeting;	// setter 주입
	
	// field 추가
	private Outputter outputter;	// setter 주입
	
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

	// Outputter setter 추가
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
}

