package model;

import java.sql.Connection;
import java.sql.DriverManager;

import config.OracleInfo;
/*
 * Naming Service를 직접 여기서 구사...
 * SingleTone 방식으로 객체를 생성...
 * --> DataSource를 리턴하면 된다... / DriverManager 방식을 쓰겠다...단위테스트 때문에
 */
public class DataSourceManager {
	private Connection conn;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager(){
		try{
			Class.forName(OracleInfo.DRIVER);
			System.out.println("driver loading...ok..");
			
			conn = 
					DriverManager.getConnection(OracleInfo.URL, OracleInfo.USER, OracleInfo.PASS);
			System.out.println("db server connection....");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}//생성자
	
	public static DataSourceManager getInstance(){
		return instance;
	}
	
	public Connection getConnection(){
		return conn;
	}
}


















