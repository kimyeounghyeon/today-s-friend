<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<style>
#fdiv {
    border: 3px solid gray;
    width: 100%;
    height: 100;
    position: absolute;
    bottom: -200%;
    text-align: center;
}
</style>
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
			<img id="rv" src="../../img/review1.jpg"> 
			<img id="rv" src="../../img/review2.jpg"> <br> 
			<img id="rv" src="../../img/review3.jpg"> 
			<img id="rv" src="../../img/review4.jpg"> <br> 
			<img id="rv" src="../../img/review5.jpg"> 
			<img id="rv" src="../../img/review6.jpg">
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
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=1&locnum=<%=member.getLocnum() %>'">
				<img src="../../img/운동.png">&nbsp;&nbsp;<br>
				<label class="label_friend">운동친구</label>&nbsp;&nbsp;
			</button>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=2&locnum=<%=member.getLocnum() %>'">
				<img src="../../img/영화.png">&nbsp;&nbsp;<br> 
				<label class="label_friend">영화친구</label>&nbsp;&nbsp;
			</button>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=3&locnum=<%=member.getLocnum() %>'">
				<img src="../../img/게임.png">&nbsp;&nbsp; <br> 
				<label class="label_friend">게임친구</label>&nbsp;&nbsp;
			</button>
			<br>
			<br>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=4&locnum=<%=member.getLocnum() %>'">
				<img src="../../img/음식.png">&nbsp;&nbsp; <br> 
				<label class="label_friend">음식친구</label>&nbsp;&nbsp;
			</button>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=5&locnum=<%=member.getLocnum() %>'">
				<img src="../../img/주식.png">&nbsp;&nbsp; <br> 
				<label class="label_friend">주식친구</label>&nbsp;&nbsp;
			</button>
			<button type="button" class="btm_image" onclick="location.href='<%=CPath%>/page/board/boardread?hobbyId=6&locnum=<%=member.getLocnum() %>'">
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