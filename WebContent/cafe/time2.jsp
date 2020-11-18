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
			<td><input type="button" name="charge" id="70000" value="1주권" class="btn btn-primary" onclick="charge(id)"></td>
			<td><input type="button" name="charge" id="1000000" value="2주권" class="btn btn-primary" onclick="charge(id)"></td>
			<td><input type="button" name="charge" id="3000000" value="한달권" class="btn btn-primary" onclick="charge(id)"></td>
			<td><input type="button" name="charge" id="5000000" value="2달권" class="btn btn-primary" onclick="charge(id)"></td>
		</tr>
		<tr>
			<td>70,000원</td>
			<td>100,000원</td>
			<td>300,000원</td>
			<td>500,000원</td>
		</tr>
	</table>
	
	<div align="center" id="result"></div>
</div>
</form>

<%@ include file="../include/footer.jsp" %>

