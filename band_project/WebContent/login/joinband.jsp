<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BAND ����</title>
</head>
<h2>BAND ����</h2>
<form name="form" action="joinband.do" method="post" onsubmit="return submitcheck()">
<table cellpadding="10px">
<tr>
	<th width="200px">���̵�</th>
	<td><input type="text" name="id" maxlength="8"/></td>
	<td><input type="button" value="�ߺ�Ȯ��" onclick="idcheck()"/></td>
	<td>����, 8�� ����</td>
</tr>
<tr>
	<th>��й�ȣ</th>
	<td><input type="password" name="password" maxlength="8"/></td>
	<td></td>
	<td>8�� ����</td>
</tr>
<tr>
	<th>��й�ȣ Ȯ��</th>
	<td><input type="password" name="repassword" maxlength="16"/></td>
</tr>
<tr>
	<th>����̸�</th>
	<td><input type="text" name="name"/></td>
	<td></td>
</tr>
<tr>
	<th>�̸���</th>
	<td><input type="text" name="email"/></td>
</tr>
<tr>
	<th>�帣</th>
	<td>
	<select name="genre">
		<option>Rock</option>
		<option>Blues</option>
		<option>R&B</option>
		<option>Folk</option>
		<option>Electronic</option>
	</select>
	</td>
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
	var id_cnt = 0;
	
	for (i=0;i<id.length;i++){
  		
		ls_one_char = id.charAt(i);
	
	 	if(ls_one_char.search(/[0-9|a-z|A-Z]/) == -1) {
	 		id_cnt++;
		}
	 	
	}
	
	if(id_cnt!=0) {
		alert("���̵�� ����, ���ڸ� �����մϴ�.") 
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
	
	 	if(ls_one_char.search(/[0-9|a-z|A-Z|��-��|��-��|��-��]/) == -1) {
	 		name_cnt++;
		}
	 	
	}
	
	if(name_cnt!=0) {
		alert("�̸��� ����, �ѱ�, ���ڸ� �����մϴ�.") 
		return false;
	}
	
	if(id_cnt!=0) {
		alert("���̵�� ����, ���ڸ� �����մϴ�.") 
		return false;
	}
	
	if(check == "") {
		alert("ID �ߺ�Ȯ���� �ϼ���.");
		return false;
	}
	else if(check == c_f) {
		alert("ID�� �ߺ��˴ϴ�.");
		return false;
	}
	else if(id == "" || password == "" || repassword == "" || name == "" || email == "" || genre == "") {
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