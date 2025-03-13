<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp</title>
</head>
<body>
<%
	out.println("model : hello world");
%>
	<p>
	안녕하세요. ${name} 님 만나서 반갑습니다.
	</p>
	<p>
	당신의 아이디는 ${id} 입니다.
	</p>
	<p>주민번호는 ${jumin }</p>
</body>
</html>