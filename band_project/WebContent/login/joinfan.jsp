<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>FAN ����</title>
</head>
<h2>FAN ����</h2>
<form name="form" action="joinfan.do" method="post" onsubmit="return submitcheck()">
<table cellpadding="10px">
<tr>
	<td width="200px">���̵� : </td>
	<td><input type="text" name="id" maxlength="8"/></td>
	<td><input type="button" value="�ߺ�Ȯ��" onclick="idcheck()"/></td>
	<td>����, 8�� ����</td>
</tr>
<tr>
	<td>��й�ȣ : </td>
	<td><input type="password" name="password"/></td>
	<td></td>
	<td>8�� ����</td>
</tr>
<tr>
	<td>��й�ȣ Ȯ�� : </td>
	<td><input type="password" name="repassword"/></td>
</tr>
<tr>
	<td>�̸� : </td>
	<td><input type="text" name="name"/></td>
	<td></td>
	<td>�ѱ�, ����</td>
</tr>
<tr>
	<td>�̸��� : </td>
	<td><input type="text" name="email"/></td>
</tr>
<tr>
	<td>������� : </td>
	<td><input type="text" name="birth"/></td>
</tr>
<tr>
	<td>���� : </td>
	<td><input type="radio" name="gender" value="��"/>����
		<input type="radio" name="gender" value="��"/>����
	</td>
</tr>
<tr>
	<td>�޴��� ��ȣ : </td>
	<td><input type="text" name="phone"/></td>
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
	
	if(check == "") {
		alert("ID �ߺ�Ȯ���� �ϼ���.");
		return false;
	}
	else if(check == c_f) {
		alert("ID�� �ߺ��˴ϴ�.");
		return false;
	}
	else if(id == "" || password == "" || repassword == "" || name == "" || email == "" || birth == "" || gender == "" || phone == "") {
		alert("�Էµ��� ���� ���� �ֽ��ϴ�.");
		return false;
	}
	else if(password != repassword) {
		alert("��й�ȣ�� ���� �ʽ��ϴ�.");
		return false;
	}else {
		alert("���ԵǼ̽��ϴ�.");
		return true;
	}
	
}
</script>
</body>
</html>