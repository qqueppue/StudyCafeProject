<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
	.image {
	 position:relative;
	 float:left; /* optional */
	 border-style: solid;
	 border-color: saddlebrown;
	}
	.image .text1 {
	 position:absolute;
	 top:120px; /* in conjunction with left property, decides the text position */
	 left:280px;
	 width:700px; /* optional, though better have one */
	 
	}
	.image .text2 { position:absolute; top:120px; left:320px; width:70px; }
	.image .text3 { position:absolute; top:120px; left:355px; width:70px; }
	.image .text4 { position:absolute; top:120px; left:440px; width:70px; }
	.image .text5 { position:absolute; top:120px; left:480px; width:70px; }
	.image .text6 { position:absolute; top:120px; left:520px; width:70px; }
	.image .text7 { position:absolute; top:120px; left:555px; width:70px; }
	.image .text8 { position:absolute; top:120px; left:590px; width:70px; }
	.image .text9 { position:absolute; top:120px; left:630px; width:70px; }
	.image .text10 { position:absolute; top:120px; left:670px; width:70px; }
	.image .text11 { position:absolute; top:120px; left:710px; width:70px; }
	.image .text12 { position:absolute; top:120px; left:770px; width:70px; }
	
	.image .text13 { position:absolute; top:200px; left:420px; width:70px; }
	.image .text14 { position:absolute; top:200px; left:460px; width:70px; }
	.image .text15 { position:absolute; top:200px; left:500px; width:70px; }
	.image .text16 { position:absolute; top:200px; left:540px; width:70px; }
	.image .text17 { position:absolute; top:200px; left:580px; width:70px; }
</style>

<div class="container">
<script>
function seatCheck(val){
	//alert(val+"번 좌석을 선택하셨습니다.");
	document.getElementById("area").innerHTML="<b><h1>"+val+"번 좌석을 선택하셨습니다.</h1></b>";
}
</script>

<form action="seatInsert" method="post" id="sMenu">
	<div align="center">
		<div align="center" id="area" style="color: blue; background-color: yellow; padding: 20px; width: 910px; height: 100px;"></div>
	</div>
	
	<div class="image" style="width:100%; height:100%;">
		<img alt="" src="../images/studyCafeImg.jpg" />
		<div class="text1"><input type="radio" name="seat" value="1" onclick="seatCheck(value)"></div>
		<div class="text2"><input type="radio" name="seat" value="2" onclick="seatCheck(value)"></div>
		<div class="text3"><input type="radio" name="seat" value="3" onclick="seatCheck(value)"></div>
		<div class="text4"><input type="radio" name="seat" value="4" onclick="seatCheck(value)"></div>
		<div class="text5"><input type="radio" name="seat" value="5" onclick="seatCheck(value)"></div>
		<div class="text6"><input type="radio" name="seat" value="6" onclick="seatCheck(value)"></div>
		<div class="text7"><input type="radio" name="seat" value="7" onclick="seatCheck(value)"></div>
		<div class="text8"><input type="radio" name="seat" value="8" onclick="seatCheck(value)"></div>
		<div class="text9"><input type="radio" name="seat" value="9" onclick="seatCheck(value)"></div>
		<div class="text10"><input type="radio" name="seat" value="10" onclick="seatCheck(value)"></div>
		<div class="text11"><input type="radio" name="seat" value="11" onclick="seatCheck(value)"></div>
		<div class="text12"><input type="radio" name="seat" value="12" onclick="seatCheck(value)"></div>
		<div class="text13"><input type="radio" name="seat" value="13" onclick="seatCheck(value)"></div>
		<div class="text14"><input type="radio" name="seat" value="14" onclick="seatCheck(value)"></div>
		<div class="text15"><input type="radio" name="seat" value="15" onclick="seatCheck(value)"></div>
		<div class="text16"><input type="radio" name="seat" value="16" onclick="seatCheck(value)"></div>
		<div class="text17"><input type="radio" name="seat" value="17" onclick="seatCheck(value)"></div>
	</div>
	
	<div align="center" align="center">
		<button type="submit" id="seatBtn" class="btn btn-lg btn-primary btn-block">자리 선택하기</button>
	</div>
</form>
</div>

<%@ include file="../include/footer.jsp"%>