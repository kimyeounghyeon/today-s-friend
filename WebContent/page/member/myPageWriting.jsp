<%@page import="member.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">

	<div class="mypagelist">
		<h2>내가 쓴 글/댓글</h2>
		<button>내 글</button>
		<button>내 댓글</button>

		<div class=row>
			<table class="table" id="table">
				<thead>

					<tr>
						<th><input type="checkbox" id="checkall" /></th>
						<th>No.</th>
						<th>제목</th>
						<th>공개여부</th>
						<th>작성일</th>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td class="num">1</td>
						<td class="sub">안녕하세요</td>
						<td class="change">공개</td>
						<td class="date">2021-04-29</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>2</td>
						<td>안녕하세요</td>
						<td>공개</td>
						<td>2021-04-29</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>3</td>
						<td>안녕하세요</td>
						<td>공개</td>
						<td>2021-04-29</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>4</td>
						<td>안녕하세요</td>
						<td>공개</td>
						<td>2021-04-29</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>5</td>
						<td>안녕하세요</td>
						<td>공개</td>
						<td>2021-04-29</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>6</td>
						<td>안녕하세요</td>
						<td>공개</td>
						<td>2021-04-29</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>7</td>
						<td>안녕하세요</td>
						<td>공개</td>
						<td>2021-04-29</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>8</td>
						<td>안녕하세요</td>
						<td>공개</td>
						<td>2021-04-29</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>9</td>
						<td>안녕하세요</td>
						<td>공개</td>
						<td>2021-04-29</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="item" /></td>
						<td>10</td>
						<td>안녕하세요</td>
						<td>공개</td>
						<td>2021-04-29</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<input class="changeBtn" type="button" value="공개여부변경">
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>