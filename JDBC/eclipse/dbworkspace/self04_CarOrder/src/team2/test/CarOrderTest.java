package team2.test;

import java.sql.SQLException;
import java.util.ArrayList;

import team2.config.DBInfo;
import team2.dao.CarOrderDAO;
import team2.exception.DuplicateModelException;
import team2.exception.RecordNotFoundException;
import team2.vo.CarOrderVO;
import team2.vo.CarVO;
import team2.vo.CustomerVO;

public class CarOrderTest {
	
	static{
		// Driver Loading
		try {
			Class.forName(DBInfo.driver);
			System.out.println("[SUCCESS] Driver Loading");
		} catch (ClassNotFoundException e) {
			System.out.println("[FAIL] Driver Loading");
		}
	}
	
	public static void main(String[] args) throws SQLException, RecordNotFoundException, DuplicateModelException {
		CarOrderDAO cdao = new CarOrderDAO();
		
		/*cdao.addCust(new CustomerVO("555", "KWJ", "Ohio", "1111-2222"));
		cdao.addCust(new CustomerVO("222", "SJW", "California", "3333-4444"));
		cdao.addCust(new CustomerVO("333", "OSJ", "Colorado", "5555-6666"));
		cdao.addCust(new CustomerVO("444", "KJG", "Texas", "7777-8888"));*/
		//cdao.updateCustomer(new CustomerVO("555", "KWJ", "Indianapolis"));
		//cdao.delCust("333");
		/*ArrayList<CustomerVO> list = cdao.getAllMember();
		for(CustomerVO cv : list){
			System.out.println(cv);
		}*/
		
		/*cdao.addCar(new CarVO("a01", "black", 200, "Audi"));
		cdao.addCar(new CarVO("b01", "red", 300, "Lamborghini"));
		cdao.addCar(new CarVO("c01", "yellow", 400, "Maybach"));*/
		//cdao.updatecar(new CarVO("b01", "Orange", 550, "Lamborghini"));
		//cdao.delCar("c01");
		//cdao.getAllCar();
		
		cdao.buyCar("b01", "222", 3);
		//cdao.printAllOrders("111");
	}
}
