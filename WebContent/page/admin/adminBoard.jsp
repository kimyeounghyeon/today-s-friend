<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<section class="setop">
	<div class=row>
		<p id="pabouttitle">공지사항 작성</p>
	<button class="change_btn" onclick="location.href='<%=request.getContextPath()%>/page/admin/adminBoardWrite.jsp'">공지글쓰기</button>
		<br><br>
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
							<td class="sub"><a href="<%=request.getContextPath() %>/page/admin/adminread?admno=${n.admno }">${n.admsubject}</td>
							<td class="writer">${n.id }</td>
							<td class="date">${n.admdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<br>
		<c:if test="${startPage != 1 }">
			<a href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${startPage-1}&search=${search }&hobbyId=4">이전</a>
		</c:if>
		<c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
			<a href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${s }&search=${search }&hobbyId=4">${s }</a>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${endPage+1}&search=${search }&hobbyId=4">다음</a>
		</c:if>
	</div>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>