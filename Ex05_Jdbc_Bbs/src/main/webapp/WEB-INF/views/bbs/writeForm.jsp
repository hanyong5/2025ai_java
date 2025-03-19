<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

	<div class="container ">
		<img src="images/testimg.jpg" alt="" />
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

<%@ include file="../include/footer.jsp" %>