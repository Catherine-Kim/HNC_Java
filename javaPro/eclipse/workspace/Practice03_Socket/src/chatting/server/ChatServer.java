package chatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ChatServerThread extends Thread {
	Socket client_match;
	BufferedReader br;
	PrintWriter pw;
	ChatServer cs;

	ChatServerThread(Socket client_match, ChatServer cs) throws IOException {
		this.cs = cs;
		this.client_match = client_match;
		// create stream
		br = new BufferedReader(new InputStreamReader(client_match.getInputStream()));
		pw = new PrintWriter(client_match.getOutputStream(), true);
		System.out.println("Streams have been made. Ready for commuication.");
	}
	
	public void sendMessage(String message){
		pw.println(message);
	}

	@Override
	public void run() {
		// data reading and writing
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				cs.broadcast(line);
			}
		} catch (IOException e) {
			cs.removeThread(this);
		}

	}
}

public class ChatServer {
	// fields
	ServerSocket server;
	ArrayList<ChatServerThread> threadList; // thread arraylist
	
	// addThread()
	public void addThread(ChatServerThread client_thread){
		threadList.add(client_thread);
		System.out.println("Added a client to a thread list.");
	}
	
	// removeThread()
	public void removeThread(ChatServerThread client_thread){
		threadList.remove(client_thread);
		System.out.println("Removed a client from a thread list.");
	}
	
	// broadcast()
	public void broadcast(String message){
		for(ChatServerThread t : threadList){
			t.sendMessage(message);
		}
	}

	ChatServer() throws IOException {
		threadList = new ArrayList<ChatServerThread>();
	}

	public void net() throws IOException {
		// create ServerSocket
		server = new ServerSocket(2233);
		System.out.println("Server is ready.");

		while (true) {
			// accept client & create thread
			Socket client_match = server.accept();
			ChatServerThread client_thread = new ChatServerThread(client_match, this);
			this.addThread(client_thread);
			client_thread.start();
			System.out.println("Accepted client [" + client_match.getInetAddress() + "]");

		}
	}

	public static void main(String[] args) throws IOException {
		ChatServer chattingServer = new ChatServer();
		chattingServer.net();
	}
}
