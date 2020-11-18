<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container">
	<h3>회원 가입</h3>
	<p>'*'표시항목은 필수 입력 항목입니다.</p>
	<form  action ="join" id="frm" method="post">
	  <div class="form-group">
	    <label for="name">*Name:</label>
	    <input type="text" class="form-control" placeholder="Enter Name" id="name" name="name">
	  </div>
	  <div class="form-group">
	    <label for="phone">*Phone:</label>
	    <input type="text" onKeyup="inputPhone(this)" maxlength="13" class="form-control" placeholder="Enter Phone" id="phone" name="phone">
	  </div>
	  <div class="form-group">
	    <label for="userid">Nick Name:</label>
	    <input type="text" class="form-control" placeholder="Enter Nick Name" id="nickname" name="nickname" readonly="readonly">
	    <button type="button" id="nickcheckBtn" class="btn btn-primary">중복확인</button>
	  </div>
	  <div class="form-group">
	    <label for="pwd">*Password:</label>
	    <input type="password" class="form-control" placeholder="Enter Password" id="pwd" name="pwd">
	  </div>
	  <div class="form-group">
	    <label for="pwd_check">*Password Check:</label>
	    <input type="password" class="form-control" placeholder="Enter Password Check" id="pwd_check" name="pwd_check">
	  </div>
	  <div class="form-group">
	    <label for="email">Email address:</label>
	    <input type="text" class="form-control" placeholder="Enter Email" id="email" name="email">
	  </div>
	  <div class="form-check">
	  <label class="form-check-label">
	    <input type="radio" class="form-check-input" name="admin" value="0" checked>일반회원
	  </label>
	  </div>
	  <div class="form-check">
	  <label class="form-check-label">
	    <input type="radio" class="form-check-input" name="admin" value="1">관리자
	  </label>
	  </div>
	  <br/>
	  <button type="button" class="btn btn-primary" id="send">확인</button>
	  <button type="reset" class="btn btn-primary" >취소</button>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>