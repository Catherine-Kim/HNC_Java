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
		// 1. ServerSocket 생성
		server = new ServerSocket(2222);
		System.out.println("Server is now ready to accept requests from clients...");
	
		// 2. Client가 접속하면 Socket 리턴
		s = server.accept();		// 접속한 client와 매칭되는 Socket(접속한 client의 정보를 가지고 있는 Socket)
		System.out.println("Accepting " + s.getInetAddress() + "'s request...");
		
		// 3. Stream 생성
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println("Created Stream");
		
		// 4. Client가 보낸 메세지 받아서 자신의 콘솔창으로 출력
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
