<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/font.css">
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.content {
	text-align: center;
	font-family: GmarketSansMedium;
	text-decoration:none;
}
.form {
	font-family: GmarketSansMedium;
}

.submit{
 	height: 30px;
    margin-bottom: 20px;
    margin-top: 20px;
    text-align: center;
    box-shadow:inset 0px 1px 0px 0px #ffffff;
    background:linear-gradient(to bottom, #f9f9f9 5%, #e9e9e9 100%);
    background-color:#f9f9f9;
    border-radius:6px;
    border:1px solid #dcdcdc;
    display:inline-block;
    cursor:pointer;
    color:#666666;
    /* font-family:Arial;
    font-size:15px; */
    font-weight:bold;
    padding:8px 24px;
    text-decoration:none;
    text-shadow:0px 1px 0px #ffffff;
    font-family: GmarketSansMedium;
    }
.submit:hover {
	background-color:#6bcf36;
}
.submit:active {
	position:relative;
	top:1px;
}
.bar{
	 padding: 3px 0;
     outline: 1;
     border: 1px solid transparent;
     border-bottom: 1px solid #575756;
     border-radius: 0;
}

</style>
</head>
<body>
	<div class="content">
		<h3> </h3>
		<form class="form" method="post" action="idCheckPro.jsp" onsubmit="return blankCheck(this)">
			<% String str=request.getParameter("id"); %>
			아이디 <input class="bar" type="text" name="id" maxlength="10" value="<%=str %>" autofocus>
			<input class="submit" type="submit" value="중복확인">
		</form>
	</div>

	<script> 
	function blankCheck(f){ 
		var id=f.id.value; id=id.trim(); 
		if(id.length<4){ alert("아이디는 4자 이상 입력 바랍니다 :)"); 
			return false; 
			}//if end 
			return true; 
			}//blankCheck() end
			
			</script>
</body>
</html>