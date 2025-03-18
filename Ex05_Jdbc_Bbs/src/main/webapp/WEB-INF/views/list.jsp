<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.3/css/bootstrap.css"
	media="all" />
<style>
ul, li {
	list-style: none
}
</style>
</head>
<body>
	<div class="bg-primary text-white mb-5">

		<div class="container d-flex justify-content-between">
			<h1>LOGO</h1>
			<ul class="d-flex gap-3 align-itmes-center ">
				<li><a href="/writeForm" class="nav-link">글쓰기</a></li>
				<li><a href="/list" class="nav-link">리스트</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<h3>글리스트</h3>
		<table class="table table-striped table-hover">
			<tr>
				<th>번호</th>
				<th>글쓴이</th>
				<th>제목</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${lists}" var="dto">
				<tr>
					<td>${dto.id}</td>
					<td>${dto.writer }</td>
					<td><a href="#" class="nav-link">${dto.title }</a></td>
					<td><a href="#" class="btn btn-primary">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="d-flex justify-content-center">
			<ul class="pagination">
				<li class="page-item"><a class="page-link">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</div>
		<div  class="d-flex justify-content-end">
			<a href="/writeForm" class="btn btn-primary">글작성</a>
		</div>
	</div>

</body>
</html>