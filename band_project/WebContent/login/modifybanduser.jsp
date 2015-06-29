<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BAND ���� ����</title>
</head>
<body>
BAND ��������<br/><br/>
<form name="form" action="modifyuserinfo.do" method="post" onsubmit="return submitcheck()">
<table class="list" cellpadding="10px">
<tr>
	<th>��й�ȣ</th>
	<td><input type="password" name="password"/></td>
</tr>
<tr>
	<th>��й�ȣ Ȯ��</th>
	<td><input type="password" name="repassword"/></td>
</tr>
<tr>
	<th>����̸�</th>
	<td><input type="text" name="name" value="${sessionScope.NAME }"/></td>
	<td>�ѱ�, ����</td>
</tr>
<tr>
	<th>�̸���</th>
	<td><input type="text" name="email" value="${sessionScope.EMAIL }"/></td>
</tr>
<tr>
	<th>�帣</th>
	<td>${sessionScope.GENRE } - 
		<select name="genre">
			<option>Rock</option>
			<option>Blues</option>
			<option>R&B</option>
			<option>Folk</option>
			<option>Electronic</option>
		</select>
	</td>
</tr>
</table><br/><br/>
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