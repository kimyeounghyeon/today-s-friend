<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/adminpagemember.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<section class="setop">
	<div class="mypagelist">
		<p id="pabouttitle">회원 관리</p>
		<div class="search">
			<form class="search_form" action="#" method="get">
				<input class="search_bar" type="text" name="keyword"
					placeholder="회원아이디로 검색" style="font-family: GmarketSansMedium;">
				<button class="search_btn" type="submit"
					style="font-family: GmarketSansMedium;">검색</button>
			</form>
			<c:if test="${empty search }">
				<c:if test="${not empty search}">
					<h1>${search}에대한 검색 결과입니다.</h1>
					<table border="1">
						<tr>
							<th><input type="checkbox" id="checkall" /></th>
							<th>No</th>
							<th>아이디</th>
							<th>이름</th>
							<th>연락처</th>
						</tr>
						<tr>
							<td><input type="checkbox" name="item" /></td>
							<td>2</td>
							<td>${m.id }</td>
							<td>${m.name }</td>
							<td>${m.phone }</td>
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
				<form id="frmhidden">
					<table class="table" id="table">
						<thead>
							<tr>
								<th><input type="checkbox" id="checkall" /></th>
								<th>No.</th>
								<th>아이디</th>
								<th>이름</th>
								<th>연락처</th>
						</thead>
						<tbody>
							<c:forEach items="${mlist }" var="m">
								<c:set var="i" value="${i+1 }" />
								<tr>
									<td><input type="checkbox" name="item" id="item"
										value="${m.id }" /></td>
									<td class="num">${i }</td>
									<td class="id">${m.id }</td>
									<td class="name">${m.name }</td>
									<td class="pnum">${m.phone }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</c:if>
		</div>
	</div>
	<button class="Withdrawal" type="button" id="delete_btn"
		style="font-family: GmarketSansMedium;">회원탈퇴</button>
	<br>
	<br>
	<c:if test="${startPage != 1 }">
		<a href="<%=request.getContextPath() %>/page/indexpage/user?pageNum=${startPage-1}&search=${search }">이전</a>
	</c:if>
	<c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
		<a href="<%=request.getContextPath() %>/page/indexpage/user?pageNum=${s }&search=${search }">${s }</a>
	</c:forEach>
	<c:if test="${endPage < pageCnt }">
		<a href="<%=request.getContextPath() %>/page/indexpage/user?pageNum=${endPage+1}&search=${search }">다음</a>
	</c:if>
</section>
<script>


	$("#checkall").change(function(){
	    if($("#checkall").is(":checked")){
	     //alert("체크박스 체크했음!");
	     $("input[name='item']").prop('checked', true);
	    }else{
	        //alert("체크박스 체크 해제!");
	     $("input[name='item']").prop('checked', false);
	    }
	});


	$(function (){
		   $("#delete_btn").click(Withdrawal);
		  
		      function Withdrawal(){
		          if($("input:checkbox[name='item']:checked")) {
		             var ids = $("#item").val();
		             console.log("테스트");
		             console.log(ids);
		             		             
	            	 var frmhidden = document.getElementById("frmhidden");
	                 frmhidden.action = "<%=request.getContextPath() %>/page/indexpage/deletepage";
	                 frmhidden.method = "post";
	                 frmhidden.submit();	                
		             } else {
		            	 console.log("실패");
		             }
		         }
		   });
		   
	
	
</script>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>