<%@page import="member.member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mypageindex.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
	<div class="mypage">
	    <h2>마이 페이지</h2>
		    <button class="outline-button" id="indexModify" style="font-family: GmarketSansMedium; font-size : 14px">정재만님</button><br>
    		<button class="outline-button" style="font-family: GmarketSansMedium; font-size : 14px"><a href="<%=request.getContextPath()%>/page/member/myPageWriting.jsp">내가 쓴 글/댓글</button><br>
    		<button class="outline-button" style="font-family: GmarketSansMedium; font-size : 14px" >내 글 알림</button><br>
    </div>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>