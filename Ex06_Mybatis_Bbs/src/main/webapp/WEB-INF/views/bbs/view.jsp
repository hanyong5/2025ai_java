<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp" %>

	<div class="container ">
		<h3>글내용보기 / ${dto.formattedDate}</h3>
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

<%@ include file="../include/footer.jsp" %>