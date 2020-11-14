<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
	<title>KIMSCHOOL | 팀프로젝트원</title>
	<!-- css -->
	<style type="text/css">
	#head2 a:link {text-decoration:none; color :Blue}
	#head2 a:visited {text-decoration:none; color :Blue}
	.btn{
	}
	</style>
</head>

<body>
    <!-- jQuery를CDN으로부터취득 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>

	<div id="head1" style="height: 100px; width: 100%; text-align: left; ">
		<h1>회원등록 페이지</h1>
		<hr>
	</div>

   	<div id="head2" style="height: 100px; width: 100%; text-align: left; ">
   		<span>근태관리 웹 사이트</span><br><br>
			<form action="reguser" method="post" name = "form1">
				아이디 :
				<input type="text" id="u_no" name="u_no" required="required" placeholder="아이디를 입력해주세요" maxlength="10">
				<input type="button" class="myButton" id="temp" value="중복체크">
				<!-- 경고메세지 출력 -->
				<!-- <div class="text-center small mt-2" id="checkMsg" style="color: red"></div> -->
				<br>
				패스워드 :
				<input type="password" class="pw" id="password1" name="u_password" required="required" placeholder="비밀번호를 입력해주세요" maxlength="20">
				<span>8~20자리의 영문,숫자,특수문자를 혼합하여 입력해주세요.</span><br>
				패스워드 확인 :
				<input type="password" class="pw" id="password2"  required="required" placeholder="비밀번호를 입력해주세요" maxlength="20">
				<span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
    			<span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호가 일치하지 않습니다.</span>
				<br>
				이름 :
				<input type="text" name="name" required="required" placeholder="성함를 입력해주세요" maxlength="20"><br>
				성별 :
				남<input type="radio" name="gender" value="1"  required="required">
				여<input type="radio" name="gender" value="2" required="required"><br>
				EMAIl :
				<input type="email" name="email" placeholder="이메일를 입력해주세요" required="required"><br>
				주소 :
				<input type="text" name="address"  placeholder="주소를 입력해주세요" maxlength="100" size="100" required="required"><br>
				전화번호 :
				<input type="text" name="mobile_number"  placeholder="전화번호를 입력해주세요" required="required"><br>
				입사날짜 :
				<input type="text" name="hire_date"  placeholder="yyyymmdd형식으로 입력해주세요" maxlength="8" required="required"><br>

				<input type="submit" value="회원가입" onclick="check()">
				<br>
				<input type="button" value="메인페이지로 돌아가기" onclick="location.href='/manage'">
			</form>
	</div>

	<!-- 자바스크립트 -->
	<script>
		//패스워드 일치체크
        $('.pw').focusout(function () {
        var pwd1 = $("#password1").val();
        var pwd2 = $("#password2").val();

        if ( pwd1 != '' && pwd2 == '' ) {
            null;
        } else if (pwd1 != "" || pwd2 != "") {
            if (pwd1 == pwd2) {
                // 비밀번호 일치 이벤트 실행
                $("#alert-success").css('display', 'inline-block');
                $("#alert-danger").css('display', 'none');
            } else {
                // 비밀번호 불일치 이벤트 실행
                alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
                $("#alert-success").css('display', 'none');
                $("#alert-danger").css('display', 'inline-block');
            }
        }
    });

		//회원가입 버튼 클릭시 비밀번호 규칙체크
        function check(){

        	 var uno = $("#u_no").val();
        	 var pw = $("#password1").val();
        	 var num = pw.search(/[0-9]/g);
        	 var eng = pw.search(/[a-z]/ig);
        	 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

        	 if(pw.length < 8 || pw.length > 20){
        	  alert("8자리 ~ 20자리 이내로 입력해주세요.");
        	  return false;
        	 }else if(pw.length < 8 || pw.length > 20){
        	  alert("8자리 ~ 20자리 이내로 입력해주세요.");
        	  return false;
        	 }else if(pw.search(/\s/) != -1){
        	  alert("비밀번호는 공백 없이 입력해주세요.");
        	  return false;
        	 }else if(num < 0 || eng < 0 || spe < 0 ){
        	  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
        	  return false;
        	 }else {
        		 console.log("통과.");
        	    return true;
        	 }

        }

/*         $('.myButton').click(function () {
            $.ajax({
                type: "GET",
                url: "idCheck",
                data: {
                    "id": $('#u_no').val()
                },
                success: function (data) {
                    if ($.trim(data) == "YES") {
                        if ($('#u_no').val() != '') {
                            $('#checkMsg').html('<p style="color:blue">사용가능한 ID 입니다!</p>');
                        }
                    } else {
                        if ($('#u_no').val() != '') {
                            $('#checkMsg').html('<p style="color:red">이미 사용중인 ID 입니다. 다른 ID를 입력하세요.</p>');
                            $('#u_no').val('');
                            $('#u_no').focus();
                        }
                    }
                }
            })
        }); */
    </script>
</body>
</html>