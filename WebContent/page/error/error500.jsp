<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<style>
.img{
	width : 1100px;
	height: 500px;
}
.setop{
	text-align: center;
}
</style>
<section class="setop">
<br><br><br>
	<span class="span">
		<a href="<%=request.getContextPath()%>/page/indexPage/main"><img
			src="../../img/error500.png" class="img"></a>
	</span>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>