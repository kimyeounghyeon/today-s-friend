<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/join.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/font.css">
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<style>
.id_chk_re {
	background-color:#53cf74;
	border-radius:10px;
	border:2px solid #1fba2f; 
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-size:13px;
	padding:5px 15px;
	text-decoration:none;
	/* text-shadow:0px 1px 0px #2f6627; */
	font-family: GmarketSansMedium;
	margin-left:330px;
	
}
.id_chk_re:hover {
	background-color:#6bcf36;
}
.id_chk_re:active {
	position:relative;
	top:1px;
}
.mail_chk_re {
	background-color:#53cf74;
	border-radius:10px;
	border:2px solid #1fba2f; 
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-size:13px;
	padding:5px 15px;
	text-decoration:none;
	/* text-shadow:0px 1px 0px #2f6627; */
	font-family: GmarketSansMedium;
	margin-left:375px;
	margin-top:-23px;
}
.mail_chk_re:hover {
	background-color:#6bcf36;
}
.mail_chk_re:active {
	position:relative;
	top:1px;
}
.join_title_email{
	height: 30px;
}

</style>
<section class="setop">
	<!-- wrapper -->
	<div id="wrapper">
		<!-- content-->
		<div id="content">
			<form id="frmJoin" name="regForm">
				<!-- ID -->
				<div class="form-group">
					<h3 class="join_title">
						<label for="id">아이디</label>
						<input class="id_chk_re" type="button" value="중복확인" onclick="idCheck()">
					</h3>
					<span class="box int_id"> <input type="text" id="id"
						name="id" class="int" maxlength="20">
					</span> <span class="error_next_box"></span>
					
					<div class="check_font" id="id_check"></div>
				</div>
				
				<!-- PW1 -->
				<div>
					<h3 class="join_title">
						<label for="pswd1">비밀번호</label>
					</h3>
					<span class="box int_pass"> <input type="password"
						id="pswd1" name="pswd1" class="int" maxlength="20"> <span
						id="alertTxt">사용불가</span>
					</span> <span class="error_next_box"></span>
					<div class="check_font" id="pass_check"></div>
				</div>
				
				<!-- PW2 -->
				<div>
					<h3 class="join_title">
						<label for="pswd2">비밀번호 재확인</label>
					</h3>
					<span class="box int_pass_check"> <input type="password"
						id="pswd2" name="pswd2" class="int" maxlength="20">
					</span> <span class="error_next_box"></span>
					<div class="check_font" id="passre_check"></div>
				</div>
				
				<!-- NAME -->
				<div>
					<h3 class="join_title">
						<label for="name">이름</label>
					</h3>
					<span class="box int_name"> <input type="text" id="name"
						name="name" class="int" maxlength="20">
					</span> <span class="error_next_box"></span>
					<div class="check_font" id="name_check"></div>
				</div>
				
				<!-- AGE -->
				<div>
					<h3 class="join_title">
						<label for="age">나이</label>
					</h3>
					<div id="age_wrap">
						<div id="age">
							<span class="box"> <input type="text" id="age" name="age"
								class="int" maxlength="2">
							</span>
							<div class="check_font" id="age_check"></div>
						</div>
					</div>
					<span class="error_next_box"></span>
				</div>
				
				<!-- GENDER -->
				<div>
					<h3 class="join_title">
						<label for="gender">성별</label>
					</h3>
					<span class="box gender_code"> <select id="gender"
						name="gender" class="sel">
							<option>성별</option>
							<option value="M">남자</option>
							<option value="F">여자</option>
					</select>
					</span> <span class="error_next_box">필수 정보입니다.</span>
					<div class="check_font" id="gender_check"></div>
				</div>
				
				<!-- LOCAL -->
				<div>
					<h3 class="join_title">
						<label for="local">지역 선택</label>
					</h3>
					<span class="box local_code"> <select id="local"
						name="local" class="sel">
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
					<div class="check_font" id="local_check"></div>
				</div>
				
				<!-- EMAIL -->
				<div>
					<h3 class="join_title_email" >
						<label for="email">본인 확인 이메일<span class="optional"></span></label>
						<input class="mail_chk_re" type="button" value="중복확인" onclick="mailCheck()">
					</h3>
					<span class="box int_email"> <input type="text" id="email"
						name="email" class="int" maxlength="100" placeholder="이메일 ">
					</span> <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>
					<div class="check_font" id="mail_check"></div>
				</div>
				
				<!-- MOBILE -->
				<div>
					<h3 class="join_title">
						<label for="phoneNo">휴대전화</label>
					</h3>
					<span class="box int_mobile"> <input type="tel" id="mobile"
						name="phone" class="int" maxlength="16" placeholder="숫자만 입력해주세요 :)">
					</span> <span class="error_next_box"></span>
					<div class="check_font" id="pnum_check"></div>
				</div>
				
				<!-- JOIN BTN-->
				<div class="btn_area">
					<button type="button" id="btnJoin" class="header-btn">
						<span>가입하기</span>
					</button>
				</div>
			</form>
		</div>
		<!-- content-->
	</div>
	<!-- wrapper -->
