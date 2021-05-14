<%@page import="java.util.List"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/select.css">
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<style>
.pabouttitle{
	display : inline-block;
}
#tool {
	align-content: center;
	text-align: center;
}
#fdiv {
    border: 3px solid gray;
    width: 100%;
    height: 100;
    position: absolute;
    bottom: -350%;
    text-align: center;
}
#selloc{
	display : inline-block;
 	width: 150px;
}

</style>
<script>
    $(function () {
           $("#btnSearch").click(function(){
            var frm = document.getElementById("frmSearch");
            frm.action = "<%=request.getContextPath()%>/page/board/boardread";
			frm.method = "post";
			frm.submit();
           	});
           
			$("#selloc").change(function(){ 
    		var locnum = $(this).val();
    		location = "<%=request.getContextPath()%>/page/board/boardread?hobbyId=1&locnum="+locnum;
			});
		
	});
</script>
<div class="click"
	style="position: fixed; right: 100px; bottom: 50px; z-index: 100">
	<a
		href="<%=request.getContextPath()%>/page/board/boardwrite.jsp?hobbyId=4"
		id="write" class="write"><img class="click" src="../../img/클릭.png"
		onmouseover="this.src='../../img/클릭.png'"
		onmouseout="this.src='../../img/클릭1.png'"> </a>
</div>
<section class="setop">
	<article id="hi">
<% 
String loc = (String)request.getAttribute("loc");
%>
		<p class="pabouttitle">운동친구 - <%=loc %></p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="selloc">
			<option value="">--지역 선택--</option>
			<option value="1">서울</option>
			<option value="2">경기</option>
			<option value="3">인천</option>
			<option value="4">충청</option>
			<option value="5">강원</option>
			<option value="6">경상</option>
			<option value="7">전라</option>
			<option value="8">제주</option>
		</select>
		<br>
		<div id="tool">

			<a id="introducea" class="bar-item button"
				href="javascript:void(window.open('https://www.youtube.com/watch?v=tyiN2jjaX0g', '_blank'))">운동영상</a>
			<a id="introduceb" class="bar-item button"
				href="javascript:void(window.open('<%=request.getContextPath()%>/page/map/map.jsp', '_blank','width=500px, height=400px'))">따릉이
				대여</a> <a href="<%=request.getContextPath()%>/page/board/adread"
				id="introducec" class="bar-item button">공지사항</a> <a id="introduced"
				class="bar-item button"
				href="javascript:void(window.open('<%=request.getContextPath()%>/page/channel/channel.jsp', '_blank','width=500px, height=400px'))">신고
				& 문의</a> <a id="introducee" class="bar-item button"
				href="javascript:void(window.open('<%=request.getContextPath()%>/page/channel/chatting.jsp', '_blank','width=500px, height=700px'))">채팅하기</a>

		</div>
		<br>
		<c:if test="${not empty search }">
			<h1>${search }에대한검색결과입니다.</h1>
		</c:if>
		<c:if test="${empty blist }">
			<h1>게시물이 없습니다</h1>
			<h1>${search }글의주인공이되어주세요!</h1>
		</c:if>
		<c:if test="${not empty blist }">
			<form id="frmSearch">
				<input type="text" name="search" id="search"> <input
					type="hidden" name="hobbyId" value="4"> <input
					type="button" id="btnSearch" value="검색">
			</form>
			<c:forEach items="${blist }" var="v" varStatus="status">
				<table border="1" class="trd">
					<tr class="line" id="sub">
						<td colspan=2;>&nbsp;${v.bsubject }</td>
					</tr>
					<tr class="nline" id="vid">
						<td style="padding-left: 10px;" valign="top">${v.id }</td>

						<td class="btnn" style="text-align: right">
							<button type="button" class="btn" id="ed"
								onclick="location.href='<%=request.getContextPath()%>/page/board/simread?bno=${v.bno}'">수정</button>
							<button type="button" class="btn" id="ed"
								onclick="location.href='<%=request.getContextPath()%>/page/board/delete1?bno=${v.bno}&hobbyId=4'">삭제</button>
						</td>
					</tr>
					<tr class="nline setrimg">
						<td colspan="2" height="500" width="600">
					<c:if test="${not empty v.bfilePath }">
							<img src="<%=request.getContextPath()%>/files/${v.bfilePath }">
					</c:if>
					<c:if test="${empty v.bfilePath }">
							<img src="../../img/logo회색.png">
					</c:if>
						</td>
					</tr>
					<tr class="nline" height="50">
						<td valign="bottom" colspan="2">${v.bcontent }</td>
					</tr>
					<tr class="nline" height="20">
						<td class="ar" colspan="2"
							style="text-align: right; valign: bottom;">${v.fbno }</td>
					</tr>
					<tr class="nline" id="pan" bgcolor="#57d2b4">
						<td colspan="2">
							<button type="button" class="btn"
								onclick="location.href='<%=request.getContextPath()%>/page/comment/commentlist?bno=${v.bno}'">댓글쓰러가기</button>
						</td>
						<form id="frmmod" class="frmmod">
							<input type="hidden" name="bno" value="${v.bno }"> <input
								type="hidden" name="id" value="${v.id }"> <input
								type="hidden" name="bsubject" value="${v.bsubject }"> <input
								type="hidden" name="bfilePath" value="${v.bfilePath }">
							<input type="hidden" name="bcontent" value="${v.bcontent }">
							<input type="hidden" name="hobbyId" value="4">
						</form>
				</table>
				<br>
			</c:forEach>
		</c:if>
		<div id="pagen">
			<c:if test="${startPage != 1 }">
				<a href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${startPage-1}&search=${search }&hobbyId=4">이전</a>
			</c:if>
			<c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
				<a
					href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${s }&search=${search }&hobbyId=4">${s }</a>
			</c:forEach>
			<c:if test="${endPage < pageCnt }">
				<a
					href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${endPage+1}&search=${search }&hobbyId=4">다음</a>
			</c:if>
		</div>
	</article>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>