<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/adminpagemember.css">
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<style>
.num {
	width: 10%;
}

.sub {
	width: 30%;
}

.writer {
	width: 30%;
}

.date {
	width: 30%;
}

.Withdrawal {
	font-family: "GmarketSansMedium";
}
</style>
<section class="setop">
	<div class=row>
		<p id="pabouttitle">공지사항</p>

		<br>
		<br>
		<c:if test="${empty nlist }">
			<h1>공지사항이 없습니다</h1>
		</c:if>
		<c:if test="${not empty nlist }">
			<table class="table" id="table">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkall" /></th>
						<th>No.</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
				</thead>
				<tbody>
					<c:forEach items="${nlist }" var="n">
						<tr>
							<td><input type="checkbox" name="item" /></td>
							<td class="num">${n.admno}</td>
							<td class="sub"><a
								href="<%=request.getContextPath() %>/page/board/adreadcon?admno=${n.admno }">${n.admsubject}</a></td>
							<td class="writer">${n.id }</td>
							<td class="date">${n.admdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<br> <input type="button" value="이전 돌아가기" class="Withdrawal"
			onclick="javascript:history.back();">
	</div>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>