<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminpagemember.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">

	<div class="mypagelist">
		<h2>회원 관리</h2>
		
		<div class="search">
			<form class="search_form" action="#"  method="get">
	    		<input class="search_bar" type="text" name="keyword" placeholder="회원아이디로 검색" style="font-family: GmarketSansMedium;">
	    		<button class="search_btn" type="submit" style="font-family: GmarketSansMedium;">검색</button>
		  	</form>
		</div>

		<div class=row>
			<table class="table" id="table">
				<thead>

					<tr>
						<th><input type="checkbox" id="checkall" /></th>
						<th>No.</th>
						<th>아이디</th>
						<th>이름</th>
						<th>연락처</th>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td class="num">1</td>
						<td class="id">아이디</td>
						<td class="name">이름</td>
						<td class="pnum">010-1111-2222</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>2</td>
						<td>아이디</td>
						<td>이름</td>
						<td>010-1111-2222</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>3</td>
						<td>아이디</td>
						<td>이름</td>
						<td>010-1111-2222</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>4</td>
						<td>아이디</td>
						<td>이름</td>
						<td>010-1111-2222</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>5</td>
						<td>아이디</td>
						<td>이름</td>
						<td>010-1111-2222</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>6</td>
						<td>아이디</td>
						<td>이름</td>
						<td>010-1111-2222</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>7</td>
						<td>아이디</td>
						<td>이름</td>
						<td>010-1111-2222</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>8</td>
						<td>아이디</td>
						<td>이름</td>
						<td>010-1111-2222</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>9</td>
						<td>아이디</td>
						<td>이름</td>
						<td>010-1111-2222</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>10</td>
						<td>아이디</td>
						<td>이름</td>
						<td>010-1111-2222</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<input class="Withdrawal" type="button" value="회원탈퇴" style="font-family: GmarketSansMedium;">
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>