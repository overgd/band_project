<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>FAN ���� ����</title>
</head>
<body>
FAN ���� ����
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
	<td>�̸� : </td>
	<td><input type="text" name="name" value="${sessionScope.NAME }"/></td>
</tr>
<tr>
	<td>�̸��� : </td>
	<td><input type="text" name="email" value="${sessionScope.EMAIL }"/></td>
</tr>
<tr>
	<td>������� : </td>
	<td><input type="text" name="birth" value="${sessionScope.BIRTH }"/></td>
</tr>
<tr>
	<td>���� : </td>
	<td><input type="text" name="gender" value="${sessionScope.GENDER }"/></td>
</tr>
<tr>
	<td>�޴��� ��ȣ : </td>
	<td><input type="text" name="phone" value="${sessionScope.PHONE }"/></td>
</tr>
</table>
<input type="submit" value="�����ϱ�"/>
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
		alert("�Էµ��� ���� ���� �ֽ��ϴ�.");
		return false;
	}else if(password != repassword) {
		alert("��й�ȣ�� ���� �ʽ��ϴ�.");
		return false;
	}else {
		alert("�����Ǿ����ϴ�.");
		return true;
	}
	
}
</script>
</body>
</html>