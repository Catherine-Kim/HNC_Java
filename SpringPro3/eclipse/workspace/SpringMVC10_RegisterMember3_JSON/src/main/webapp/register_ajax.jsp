<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	var xhr;
	var id;
	var idCheckView;
	
	function idCheck() { //중복확인 버튼 눌렀을때 자동호출되는 함수		
		id = document.getElementById("id");
		idCheckView = document.getElementById("idCheckView");
		if(id.value.length<5){
			idCheckView.innerHTML = "<font color='red'>아이디는 5자 이상</font>";
		 	return;
		}
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		var url = "member.do?command=idcheckAjax&&id="+id.value;
		xhr.open("get", url, true);
		xhr.send(null);
	}
	
	function callback(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				var jsonData = JSON.parse(xhr.responseText);
				if(jsonData.flag){
					idCheckView.innerHTML = "<font color='red'>이미 존재하는 아이디임</font>";
				}else{
					idCheckView.innerHTML = "<font color='blue'>쓸 수 있는 아이디임</font>";
				}
			}
		}
	}
	

</script>
</head>
<body>
<h2 align="center">Register Form....</h2><p>
<form name="regForm" action="member.do" method="post">
<input type="hidden" name="command" value="register">
ID <input type="text" name="id" id="id" onkeyup="idCheck()">
<span id="idCheckView"></span>
<br><br>
<input type="hidden" name="idFlag" value="">
PASS <input type="password" name="password"><br><br>
NAME <input type="text" name="name"><br><br>
ADDRESS <input type="text" name="address"><br><br>
<input type="submit" value="회원가입" onclick="checkReg()">  
</form>
</body>
</html>











