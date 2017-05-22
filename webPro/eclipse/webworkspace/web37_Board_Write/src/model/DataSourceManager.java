package model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/*
 * Naming Service를 직접 여기서 구사...
 * SingleTone 방식으로 객체를 생성...
 * --> DataSource를 리턴하면 된다... / DriverManager 방식을 쓰겠다...단위테스트 때문에
 */
public class DataSourceManager {
	//private Connection conn;
	private DataSource ds;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager(){
		try{
			// DataSource lookup
			Context ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("[SUCCESS] DataSource lookup() from DataSourceManager");
		}catch(Exception e){
			System.out.println("[FAIL] DataSource lookup() from DataSourceManager");
			e.printStackTrace();
		}		
	}//생성자
	
	public static DataSourceManager getInstance(){
		return instance;
	}
	
	public DataSource getConnection(){
		return ds;
	}
}


















