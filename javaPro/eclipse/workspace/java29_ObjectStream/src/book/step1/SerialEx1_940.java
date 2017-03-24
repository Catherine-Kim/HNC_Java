package book.step1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx1_940 {
	public static void main(String[] args) throws Exception{
		// Variables
		UserInfo_939 user1 = new UserInfo_939();
		UserInfo_939 user2 = new UserInfo_939("Woojeong Kim", 24, "010110");
		UserInfo_939 user3 = new UserInfo_939("Jimin Park", 23, "110101");
		ArrayList<UserInfo_939> users = new ArrayList<UserInfo_939>();
		users.add(user3);
		users.add(user2);
		
		String userFileName = "c:\\object\\users.obj";
		
		// Create file
		File userFile = new File(userFileName);
		userFile.getParentFile().mkdirs();
		userFile.createNewFile();
		
		// Output Stream
		FileOutputStream fos = new FileOutputStream(userFile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// Object writing
		oos.writeObject(user1);
		oos.writeObject(user2);
		oos.writeObject(user3);
		oos.writeObject(users);
		
		// Stream closing
		oos.close();
	}
}
