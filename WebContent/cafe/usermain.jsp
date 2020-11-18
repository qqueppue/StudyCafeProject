<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="section2" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
	<div class="container" align="center">
		${sessionScope.user.name }님 반갑습니다.
		<hr/>
		<p>회원님이 현재 사용하고 있는 좌석은</p>
		<h2>${sessionScope.user.seat }번</h2>
		<p>입니다.</p> 
	</div>
	
</div>
<hr/>
<div id="section1" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
	<div class="container">
		<button type="button" class="btn btn-outline-warning btn-lg btn-block" onclick="location.href='/StudyCafeProject/cafe/seatInsert'">좌석 변경</button>
		<button type="button" class="btn btn-outline-warning btn-lg btn-block" onclick="location.href='/StudyCafeProject/cafe/seatInsert'">1회권</button>
		<button type="button" class="btn btn-outline-warning btn-lg btn-block" onclick="">기간권</button>
		<button type="button" class="btn btn-outline-warning btn-lg btn-block" onclick="">사물함</button>
		<button type="button" class="btn btn-outline-warning btn-lg btn-block" onclick="">퇴실</button>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>