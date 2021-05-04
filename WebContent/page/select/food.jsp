<%@page import="java.util.List"%>
<%@page import="board.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
	<article>
		<p id="pabouttitle">음식친구</p>
<%
List<Board> list = (List<Board>)request.getAttribute("blist");
	for(Board vo : list) {
%>
		<form id="frm">
			<table border="1">
				<tr>
					<td>작성자</td>
					<td><%=vo.getId() %></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><%=vo.getBsubject() %></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><%=vo.getBcontent() %><</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="답글작성"> <input
						type="button" value="수정" id="btnMod"> <input type="button"
						value="삭제" id="btndel"> <input type="button" value="목록">
					</td>
				</tr>
			</table>
		</form>
<%
} 
%>
	</article>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>