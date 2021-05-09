<%@page import="java.util.List"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    $(function () {
           $("#btnSearch").click(function(){
            var frm = document.getElementById("frmSearch");
            frm.action = "<%=request.getContextPath()%>/page/board/boardread";
			frm.method = "post";
			frm.submit();
		});
	});
</script>
<section class="setop">
	<article>
		<p id="pabouttitle">게임친구</p>
		<a href="<%=request.getContextPath()%>/page/board/boardwrite.jsp?hobbyId=3"
			id="write" class="write">글쓰기</a>
	<c:if test="${not empty search }">
		<h1>${search }에 대한 검색 결과입니다.</h1>
	</c:if>
	<c:if test="${empty blist }">
		<h1>게시물이 없습니다</h1>
		<h1>${search } 글의 주인공이 되어주세요!</h1>
	</c:if>
	<c:if test="${not empty blist }">
		<form id="frmSearch">
				<input type="text" name="search" id="search">
				<input type="hidden" name="hobbyId" value="3">
				<input type="button" id="btnSearch" value="검색">
		</form>
		<c:forEach items="${blist }" var="v">
			<table border="1">
		<tr>
			<td>작성자</td>
			<td>${v.id }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${v.bsubject }</td>
		</tr>
		<tr>
			<td>파일경로</td>
			<td><img src="<%=request.getContextPath()%>/files/${v.bfilePath }"></td>
		</tr>
		<tr>	
			<td>내용</td>
			<td>${v.bcontent }</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="답글작성"> 
			<input type="button" value="수정" id="btnMod"> 
			<input type="button" value="삭제" id="btndel"> 
			</td>
		</tr>
		</table>
		<br>
		</c:forEach>
	</c:if>
		<c:if test="${startPage != 1 }">
			<a href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${startPage-1}&search=${search }&hobbyId=3">이전</a>
		</c:if>
		<c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
			<a href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${s }&search=${search }&hobbyId=3">${s }</a>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${endPage+1}&search=${search }&hobbyId=3">다음</a>
		</c:if>
	</article>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>