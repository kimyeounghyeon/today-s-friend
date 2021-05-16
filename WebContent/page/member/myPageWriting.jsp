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
		<p class="pabouttitle">내가 쓴 글</p>
		<div class=row>
			<c:if test="${not empty blist }">
				<!-- <form id="frmhidden"> -->
				<table class="table" id="table">
					<thead>
						<tr>
							<th class="chk"><input type="checkbox" id="checkall" /></th>
							<th class="hobbyid">게시판</th>
							<th class="subj">제목</th>
							<th class="con">내용</th>
							<th class="date">작성일</th>
							<th class="del">삭제</th>
					</thead>
					<tbody>
						<c:forEach items="${blist }" var="b" varStatus="status">

							<tr>
								<td class="chk"><input type="checkbox" name="item"
									id="item" value="${b.id }" /></td>

								<td class="hobbyid"><c:if test="${b.hobbyId eq 1 }">
										<c:out value="운동"></c:out>
									</c:if>
									<c:if test="${b.hobbyId eq 2 }">
										<c:out value="영화"></c:out>
									</c:if>
									<c:if test="${b.hobbyId eq 3 }">
										<c:out value="게임"></c:out>
									</c:if>
									<c:if test="${b.hobbyId eq 4 }">
										<c:out value="음식"></c:out>
									</c:if>
									<c:if test="${b.hobbyId eq 5 }">
										<c:out value="주식"></c:out>
									</c:if>
									<c:if test="${b.hobbyId eq 6 }">
										<c:out value="자유"></c:out>
									</c:if>
								</td>

								<td class="subj">${b.bsubject }</td>
								<td class="con">${b.bcontent }</td>
								<td class="date">${b.bdate }</td>
								<td class="date">
								<button type="button" class="btn" id="ed"
								onclick="location.href='<%=request.getContextPath()%>/page/board/delete2?bno=${b.bno}'">삭제</button>
								</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>

			</c:if>
		</div>
	</div>

	<br> <br>

</section>

</body>
</html>