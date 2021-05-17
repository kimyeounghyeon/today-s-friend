<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
   <p id="pabouttitle">아이디 / 비밀번호 찾기</p>
   <div class="loginmodal" id="modelid">
      <div class="form idpw" id="dfrmsi">
         <span id=close_check onclick="checkclose();">&#10006;</span>
         <p class="pabouttitle">아이디 찾기</p>
         <br> <span class="smsg">회원 정보에 등록한 이름과 이메일 주소가 같아야,<br>아이디를 찾을 수 있습니다.</span>
         <br><br>
         <form class="login-form" id="frmsi">
            <input type="text" placeholder="name" name="name" />
            <input type="text" placeholder="e-mail" name="email" />
            <input type="hidden" name="id" value="''" />
            <button class="btnsearch" id="btnSI">아이디 찾기</button>
         </form>
      </div>
   </div>
   <div class="loginmodal" id="modelpw">
      <div class="form idpw" id="dfrmpw">
         <span id=close_check onclick="checkclose();">&#10006;</span>
         <p class="pabouttitle">비밀번호 찾기</p>
         <br> <span class="smsg">회원 정보에 등록한 아이디와 이메일 주소가 같아야,<br>비밀번호를 찾을 수 있습니다.</span>
         <br><br>
         <form class="login-form" id="frmpw">
            <input type="text" placeholder="id" name="id" />
            <input type="text" placeholder="e-mail" name="email" />
            <input type="hidden" name="name" value="''" />
            <button class="btnsearch" id="btnPW">비밀번호 찾기</button>
         </form>
      </div>
   </div>
   <div class="btns">
   <button class="btn-search" onclick="searchId();"><h1>아이디 찾기</h1></button>
   <button class="btn-search"onclick="searchPW();"><h1>비밀번호 찾기</h1></button>
   </div>
   <script>
      function searchId() {
         $("#modelid").css("display", "block");
         $("#dfrmsi").css("display", "block");
      };
      function searchPW() {
         $("#modelpw").css("display", "block");
         $("#dfrmpw").css("display", "block");
      };
      
      function checkclose(){
    	  $("#modelid").css("display", "none");
          $("#dfrmsi").css("display", "none");
          $("#modelpw").css("display", "none");
          $("#dfrmpw").css("display", "none");
      };
      
      $("#btnSI").click(function() {
         var frmsi = document.getElementById("frmsi");
         frmsi.action = "<%=request.getContextPath()%>/page/member/search";
         frmsi.method = "post";
         frmsi.submit();
      });
      $("#btnPW").click(function() {
         var frmpw = document.getElementById("frmpw");
         frmpw.action = "<%=request.getContextPath()%>/page/member/search";
         frmpw.method = "post";
         frmpw.submit();
      });
      

   </script>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>