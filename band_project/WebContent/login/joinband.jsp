<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
BAND ����
<form action="joinband.do" method="post">
<table cellpadding="10px">
<tr>
	<td width="200px">���̵� : </td>
	<td><input type="text" name="id"/></td>
	<td><input type="button" name="idcheck" onclick="bandidcheck.do"></td>
</tr>
<tr>
	<td>��й�ȣ : </td>
	<td><input type="password" name="password"/></td>
</tr>
<tr>
	<td>��й�ȣ Ȯ�� : </td>
	<td><input type="password" name="repassword"/></td>
</tr>
<tr>
	<td>����̸� : </td>
	<td><input type="text" name="name"/></td>
</tr>
<tr>
	<td>�̸��� : </td>
	<td><input type="text" name="email"/></td>
</tr>
<tr>
	<td>�帣 : </td>
	<td><input type="text" name="genre"/></td>
</tr>
</table>
<input type="submit" value="�����ϱ�"/>
<input type="button" value="�ٽþ���"/>
</form>
</body>
</html>