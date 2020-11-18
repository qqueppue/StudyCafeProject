<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>
<body style="height:1500px">
<div class="container" style="margin-top:80px">
	<h3>글쓰기</h3>
	<form  action ="replyWrite" id="frm" method="post">
	
	<input type="hidden" name="num" value="${bean.num }">
	<input type="hidden" name="ref" value="${bean.ref }">
	<input type="hidden" name="re_step" value="${bean.re_step }">
	<input type="hidden" name="re_level" value="${bean.re_level }">
	
	  <div class="form-group">
	    <label for="writer">Name:</label>
	    <input type="text" class="form-control" placeholder="Enter Name" id="writer" name="writer" value=${sessionScope.user.name }>
	  </div>
	  <div class="form-group">
	    <label for="subject">Subject:</label>
	    <input type="text" class="form-control" placeholder="Enter User Subject" id="subject" name="subject" value="[답글]">
	  </div>
	  <div class="form-group">
	    <label for="email">Email address:</label>
	    <input type="text" class="form-control" placeholder="Enter Email" id="email" name="email" value=${sessionScope.user.email }>
	  </div>
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" class="form-control" placeholder="Enter Password Check" id="password" name="password">
	  </div>
	  <div class="form-group">
	    <label for="content">Content:</label>
	    <textarea class="form-control" rows="5" placeholder="Enter Content" id="content" name="content"></textarea>
	  </div>
	  <br />
	  <button type="submit" class="btn btn-primary">글쓰기</button>
	  <button type="reset" class="btn btn-primary" >취소</button>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>