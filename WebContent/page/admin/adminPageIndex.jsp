<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminpageindex.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<section class="setop">
	<div class="mypage">
	    <h2>관리자 페이지</h2>
		    <button class="outline-button" style="font-family: GmarketSansMedium; font-size : 14px"><a href="<%=request.getContextPath()%>/page/admin/adminPageMember">회원관리</button>
    		<button class="outline-button" style="font-family: GmarketSansMedium; font-size : 14px"><a href="<%=request.getContextPath()%>/page/admin/adminPageGrade">등급관리</button>
    		<button class="outline-button" style="font-family: GmarketSansMedium; font-size : 14px"><a href="<%=request.getContextPath()%>/page/admin/adminWriter">공지사항</button><br>
    		<button class="outline-button" style="font-family: GmarketSansMedium; font-size : 14px"><a href="<%=request.getContextPath()%>/page/admin/adminWriting">글/댓글 삭제</button>
    		<button class="outline-button" style="font-family: GmarketSansMedium; font-size : 14px"><a href="<%=request.getContextPath()%>#">인기분석</button>
    </div>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>