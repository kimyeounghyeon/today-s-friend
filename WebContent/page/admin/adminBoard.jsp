<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("member");
if (member.getLEVnum() != 0) {
%>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<%
	} else {
%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<%
	}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/mypagewriting.css">
<script>
function deleteAdmin(inputAdmno) {
	var admno = inputAdmno;
    var answer = confirm('글을 정말 삭제하시겠습니까?');
    
    if(answer==true){
    	location ="<%=request.getContextPath()%>/page/admin/admboarddelete?admno="+admno;
    }
};
</script>
<section class="setop">
	<div class=row>
		<p id="pabouttitle">공지사항</p>
		<%
			if (member.getLEVnum() != 0) {
		%>
		<button class="btn" id="btnInsertAdmin"
			onclick="location.href='<%=request.getContextPath()%>/page/admin/adminBoardWrite.jsp'">공지글쓰기</button>
		<%
			}
		%>
		<br>
		<br>
		<c:if test="${empty nlist }">
			<h1>공지사항이 없습니다</h1>
		</c:if>
		<c:if test="${not empty nlist }">
			<table class="table" id="table">
				<thead>
					<tr>
						<th>NO</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<%
							if (member.getLEVnum() != 0) {
						%>
						<th>삭제</th>
						<%
							}
						%>
				</thead>
				<tbody>
					<c:forEach items="${nlist }" var="n">
						<tr>
							<td class="num">${n.admno}</td>
							<td class="sub"><a href="<%=request.getContextPath() %>/page/admin/adminread?admno=${n.admno }">${n.admsubject}</td>
							<td class="writer">${n.id }</td>
							<td class="date">${n.admdate}</td>
							<%
								if (member.getLEVnum() != 0) {
							%>
							<td class="date">
								<button type="button" class="btn" id="deleteAdmin"
									onclick="deleteAdmin(${n.admno });">삭제</button>
							</td>
							<%
								}
							%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<br>
		<c:if test="${startPage != 1 }">
			<a
				href="<%=request.getContextPath() %>/page/admin/admboardread?pageNum=${startPage-1}">&#60;</a>
		</c:if>
		<c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
			<a
				href="<%=request.getContextPath() %>/page/admin/admboardread?pageNum=${s }">${s }</a>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a
				href="<%=request.getContextPath() %>/page/admin/admboardread?pageNum=${endPage+1}">&#62;</a>
		</c:if>
	</div>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>