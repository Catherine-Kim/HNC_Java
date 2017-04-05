package jdbc.step1.test;

import java.sql.SQLException;

import jdbc.step1.config.DBInfo;
import jdbc.step1.dao.KostaDAO;
import jdbc.step1.vo.KostaVO;

public class KostaTest {
	static{
		// Driver Loading
		try {
			Class.forName(DBInfo.driver);
			System.out.println("[SUCCESS] Driver Loading");
		} catch (ClassNotFoundException e) {
			System.out.println("[FAIL] Driver Loading");
		}
	}
	
	public static void main(String[] args) throws SQLException {
		KostaDAO kdao = new KostaDAO();
		kdao.addKosta(new KostaVO("333", "Tahyung Kim", "Columbus, Ohio"));
		
	}
}
