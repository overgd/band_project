<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��������</title>
</head>
<body>
<table>
	<tr>
		<td>�۾��� : ������������</td><td><a href="javascript:goInsert()">���</a></td><td>����</td><td>����</td>
	</tr>
</table>
<table>
	<tr>
		<td>���� : </td><td>������������</td>
	</tr>
</table>
<c:if test="">
<table>
	<tr>
		<td>�۾��� : ������������</td><td>���</td><td>����</td><td>����</td>
	</tr>
</table>
<table>
	<tr>
		<td>���� : </td><td>������������</td>
	</tr>
</table>
</c:if>
<script type="text/javascript">
function goInsert() {
	
	location.href("qnawriteform.jsp");
	
}
</script>
</body>
</html>