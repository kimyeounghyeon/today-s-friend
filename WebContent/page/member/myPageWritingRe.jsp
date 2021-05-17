<%@page import="board.model.vo.Board"%>
<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/mypagewriting.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/font.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
	<div class="mypagelist">
		<p class="pabouttitle">내 글에 달린 댓글</p>
		<br><br>
		<div class=row>
			<c:if test="${not empty clist }">
				<table class="table" id="table">
					<thead>
						<tr>
							<th>글번호</th>
							<th>댓글작성자</th>
							<th>댓글내용</th>
							<th>댓글작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clist }" var="c" varStatus="status">
							<tr>
								<td class="subj"><a href="<%=request.getContextPath()%>/page/comment/commentlist?bno=${c.bno}">${c.bno }</a></td>
								<td class="con">${c.id }</td>
								<td class="date">${c.recontent }</td>
								<td class="date">${c.redate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<br>
			<div id="pagen">
			 <c:if test="${startPage != 1 }">
            <a href="<%=request.getContextPath() %>/page/member/myreplyread?pageNum=${startPage-1}">&#60;</a>
         </c:if>
         <c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
            <a
               href="<%=request.getContextPath() %>/page/member/myreplyread?pageNum=${s }">${s }</a>
         </c:forEach>
         <c:if test="${endPage < pageCnt }">
            <a href="<%=request.getContextPath() %>/page/member/myreplyread?pageNum=${endPage+1}">&#62;</a>
         </c:if>
			</div>
		</div>
	</div>
	<br> <br>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>