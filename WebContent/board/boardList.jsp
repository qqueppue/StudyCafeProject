<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp" %>
<body style="height:1500px">

<div class="container" style="margin-top:80px">
	<div class="container" align="right">
	</div>
	<div class="container"><h3>게시글 리스트(<span>${count }</span>)</h3></div>
	<c:if test="${not empty sessionScope.user }">
		<div align="right"><a href="write"><button type="button" class="btn btn-primary">글쓰기</button></a></div>
	</c:if>

	<div class="container">
	<table class="table table-hover">
	<thead>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>이메일</td>
			<td>작성일</td>
			<td>작성자</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${board }" var="b" varStatus="st">
		<tr>
			<td>${rowNum-st.index }</td>
			<td><a href="detail?num=${b.num }">${b.subject }</a></td>
			<td>${b.email }</td>
			<td>${b.reg_date }</td>
			<td>${b.writer }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<div>
	  <ul class="pagination justify-content-center">
		<!-- 이전 -->
		<c:if test="${startPage>blockPage }">
    		<li class="page-item"><a class="page-link" href="list?pageNum=${startPage-blockPage }">이전</a></li>
		</c:if>
		<!-- 페이지 번호 -->
		<c:forEach begin="${startPage }" end="${endPage }" var="i">
    		<li class="page-item"><a class="page-link" href="list?pageNum=${i }">${i }</a></li>
		</c:forEach>
		<!-- 다음 -->
		<c:if test="${endPage<totPage }">
    		<li class="page-item"><a class="page-link" href="list?pageNum=${startPage+blockPage }">다음</a></li>
		</c:if>
  	  </ul>
	</div>
	
	
	</div>
</div>

<%@ include file="../include/footer.jsp" %>