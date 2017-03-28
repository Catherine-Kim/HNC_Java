package chatting.server.step1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	ServerSocket server;
	Socket s;
	
	public void net() throws IOException{
		server = new ServerSocket(2222);
		System.out.println("Server is now ready to accept requests...");
		
		s = server.accept();
		System.out.println("Accepting client's request...");
	}
	
	public static void main(String[] args) throws IOException{
		ChatServer cs = new ChatServer();
		cs.net();		
	}
}