</section>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

	// 모든 공백 체크
	var empJ = /\s/g;
	// 아이디 정규식
	var idJ = /^[a-z0-9]{4,12}$/; // a~z, 0~9로 시작하는 4~12자리 아이디
	// 비밀번호 정규식
	var pwJ = /^[A-Za-z0-9]{4,12}$/; // A~Z, a~z, 0~9로 시작하는 4~12자리 비밀번호
	// 비밀번호 재확인	
	var pwreJ = /^[A-Za-z0-9]{4,12}$/; // A~Z, a~z, 0~9로 시작하는 4~12자리 비밀번호
	// 이름 정규식
	var nameJ = /^[가-힣]{2,6}$/; // 가~힣, 2-6 자리 한글로만 이루어진 문자
	// 이메일 검사 정규식
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // 가운데 @ 무조건 들어가야댐
	// 휴대폰 번호 정규식
	var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/; // 

	// 아이디
	$('#id').blur(function(){
		
		if(idJ.test($(this).val())){
			console.log(idJ.test($(this).val()));
			$("#id_check").text('');
		} else {
			$('#id_check').text('아이디는 영문+숫자 4~12자리로 설정가능합니다.');
			$('#id_check').css('color', 'red');
		}
	});
	
	// 비밀번호
	$('#pswd1').blur(function(){
		if(pwJ.test($(this).val())){
			console.log(pwJ.test($(this).val()));
			$("#pass_check").text('');
		} else {
			$('#pass_check').text('비밀번호는 영문+숫자 4~12자리로 설정가능합니다.');
			$('#pass_check').css('color', 'red');
		}
	});
	
	// 비밀번호 확인
	/* $('#pswd2').blur(function(){
		if((pwJ.test($("#pswd1").val()) == ((pwJ.test($("#pswd2").val())){
			console.log(pwJ.test($(this).val());
			$("#passre_check").text('');
		} else {
			$('#passre_check').text('비밀번호 확인 바랍니다.');
			$('#passre_check').css('color', 'red');
		}
	}); */
	
	// 이름에 특수문자 들어가지 않도록 설정
	$("#name").blur(function() {
		if (nameJ.test($(this).val())) {
				console.log(nameJ.test($(this).val()));
				$("#name_check").text('');
		} else {
			$('#name_check').text('2~6자리 한글만 가능합니다.');
			$('#name_check').css('color', 'red');
		}
	});

	// 휴대전화
	$('#mobile').blur(function(){
		if(phoneJ.test($(this).val())){
			console.log(phoneJ.test($(this).val()));
			$("#pnum_check").text('');
		} else {
			$('#pnum_check').text('휴대폰번호를 확인해주세요 :)');
			$('#pnum_check').css('color', 'red');
		}
	});
	
	// 이메일
	$('#email').blur(function(){
		if(mailJ.test($(this).val())){
			console.log(mailJ.test($(this).val()));
			$("#mail_check").text('');
		} else {
			$('#mail_check').text('이메일주소를 확인해주세요 :)');
			$('#mail_check').css('color', 'red');
		}
	});
		
	//id 중복체크 
	function idCheck(){ 
		//새창 만들기 
		window.open("idCheckForm.jsp", "idwin", "width=400, height=350"); 
	}
	
	//mail 중복체크 
	function mailCheck(){ 
		//새창 만들기 
		window.open("mailCheckForm.jsp", "mailwin", "width=400, height=350"); 
	}
		
			
	// 회원가입 버튼클릭시 이벤트
$("#btnJoin").click(function(){
	
	var inval_Arr = new Array(4).fill(false);


	// 비밀번호가 같은 경우 && 비밀번호 정규식
	if (($('#pswd1').val() == ($('#pswd2').val()))
			&& pwJ.test($('#pswd1').val())) {
		inval_Arr[0] = true;
	} else {
		inval_Arr[0] = false;
	}
	// 이름 정규식
	if (nameJ.test($('#name').val())) {
		inval_Arr[1] = true;	
	} else {
		inval_Arr[1] = false;
	}
	// 이메일 정규식
	if (mailJ.test($('#email').val())){
		console.log(phoneJ.test($('#email').val()));
		inval_Arr[2] = true;
	} else {
		inval_Arr[2] = false;
	}
	// 휴대폰번호 정규식
	if (phoneJ.test($('#mobile').val())) {
		console.log(phoneJ.test($('#mobile').val()));
		inval_Arr[3] = true;
	} else {
		inval_Arr[3] = false;
	}
	
	var validAll = true;
	for(var i = 0; i < inval_Arr.length; i++){
		
		if(inval_Arr[i] == false){
			validAll = false;
		}
	}
	
	if(validAll){ // 유효성 모두 통과
		alert('오늘의 친구가 되신걸 축하합니다 :)');
	
    var frmJoin = document.getElementById("frmJoin");
    frmJoin.action = "<%=request.getContextPath()%>/page/indexPage/insertmember";
						frmJoin.method = "post";
						frmJoin.submit();
					
	} else {
	alert('입력한 정보들을 다시 한번 확인해주세요 :)')
	}
	
});

	
					
					
</script>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>