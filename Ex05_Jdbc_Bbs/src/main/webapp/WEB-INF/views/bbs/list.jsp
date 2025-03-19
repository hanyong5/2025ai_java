<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp" %>
	<div class="container">
		<h3>글리스트( 게시물 : ${totalCount } )</h3>
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
					<td><a href="/view?id=${dto.id}" class="nav-link">${dto.title }</a></td>
					<td><a href="/delete?id=${dto.id}" class="btn btn-primary">삭제</a></td>
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
<%@ include file="../include/footer.jsp" %>