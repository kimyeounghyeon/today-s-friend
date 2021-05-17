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
     
	.btn {
    /* border:1px solid #ddd; */
    /* width: 70px; */
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
	}
	
</style>

<section class="setop">
	<p id="pabouttitle">공지사항 읽기</p>
	<c:if test="${not empty nlist }">
	<table border="1">
		<tr>
			<td class="td1">글번호</td>
			<td class="td2">&nbsp;${nlist.admno}</td>
		</tr>
		<tr>
			<td class="td1">작성자</td>
			<td class="td2">&nbsp;${nlist.id}</td>
		</tr>
		<tr>
			<td class="td1">제목</td>
			<td class="td2">&nbsp;${nlist.admsubject}</td>
		</tr>
		<tr>
			<td class="content2">내용</td>
			<td class="td2">&nbsp;${nlist.admcontent}</td>
		</tr>
		<tr>
			<td colspan="2" class="td3">
				<button type="button" id="btnAMod" class="btn" onclick="ModifyContent();">수정</button>
				<button type="button" id="btnAdel" class="btn" onclick="window.location='<%=request.getContextPath() %>/page/admin/admboarddelete?admno=${nlist.admno}';">삭제</button>
				<button type="button" class="btn" onclick="window.location='<%=request.getContextPath() %>/page/admin/admboardread';">목록</button>
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