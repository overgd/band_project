<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BAND ����</title>
</head>
BAND ����
<form name="form" action="joinband.do" method="post" onsubmit="javascript:submitcheck()">
<table cellpadding="10px">
<tr>
	<td width="200px">���̵� : </td>
	<td><input type="text" name="id"/></td>
	<td><input type="button" value="�ߺ�Ȯ��" onclick="idcheck()"></td>
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
<input type="button" value="�ٽþ���" onclick="formreset()"/>
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
		alert("ID �ߺ�Ȯ���� �ϼ���.");
		return false;
	}
	if(check == c_f) {
		alert("ID�� �ߺ��˴ϴ�.");
		return false;
	}
	if(id == "" || password == "" || repassword == "" || name == "" || email == "" || genre == "") {
		alert("�Էµ��� ���� ���� �ֽ��ϴ�.");
		return false;
	}
	if(password != repassword) {
		alert("��й�ȣ�� ���� �ʽ��ϴ�.");
	}
	
}
</script>
</body>
</html>