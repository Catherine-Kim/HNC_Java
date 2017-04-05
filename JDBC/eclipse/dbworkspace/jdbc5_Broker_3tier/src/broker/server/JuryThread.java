package broker.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import broker.exception.DuplicateSSNException;
import broker.exception.InvalidTransactionException;
import broker.exception.RecordNotFoundException;
import broker.share.Command;
import broker.share.Result;
import broker.vo.CustomerRec;
import broker.vo.StockRec;

public class JuryThread extends Thread{
	// fields
	private Socket s;
	private Database db;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Command cmd;
	
	public JuryThread(Socket s, Database db) {
		this.s = s;
		this.db = db;
		
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("JuryThread creating...");
	}
	@Override
	public void run() {
		// 받아온 도시락통 열어서 그 안에 상수값, 반찬 확인해서 
		// 그에 해당하는 Database의 메소드를 호출
		System.out.println("run()... JuryThread");
		while(true){
			try {
				// 1. 도시락통을 받는다.
				cmd = (Command)ois.readObject();
				System.out.println("[SUCCESS] readObject() .. JuryThread");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 2. 도시락통을 깐다
			int comm = cmd.getCommandValue();
			String[] args = cmd.getArgs();
			Result r = cmd.getResults();
			
			// 3. commandValue에 따른 Database의 메소드를 호출한다
			switch(comm){
			case 10:	// buyShares()
				try {
					db.buyShares(args[0], args[1], Integer.parseInt(args[2]));
					r.setStatus(0);
				} catch (SQLException e) {
					r.setStatus(-1);
				}
				break;
				
			case 20: // sellShares()
				try {
					db.sellShares(args[0], args[1], Integer.parseInt(args[2]));
					r.setStatus(0);
				} catch (RecordNotFoundException e) {
					r.setStatus(-1);
				} catch (InvalidTransactionException e){
					r.setStatus(-3);
				} catch (SQLException e){
					
				}
				break;
				
			case 30:	// getAllStocks()
				ArrayList<StockRec> list;
				try {
					list = db.getAllStocks();
					r.add(list);
					r.setStatus(0);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			
			case 40:	// getStockPrice()
				float price;
				try{
					price = db.getStcokPrice(args[0]);
					r.add(price);
					r.setStatus(0);
				}catch(RecordNotFoundException e){
					r.setStatus(-1);
				}catch(SQLException e){
					r.setStatus(-1);
				}
				break;
				
			case 50:	// getAllCustomers()
				//clist;
				try{
					ArrayList<CustomerRec>  clist = db.getAllCustomers();
					r.add(clist);
					cmd.setResults(r);
					r.setStatus(0);
				}catch(SQLException e){
					
				}
				break;
				
			case 60:	// getCustomer()
				CustomerRec c;
				try{
					c = db.getCustomer(args[0]);
					r.add(c);
					r.setStatus(0);
				}catch(SQLException e){
					r.setStatus(-1);
				}
				break;
				
			case 70:	// addCustomer()
				try{
					db.addCustomer(new CustomerRec(args[0], args[1], args[2]));
					r.setStatus(0);
				}catch(DuplicateSSNException e){
					r.setStatus(-1);
				}catch(SQLException e){
					r.setStatus(-1);
				}
				break;
				
			case 80:	// deleteCustomer()
				try{
					db.deleteCustomer(args[0]);
					r.setStatus(0);
				}catch(RecordNotFoundException e){
					r.setStatus(-1);
				}catch(SQLException e){
					r.setStatus(-1);
				}
				break;
				
			case 90:	// updateCustomer()
				try{
					db.updateCustomer(new CustomerRec(args[0], args[1], args[2]));
					r.setStatus(0);
				}catch(RecordNotFoundException e){
					r.setStatus(-1);
				}catch(SQLException e){
					r.setStatus(-1);
				}
				break;
			}	// switch end
			
			try{
				oos.writeObject(cmd);
			}catch(Exception e){
				
			}
		}
	}
}
