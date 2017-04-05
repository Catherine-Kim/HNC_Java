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
	//�ʵ� ����...
	private Socket s;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Command cmd;
	private static final int MIDDLE_PORT = 60000;	// ������ ��Ʈ�� �����ؾ���

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
	//2.//////////// Database�� �޼ҵ带 �����ϰ� ����...////////////////////////////
	public void buyShares(String ssn, String symbol, int quantity)
										throws RecordNotFoundException{
		// 1. ���ö� �α�
		cmd = new Command(Command.BUYSHARES); 	// ���ٰ� �ٽ� ���ƿðű� ������ ���÷� �����
		String[] str = {ssn, symbol, String.valueOf(quantity)};
		cmd.setArgs(str);
		
		// 2. ���ö� ������ - Jury����
		writeCommand(cmd);
		
		////////////////////////////////// Blocked ///////////////////////////////////
		
		// 3. Jury�� ���� ���ö��� �ٽ� �޴´�.(������ �������� ��� blocked, ���� ������ ���)
		// Result�� ������� �Ű�(void Ÿ���̴ϱ�), status�� ä������ �ð���
		int status = getResponse();
		if(status == -1) throw new RecordNotFoundException();
	}

	public void sellShares(String ssn, String symbol, int quantity)
						throws RecordNotFoundException, InvalidTransactionException{
		// 1. ���ö� �α�
		cmd = new Command(20);
		String[] str = {ssn, symbol, String.valueOf(quantity)};
		cmd.setArgs(str);
		
		// 2. ���ö� ������
		writeCommand(cmd);
		
		//////////////////////////////////Blocked ///////////////////////////////////

		// 3. ���ö� �ٽ� �ޱ�
		int status = getResponse();
		if (status == -1) throw new RecordNotFoundException();
		if (status == -3) throw new InvalidTransactionException();
	}
	
	public ArrayList<StockRec> getAllStocks(){	
		ArrayList<StockRec> list = new ArrayList<StockRec>();	
		
		// 1. ���ö� �α�
		cmd = new Command(30);
		
		// 2. ���ö� ������
		writeCommand(cmd);
		
		//////////////////////////////////Blocked ///////////////////////////////////
		
		// 3. ���ö� �ٽ� �޾Ƽ� ���
		int status = getResponse();
		list = (ArrayList<StockRec>)cmd.getResults().get(0);
		
		return list;
	}
	
	public float getStockPrice(String symbol){	
		float price = 0.0f;

		// 1. ���ö� �α�
		cmd = new Command(40);
		String[] str = {symbol};
		cmd.setArgs(str);

		// 2. ���ö� ������
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
		
		// 3. ���ö� �ٽ� �޾Ƽ� ���
		int status = getResponse();
		price = (float)cmd.getResults().get(0);		
		
		return price;
	}	
	
	public ArrayList<CustomerRec> getAllCustomers(){	
		ArrayList<CustomerRec> list = new ArrayList<CustomerRec>();

		// 1. ���ö� �α�
		cmd = new Command(50);
		
		// 2. ���ö� ������
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
	
		// 3. ���ö� �ٽ� �޾Ƽ� ���
		getResponse();
		list = (ArrayList)cmd.getResults().get(0);
		
		return list;
	}	
	
	public CustomerRec getCustomer(String ssn)throws RecordNotFoundException{	
		CustomerRec cust = null;
		
		// 1. ���ö� �α�
		cmd = new Command(60);
		String[] str = {ssn};
		cmd.setArgs(str);
		
		// 2. ���ö� ������
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
	
		// 3. ���ö� �ٽ� �޾Ƽ� ���
		int status = getResponse();
		if(status == -1) throw new RecordNotFoundException();
		cust = (CustomerRec)cmd.getResults().get(0);
		
		return cust;		
	}		
	
	public void addCustomer(CustomerRec cust) throws DuplicateSSNException{	
		// 1. ���ö� �α�
		cmd = new Command(70);
		String[] str = {cust.getSsn(), cust.getName(), cust.getAddress()};
		cmd.setArgs(str);
		
		// 2. ���ö� ������
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
	
		// 3. ���ö� �ٽ� �޾Ƽ� ���
		int status = getResponse();
		if(status == -2) throw new DuplicateSSNException();
	}
	public void deleteCustomer(String ssn)	throws RecordNotFoundException{		
		// 1. ���ö� �α�
		cmd = new Command(80);
		String[] str = {ssn};
		cmd.setArgs(str);
		
		// 2. ���ö� ������
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
			
		// 3. ���ö� �ٽ� �޾Ƽ� ���
		int status = getResponse();
		if(status == -1) throw new RecordNotFoundException();
	}	
	public void updateCustomer(CustomerRec cust) throws RecordNotFoundException{
		// 1. ���ö� �α�
		cmd = new Command(90);
		String[] str = {cust.getSsn(), cust.getName(), cust.getAddress()};
		cmd.setArgs(str);
		
		// 2. ���ö� ������
		writeCommand(cmd);

		//////////////////////////////////Blocked ///////////////////////////////////
		
		// 3. ���ö� �ٽ� �޾Ƽ� ���
		int status = getResponse();
		if(status == -1) throw new RecordNotFoundException();
	}	
}




















