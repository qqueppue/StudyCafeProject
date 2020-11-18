<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<body style="height:1500px">
<div class="container" style="margin-top:80px">
<div align="center">
<h2>글 내용 보기</h2></div>

<script>
$(function(){
	$("#replyBtn").click(function(){
		if(${empty sessionScope.user }){
			alert("로그인하세요");
			location.href = "/project/member/login";
		}else{
			$("#frm").submit();
		}
	})
})
</script>

<form action="replyWrite" id="frm" method="get">
<input type="hidden" name="num" id="num" value="${boards.num }">
<input type="hidden" name="ref" value="${boards.ref }">
<input type="hidden" name="re_step" value="${boards.re_step }">
<input type="hidden" name="re_level" value="${boards.re_level }">
</form>

<table class="table table-bordered">
	<tr>
		<td align="center" class="table-primary">글번호</td>
		<td>${boards.num }</td>
		<td align="center" class="table-primary">작성일</td>
		<td>${boards.reg_date }</td>
		<td align="center" class="table-primary">작성자</td>
		<td>${boards.writer }</td>
	</tr>
	<tr>
		<td align="center" class="table-primary">조회수</td>
		<td></td>
		<td align="center" class="table-primary">이메일</td>
		<td>${boards.email }</td>
		<td align="center" class="table-primary">IP</td>
		<td>${boards.ip }</td>
	</tr>
	<tr>
		<td align="center" class="table-primary">제목</td>
		<td colspan="5">${boards.subject }</td>
	</tr>
	<tr>
		<td colspan="6" align="center" class="table-primary">내용</td>
	</tr>
	<tr>
		<td colspan="6">${boards.content }</td>
	</tr>
	<tr>
		<td colspan="6" align="center">
			<c:if test="${sessionScope.user.name == boards.writer }">
				<a href="update?num=${boards.num }"><button type="button" class="btn btn-primary">수정</button></a>
				<button type="button" id="deleteBtn" class="btn btn-primary">삭제</button>
			</c:if>
			<button type="button" class="btn btn-primary" id="replyBtn">답글쓰기</button>
			<a href="list"><button type="button" class="btn btn-primary">글목록</button></a>
		</td>
	</tr>
</table>
<br><br><br><br>
<div align="center">
	<textarea rows="5" cols="50" id="msg"></textarea>
	<input type="button" value="댓글쓰기" id="commentBtn">
</div>
<div id="area"></div>

<script>
	var clists = function(){
		var str = "<table>";
		$.getJSON("cList",{"num":$("#num").val()},
		function(data){
			$.each(data.com, function(key, val){
				str += "<tr>";
				str += "<td>" + val.userid + "</td>";
				str += "<td>" + val.msg + "</td>";
				str += "<td>" + val.regdate + "</td>";
				str += "</tr>";
			});
			str += "</table>";
			$("#area").html(str);
		})
	};
	clists();
</script>

<script>
	$(function(){
		$("#commentBtn").click(function(){
			if(${empty sessionScope.user}){
				alert("로그인해주세요");
				location.href="/project/member/login";
			}
			if($("#msg").val()==""){
				alert("메시지를 입력해주세요");
				$("#msg").focus();
				return false;
			}
			$.ajax({
				type:"post",
				url:"cInsert",
				data:{"userid":${sessionScope.user.userid }, "bnum":$("#bnum").val(), "msg":$("#msg").val()},
				success:function(d){
					alert("성공");
				},
				error:function(e){
					alert("error:"+e);
				}
			})
		});
	})
</script>
</div>

<%@ include file="../include/footer.jsp" %>