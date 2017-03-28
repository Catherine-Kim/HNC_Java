package chatting.client.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class ClientThread extends Thread{
	Socket s;
	BufferedReader br2;
	
	public ClientThread(Socket s){
		try {
			this.s = s;
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try{
			while(true){
				System.out.println(br2.readLine());
			}
		}catch(IOException e){
			
		}
	}
}

public class ChatClient {
	Socket client;
	BufferedReader br1;		// br2 ªË¡¶
	PrintWriter pw;
	
	public void net() throws UnknownHostException, IOException{
		// 1. Create socket
		client = new Socket("127.0.0.1", 60000);
		System.out.println("Created client socket(" + client.getInetAddress() + ")");
		
		// 2. Create stream
		br1 = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(client.getOutputStream(), true);
		
		ClientThread ct = new ClientThread(client);
		ct.start();
		
		System.out.println("Created stream...");
		
		// 3. Data reading and writing
		String line = null;
		String line2 = null;
		while((line = br1.readLine()) != null){
			pw.println(line);
		}
		
		// 4. Stream closing
		br1.close();
		pw.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient cc = new ChatClient();
		cc.net();
	}
}
