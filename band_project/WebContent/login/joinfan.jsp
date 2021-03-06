<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>FAN 가입</title>
</head>
<h2>FAN 가입</h2>
<form name="form" action="joinfan.do" method="post" onsubmit="return submitcheck()">
<table class="list" cellpadding="10px">
<tr>
	<th width="200px">아이디</th>
	<td><input type="text" name="id" maxlength="8"/></td>
	<td><input type="button" value="중복확인" onclick="idcheck()"/></td>
	<td>영문, 8자 이하</td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="password"/></td>
	<td></td>
	<td>8자 이하</td>
</tr>
<tr>
	<th>비밀번호 확인</th>
	<td><input type="password" name="repassword"/></td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="text" name="name"/></td>
	<td></td>
</tr>
<tr>
	<th>이메일</th>
	<td><input type="text" name="email"/></td>
</tr>
<tr>
	<th>생년월일</th>
	<td><input type="text" name="birth"/></td>
</tr>
<tr>
	<th>성별</th>
	<td><input type="radio" name="gender" value="남"/>남성
		<input type="radio" name="gender" value="여"/>여성
	</td>
</tr>
<tr>
	<th>휴대폰 번호</th>
	<td><input type="text" name="phone"/></td>
</tr>
</table><br/><br/>
<input type="submit" value="가입하기"/>
<input type="button" value="다시쓰기" onclick="formreset()"/>
<input type="hidden" name="check"/>
</form>
<script type="text/javascript">
var newWindow;
var check;

function idcheck() {
	
	var id = form.id.value;
	var id_cnt = 0;
	
	for (i=0;i<id.length;i++){
  		
		ls_one_char = id.charAt(i);
	
	 	if(ls_one_char.search(/[0-9|a-z|A-Z]/) == -1) {
	 		id_cnt++;
		}
	 	
	}
	
	if(id_cnt!=0) {
		alert("아이디는 영문, 숫자만 가능합니다.") 
		return false;
	}
	
	newWindow=open("joinidcheck?id="+id, "idcheck", "height=40, width=80, resizable=no");
	
}

function formreset() {

	form.id.value = "";
	form.password.value= "";
	form.repassword.value= "";
	form.name.value= "";
	form.email.value= "";
	form.birth.value= "";
	form.gender.value= "";
	form.phone.value= "";
	
}

function submitcheck() {
		
	check = document.form.check.value;
	
	var c_f = "false";
	var id = form.id.value;
	var password = form.password.value;
	var repassword = form.repassword.value;
	var name = form.name.value;
	var email = form.email.value;
	var birth = form.birth.value;
	var gender = form.gender.value;
	var phone = form.phone.value;
	
	var id_cnt = 0;
	
	for (i=0;i<id.length;i++){
  		
		ls_one_char = id.charAt(i);
	
	 	if(ls_one_char.search(/[0-9|a-z|A-Z]/) == -1) {
	 		id_cnt++;
		}
	 	
	}
	
	var name_cnt = 0;
	
	for (i=0;i<name.length;i++){
  		
		ls_one_char = name.charAt(i);
	
	 	if(ls_one_char.search(/[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]/) == -1) {
	 		name_cnt++;
		}
	 	
	}
	
	if(name_cnt!=0) {
		alert("이름은 영문, 한글, 숫자만 가능합니다.") 
		return false;
	}
	
	if(id_cnt!=0) {
		alert("아이디는 영문, 숫자만 가능합니다.") 
		return false;
	}

	
	if(check == "") {
		alert("ID 중복확인을 하세요.");
		return false;
	}
	else if(check == c_f) {
		alert("ID가 중복됩니다.");
		return false;
	}
	else if(id == "" || password == "" || repassword == "" || name == "" || email == "" || birth == "" || gender == "" || phone == "") {
		alert("입력되지 않은 폼이 있습니다.");
		return false;
	}
	else if(password != repassword) {
		alert("비밀번호가 같지 않습니다.");
		return false;
	}else {
		alert("가입되셨습니다.");
		return true;
	}
	
}
</script>
</body>
</html>