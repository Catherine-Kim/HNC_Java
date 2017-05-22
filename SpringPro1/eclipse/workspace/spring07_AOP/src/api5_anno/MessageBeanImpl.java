package api5_anno;

public class MessageBeanImpl implements MessageBean{
	// field
	private String name;
	
	// setter
	public void setName(String name){
		this.name = name;
	}

	@Override
	public void sayHello() {
		try {
			Thread.sleep(5000);
			System.out.println("Sleeping for 5 sec...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		// 5초 후에 Business Logic 수행
		
		System.out.println("Love you so much, " + name + " :D");
	}
}


