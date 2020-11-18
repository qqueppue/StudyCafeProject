var exp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/

$(function() {
	$("#send").click(function() {
		if ($("#name").val() == "") {
			alert("이름을 넣어주세요");
			$("#name").focus();
			return false;
		}
		if ($("#nickname").val() == "") {
			alert("닉네임을 넣어주세요");
			$("#nickname").focus();
			return false;
		}
		if ($("#pwd").val() == "") {
			alert("비밀번호를 넣어주세요");
			$("#pwd").focus();
			return false;
		}
		if ($("#pwd").val() != $("#pwd_check").val()) {
			alert("비밀번호가 일치하지 않습니다");
			$("#pwd_check").focus();
			return false;
		}
		/*if ($("#email").val() == "") {
			alert("이메일일 넣어주세요");
			$("#email").focus();
			return false;
		}*/
		if (!$("#phone").val().match(exp)) {
			alert("전화번호 양식이 아닙니다.");
			$("#phone").focus();
			return false;
		}
		$("#frm").submit();
	});
	
	//아이디 입력창
	$("#nickcheckBtn").click(function(){
		window.open("nickCheck","","width=500 height=300");
	});
	
	//아이디 중복창
	$("#useBtn").click(function(){
		if($("#nickname").val()==""){
			alert("닉네임를 입력하세요.");
			$("#nickname").focus();
			return false;
		}
		$.ajax({
			type:"post",
			url:"nickCheck",
			data:{"nickname":$("#nickname").val()},
			success:function(d){
				//alert(d);
				if(d.trim()=="yes"){
					alert("사용 가능한 닉네임입니다.");
					$(opener.document).find("#nickname").val($("#nickname").val());
					self.close();
				}else{
					alert("사용 불가능한 닉네임입니다.");
					$("#nickname").val("");
				}
			},
			error:function(e){
				alert("error:"+e);
			}
		})
	});

})

$(function() {
	$("#seatBtn").click(function() {
		if ($("#seat").val() == "") {
			alert("좌석을 선택해주세요");
			$("#seat").focus();
			return false;
		}
		$("#sMenu").submit();
	});
})

//회원삭제
function del(userid){
	//alert(userid)
	var str = "";
	$.getJSON("userDelete",{"userid":userid},
		function(data){	//회원수+회원내용
		//alert(data.jarr.length)
			$.each(data.jarr,function(key,val){
				str += "<tr>";
				str += "<td>" + val.name + "</td>";
				str += "<td>" + val.userid + "</td>";
				str += "<td>" + val.phone + "</td>";
				str += "<td>" + val.email + "</td>";
				str += "<td>" + val.admin + "</td>";
				str += "<td onclick=del('"+val.userid+"')>삭제</td>";
				str += "</tr>";
			});//each (회원들 내용)
			$("table tbody").html(str);
			$("#countSpan").text(data.countObj.countObj);
		}	//function
	);	//getJSON
}

//전화번호 자동완성
function inputPhone(obj){
	var number = obj.value.replace(/[^0-9]/g, "");
	var phone ="";
	
	if(number.length < 4){
		return number;
	}else if(number.length < 7){
		phone += number.substr(0,3);
		phone += "-";
		phone += number.substr(3);
	}else if(number.length < 11){
		phone += number.substr(0,3);
		phone += "-";
		phone += number.substr(3,3);
		phone += "-";
		phone += number.substr(6);
	}else{
		phone += number.substr(0,3);
		phone += "-";
		phone += number.substr(3,4);
		phone += "-";
		phone += number.substr(7);
	}
	obj.value = phone;
}
