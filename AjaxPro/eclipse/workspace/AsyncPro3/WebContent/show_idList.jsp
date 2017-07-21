<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
	var xhr;
	
	function startRequest(){
		var id = document.getElementById("memberId").value;
		// id가 한글이라서 그런지 URIEncoding 안 해줌
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("post", "DispatcherServlet");
		xhr.setRequestHeader("Content-Type", 
					"application/x-www-form-urlencoded;charset:utf-8");
		xhr.send("command=findMember&&id="+id);
		//alert(xhr.readyState + " / " + selectValue);
	}
	
	function callback(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				var id = xhr.responseText.trim();
				document.getElementById("resultView").innerHTML = 
					"&nbsp;" + id;
			}
		}
	}
</script>

</head>
<body>

<h2 align="center">ID List에서 ID를 선택하세용</h2><p>
<select id="memberId" onchange="startRequest()">
	<c:forEach items="${idList}" var="id">
		<option value="${id}">${id}</option>
	</c:forEach>	
</select>
<span id="resultView"></span>

</body>
</html>