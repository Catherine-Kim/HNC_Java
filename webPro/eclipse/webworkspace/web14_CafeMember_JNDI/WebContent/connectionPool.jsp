<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Connection Pool Test</h2><p>
<%
	Connection conn = null;
	try {
		// Naming Service
		Context ic = new InitialContext();

		// lookup (no binding here. already done in Context.xml)
		DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracleDBS");
		out.println("DataSource Lookup... Using JNDI API");

		// Connection rent
		conn = ds.getConnection();
		
		out.println("<h2><b>Got a Connection from Pool</b></h2>");
	} catch (Exception e) {
		out.println("<h2><b>Couldn't get a Connection from Pool. "
								+ "There must be a problem.</b></h2>");
	}
%>
</body>
</html>
