<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${! empty writing }">
<form action="free.delete.do" method="post" onSubmit="return validate(this)">
<input type="hidden" name="id" value="${writing.writingid }"/>
<h2>�Ѹ��� �����ϱ�</h2>
<table class="list" width="1000" border="0" cellpadding="1"  align="center">
<tr>
	<td width="20%"></td><th>������</th><td  align="left">${writing.title }</td>
</tr>
<tr>
	<td width="20%"></td><th>�ۼ���</th><td  align="left">${writing.writername }</td>
</tr>
<tr>
	<td width="20%"></td><th>�̹���</th><td  align="left"><img src="free_upload_files/${writing.imagename }" alt="�̹���" width="250"/></td>
</tr>

<tr>
	<td colspan="4"  align="right">
		<input type="submit" value="����"/>
		<input type="button" value="���" onClick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>
</form>
</c:if>
</body>
</html>


















