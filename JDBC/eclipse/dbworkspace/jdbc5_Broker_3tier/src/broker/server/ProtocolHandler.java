package broker.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolHandler extends Thread{
	// fields
	private ServerSocket server;
	private Socket s;
	private JuryThread jury;
	private Database db;

	private static final int MIDDLE_PORT = 60000;
	
	// constructors
	public ProtocolHandler(String host){
		try {
			server = new ServerSocket(MIDDLE_PORT);
			System.out.println("[SUCCESS] Start ProtocolHandler - port number : " + MIDDLE_PORT);
		} catch (IOException e) {
			System.out.println("[FAIL] ProtocolHandler");
		}
		try {
			db = new Database("127.0.0.1");
			System.out.println("[SUCCESS] Database");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[FAIL] Database");
		}
	}
	
	@Override
	public void run() {
		while(true){
			// waiting
			try {
				s = server.accept();
				jury = new JuryThread(s, db); 	// Thread는 Database를 Hasing해야 Database의 메소드를 쓸 수 있게 됨
				jury.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		ProtocolHandler handler = new ProtocolHandler("127.0.0.1");
		handler.start();	// run()
	}
}
