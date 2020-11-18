<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container">
	<form  action ="tempJoin" id="frm" method="post">
	<h3>비회원으로 로그인</h3>
	<p></p>
	<div class="form-group">
	    <label for="phone">Phone:</label>
	    <input type="text" onKeyup="inputPhone(this)" maxlength="13" class="form-control" placeholder="Enter Phone" id="phone" name="phone">
	</div>
	<div class="form-group">
	    <label for="pwd">Password:</label>
	    <input type="password" class="form-control" placeholder="Enter Password" id="pwd" name="pwd">
	</div>
	<div class="form-group">
	    <label for="pwd_check">Password Check:</label>
	    <input type="password" class="form-control" placeholder="Enter Password Check" id="pwd_check" name="pwd_check">
	</div>
	<button type="button" class="btn btn-primary" id="send">확인</button>
	<button type="reset" class="btn btn-primary" >취소</button>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>