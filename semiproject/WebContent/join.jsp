<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<section class="setop">
	<!-- wrapper -->
	<div id="wrapper">
		<!-- content-->
		<form id="frm">
			<!-- ID -->
			<div>
				<h3 class="join_title">
					<label for="id">아이디</label>
				</h3>
				<span class="box int_id"> 
				<input type="text" id="id" name="id" class="int" maxlength="20">
				</span> 
				<span class="error_next_box"></span>
			</div>
			<!-- PW1 -->
			<div>
				<h3 class="join_title">
					<label for="pswd1">비밀번호</label>
				</h3>
				<span class="box int_pass"> 
				<input type="password" id="pswd1" name="pswd1" class="int" maxlength="20"> 
				<span id="alertTxt">사용불가</span>
				</span> <span class="error_next_box"></span>
			</div>
			<!-- PW2 -->
			<div>
				<h3 class="join_title">
					<label for="pswd2">비밀번호 재확인</label>
				</h3>
				<span class="box int_pass_check"> 
				<input type="password" id="pswd2" name="pswd2" class="int" maxlength="20">
				</span> <span class="error_next_box"></span>
			</div>
			<!-- NAME -->
			<div>
				<h3 class="join_title">
					<label for="name">이름</label>
				</h3>
				<span class="box int_name"> 
				<input type="text" id="name" name="name" class="int" maxlength="20">
				</span> <span class="error_next_box"></span>
			</div>
			<!-- AGE -->
			<div>
				<h3 class="join_title">
					<label for="age">나이</label>
				</h3>
				<div id="age_wrap">
					<div id="age">
						<span class="box"> 
						<input type="text" id="age" name="age" class="int" maxlength="2">
						</span>
					</div>
				</div>
				<span class="error_next_box"></span>
			</div>
			<!-- GENDER -->
			<div>
				<h3 class="join_title">
					<label for="gender">성별</label>
				</h3>
				<span class="box gender_code"> 
				<select id="gender" name="gender" class="sel">
						<option>성별</option>
						<option value="M">남자</option>
						<option value="F">여자</option>
				</select>
				</span> <span class="error_next_box">필수 정보입니다.</span>
			</div>
			<!-- LOCAL -->
			<div>
				<h3 class="join_title">
					<label for="local">지역 선택</label>
				</h3>
				<span class="box local_code"> 
				<select id="local" name="local" class="sel">
						<option>지역</option>
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
					<label for="email">본인확인 이메일<span class="optional">(선택)</span></label>
				</h3>
				<span class="box int_email"> 
				<input type="text" id="email" name="email"class="int" maxlength="100" placeholder="선택입력">
				</span> <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>
			</div>
			<!-- MOBILE -->
			<div>
				<h3 class="join_title">
					<label for="phoneNo">휴대전화</label>
				</h3>
				<span class="box int_mobile"> 
				<input type="tel" id="mobile" name="phone" class="int" maxlength="16" placeholder="전화번호 입력">
				</span> <span class="error_next_box"></span>
			</div>
			<!-- JOIN BTN-->
			<div class="btn_area">
				<button type="button" id="btnJoin" class="header-btn">
					<span>가입하기</span>
				</button>
			</div>
		</form>
		<!-- content-->
	</div>
	<!-- wrapper -->
</section>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$("#btnJoin").click(function(){
		var frm = document.getElementById("frm");
		frm.action = "<%= request.getContextPath()%>/insertmember";
		frm.method = "post";
		frm.submit();
	});
</script>
<jsp:include page="footer.jsp"></jsp:include>