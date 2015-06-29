<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>FAN ���� ����</title>
</head>
<body>
FAN ���� ����
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
	<th>�̸�</th>
	<td><input type="text" name="name" value="${sessionScope.NAME }"/></td>
	<td>�ѱ�, ����</td>
</tr>
<tr>
	<th>�̸���</th>
	<td><input type="text" name="email" value="${sessionScope.EMAIL }"/></td>
</tr>
<tr>
	<th>�������</th>
	<td><input type="text" name="birth" value="${sessionScope.BIRTH }"/></td>
</tr>
<tr>
	<th>����</th>
	<td>
	<c:if test="${sessionScope.GENDER == '��'}">
	<input type="radio" name="gender" value="��" checked="checked"/>����
	<input type="radio" name="gender" value="��"/>����
	</c:if>
	<c:if test="${sessionScope.GENDER == '��'}">
	<input type="radio" name="gender" value="��"/>����
	<input type="radio" name="gender" value="��" checked="checked"/>����
	</c:if>
	<c:if test="${sessionScope.GENDER == null}">
	<input type="radio" name="gender" value="��"/>����
	<input type="radio" name="gender" value="��"/>����
	</c:if>
	</td>
</tr>
<tr>
	<th>�޴��� ��ȣ</th>
	<td><input type="text" name="phone" value="${sessionScope.PHONE }"/></td>
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
	var birth = form.birth.value;
	var gender = form.gender.value;
	var phone = form.phone.value;

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
	
	if(password == "" || repassword == "" || name == "" || email == "" || birth == "" || gender == "" || phone == "") {
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