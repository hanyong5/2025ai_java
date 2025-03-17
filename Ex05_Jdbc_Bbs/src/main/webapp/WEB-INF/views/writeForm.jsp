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
				<li><a href="#" class="nav-link">리스트</a></li>
			</ul>
		</div>
	</div>
	<div class="container ">
		<h3>글쓰기</h3>
		<hr />

		<form action="write" method="get">

			<div class="row mb-3 px-3">
				<label for="name" class="col-2 col-form-label">작성자</label> <input
					type="text" id="name" class="col form-control" name="writer" />
			</div>
			<div class="row mb-3 px-3">
				<label for="title" class="col-2 col-form-label">제목</label> <input
					type="text" id="title" class="col form-control" name="title" />
			</div>
			<div class="row mb-3 px-3">
				<label for="content" class="col-2 col-form-label">내용</label> <input
					type="text" id="content" class="col form-control" name="content" />
			</div>

			<div class="d-flex justify-content-end">
				<input type="submit" value="insert" class="btn btn-primary" />
			</div>

		</form>

	</div>

</body>
</html>