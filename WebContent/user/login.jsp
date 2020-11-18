<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="/StudyCafeProject/js/member.js"></script>
<title>로그인 폼</title>

<style>
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 80px;
  		padding-bottom: 40px;
  		font-family: "Nanum Gothic", arial, helvetica, sans-serif;
  		background-repeat: no-repeat;
  		background: #E3A967;
	}
	
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
</style>
</head>

<div class="card align-middle" style="width:20rem; border-radius:20px;">
	<div class="card-title" style="margin-top:30px;">
		<h2 class="card-title text-center" style="color:#113366;">로그인 폼</h2>
	</div>
	<div class="card-body">
      <form class="form-signin" method="post">
        <h5 class="form-signin-heading">로그인 정보를 입력하세요</h5>
        <label for="phone" class="sr-only">Phone</label>
        <input type="text" id="phone" name="phone" onKeyup="inputPhone(this)" maxlength="13" class="form-control" placeholder="Phone"><br>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password"><br>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 기억하기
          </label>
        </div>
        <button id="loginBtn" class="btn btn-lg btn-primary btn-block" type="button">로 그 인</button>
      </form>
	</div>
</div>

<script>
$("#loginBtn").click(function(){
	if ($("#phone").val() == "") {
		alert("전화번호를 넣어주세요");
		$("#phone").focus();
		return false;
	}
	if($("#pwd").val()==""){
		alert("비밀번호를 입력하세요.");
		$("#pwd").focus();
		return false;
	}$.ajax({
		type:"post",
		url:"login",
		data:{"phone":$("#phone").val(), "pwd":$("#pwd").val()},
		success:function(d){	//0:일반회원, 1:관리자, -1:비회원, 2:비번오류, 5:비회원
			if(d.trim()==0){
				alert("일반회원 로그인");
				$(location).attr("href","/StudyCafeProject/cafe/usermain.jsp");
			}else if(d.trim()==1){
				alert("관리자 로그인");
				$(location).attr("href","list");
			}else if(d.trim()==-1){
				alert("회원이 아닙니다. 회원가입하세요");
			}else if(d.trim()==2){
				alert("비밀번호를 확인하세요");
			}else if(d.trim()==5){
				alert("비회원입니다.");
				$(location).attr("href","/StudyCafeProject/cafe/main.jsp");
			}
		},
		error:function(e){
			alert("error :"+e);
		}
	})//ajax
})//loginBtn
</script>

</body>
</html>