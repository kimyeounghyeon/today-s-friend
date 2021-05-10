<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminpageindex.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<section class="setop">
	<div class="mypage">
	    <p id="pabouttitle">관리자 페이지</p>
    		<button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/admin/adminWriter.jsp';">공지사항</button>
		    <button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/admin/adminPageMember.jsp';" >회원관리</button>
    		<button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/admin/adminPageGrade.jsp';">등급관리</button>
    		<br>
    		<button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/admin/adminWriting.jsp';">게시글관리</button>
    		<button class="outline-button">인기분석</button>
    </div>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>