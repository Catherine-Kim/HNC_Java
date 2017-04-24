<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"> 1. 우승자 명단</h2>
1등.  ${winner[0]} <br/>
2등.  ${winner[1]} <br/>
3등.  ${winner[2]} <br/>
<hr>
<h2 align="center"> 2. 이 달에 가장 많이 팔린 과일은</h2>
가장 많이 팔린 과일.  ${items[0]} <br/>
두 번째로 많이 팔린 과일.  ${items[1]} <br/>
<hr>
<h2 align="center"> 3. Edgar와 Gosling의 주소를 출력합니다.</h2>
Edgar 주소.  ${map.Edgar} <br/>
Gosling의 주소.  ${map["Gosling"]} <br/>
${param.name}이 사는 곳은 ${map[param.name] } 입니당
</body>
</html>
