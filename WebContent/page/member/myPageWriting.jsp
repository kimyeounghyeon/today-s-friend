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
		<p class="pabouttitle">내가 쓴 글/댓글</p>
		<button class="mywrite_btn" style="font-family: GmarketSansMedium;">내
			글</button>
		<button class="mywrite_btn" style="font-family: GmarketSansMedium;">내
			댓글</button>
		<div class=row>
			<c:if test="${not empty blist }">
				<!-- <form id="frmhidden"> -->
					<table class="table" id="table">
						<thead>
							<tr>
								<th class="chk"><input type="checkbox" id="checkall" /></th>
								<th class="hobbyid">게시판</th>
								<th class="subj">제목</th>
								<th class="date">작성일</th>
								<th class="con">내용</th>
								<th class="bno">bno</th>
						</thead>
						<tbody>
							<c:forEach items="${blist }" var="b" varStatus="status">

								<tr>
									<td class="chk"><input type="checkbox" name="item"
										id="item" value="${b.id }" /></td>
									<td class="hobbyid">${b.hobbyId }</td>
									<td class="subj">${b.bsubject }</td>
									<td class="date">${b.bdate }</td>
									<td class="con">${b.bcontent }</td>
									<td class="bno">${b.bno }</td>
								</tr>
								<tr>
									<td colspan="2">
										<button type="button" class="btn" id="ed"
											onclick="location.href='<%=request.getContextPath()%>/page/board/delete2?bno=${v.bno}&hobbyId=1'">삭제</button>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
			<!-- 	</form> -->
			</c:if>
		</div>
	</div>
	<button class="Withdrawal" type="button" id="delete_btn"
		style="font-family: GmarketSansMedium;"
		onclick="location.href='<%=request.getContextPath()%>/page/member/myboarddelete'">내
		글 삭제</button>
	<br> <br>

</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>