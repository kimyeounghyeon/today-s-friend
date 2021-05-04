<%@page import="member.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%
Member member = (Member)session.getAttribute("member");
if (member == null){ 
%>
<section class="setop">
	<article>
		<div id="mainlog_">
			<p id="pabouttitle">ABOUT</p>
			<img id="mainlog" src="../../img/about.png">
		</div>
	</article>
	<article>
		<div id="review">
			<p id="pabouttitle">친구들 후기</p>
			<img id="rv" src="../../img/logo.png"> 
			<img id="rv" src="../../img/logo.png"> <br> 
			<img id="rv" src="../../img/logo.png">
			<img id="rv" src="../../img/logo.png"> <br> 
			<img id="rv"src="../../img/logo.png">
			<img id="rv" src="../../img/logo.png">
		</div>
	</article>
</section>
<%
}  else {
%>
<section class="setop">
    <article>
        <br>
        <p id="pabouttitle">취미를 선택 하세요~</p>
        <div id="intr">
            <button type="button" class="btm_image" id="select_h" onclick="location.href='../select/exercise'">
                <img src="../../img/운동.png">
            </button>
            <button type="button" class="btm_image" id="select_h" onclick="location.href='../select/movie'">
                <img src="../../img/영화.png">
            </button>
            <button type="button" class="btm_image" id="select_h" onclick="location.href='../select/game'">
                <img src="../../img/게임.png">
            </button><br>
            <button type="button" class="btm_image" id="select_h" onclick="location.href='../select/food'">
                <img src="../../img/음식.png">
            </button>
            <button type="button" class="btm_image" id="select_h" onclick="location.href='../select/stock'">
                <img src="../../img/주식.png">
            </button>
            <button type="button" class="btm_image" id="select_h" onclick="location.href='../select/freeboard'">
                <img src="../../img/자유.png">
            </button>
            <br><br><br>
        </div>
    </article>
</section>
<%	
}
%>
<jsp:include page="footer.jsp"></jsp:include>