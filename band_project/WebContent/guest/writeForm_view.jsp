<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(form) {
	if(form.title.value == ""){
		alert("������ �Է��ϼ���."); return false;
	}else if(form.content.value == ""){
		alert("�� ������ �Է��ϼ���."); return false;
	}
}
</script>
<form action="guest.write.do" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">

<table width="100%" border="1" cellpadding="1">
<tr>
	<td>�� ����</td>
	<td><input type="text" name="title" size="40" value="${title }"/></td>
</tr>
<tr>
	<td>�۳���</td>
	<td><textarea name="content" rows="8" cols="40"></textarea></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="�� �ø���"/></td>
</tr>
</table>
<input type="hidden" name="writername" size="10" value="session.getId()"/>	
</form>
</body>
</html>