<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  
<title>스터디카페</title>

<style>
	footer {
	height: 100px;
	background-color:#BC894F;
  }
  .jbTitle {
    text-align: center;
    background-color: #E3A967;
    padding:30px;
    height: 200px;
    width: 100%;
    height: 100%;
  }
  .jbMenu {
    text-align: center;
    background-color: #E3A967;
    padding: 10px 0px;
    width: 100%;
  }
  .jbFixed {
    position: fixed;
    top: 0px;
    background-color:#BC894F;
  }
</style>
	
<script>
  $( document ).ready( function() {
    var jbOffset = $( '.jbMenu' ).offset();
    $( window ).scroll( function() {
      if ( $( document ).scrollTop() > jbOffset.top ) {
        $( '.jbMenu' ).addClass( 'jbFixed' );
      }
      else {
        $( '.jbMenu' ).removeClass( 'jbFixed' );
      }
    });
  } );
</script>
</head>
  
<header>
<div class="jbTitle">
	 <img alt="" src="../images/Main.png"/>
</div>
  
<div class="jbMenu">
   <nav class="navbar navbar-expand-sm navbar-dark">
	  <a class="navbar-brand" href="/StudyCafeProject/cafe/main.jsp">스터디 카페</a>
	  <ul class="navbar-nav">
	  <li class="nav-item">
	      <a class="nav-link" href="/StudyCafeProject/cafe/information.jsp">소개</a>
	    </li>
  		<li class="nav-item">
	      <a class="nav-link" href="/StudyCafeProject/cafe/howtouse.jsp">이용방법</a>
	    </li>
	  <c:choose>
	  
	  	<c:when test="${empty sessionScope.user }"><!-- 세션이 없을 때 -->
		    <li class="nav-item">
		      <a class="nav-link" href="/StudyCafeProject/user/join">회원가입</a>
		    </li>
		    <li class="nav-item">
	      	  <a class="nav-link" href="/StudyCafeProject/board/list">게시판</a>
	  		</li>
	  	</c:when>

	  	
	    <c:otherwise><!-- 세션이 있을 때 -->
	      <li class="nav-item">
	        <a class="nav-link" href="/StudyCafeProject/user/logout">로그아웃</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/StudyCafeProject/user/view">회원변경</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/StudyCafeProject/user/delete">회원탈퇴</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/StudyCafeProject/board/list">게시판</a>
	      </li>
	      <!-- <li class="nav-item">
	        <a class="nav-link" href="/StudyCafeProject/cafe/seatInsert">자리</a>
	      </li> -->
	      <li class="nav-item">
	        <a class="nav-link">(${sessionScope.user.name }<c:if test="${sessionScope.user.admin==1 }">(관리자)</c:if>님 반갑습니다.)</a>
	  	  </li>
	    </c:otherwise>
	    
	  </c:choose>
	  </ul>
   </nav>
</div>
</header>
  
<body style="height:2000px">
<br/><br/>