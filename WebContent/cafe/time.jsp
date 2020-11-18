<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<script>
	 function charge(val){
		 alert(val+"원을 결제하시겠습니까?");
		 location.href="/StudyCafeProject/cafe/usermain.jsp"
	 }
</script>

<form action="timeInsert" method="post">
<div class="container">
	<table>
		<tr>
			<td><input type="button" value="2시간" class="btn btn-primary"></td>
			<td><input type="button" value="4시간" class="btn btn-primary"></td>
			<td><input type="button" value="8시간" class="btn btn-primary"></td>
			<td><input type="button" value="12시간" class="btn btn-primary"></td>
			<td></td>
		</tr>
		<tr>
			<td>2,000원</td>
			<td>4,000d원</td>
			<td>8,000원</td>
			<td>10,000원</td>
		</tr>
	</table>
	
	<div align="center" id="result"></div>
</div>
</form>

<%@ include file="../include/footer.jsp" %>
