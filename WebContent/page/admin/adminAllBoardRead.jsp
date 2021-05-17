<%@page import="board.model.vo.Board"%>
<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/mypagewriting.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/font.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
<section class="setop">
	<div class="mypagelist">
		<p class="pabouttitle">게시글 관리</p>
		<br><br>
		<div class=row>
			<c:if test="${not empty blist }">
				<table class="table" id="table">
					<thead>
						<tr>
							<th>NO</th>
							<th class="id">작성자</th>
							<th class="hobbyid">취미</th>
							<th class="locnum">지역</th>
							<th class="subj">제목</th>
							<th class="con">내용</th>
							<th class="date">작성일</th>
							<th class="del">삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blist }" var="b" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td class="subj">${b.id }</td>
								<td class="hobbyid"><c:if test="${b.hobbyId eq 1 }">
										<c:out value="운동"></c:out>
									</c:if> <c:if test="${b.hobbyId eq 2 }">
										<c:out value="영화"></c:out>
									</c:if> <c:if test="${b.hobbyId eq 3 }">
										<c:out value="게임"></c:out>
									</c:if> <c:if test="${b.hobbyId eq 4 }">
										<c:out value="음식"></c:out>
									</c:if> <c:if test="${b.hobbyId eq 5 }">
										<c:out value="주식"></c:out>
									</c:if> <c:if test="${b.hobbyId eq 6 }">
										<c:out value="자유"></c:out>
									</c:if></td>
								<td class="locnum"><c:if test="${b.locNum eq 1 }">
										<c:out value="서울"></c:out>
									</c:if> <c:if test="${b.locNum eq 2 }">
										<c:out value="경기"></c:out>
									</c:if> <c:if test="${b.locNum eq 3 }">
										<c:out value="인천"></c:out>
									</c:if> <c:if test="${b.locNum eq 4 }">
										<c:out value="충청"></c:out>
									</c:if> <c:if test="${b.locNum eq 5 }">
										<c:out value="강원"></c:out>
									</c:if> <c:if test="${b.locNum eq 6 }">
										<c:out value="경상"></c:out>
									</c:if>	<c:if test="${b.locNum eq 7 }">
										<c:out value="전라"></c:out>
									</c:if>	<c:if test="${b.locNum eq 8 }">
										<c:out value="제주"></c:out>
									</c:if></td>
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
			<br>
			<div id="pagen">
			 <c:if test="${startPage != 1 }">
            <a href="<%=request.getContextPath() %>/page/board/boardAllread?pageNum=${startPage-1}">&#60;</a>
         </c:if>
         <c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
            <a
               href="<%=request.getContextPath() %>/page/board/boardAllread?pageNum=${s }">${s }</a>
         </c:forEach>
         <c:if test="${endPage < pageCnt }">
            <a href="<%=request.getContextPath() %>/page/board/boardAllread?pageNum=${endPage+1}">&#62;</a>
         </c:if>
			</div>
		</div>
	</div>
	<br> <br>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>