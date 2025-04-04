<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LG</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.css"
	media="all" />
<link rel="stylesheet" href="css/style.css" media="all" />

</head>
<body>
	<div class="bg-primary text-white mb-5">

		<div class="container d-flex justify-content-between  align-items-center">
			<h1><a href="./" class="nav-link">LG</a></h1>
			<ul class="d-flex gap-3 align-items-center">
				<li><a href="/writeForm" class="nav-link">글쓰기</a></li>
				<li><a href="/list" class="nav-link">리스트</a></li>
				<sec:authorize access="isAuthenticated()">
					<li><a href="/logout" class="nav-link">로그아웃</a></li>
					<li> <sec:authentication property="principal.username" /> 님</li>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<li><a href="/login" class="nav-link">로그인</a></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
	