<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mypageindex.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
    <div class="mypage">
        <h2>마이 페이지</h2>
<%
Member member = (Member)session.getAttribute("member");
%>
            <button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/member/modify';"><%=member.getName()%>님 정보 수정</button><br>
            <button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/member/myPageWriting';">내가 쓴 글/댓글</button><br>
            <button class="outline-button">내 글 알림</button><br>
    </div>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>jsp:include>