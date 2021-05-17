<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/update.css">
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<section class="setop">
	<p id="pabouttitle">공지사항 작성</p>
	<div class=row>
	<form id="frmAInsert">
	<% Member member = (Member)session.getAttribute("member"); %>
		<table class="table" id="table">
			<thead>
				<tr>
					<th>제목</th>
					<th class="sub"><textarea name="admsubject" class="textarea" cols="90" rows="1"></textarea></th>
			</thead>
			<tbody>
				<tr>
					<th>글쓰기</th>
					<td class="write"><textarea name="admcontent" class="textarea" cols="90" rows="20"></textarea></td>
				</tr>
			</tbody>
		</table>
			<input type="hidden" name="id" value="<%= member.getId() %>">
		</form>
		<br>
		<button type="button" id="btnAInsert" onclick="InsertContent();">등록</button>
	</div>
</section>
<script>
	function InsertContent(){		
			var frmAInsert = document.getElementById("frmAInsert");
			frmAInsert.action="<%=request.getContextPath()%>/page/admin/admboardwrite";
			frmAInsert.method="post";
			frmAInsert.submit();		
	}
</script>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>