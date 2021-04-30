<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/join.css">
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
            $("#close").click(loginclose);

            function login() {
                $(".loginmodal").css("display", "block");
                $(".form").css("display", "block");
            };

            function loginclose() {
                $(".loginmodal").css("display", "none");
            };           
            
           $("#btnLogin").click(function(){
              var frm = document.getElementById("frm");
              frm.action = "<%=request.getContextPath()%>/loginmember";
            frm.method = "post";
            frm.submit();

      });
   });
</script>
</head>
<body>
   <header>
      <div id="d1">
         <a href="<%=request.getContextPath()%>/main.jsp"><img
            src="img/logo.png"></a>
      </div>
      <a href="<%=request.getContextPath()%>/introduceourself.jsp"
         id="introduce" class="bar-item button">5조 소개</a> <a
         href="<%=request.getContextPath()%>/serviceintro.jsp" id="introduce1"
         class="bar-item button">서비스 소개</a>
      <div class="dropdown-hover">
         <button class="button">친구 만나러 가기</button>
         <div class="dropdown-content bar-block">
            <a href="#" class="bar-item button">운동</a> <a href="#"
               class="bar-item button">게임</a> <a href="#" class="bar-item button">영화</a>
            <a href="#" class="bar-item button">음식</a> <a href="#"
               class="bar-item button">주식</a> <a href="#" class="bar-item button">자유/후기</a>
         </div>
      </div>
      <a href="#" class="bar-item button">마이페이지</a>
      <div id="d2">
         <button class="header-btn button" id="loginbtn">로그인</button>
      </div>
      <!-- 로그인 모달창 -->
      <div class="loginmodal">
         <div class="form">
            <span id=close>&#10006;</span>
            <form class="login-form" id="frm">
               <input type="text" placeholder="id" name="id" /> <input
                  type="password" placeholder="password" name="passwd" />
               <button class="header-btn button" id="btnLogin">login</button>
               <p class="message">
                  <a href="#">ID/PW찾기</a> <a
                     href="<%=request.getContextPath()%>/join.jsp" id="join"
                     class="join">회원가입</a>
               </p>
            </form>
         </div>
      </div>
      <!-- 모달 끝! -->
   </header>