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
				<th>날짜</th>
			</tr>
			<c:forEach items="${lists}" var="dto" varStatus="loop">
				<tr>
					<td>${totalCount - ((currentPage-1)*size + loop.index) }</td>
					<td>${dto.writer }</td>
					<td><a href="/view?id=${dto.id}" class="nav-link">${dto.title }</a></td>
					<%-- <td><a href="/delete?id=${dto.id}" class="btn btn-primary">삭제</a></td> --%>
					<td>${dto.formattedDate}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="d-flex justify-content-center">
			<ul class="pagination">
				<c:if test="${currentPage > 1 }">
			
				<li class="page-item">
					<a class="page-link" href="list?page=${currentPage -1}&size=${size}">Previous</a>
				</li>
				</c:if>
				
				<c:forEach begin="1" end="${totalPages }" var="page">
				<li class="page-item ${page == currentPage ? 'active':''}" >
					<a class="page-link" href="list?page=${page}&size=${size}">${page}</a>
				</li>
				</c:forEach>

				<c:if test="${currentPage < totalPages}">
				
				<li class="page-item"><a class="page-link" href="list?page=${currentPage + 1}&size=${size}">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div  class="d-flex justify-content-end">
			<a href="/writeForm" class="btn btn-primary">글작성</a>
		</div>
	</div>
<%@ include file="../include/footer.jsp" %>