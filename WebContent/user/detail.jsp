<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div class="container">
<form  action ="update" id="frm" method="post">
	<div class="form-group">
	    <label for="name">Name:</label>
	    <input type="text" class="form-control" placeholder="Enter Name" id="name" name="name" value="${sessionScope.user.name }">
	</div>
	<div class="form-group">
	    <label for="nikcname">Nick Name:</label>
	    <input type="text" class="form-control" placeholder="Enter Nick Name" id="nickname" name="nickname" readonly="readonly" value="${userinfo.nickname }">
	</div>
	<div class="form-group">
	    <label for="pwd">Password:</label>
	    <input type="password" class="form-control" placeholder="Enter Password" id="pwd" name="pwd">
	</div>
	<div class="form-group">
	    <label for="email">Email address:</label>
	    <input type="text" class="form-control" placeholder="Enter Email" id="email" name="email" value=${userinfo.email } >
	</div>
	<div class="form-group">
	    <label for="phone">Phone:</label>
	    <input type="text" class="form-control" placeholder="Enter Phone" id="phone" name="phone" value=${userinfo.phone } >
	</div>
	<script>
		if(${userinfo.admin }==0){
			$("input:radio[value='0']").prop("checked",true);	//prop=속성
		}else{
			$("input:radio[value='1']").prop("checked",true);
		}
	</script>
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
	<button type="submit" class="btn btn-primary">수정</button>
	<button type="reset" class="btn btn-primary" >취소</button>
</form>

</div>

<%@ include file="../include/footer.jsp" %>