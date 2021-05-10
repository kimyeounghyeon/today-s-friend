<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../admin/adminheader.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminWriting.css">

<section class="setop">
	<h2>공지사항 글쓰기</h2>
	<div class=row>
	<form action="#" method="post"></form>
		<table class="table" id="table">
			<thead>
				<tr>
					<th>제목</th>
					<th class="sub"><textarea name="contents" cols="90" rows="1"></textarea></th>
			</thead>
			<tbody>
				<tr>
					<th>글쓰기</th>
					<td class="write"><textarea name="contents" cols="90"
							rows="20"></textarea></td>
				</tr>
			</tbody>
		</table>
		<br>
		<a href="#"></a><input class="changeBtn" type="button"
			value="글 등록" style="font-family: GmarketSansMedium;"></a>
	</div>


</section>


<jsp:include page="../indexPage/footer.jsp"></jsp:include>