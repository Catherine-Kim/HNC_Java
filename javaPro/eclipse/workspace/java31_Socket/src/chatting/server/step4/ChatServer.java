package chatting.server.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

class ServerThread extends Thread {
	Socket client_match;
	BufferedReader br;
	PrintWriter pw;
	ChatServer cs;
	
	public ServerThread(Socket client_match, ChatServer cs) throws IOException {
		this.cs = cs;
		this.client_match = client_match;
		System.out.println(client_match.getInetAddress() + "님이 접속했습니다.");		// 내 콘솔에다도 띄우고
		cs.broadcast(client_match.getInetAddress() + "님이 접속했습니다.");			// 다른 사람들 콘솔에다도 띄우고
		br = new BufferedReader(new InputStreamReader(client_match.getInputStream()));
		pw = new PrintWriter(client_match.getOutputStream(), true);
	}
	
	public void sendMessage(String message){
		pw.println(message);
	}

	@Override
	public void run() {
		try{
			String line = null;
			while((line = br.readLine()) != null){
				cs.broadcast(line);
			}
		}catch(Exception e){
			// Thread가 없을 때 == 연결이 끊어질 때
			System.out.println(client_match.getInetAddress() + "님이 탈퇴했습니다.");
			cs.broadcast(client_match.getInetAddress() + "님이 탈퇴했습니다.");
			cs.removeThread(this);
		}finally{
			// Stream closing
		}
	}
}

public class ChatServer {
	ServerSocket server;
	Socket s;
	Vector<ServerThread> tVector;

	public ChatServer() throws IOException {
		tVector = new Vector<ServerThread>(1, 1);	// 최초의 Capacity & 늘어나는 size
	}

	// Vector에 Thread 추가
	public void addThread(ServerThread t) {
		tVector.add(t);
	}

	// Vector에서 Thread 제거
	public void removeThread(ServerThread t) {
		tVector.remove(t);
	}

	// Vector 내 모든 Thread에 message를 뿌림
	public void broadcast(String message) {
		for(ServerThread thread : tVector){
			thread.sendMessage(message);
		}
	}
	
	// ServerSocket 생성
	// 무한루프를 돌면 Client가 접속하면 Socket을 생성하고, 생성된 Socket울 인자로 Thread을 생성 & addThread() 호출
	// removeThread()는 언제 쓸까?
	public void net() throws Exception{
		server = new ServerSocket(60000);
		System.out.println("Server ready...");
		
		while(true){
			s = server.accept();
			ServerThread st = new ServerThread(s, this);
			this.addThread(st);
			st.start();
		}
	}

	public static void main(String[] args) throws Exception{
		ChatServer cs = new ChatServer();
		cs.net();
	}
}
