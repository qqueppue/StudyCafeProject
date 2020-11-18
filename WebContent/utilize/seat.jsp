<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<body style="height:1500px">
<script>
	var seat = 10;
</script>
<div class="container" style="margin-top:80px">
	<c:forEach items="${seat }" var="s">
		<button>${s }</button>
	</c:forEach>
</div>
<%@ include file="../include/footer.jsp" %>