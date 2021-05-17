<%@page import="member.model.vo.Member"%>
<%@page import="member.model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<%
Member member = (Member)session.getAttribute("member");
%>
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
					<div class="check_font" id="pass_check"></div>
				</div>
				<!-- PW2 -->
				<div>
					<h3 class="join_title">
						<label for="pswd2">비밀번호 재확인</label>
					</h3>
					<span class="box int_pass_check"> 
					<input type="password" id="pswd2" name="passwd2" class="int" maxlength="20"	value="<%=member.getPasswd()%>">
					</span> <span class="error_next_box"></span>
					<span id="alert-success"
						style="display: none; color: blue;">비밀번호가 일치합니다.</span> <span
						id="alert-danger" style="display: none; color: red;">비밀번호가
						일치하지 않습니다.</span>
					<div class="check_font" id="passre_check"></div>
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
if(gender.equals("M")){
	gender = "남자";
%>	<%
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
					<span class="box int_mobile"> <input type="tel" id="mobile"
						name="phone" class="int" maxlength="16"
						placeholder="숫자와 - 를 포함하여 입력해 주세요 :)" value="<%=member.getPhone()%>">
					</span> <span class="error_next_box"></span>
					<div class="check_font" id="pnum_check"></div>
				</div>
				<!-- MODIFY BTN-->
				<div class="btn_area">
					<button type="button" id="btnModify" class="header-btn">
						<span>수정하기</span>
					</button>
					<!-- <button type="button" id="btnDelete" class="header-btn">
						<span>탈퇴하기</span>
					</button> -->
				</div>
				<input type="hidden" name="id" value="<%=member.getId()%>" >
			</form>
		</div>
		<!-- content-->
	</div>
	<!-- wrapper -->
</section>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
//모든 공백 체크
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
var phoneJ = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/; //
// 나이 정규식
var ageJ = /^[0-9]{2}$/;  // 0~9로 시작하는 2자리 나이
	
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
	$('#pswd2').focusout(function () {
        var pwd1 = $("#pswd1").val();
        var pwd2 = $("#pswd2").val();
  
        if ( pwd1 != '' && pwd2 == '' ) {
            null;
        } else if (pwd1 != "" || pwd2 != "") {
            if (pwd1 == pwd2) {
                $("#alert-success").css('display', 'inline-block');
                $("#alert-danger").css('display', 'none');
            } else {
                alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
                $("#alert-success").css('display', 'none');
                $("#alert-danger").css('display', 'inline-block', 'red');
            }
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
	
	// 나이
	$('#age').blur(function(){
		if(ageJ.test($(this).val())){
			console.log(ageJ.test($(this).val()));
			$("#age_check").text('');
		} else {
			$('#age_check').text('나이는 숫자만 가능합니다.');
			$('#age_check').css('color', 'red');
		}
	});
	
	
	// 수정하기 버튼클릭시 이벤트
	$("#btnModify").click(function(){
		
		var inval_Arr = new Array(4).fill(false);


		// 비밀번호가 같은 경우 && 비밀번호 정규식
		if (($('#pswd1').val() == ($('#pswd2').val()))
				&& pwJ.test($('#pswd1').val())) {
			inval_Arr[0] = true;
		} else {
			inval_Arr[0] = false;
		}
		
		// 이메일 정규식
		if (mailJ.test($('#email').val())){
			console.log(mailJ.test($('#email').val()));
			inval_Arr[1] = true;
		} else {
			inval_Arr[1] = false;
		}
		// 휴대폰번호 정규식
		if (phoneJ.test($('#mobile').val())) {
			console.log(phoneJ.test($('#mobile').val()));
			inval_Arr[2] = true;
		} else {
			inval_Arr[2] = false;
		}
		// 나이 정규식
		if (ageJ.test($('#age').val())) {
			console.log(ageJ.test($('#age').val()));
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
		
	    var frmmod = document.getElementById("frmMod");
		frmmod.action = "<%=request.getContextPath()%>/page/member/update";
		frmmod.method = "post";
		frmmod.submit();
		
		
		} else {
		alert('입력한 정보들을 다시 한번 확인해주세요 :)')
		}
		
	});
	
<%-- 	 $("#btnDelete").click(function(){
		var frmmod = document.getElementById("frmMod");
		frmmod.action = "<%=request.getContextPath()%>/page/member/delete3";
		frmmod.method = "post";
		frmmod.submit();
	}); --%>

</script>

<jsp:include page="../indexPage/footer.jsp"></jsp:include>