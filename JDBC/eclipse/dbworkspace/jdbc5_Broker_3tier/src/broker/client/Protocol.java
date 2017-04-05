package broker.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import broker.exception.DuplicateSSNException;
import broker.exception.InvalidTransactionException;
import broker.exception.RecordNotFoundException;
import broker.share.Command;
import broker.vo.CustomerRec;
import broker.vo.StockRec;



public class Protocol {
	//필드 선언...
	private Socket s;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Command cmd;
	private static final int MIDDLE_PORT = 60000;	// 서버의 포트와 동일해야함

	public Protocol(String serverIp)throws Exception{
		s = new Socket(serverIp, MIDDLE_PORT);
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
	}
	
	public void close(){
		try{
			s.close();
		}catch(Exception e){
			System.out.println("Protocol.close()...."+e);
		}
	}
	
	
	public void writeCommand(Command cmd){
		try {
			oos.writeObject(cmd);
			System.out.println("[SUCCESS] Client protocol writeCommand()");
		} catch (IOException e) {
			System.out.println("[FAIL] Client protocol writeCommand()\n" + e);
		}
	}
	
	public int getResponse(){	// readObject() + getResult().getStatus();
		try {
			cmd = (Command)ois.readObject();
			System.out.println("[SUCCESS] Client protocol getResponse()");
		} catch (Exception e) {
			System.out.println("[FAIL] Client protocol getResponse()\n" + e);
		}
		int status = cmd.getResults().getStatus();
		return status;
	}
	
	// Business Logic
	//2.//////////// Database의 메소드를 동일하게 선언...////////////////////////////
	public void buyShares(String ssn, String symbol, int quantity)
										throws RecordNotFoundException{
		// 1. 도시락 싸기
		cmd = new Command(Command.BUYSHARES); 	// 갔다가 다시 돌아올거기 때문에 로컬로 써야함
		String[] str = {ssn, symbol, String.valueOf(quantity)};
		cmd.setArgs(str);
		
		// 2. 도시락 보내기 - Jury에게
		writeCommand(cmd);
		
		////////////////////////////////// Blocked ///////////////////////////////////
		
		// 3. Jury가 보낸 도시락을 다시 받는다.(던지기 전까지는 잠시 blocked, 받을 때까지 대기)
		// Result는 비어있을 거고(void 타입이니까), status가 채워져서 올거임
		int status = getResponse();
		if(status == -1) throw new RecordNotFoundException();
	}

	public void sellShares(String ssn, String symbol, int quantity)
						throws RecordNotFoundException, InvalidTransactionException{
		// 1. 도시락 싸기
		cmd = new Command(20);
		String[] str = {ssn, symbol, String.valueOf(quantity)};
		cmd.setArgs(str);
		
		// 2. 도시락 보내기
		writeCommand(cmd);
		
		//////////////////////////////////Blocked ///////////////////////////////////

		// 3. 도시락 다시 받기
		int status = getResponse();
		if (status == -1) throw new RecordNotFoundException();
		if (status == -3) throw new InvalidTransactionException();
	}
	
	public ArrayList<StockRec> getAllStocks(){	
		ArrayList<StockRec> list = new ArrayList<StockRec>();	
		
		// 1. 도시락 싸기
		cmd = new Command(30);
		
		// 2. 도시락 던지기
		writeCommand(cmd);
		
		//////////////////////////////////Blocked ///////////////////////////////////
		
		// 3. 도시락 다시 받아서 까기
		int status = getResponse();
		list = (ArrayList<StockRec>)cmd.getResults().get(0);
		
		return list;
	}
	
	public float getStockPrice(String symbol){	
		float price = 0.0f;

		// 1. 도시락 싸기
		cmd = new Command(40);
		String[] str = {symbol};
		cmd.setArgs(str);

		// 2. 도시락 던지기
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
		
		// 3. 도시락 다시 받아서 까기
		int status = getResponse();
		price = (float)cmd.getResults().get(0);		
		
		return price;
	}	
	
	public ArrayList<CustomerRec> getAllCustomers(){	
		ArrayList<CustomerRec> list = new ArrayList<CustomerRec>();

		// 1. 도시락 싸기
		cmd = new Command(50);
		
		// 2. 도시락 던지기
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
	
		// 3. 도시락 다시 받아서 까기
		getResponse();
		list = (ArrayList)cmd.getResults().get(0);
		
		return list;
	}	
	
	public CustomerRec getCustomer(String ssn)throws RecordNotFoundException{	
		CustomerRec cust = null;
		
		// 1. 도시락 싸기
		cmd = new Command(60);
		String[] str = {ssn};
		cmd.setArgs(str);
		
		// 2. 도시락 던지기
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
	
		// 3. 도시락 다시 받아서 까기
		int status = getResponse();
		if(status == -1) throw new RecordNotFoundException();
		cust = (CustomerRec)cmd.getResults().get(0);
		
		return cust;		
	}		
	
	public void addCustomer(CustomerRec cust) throws DuplicateSSNException{	
		// 1. 도시락 싸기
		cmd = new Command(70);
		String[] str = {cust.getSsn(), cust.getName(), cust.getAddress()};
		cmd.setArgs(str);
		
		// 2. 도시락 던지기
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
	
		// 3. 도시락 다시 받아서 까기
		int status = getResponse();
		if(status == -2) throw new DuplicateSSNException();
	}
	public void deleteCustomer(String ssn)	throws RecordNotFoundException{		
		// 1. 도시락 싸기
		cmd = new Command(80);
		String[] str = {ssn};
		cmd.setArgs(str);
		
		// 2. 도시락 던지기
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
			
		// 3. 도시락 다시 받아서 까기
		int status = getResponse();
		if(status == -1) throw new RecordNotFoundException();
	}	
	public void updateCustomer(CustomerRec cust) throws RecordNotFoundException{
		// 1. 도시락 싸기
		cmd = new Command(90);
		String[] str = {cust.getSsn(), cust.getName(), cust.getAddress()};
		cmd.setArgs(str);
		
		// 2. 도시락 던지기
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
		
		// 3. 도시락 다시 받아서 까기
		int status = getResponse();
		if(status == -1) throw new RecordNotFoundException();
	}	
}




















