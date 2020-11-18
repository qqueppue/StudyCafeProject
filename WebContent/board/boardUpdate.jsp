<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>
<body style="height:1500px">
<div class="container" style="margin-top:80px">
	
	<h3>글쓰기</h3>
	<form  action ="update" id="frm" method="post">
	<input type="hidden" name="num" value="${toUpdate.num }">
	  <div class="form-group">
	    <label for="writer">Name:</label>
	    <input type="text" class="form-control" placeholder="Enter Name" id="writer" name="writer" value="${toUpdate.writer }">
	  </div>
	  <div class="form-group">
	    <label for="subject">Subject:</label>
	    <input type="text" class="form-control" placeholder="Enter User Subject" id="subject" name="subject" value="${toUpdate.subject }">
	  </div>
	  <div class="form-group">
	    <label for="email">Email address:</label>
	    <input type="text" class="form-control" placeholder="Enter Email" id="email" name="email" value="${toUpdate.email }">
	  </div>
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" class="form-control" placeholder="Enter Password Check" id="password" name="password" value="${toUpdate.password }">
	  </div>
	  <div class="form-group">
	    <label for="content">Content:</label>
	    <textarea class="form-control" rows="5" placeholder="Enter Content" id="content" name="content">${toUpdate.content }</textarea>
	  </div>
	  <br />
	  <button type="submit" class="btn btn-primary">수정하기</button>
	  <button type="reset" class="btn btn-primary">취소</button>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>