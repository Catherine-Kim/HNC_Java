package chatting.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class ChatClientThread extends Thread{
	BufferedReader br2;
	Socket client;
	
	public ChatClientThread(Socket client) throws IOException {
		this.client = client;
		br2 = new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println("Stream has been made. Now ready to receive data from server");
	}
	
	@Override
	public void run() {
		// data reading and writing
		String line2 = null;
		try {
			while((line2 = br2.readLine()) != null){
				System.out.println("Data :: " + line2);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		// stream closing
		try {
			br2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ChatClient {
	Socket client;
	BufferedReader br1;
	PrintWriter pw;
	
	public ChatClient(){
		
	}
	
	public void net() throws UnknownHostException, IOException{
		// create socket
		client = new Socket("127.0.0.1", 2233);
		System.out.println("Client socket has been made.");
		
		// create stream
		br1 = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(client.getOutputStream(), true);
		System.out.println("Streams have been made. Now ready to send data to server");		
		
		ChatClientThread client_thread = new ChatClientThread(client);
		client_thread.start();
		
		// data reading and writing
		String line = null;
		while((line = br1.readLine()) != null){
			pw.println(line);
		}
		
		// close stream
		br1.close();
		pw.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient chattingClient = new ChatClient();
		chattingClient.net();
	}
}
