<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mypageindex.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
    <div class="mypage">
        <p class="pabouttitle">마이페이지</p>
<%
Member member = (Member)session.getAttribute("member");
String id = member.getId();
%>
            <button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/member/modify';"><%=member.getName()%>님 정보 수정</button><br>
            <button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/member/myboardread'">내가 쓴 글</button><br> 
            <button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/member/myreplyread'">내 글에 달린 댓글</button><br>
            <button class="outline-button" onclick="location.href='<%=request.getContextPath()%>/page/member/delete3?id=<%=id%>'">회원탈퇴하기</button>
           
    </div>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>jsp:include>


