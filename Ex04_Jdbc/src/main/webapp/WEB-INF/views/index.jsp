<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${lists }<br>

<table>
<c:forEach items="${lists}" var="dto">
	<tr>
		<td>${dto.id}</td>
		<td>${dto.writer }</td>
		<td>${dto.title }</td>
		<td>${dto.content }</td>
	</tr>
</c:forEach>
</table>

</body>
</html>