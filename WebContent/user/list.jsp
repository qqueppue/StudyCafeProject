<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp" %>
<!-- <script>
	//btn 클릭하면
	$(function(){
		$("#btn").on("click", function(){
			if($("#word").val()==""){
				alert("검색어를 입력하세요");
				$("#word").focus();
				return false;
			}
			$.getJSON("searchList",{"field":$("#field").val(), "word":$("#word").val()},
				function(data){
				//alert(data);	//검색내용, count
				var htmlStr = "";
				$.each(data.jarr, function(key, val){
					htmlStr +="<tr>";
					htmlStr +="<td>"+val.name+"</td>";
					htmlStr +="<td>"+val.addr+"</td>";
					htmlStr +="<td>"+val.zipcode+"</td>";
					htmlStr +="<td>"+val.tel+"</td>";
					htmlStr +="</tr>";
				})
				$("table tbody").html(htmlStr);
				$("span").text(data.countObj.count);
			});
		})//btn
	})//document
	//word가 비어있으면 검색어를 입력하세요
</script> -->

<div class="container" style="margin-top:80px">
<!-- <div class="container" align="right"><a href="Insert">글쓰기</a> / <a href="List">전체보기</a><br/></div> -->
<div class="container"><h3>회원리스트(회원수: <span>${count }</span>)</h3></div>

<div class="container">
<table class="table table-hover">
	<thead>
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>등급</td>
			<td></td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${users }" var="u">
		<tr>
			<td>${u.name }</td>
			<td>${u.nickname }</td>
			<td>${u.email }</td>
			<td>${u.phone }</td>
			<c:if test="${u.admin==0 }">
				<td>일반회원</td>
				<td onclick="del('${u.name}')">삭제</td>
			</c:if>
			<c:if test="${u.admin==1 }">
				<td>관리자</td>
				<td>Admin</td>
			</c:if>
			<c:if test="${u.admin==5 }">
				<td>비회원</td>
				<td onclick="del('${u.name}')">삭제</td>
			</c:if>
		</tr>
	</c:forEach>
	</tbody>
</table>

<!-- <form action="searchList">
		<select name="field" id="field">
			<option value="name">이름</option>
			<option value="tel">전화번호</option>
		</select>
		<input type="text" name="word" id="word">
		<button type="button" id="btn">찾기</button>
	</form> -->
</div>
</div>

<%@ include file="../include/footer.jsp" %>