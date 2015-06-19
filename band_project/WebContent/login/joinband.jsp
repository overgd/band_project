<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BAND 가입</title>
</head>
BAND 가입
<form name="form" action="joinband.do" method="post" onsubmit="javascript:submitcheck()">
<table cellpadding="10px">
<tr>
	<td width="200px">아이디 : </td>
	<td><input type="text" name="id"/></td>
	<td><input type="button" value="중복확인" onclick="idcheck()"></td>
</tr>
<tr>
	<td>비밀번호 : </td>
	<td><input type="password" name="password"/></td>
</tr>
<tr>
	<td>비밀번호 확인 : </td>
	<td><input type="password" name="repassword"/></td>
</tr>
<tr>
	<td>밴드이름 : </td>
	<td><input type="text" name="name"/></td>
</tr>
<tr>
	<td>이메일 : </td>
	<td><input type="text" name="email"/></td>
</tr>
<tr>
	<td>장르 : </td>
	<td><input type="text" name="genre"/></td>
</tr>
</table>
<input type="submit" value="가입하기"/>
<input type="button" value="다시쓰기" onclick="formreset()"/>
<input type="hidden" name="check"/>
</form>
<script type="text/javascript">
var newWindow;
var check;

function idcheck() {
	
	var id = form.id.value;
	newWindow=open("joinidcheck?id="+id, "idcheck", "height=40, width=80, resizable=no");
}

function formreset() {

	form.id.value = "";
	form.password.value= "";
	form.repassword.value= "";
	form.name.value= "";
	form.email.value= "";
	form.genre.value= "";
	
}

function submitcheck() {
		
	check = document.form.check.value;
	
	var c_f = "false";
	var id = form.id.value;
	var password = form.password.value;
	var repassword = form.repassword.value;
	var name = form.name.value;
	var email = form.email.value;
	var genre = form.genre.value;
	
	if(check == "") {
		alert("ID 중복확인을 하세요.");
		return false;
	}
	if(check == c_f) {
		alert("ID가 중복됩니다.");
		return false;
	}
	if(id == "" || password == "" || repassword == "" || name == "" || email == "" || genre == "") {
		alert("입력되지 않은 폼이 있습니다.");
		return false;
	}
	if(password != repassword) {
		alert("비밀번호가 같지 않습니다.");
	}
	
}
</script>
</body>
</html>