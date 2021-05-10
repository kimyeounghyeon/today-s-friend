<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminpagegrade.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../admin/adminheader.jsp"></jsp:include>

<section class="setop">


	<div class="mypagelist">
		<h2>등급 관리</h2>
		<div class="search">
			<form class="search_form" action="#" method="get">
	    		<input class="search_bar" type="text" name="keyword" placeholder="회원아이디로 검색" style="font-family: GmarketSansMedium;">
	    		<button class="search_btn" type="submit" style="font-family: GmarketSansMedium;">검색</button>
		  	</form>
		<c:if test="${empty search }">
		<c:if test="${not empty search}">
		<h1>${search}에 대한 검색 결과입니다.</h1>
		<table border="1">
			<tr>
			<th><input type="checkbox" id="checkall" /></th>
				<th>No</th>
				<th>아이디</th>
				<th>이름</th>
				<th>포인트</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="item" /></td>
				<td>1</td>
				<td>${m.id}</td>
				<td>${m.name}</td>
				<td name="mpoint" >${m.mpoint}</td>
			</tr>		
		</table>
	</c:if>
	</c:if>
		</div>

		<div class=row>
		<c:if test="${empty mlist}">
		등록 된 회원이 없습니다.
		</c:if>
		<c:if test="${not empty mlist }">
			<table class="table" id="table">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkall" /></th>
						<th>No.</th>
						<th>아이디</th>
						<th>이름</th>
						<th>포인트</th>
				</thead>
				<tbody>
		<c:forEach items="${mlist }" var="m">
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td class="num">1</td>
						<td class="id">${m.id}</td>
						<td class="name">${m.name}</td>
						<td class="mpoint">${m.mpoint}</td>
					</tr>
	</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	</div>
	<button class="levelup_btn" type="button" style="font-family: GmarketSansMedium;">등급 UP</button>
	<form id="frmhidden">
	<input type="hidden" name="mpoint" value="${m.mpoint }">
	<input type="hidden" name="id" value="${m.id }">
	</form>
			<c:if test="${startPage != 1 }">
			<a href="<%=request.getContextPath() %>/page/indexpage/gradeUp?pageNum=${startPage-1}&search=${search }">이전</a>
		</c:if>
		<c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
			<a href="<%=request.getContextPath() %>/page/indexpage/gradeUp?pageNum=${s }&search=${search }">${s }</a>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="<%=request.getContextPath() %>page/indexpage/gradeUp?pageNum=${endPage+1}&search=${search }">다음</a>
		</c:if>
</section>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	$(function(){
		$(".levelup_btn").click(levelup);
		
		function levelup(){
			if($("input:checkbox[name='item']:checked")) {
			var mpoint = $("#mpoint").val();
			console.log("버튼 동작해용");
			console.log(mpoint);
			
			var frmhidden = document.getElementById("frmhidden");
			frmhidden.action = "<%=request.getContextPath()%>/page/indexpage/gradeup";
			frmhidden.method = "post";
			frmhidden.submit();
			
			} else {
				console.log("실패");
			}
		}
	});
	
	</script>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>