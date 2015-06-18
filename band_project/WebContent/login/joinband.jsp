<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
BAND 가입
<form action="joinband.do" method="post">
<table cellpadding="10px">
<tr>
	<td width="200px">아이디 : </td>
	<td><input type="text" name="id"/></td>
	<td><input type="button" name="idcheck" onclick="bandidcheck.do"></td>
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
<input type="button" value="다시쓰기"/>
</form>
</body>
</html>