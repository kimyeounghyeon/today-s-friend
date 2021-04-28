<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkValues() {
		if(document.getElementById("grade").value.length>2){
			alert("등급은 2자리 문자만 허용합니다.")
			return false;
		}
		// 유효성 검사를 쭈욱~~
		// return false;
		
		return true;
	}
</script>
</head>
<body>
<%= request.getContextPath() %>

	<form action="<%=request.getContextPath() %>/minsert" method="post">
		아이디: <input type="text" name="id"/> <br>
		패스워드: <input type="password" name="passwd"/> <br>
		이름: <input type="text" name="name"/> <br>
		이메일: <input type="text" name="email"/> <br>
		등급: <input type="text" name="grade" id="grade"/> <br>
		성별: 남<input type="radio" name="gender" value="m"/> &nbsp;&nbsp;&nbsp; 여<input type="radio" name="gender" value="f"/> <br>
		<input type="submit" onclick ="return checkValues();">
	</form>
</body>
</html>