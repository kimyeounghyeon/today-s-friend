<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" 	href="<%=request.getContextPath()%>/css/font.css">
<link rel="stylesheet" type="text/css" 	href="<%=request.getContextPath()%>/css/main.css">
<link rel="stylesheet" type="text/css" 	href="<%=request.getContextPath()%>/css/mypageindex.css">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>오늘의 친구</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<header>
		<%
			String CPath = request.getContextPath();
		%>
		<div id="d1">
			<a href="<%=CPath%>/page/admin/adminPageIndex.jsp">
			<img src="../../img/logo.png"></a>
		</div>
		<a href="<%=CPath%>/page/admin/admboardread" class="bar-item button">공지사항</a>
		<a href="<%=CPath%>/page/indexpage/user" class="bar-item button">회원관리</a>
		<a href="<%=CPath%>/page/indexpage/point" class="bar-item button">등급관리</a>
		<a href="<%=CPath%>/page/board/boardAllread" class="bar-item button">게시글관리</a>
		
		<a href="javascript:void(window.open('<%=request.getContextPath()%>/page/board/allcount', '_blank','width=1000px, height=600px'));" class="bar-item button">인기분석</a>
		<div id="d3">
			<div>관리자님!</div>
			<button type="button" class="adminLogout" onclick="window.close()">관리자모드 나가기</button>
		</div>
	</header>