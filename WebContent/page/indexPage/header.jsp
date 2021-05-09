<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/join.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/modify.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/searchIdNPw.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>오늘의 친구</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
        $(function () {
            $("#loginbtn").click(login);
            $(".pointspan").click(point);
            $(".close").click(loginclose);
            $("#close2").click(pointclose);

            function login() {
                $(".loginmodal").css("display", "block");
                $(".form").css("display", "block");
            };
            
            function loginclose() {
                $(".loginmodal").css("display", "none");
            };           
            
            
            function point() {
                $(".pointbg").css("display", "block");
                $(".pointmodal").css("display", "block");
            };

            function pointclose() {
                $(".pointbg").css("display", "none");
            };           
            
           $("#btnLogin").click(function(){
              var frm = document.getElementById("frm");
              frm.action = "<%=request.getContextPath()%>/page/indexpage/login";
            frm.method = "post";
            frm.submit();

      });
   });
        
        $(document).ready(function(e) {
        	/*
        	$("#all_chk").click(function(){
        		var chk = $(this).is(":checked");
        		if(chk) $("input[name='cart']").prop('checked', true);
        		else  $("input[name='cart']").prop('checked', false);
        	});
        	*/
            $("#checkall").change(function(){
                if($("#checkall").is(":checked")){
        			//alert("체크박스 체크했음!");
        			$("input[name='item']").prop('checked', true);
                }else{
                    //alert("체크박스 체크 해제!");
        			$("input[name='item']").prop('checked', false);
                }	
        	});	
        });
</script>
</head>
<body>
   <header>
<% String CPath = request.getContextPath(); %>
      <div id="d1">
         <a href="<%=CPath%>/page/indexPage/main"><img src="../../img/logo.png"></a>
      </div>
      <a href="<%=CPath%>/page/indexPage/introduceourself" id="introduce" class="bar-item button">5조 소개</a> 
      <a href="<%=CPath%>/page/indexPage/serviceintro" id="introduce1" class="bar-item button">서비스 소개</a>
      <div class="dropdown-hover">
         <button class="button">친구 만나러 가기</button>
         <div class="dropdown-content bar-block">
            <a href="<%=CPath%>/page/board/boardread?hobbyId=1" class="bar-item button">운동</a> 
            <a href="<%=CPath%>/page/board/boardread?hobbyId=2" class="bar-item button">영화</a>
            <a href="<%=CPath%>/page/board/boardread?hobbyId=3" class="bar-item button">게임</a>
            <a href="<%=CPath%>/page/board/boardread?hobbyId=4" class="bar-item button">음식</a> 
            <a href="<%=CPath%>/page/board/boardread?hobbyId=5" class="bar-item button">주식</a> 
            <a href="<%=CPath%>/page/board/boardread?hobbyId=6" class="bar-item button">자유/후기</a>
         </div>
      </div>
      <a href="<%=CPath%>/page/member/myPageIndex" class="bar-item button">마이페이지</a>
      <div id="d2">
<%
Member member = (Member)session.getAttribute("member");
if (member == null){ 
%>
         <button class="header-btn button" id="loginbtn">로그인</button>
<%
}  else {

	 String grade ="";
     if(member.getGradeid()==1){
        grade = "브론즈";
     }else if (member.getGradeid()==2){
        grade = "실버";
     }else if (member.getGradeid()==3){
        grade = "골드";
     }else if (member.getGradeid()==4){
        grade = "플래티넘";
     }else{
        grade = "다이아몬드";
     }
%>
<p>반가운 <%=member.getName()%>님! <br> <span class="pointspan"><span>등급 : <%=grade%> / </span> <span>포인트: <%=member.getMpoint()%></span></span></p>
			<div class="myinfo_btn">
			<button type="button" id="btnLogout" onclick="location.href='<%=CPath%>/page/member/modify.jsp';">정보수정</button>
			<button type="button" id="btnLogout" onclick="location.href='<%=CPath%>/page/indexpage/logout';">로그아웃</button>
			</div>
<%	
}
%>
      </div>
      <!-- 로그인 모달창 -->
      <div class="loginmodal">
         <div class="form">
            <span class=close>&#10006;</span>
            <form class="login-form" id="frm">
               <input type="text" placeholder="id" name="id" /> <input
                  type="password" placeholder="password" name="passwd" />
               <button class="header-btn button" id="btnLogin">login</button>
               <p class="message">
                  <a href="<%=CPath%>/page/member/search.jsp">ID/PW찾기</a>
                  <a href="<%=CPath%>/page/member/join" id="join" class="join">회원가입</a>
               </p>
            </form>
         </div>
      </div>
      <!-- 모달 끝! -->
      <!-- 포인트 모달창 -->
        <div class="pointbg" id="pointbg">
         <div class="pointmodal">
            <span id=close2>&#10006;</span>
	 			<img src="../../img/포인트모달.png" class="pointimg"> 
         </div>
      </div>
      <!-- 모달 끝! -->
   </header>