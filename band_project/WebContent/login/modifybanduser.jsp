<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BAND 정보 수정</title>
</head>
<body>
BAND 정보수정
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
	<td>밴드이름 : </td>
	<td><input type="text" name="name" value="${sessionScope.NAME }"/></td>
</tr>
<tr>
	<td>이메일 : </td>
	<td><input type="text" name="email" value="${sessionScope.EMAIL }"/></td>
</tr>
<tr>
	<td>장르 : </td>
	<td><input type="text" name="genre" value="${sessionScope.GENRE }"/></td>
</tr>
</table>
<input type="submit" value="수정하기"/>
<input type="hidden" name="check"/>
<input type="hidden" name="readpassword" value="${PWD }" />
</form>
<script type="text/javascript">
function submitcheck() {
		
	var readpassword = form.readpassword.value;
	var password = form.password.value;
	var repassword = form.repassword.value;
	var name = form.name.value;
	var email = form.email.value;
	var genre = form.genre.value;
	
	if(password == "" || repassword == "" || name == "" || email == "" || genre == "") {
		alert("입력되지 않은 폼이 있습니다.");
		return false;
	}else if(password != repassword) {
		alert("비밀번호가 같지 않습니다.");
		return false;
	}else if(password != readpassword) {
		alert("비밀번호를 확인해주세요!");
		return false;
	}else {
		alert("수정되었습니다.");
		return true;
	}
	
}
</script>
</body>
</html>