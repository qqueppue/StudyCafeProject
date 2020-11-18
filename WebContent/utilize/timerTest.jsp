<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>Insert title here</title>

<script>
$( document ).ready( function() {
    $("#time").click(function(){
    	//alert($(this).attr('value'));
    	
    	});
    });
</script>

</head>
<body>
<form action="Insert" method="post">
	<table>
		<tr>
			<td>번호</td>
			<td><input type="text" name="num" id="num"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td colspan="5">시간</td>
			<td colspan="5"><button type="button" value="123"  name="time" id="time">1시간</button></td>
		</tr>
		
	</table>
	<button type="submit">입력</button>
</form>

<div>
	
</div>

</body>
</html>