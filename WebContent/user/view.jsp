<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container">
	${userinfo.name }<br/>
	${sessionScope.user.name }
</div>

<%@ include file="../include/footer.jsp" %>