package chatting.client.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	Socket client;
	BufferedReader br;
	PrintWriter pw;
	
	public void net() throws UnknownHostException, IOException{
		// 1. Socket 생성
		client = new Socket("127.0.0.1", 2222);
		System.out.println("Created client's socket...");
		
		// 2. Stream 생성
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(client.getOutputStream(), true);	// auto-flushing
		System.out.println("Created Stream...");
		
		// 3. 읽은 데이터를 Server로 보냄
		String contents = null;
		while((contents = br.readLine()) != null){
			pw.println(contents);			// println : new line 까지 하는 메소드
		}
		System.out.println("Sent data to server...");
		
		// 4. Stream closing
		br.close();
		pw.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient cc = new ChatClient();
		cc.net();
	}
}
