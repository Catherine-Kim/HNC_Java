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
		System.out.println(client_match.getInetAddress() + "���� �����߽��ϴ�.");		// �� �ֿܼ��ٵ� ����
		cs.broadcast(client_match.getInetAddress() + "���� �����߽��ϴ�.");			// �ٸ� ����� �ֿܼ��ٵ� ����
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
			// Thread�� ���� �� == ������ ������ ��
			System.out.println(client_match.getInetAddress() + "���� Ż���߽��ϴ�.");
			cs.broadcast(client_match.getInetAddress() + "���� Ż���߽��ϴ�.");
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
		tVector = new Vector<ServerThread>(1, 1);	// ������ Capacity & �þ�� size
	}

	// Vector�� Thread �߰�
	public void addThread(ServerThread t) {
		tVector.add(t);
	}

	// Vector���� Thread ����
	public void removeThread(ServerThread t) {
		tVector.remove(t);
	}

	// Vector �� ��� Thread�� message�� �Ѹ�
	public void broadcast(String message) {
		for(ServerThread thread : tVector){
			thread.sendMessage(message);
		}
	}
	
	// ServerSocket ����
	// ���ѷ����� ���� Client�� �����ϸ� Socket�� �����ϰ�, ������ Socket�� ���ڷ� Thread�� ���� & addThread() ȣ��
	// removeThread()�� ���� ����?
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
