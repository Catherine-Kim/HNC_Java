package config;

public interface DBServerInfo {
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";	
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";		
	public static final String USER = "scott";			
	public static final String PASSWORD = "tiger";	
}
