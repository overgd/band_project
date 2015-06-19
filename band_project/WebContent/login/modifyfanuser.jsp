<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>FAN 정보 수정</title>
</head>
<body>
FAN 정보 수정
<form name="form" action="modifyuserinfo.do" method="post" onsubmit="return submitcheck()">
<table cellpadding="10px">
<tr>
	<td>비밀번호 : </td>
	<td><input type="password" name="password"/></td>
</tr>
<tr>
	<td>비밀번호 확인 : </td>
	<td><input type="password" name="repassword"/></td>
</tr>
<tr>
	<td>이름 : </td>
	<td><input type="text" name="name" value="${sessionScope.NAME }"/></td>
</tr>
<tr>
	<td>이메일 : </td>
	<td><input type="text" name="email" value="${sessionScope.EMAIL }"/></td>
</tr>
<tr>
	<td>생년월일 : </td>
	<td><input type="text" name="birth" value="${sessionScope.BIRTH }"/></td>
</tr>
<tr>
	<td>성별 : </td>
	<td><input type="text" name="gender" value="${sessionScope.GENDER }"/></td>
</tr>
<tr>
	<td>휴대폰 번호 : </td>
	<td><input type="text" name="phone" value="${sessionScope.PHONE }"/></td>
</tr>
</table>
<input type="submit" value="수정하기"/>
<input type="hidden" name="check"/>
</form>
<script type="text/javascript">
function submitcheck() {
		
	var password = form.password.value;
	var repassword = form.repassword.value;
	var name = form.name.value;
	var email = form.email.value;
	var birth = form.birth.value;
	var gender = form.gender.value;
	var phone = form.phone.value;

	if(password == "" || repassword == "" || name == "" || email == "" || birth == "" || gender == "" || phone == "") {
		alert("입력되지 않은 폼이 있습니다.");
		return false;
	}else if(password != repassword) {
		alert("비밀번호가 같지 않습니다.");
		return false;
	}else {
		alert("수정되었습니다.");
		return true;
	}
	
}
</script>
</body>
</html>