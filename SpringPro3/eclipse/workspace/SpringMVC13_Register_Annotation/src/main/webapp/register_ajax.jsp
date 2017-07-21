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
	function idCheck() { 		
		id = document.getElementById("id");
		idCheckView = document.getElementById("idCheckView");
		if(id.value.length<5){ //id가 5자가 안된다면..
			idCheckView.innerHTML="<font color='red'>아이디는 5자 이상!!</font>";
			return;
		}
		//ajax기술로 연결
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		var url ="member.do?command=idcheckAjax&&id="+id.value;
		xhr.open("get",url,true);
		xhr.send(null);
	}
	function callback() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				var jsonData = JSON.parse(xhr.responseText);
				if(jsonData.flag){
					idCheckView.innerHTML=
						"<font color='red'>ID 사용 불가!!</font>";
				}else{
					idCheckView.innerHTML=
						"<font color='blue'>ID 사용 가능!!</font>";
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
ID <input type="text" name="id" onkeyup="idCheck()" id="id">
<span id="idCheckView"></span><br><br>
PASS <input type="password" name="password"><br><br>
NAME <input type="text" name="name"><br><br>
ADDRESS <input type="text" name="address"><br><br>
<input type="submit" value="회원가입">  
</form>
</body>
</html>











