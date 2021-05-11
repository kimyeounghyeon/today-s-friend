<%@page import="admin.model.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<section class="setop">
	<p id="pabouttitle">공지사항 읽기</p>
	<c:if test="${not empty nlist }">
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>${nlist.admno}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${nlist.id}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${nlist.admsubject}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${nlist.admcontent}</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="btnAMod" onclick="ModifyContent();">수정</button>
				<button type="button" id="btnAdel" onclick="window.location='<%=request.getContextPath() %>/page/admin/admboarddelete?admno=${nlist.admno}';">삭제</button>
				<button type="button" onclick="window.location='<%=request.getContextPath() %>/page/admin/admboardread';">목록</button>
			</td>
		</tr>		
	</table>
	</c:if>
	<form id="frmAcon">
		<input type="hidden" name="admno" value="${nlist.admno}">
		<input type="hidden" name="id" value="${nlist.id}">
		<input type="hidden" name="admsubject" value="${nlist.admsubject}">
		<input type="hidden" name="admcontent" value="${nlist.admcontent}">
	</form>
</section>
<script>
	function ModifyContent(){		
			var frmAcon = document.getElementById("frmAcon");
			frmAcon.action="<%=request.getContextPath()%>/page/admin/adminBoardModify.jsp";
			frmAcon.method="post";
			frmAcon.submit();		
	}
</script>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>