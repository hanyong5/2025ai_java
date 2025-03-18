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

		<div class="container d-flex justify-content-between  align-items-center">
			<h1>LOGO</h1>
			<ul class="d-flex gap-3 align-items-center">
				<li><a href="/writeForm" class="nav-link">글쓰기</a></li>
				<li><a href="/list" class="nav-link">리스트</a></li>
			</ul>
		</div>
	</div>
	<div class="container ">
		<h3>글내용보기</h3>
		<hr />

		

			<div class="row mb-3 px-3">
				
				<div class="col-2">작성자</div>
				<div class="col">${dto.writer }</div>
			</div>
			<div class="row mb-3 px-3">
				
				<div class="col-2">제목</div>
				<div class="col">${dto.title }</div>
			</div>
			<div class="row mb-3 px-3">
				
				<div class="col-2">내용</div>
				<div class="col">${dto.content }</div>
			</div>
			

			<div class="d-flex justify-content-end gap-3">
				<a href="/list" class="btn btn-primary">리스트</a>
				<a href="/writeForm" class="btn btn-info">글작성</a>

			</div>

		

	</div>

</body>
</html>