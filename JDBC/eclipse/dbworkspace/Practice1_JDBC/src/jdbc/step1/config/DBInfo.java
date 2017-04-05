package jdbc.step1.config;

public interface DBInfo {
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final String user = "hr";
	public static final String pw = "hr";
}
