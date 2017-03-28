package chatting.client.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	Socket client;
	BufferedReader br1, br2;
	PrintWriter pw;
	
	public void net() throws UnknownHostException, IOException{
		// 1. Create socket
		client = new Socket("127.0.0.1", 2222);
		System.out.println("Created client socket(" + client.getInetAddress() + ")");
		
		// 2. Create stream
		br1 = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(client.getOutputStream(), true);
		
		br2 = new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println("Created stream...");
		
		// 3. Data reading and writing
		String line = null;
		String line2 = null;
		while((line = br1.readLine()) != null){
			pw.println(line);
			//System.out.println("Wrote it - from clients");
			
			line2 = br2.readLine();
			System.out.println("Data from client :: " + line2);
		}
		
		// 4. Stream closing
		br1.close();
		br2.close();
		pw.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient cc = new ChatClient();
		cc.net();
	}
}
