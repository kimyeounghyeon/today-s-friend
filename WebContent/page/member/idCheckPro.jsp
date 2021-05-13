<%@page import="member.model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/join.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/font.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.chk_result {
	text-align: center;
	font-family: GmarketSansMedium;
	text-decoration:none;
}
.chk_re{
	text-align: center;
	font-family: GmarketSansMedium;
	text-decoration:none;
}
a {
text-decoration:none;
}


</style>
</head>
<body>
	<div class="chk_result">
		<h3>아이디 중복 확인 결과</h3>

		<%
			//1) 사용가능한 아이디일 경우, 아이디 입력 폼에 넣기 위함 
		MemberDao dao = new MemberDao();
		String id = request.getParameter("id");
		int cnt = dao.duplecateID(id);

		out.println("입력 ID : <strong>" + id + "</stong>");
		if (cnt == 0) {
			out.println("<p>사용 가능한 아이디에요!</p>");
			out.println("<a href='javascript:apply(\"" + id + "\")' style='color: #62e0d6'>사용할까요?</a>");
		%>
	</div>

	<script>
		function apply(id) {
			//2) 중복확인 id를 부모창에 적용 
			//부모창 opener 
			opener.document.regForm.id.value = id;
			opener.document.regForm.idDuplication.value = id;
			window.close(); //창닫기 
		}//apply () end
	</script>
	<%
		} else {
	out.println("<p style='color: red'>다른 '친구'가 사용중인 아이디 입니다</p>");
	} //if end
	%>
	<br>
	<hr>
	<br>
	<div class="chk_re">
		<a href="javascript:history.back()"  style='color: #68bee6'> 다시확인 </a> &nbsp; &nbsp; <a
			href="javascript:window.close()"  style='color: #68bee6'> 닫기 </a>
	</div>
</body>
</html>