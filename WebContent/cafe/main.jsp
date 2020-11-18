<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
$(function(){
	$("#seatB").click(function(){
		if(${empty sessionScope.user}){
			alert("로그인이 필요합니다.");
			$("#seatB").focus();
			return false;
		}else{
			//alert("ok");
			location.href="/StudyCafeProject/cafe/seatInsert";
		}
	});
	$("#loginB").click(function(){
		if(${not empty sessionScope.user }){
			alert("이미 로그인되어있습니다.");
			$("#loginB").focus();
			return false;
		}else{
			location.href="/StudyCafeProject/user/login";
		}
	});
	$("#timeB").click(function(){
		if(${not empty sessionScope.user }){
			location.href="/StudyCafeProject/cafe/time.jsp";
		}else{
			location.href="/StudyCafeProject/user/tempJoin.jsp";
		}
	});
	$("#time2B").click(function(){
		if(${not empty sessionScope.user }){
			location.href="/StudyCafeProject/user/time2.jsp";
		}else{
			location.href="/StudyCafeProject/user/tempJoin.jsp";
		}
	});
	$("#locker").click(function(){
		if(${empty sessionScope.user }){
			alert("로그인이 필요합니다.");
			$("#loginB").focus();
			return false;
		}else{
			location.href="";
		}
	});
})
</script>

<div id="section1" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
	<div class="container">
		<button type="button" id="loginB" class="btn btn-outline-warning btn-lg btn-block">이용하러가기</button>
		<button type="button" id="seatB" class="btn btn-outline-warning btn-lg btn-block">좌석 변경</button>
		<button type="button" id="timeB" class="btn btn-outline-warning btn-lg btn-block" onclick="location.href='/StudyCafeProject/cafe/time.jsp'">1회권</button>
		<button type="button" id="time2B" class="btn btn-outline-warning btn-lg btn-block" onclick="location.href='/StudyCafeProject/cafe/time2.jsp'">기간권</button>
		<button type="button" id="locker" class="btn btn-outline-warning btn-lg btn-block">사물함</button>
		<button type="button"  class="btn btn-outline-warning btn-lg btn-block">퇴실</button>
	</div>
</div>

<div id="section2" class="container-fluid" style="padding-top:70px;padding-bottom:70px">

	
</div>

<%@ include file="../include/footer.jsp" %>