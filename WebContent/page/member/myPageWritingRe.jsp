<%@page import="member.member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mypagewritingre.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
	<div class="mypagelistre">
    <h2>내 글에 달린 댓글</h2>
  
    <div class=row>
		<table class="re_table" id="re_table">
			<thead>

				<tr>
					<th>No.</th>
					<th>제목</th>
                    <th>작성 시간</th>
			</thead>
			<tbody>
				<tr>
					<td class="num">1</td>
					<td class="sub">안녕하세요</td>
                    <td class="date">2021-04-29</td>
                </tr>
                <tr>
					<td>2</td>
					<td>안녕하세요</td>
					<td>2021-04-29</td>
                </tr>
                <tr>
					<td>3</td>
					<td>안녕하세요</td>
					<td>2021-04-29</td>
                </tr>
                <tr>
					<td>4</td>
					<td>안녕하세요</td>
					<td>2021-04-29</td>
                </tr>
                <tr>
					<td>5</td>
					<td>안녕하세요</td>
					<td>2021-04-29</td>
                </tr>
                <tr>
					<td>6</td>
					<td>안녕하세요</td>
					<td>2021-04-29</td>
                </tr>
                <tr>
					<td>7</td>
					<td>안녕하세요</td>
					<td>2021-04-29</td>
                </tr>
                <tr>
					<td>8</td>
					<td>안녕하세요</td>
					<td>2021-04-29</td>
                </tr>
                <tr>
					<td>9</td>
					<td>안녕하세요</td>
					<td>2021-04-29</td>
                </tr>
                <tr>
					<td>10</td>
					<td>안녕하세요</td>
					<td>2021-04-29</td>
                </tr>
			</tbody>
		</table>
	</div>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>