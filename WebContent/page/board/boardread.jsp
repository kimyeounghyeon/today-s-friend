<%@page import="board.model.vo.Board"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/update.css">
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
	<article>
		<%
			Board board = (Board) request.getAttribute("board");
		Member member = (Member) session.getAttribute("member");
		%>
		<h1><%=board.getBsubject()%></h1>
		<div id="center">
			<br>
			<table border="1" id="table">
				<tr>
					<td>글번호</td>
					<td><%=board.getBno()%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><%=board.getBsubject()%></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><%=board.getBcontent()%></td>
				<tr>
					<td>파일선택-여러개</td>
					<td><img
						src="<%=request.getContextPath()%>/files/<%=board.getBfilePath()%>">

					</td>
				</tr>
				<tr>
					<td rowspan="2">댓글보기</td>
					<td><c:if test="${empty comment }">
							댓글이 없습니다.
							</c:if> <c:if test="${not empty comment }">
							<c:forEach items="${comment }" var="c" varStatus="status">
								<table>
									<tr>
										<td>${c.id }</td>
										<td>${c.recontent }</td>
										<td>${c.redate }</td>
									</tr>
								</table>
							</c:forEach>
						</c:if>
					<td>
				</tr>
				<tr>
					<td>
						<div id="btn_group">
							<form id="frmComment">
                                <input type="hidden" name="bno" value="<%=board.getBno()%>">
                                <input type="hidden" name="id" value="<%=member.getId()%>">
                                <textarea name="recontent" cols="100" rows="7" class="customHeight" id="recontent"></textarea>
                            </form>
							<button type="button" id="btnWriteCom">댓글등록</button>
							<button type="button" id="listbtn" onclick="javascript:history.back();">글목록</button>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</article>
</section>
<script>
	$(function() {
		$("#btnWriteCom").click(function() {
			var frmComment = document.getElementById("frmComment");
			frmComment.action = "<%=request.getContextPath()%>/page/comment/commentwrite";
			frmComment.method = "post";
			frmComment.submit();
		});
	});
</script>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>