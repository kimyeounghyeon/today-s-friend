<%@page import="member.model.vo.Member"%>
<%@page import="admin.model.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<section class="setop">
	<p id="pabouttitle">공지사항 글 수정</p>
	<form id="frmAcon">
	<table border="1">
<% Member member = (Member)session.getAttribute("member"); %>
		<tr>
			<td>글번호</td>
			<td>${param.admno}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%= member.getId() %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="admsubject" value="${param.admsubject}"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="admcontent" value="${param.admcontent}"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="btnAMod" onclick="ModifyContent();">수정</button>
				<button type="button" onclick="window.location='<%=request.getContextPath() %>/page/admin/admboardread';">목록</button>
			</td>
		</tr>		
	</table>
		<input type="hidden" name="admno" value="${param.admno}">
		<input type="hidden" name="id" value="<%= member.getId() %>">
	</form>
</section>
<script>
	function ModifyContent(){		
			var frmAcon = document.getElementById("frmAcon");
			frmAcon.action="<%=request.getContextPath()%>/page/admin/admboardmodify";
			frmAcon.method="post";
			frmAcon.submit();		
	}
</script>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>