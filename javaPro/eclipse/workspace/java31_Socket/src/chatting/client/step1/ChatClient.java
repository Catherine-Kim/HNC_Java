package chatting.client.step1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	Socket socket;
	
	public void net() throws UnknownHostException, IOException{
		socket = new Socket("127.0.0.1", 2222);
		System.out.println("Creating Client Socket...");
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient cc = new ChatClient();
		cc.net();
	}
}
