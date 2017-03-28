package chatting.server.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	ServerSocket server;
	Socket client_match;
	BufferedReader br;
	PrintWriter pw;
	
	public void net() throws IOException{
		// 1. Create socket
		server = new ServerSocket(2222);
		System.out.println("Created ServerSocket...");
		
		// 2. Client request accept
		client_match = server.accept();
		System.out.println("Accepted request from client(" + client_match.getInetAddress() + ")");
		
		// 3. Create stream
		br = new BufferedReader(new InputStreamReader(client_match.getInputStream()));
		pw = new PrintWriter(client_match.getOutputStream(), true); 
		System.out.println("Created Streams..");
		
		// 4. Data writing
		String line = null;
		while((line = br.readLine()) != null){
			//System.out.println("Got it - from Server");
			pw.println(line);
		}
		
		// 5. Stream closing
		br.close();
		pw.close();
	}
	
	public static void main(String[] args) throws IOException {
		ChatServer cs = new ChatServer();
		cs.net();
	}
}
