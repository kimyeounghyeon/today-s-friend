<%@page import="member.model.vo.Member"%>
<%@page import="member.model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<%
Member member = (Member)session.getAttribute("member");
%>
<script>
$(function () {
	 $("#btnModify").click(function(){
		var frmmod = document.getElementById("frmMod");
		frmmod.action = "<%=request.getContextPath()%>/page/member/update";
		frmmod.method = "post";
		frmmod.submit();
	});
});
</script>
<section class="setop">
	<!-- wrapper -->
	<div id="wrapper">
		<!-- content-->
		<div id="content">
			<form id="frmMod">
				<!-- ID -->
				<div>
					<h3 class="join_title">
						<label>아이디</label>
					</h3>
					<span class="readbox int_id"><%=member.getId()%></span>
				</div>
				<!-- PW1 -->
				<div>
					<h3 class="join_title">
						<label for="pswd1">비밀번호</label>
					</h3>
					<span class="box int_pass"> 
					<input type="password" id="pswd1" name="passwd" class="int" maxlength="20" value="<%=member.getPasswd()%>"> 
					<span id="alertTxt">사용불가</span>
					</span> <span class="error_next_box"></span>
				</div>
				<!-- PW2 -->
				<div>
					<h3 class="join_title">
						<label for="pswd2">비밀번호 재확인</label>
					</h3>
					<span class="box int_pass_check"> 
					<input type="password" id="pswd2" name="passwd2" class="int" maxlength="20"	value="<%=member.getPasswd()%>">
					</span> <span class="error_next_box"></span>
				</div>
				<!-- NAME -->
				<div>
					<h3 class="join_title">
						<label>이름</label>
					</h3>
					<span class="readbox int_name"><%=member.getName()%></span> 
				</div>
				<!-- AGE -->
				<div>
					<h3 class="join_title">
						<label for="age">나이</label>
					</h3>
					<span class="box int_pass_check"> 
					<input type="text" id="age" name="age" class="int" maxlength="2" value="<%=member.getAge()%>">
					</span><span class="error_next_box"></span>
				</div>
				<!-- GENDER -->
<% char genchar = member.getGender();
String gender = Character.toString(genchar);
if(gender.equals("m")){
	gender = "남자";
}else{
	gender = "여자";
}
%>
				<div>
					<h3 class="join_title">
						<label>성별</label>
					</h3>
					<span class="readbox gender_code"><%=gender %></span>
				</div>
				<!-- LOCAL -->
				<div>
					<h3 class="join_title">
						<label for="local">지역 선택</label>
					</h3>
					<span class="box local_code"> 
					<select id="local" name="locnum" class="sel">
							<option value="1">서울</option>
							<option value="2">경기</option>
							<option value="3">인천</option>
							<option value="4">충청</option>
							<option value="5">강원</option>
							<option value="6">경상</option>
							<option value="7">전라</option>
							<option value="8">제주</option>
					</select>
					</span> <span class="error_next_box">필수 정보입니다.</span>
				</div>
				<!-- EMAIL -->
				<div>
					<h3 class="join_title">
						<label for="email">본인확인 이메일<span class="optional"></span></label>
					</h3>
					<span class="box int_email"> 
					<input type="text" id="email" name="email" class="int" maxlength="100" value="<%=member.getEmail()%>">
					</span> <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>
				</div>
				<!-- MOBILE -->
				<div>
					<h3 class="join_title">
						<label for="phoneNo">휴대전화</label>
					</h3>
					<span class="box int_mobile"> 
					<input type="tel" id="phoneNo" name="phone" class="int" maxlength="16" placeholder="전화번호 입력" value="<%=member.getPhone()%>">
					</span> <span class="error_next_box"></span>
				</div>
				<!-- MODIFY BTN-->
				<div class="btn_area">
					<button type="button" id="btnModify" class="header-btn">
						<span>수정하기</span>
					</button>
				</div>
				<input type="hidden" name="id" value="<%=member.getId()%>" >
			</form>
		</div>
		<!-- content-->
	</div>
	<!-- wrapper -->
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>