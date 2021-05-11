<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/mypagewriting.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/font.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<%
	String test = (String) session.getAttribute("sessionId");
	System.out.println("test : " + test);
%>
<section class="setop">
	<div class="mypagelist">
		<p class="pabouttitle">내가 쓴 글/댓글</p>
		<button class="mywrite_btn" style="font-family: GmarketSansMedium;">내
			글</button>
		<button class="mywrite_btn" style="font-family: GmarketSansMedium;">내
			댓글</button>
		<div class=row>
			<c:if test="${empty mlist}">
			</c:if>
			<c:if test="${not empty mlist }">
				<form id="frmhidden">
					<table class="table" id="table">
						<thead>
							<tr>
								<th><input type="checkbox" id="checkall" /></th>
								<th>No.</th>
								<th>게시판</th>
								<th>제목</th>
								<th>작성일</th>
						</thead>
						<tbody>
							<c:forEach items="${mlist }" var="m" varStatus="status">
								<%-- <c:set var="i" value="${i+1 }" /> --%>
								<tr>
									<td><input type="checkbox" name="item" id="item"
										value="${m.id }" /></td>
									<td class="num">${status.count }</td>
									<td class="id">${m.hobby }</td>
									<td class="name">${m.bsubject }</td>
									<td class="pnum">${m.date }</td>
								</tr>
							</c:forEach>

							<!-- <tr>
						<td><input type="checkbox" name="item" /></td>
						<td class="num">1</td>
						<td class="sub">운동</td>
						<td class="change">안녕하세요</td>
						<td class="date">2021-04-29</td>
					</tr> -->
						</tbody>
					</table>
				</form>
			</c:if>
		</div>
		
		
	</div>
	<br> <br>
	<%-- 페이징 --%>
	<%-- <c:if test="${startPage != 1 }">
		<a
			href="<%=request.getContextPath() %>/page/indexpage/point?pageNum=${startPage-1}&search=${search }">이전</a>
	</c:if>
	<c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
		<a
			href="<%=request.getContextPath() %>/page/indexpage/point?pageNum=${s }&search=${search }">${s }</a>
	</c:forEach>
	<c:if test="${endPage < pageCnt }">
		<a
			href="<%=request.getContextPath() %>/page/indexpage/point?pageNum=${endPage+1}&search=${search }">다음</a>
	</c:if> --%>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>