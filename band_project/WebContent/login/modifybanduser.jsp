<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BAND ���� ����</title>
</head>
<body>
BAND ��������
<form name="form" action="modifyuserinfo.do" method="post" onsubmit="return submitcheck()">
<table cellpadding="10px">
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
	<td><input type="text" name="name" value="${sessionScope.NAME }"/></td>
</tr>
<tr>
	<td>�̸��� : </td>
	<td><input type="text" name="email" value="${sessionScope.EMAIL }"/></td>
</tr>
<tr>
	<td>�帣 : </td>
	<td><input type="text" name="genre" value="${sessionScope.GENRE }"/></td>
</tr>
</table>
<input type="submit" value="�����ϱ�"/>
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
		alert("�Էµ��� ���� ���� �ֽ��ϴ�.");
		return false;
	}else if(password != repassword) {
		alert("��й�ȣ�� ���� �ʽ��ϴ�.");
		return false;
	}else if(password != readpassword) {
		alert("��й�ȣ�� Ȯ�����ּ���!");
		return false;
	}else {
		alert("�����Ǿ����ϴ�.");
		return true;
	}
	
}
</script>
</body>
</html>