package chatting.server.step2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	ServerSocket server;
	Socket s;
	BufferedReader br;
	
	public void net() throws IOException{
		// 1. ServerSocket ����
		server = new ServerSocket(2222);
		System.out.println("Server is now ready to accept requests from clients...");
	
		// 2. Client�� �����ϸ� Socket ����
		s = server.accept();		// ������ client�� ��Ī�Ǵ� Socket(������ client�� ������ ������ �ִ� Socket)
		System.out.println("Accepting " + s.getInetAddress() + "'s request...");
		
		// 3. Stream ����
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println("Created Stream");
		
		// 4. Client�� ���� �޼��� �޾Ƽ� �ڽ��� �ܼ�â���� ���
		System.out.println("Client's data : ");
		String contents = null;
		while ((contents = br.readLine()) != null){
			System.out.println("Client's data : " + contents);
		}
		
		// 5. Stream Closing
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		ChatServer cs = new ChatServer();
		cs.net();
	}
}
