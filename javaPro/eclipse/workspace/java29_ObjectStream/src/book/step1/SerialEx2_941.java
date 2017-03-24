package book.step1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx2_941 {
	public static void main(String[] args) throws Exception{
		// Variables
		String userFileName = "c:\\object\\users.obj";
		
		UserInfo_939 user1 = new UserInfo_939();
		UserInfo_939 user2 = new UserInfo_939();
		UserInfo_939 user3 = new UserInfo_939();
		ArrayList<UserInfo_939> users = new ArrayList<UserInfo_939>();
		
		// Input Stream
		FileInputStream fis = new FileInputStream(userFileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// Object reading
		user1 = (UserInfo_939)ois.readObject();
		user2 = (UserInfo_939)ois.readObject();
		user3 = (UserInfo_939)ois.readObject();
		users = (ArrayList<UserInfo_939>)ois.readObject();
		
		// Print data
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		System.out.println(users);
		
		// Stream closing
		ois.close();
	}
}
