<%@page import="member.model.vo.Member"%>
<%@page import="admin.model.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<style>
     

          
 table {
   display: inline-block;
    }
.setop {
   text-align: center;
    } 
    
    .btn:hover {
        background:linear-gradient(to bottom, #e9e9e9 5%, #f9f9f9 100%);
        background-color:#e9e9e9;
    }
    .btn:active {
        position:relative;
        top:1px;
    }
    
    .td1 {
    width:100px;
    }
	
	.td2 {
	 width:700px;
	}
	
	.content2 {
		height: 400px;
		background-color: #eee;
	}
	bottom_bar{
		background-color: white;
		display: inline-block;
		float:right;
	}
	.td1{
		background-color:#eee;
	}
	.td2{
		text-align:left;
    
    }
    .td3{
        text-align: center;
	}
	button {
    font-family: GmarketSansMedium;
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
    padding:6px 24px;
    text-decoration:none;
    text-shadow:0px 1px 0px #ffffff;
    
    }

 
	
</style>
<section class="setop">
	<p id="pabouttitle">공지사항 글 수정</p>
	<form id="frmAcon">
	<table border="1">
<% Member member = (Member)session.getAttribute("member"); %>
		<tr>
			<td class="td1">글번호</td>
			<td class="td2">${param.admno}</td>
		</tr>
		<tr>
			<td class="td1">작성자</td>
			<td class="td2"><%= member.getId() %></td>
		</tr>
		<tr>
			<td class="td1">제목</td>
			<td class="td2"><input type="text" name="admsubject" value="${param.admsubject}" size=100 maxlength=15></td>
		</tr>
		<tr>
			<td class="content2">내용</td>
			<td class="td2"><input type="text" name="admcontent" value="${param.admcontent}" style="width:100%; height:400px; font-size:15px;" ></td>
		</tr>
		<tr>
			<td colspan="2" class="td3">
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