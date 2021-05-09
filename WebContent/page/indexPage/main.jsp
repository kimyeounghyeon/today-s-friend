<%@page import="member.model.vo.Member"%>
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
			<img id="rv" src="../../img/review1.jpg"> <img id="rv"
				src="../../img/review2.jpg"> <br> <img id="rv"
				src="../../img/logo.png"> <img id="rv"
				src="../../img/logo.png"> <br> <img id="rv"
				src="../../img/logo.png"> <img id="rv"
				src="../../img/logo.png">
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
		<br>
		<br>
		<div id="intr">
			<% String CPath = request.getContextPath(); %>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=1'">
				<img src="../../img/운동.png">&nbsp;&nbsp;<br>
				<label class="label_friend">운동친구</label>&nbsp;&nbsp;
			</button>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=2'">
				<img src="../../img/영화.png">&nbsp;&nbsp;<br> 
				<label class="label_friend">영화친구</label>&nbsp;&nbsp;
			</button>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=3'">
				<img src="../../img/게임.png">&nbsp;&nbsp; <br> 
				<label class="label_friend">게임친구</label>&nbsp;&nbsp;
			</button>
			<br>
			<br>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=4'">
				<img src="../../img/음식.png">&nbsp;&nbsp; <br> 
				<label class="label_friend">음식친구</label>&nbsp;&nbsp;
			</button>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=5'">
				<img src="../../img/주식.png">&nbsp;&nbsp; <br> 
				<label class="label_friend">주식친구</label>&nbsp;&nbsp;
			</button>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=6'">
				<img src="../../img/자유.png">&nbsp;&nbsp; <br> 
				<label class="label_friend">자유친구</label>&nbsp;&nbsp;
			</button>
			<br>
			<br>
			<br>
		</div>
	</article>
</section>
<%   
}
%>
<jsp:include page="footer.jsp"></jsp:include>