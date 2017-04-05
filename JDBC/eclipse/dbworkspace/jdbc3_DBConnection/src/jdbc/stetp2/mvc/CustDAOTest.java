package jdbc.stetp2.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

import config.DBServerInfo;

public class CustDAOTest {
	
	static{		// Driver Loading
		try {
			Class.forName(DBServerInfo.DRIVER_NAME);
			System.out.println("[SUCCESS] Driver Loading");
		} catch (ClassNotFoundException e) {
			System.out.println("[FAIL] Driver Loading");
		}
	}

	public static void main(String[] args) throws SQLException {
		CustDAO cdao = new CustDAO();
		//cdao.addCust(new CustVO("333", "¼Õ½Â¿Ï", "°æ±âµµ"));
		//cdao.deleteCust("111");
		//cdao.updateCust(new CustVO("111", "¼Õ½Â¿Ï", "°æ»óºÏµµ"));
		/*ArrayList<CustVO> custsList = cdao.getAllCusts();
		for(int i = 0; i < custsList.size(); i++){
			System.out.println(custsList.get(i));
		}*/
		//System.out.println(cdao.getACust("333"));
		ArrayList<CustVO> custsList = cdao.findCustByAddr("°­¿øµµ");
		for(int i = 0; i < custsList.size(); i++){
			System.out.println(custsList.get(i));
		}
	}
}
