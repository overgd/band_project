<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����</title>
</head>
<body>
<table width="100%" border="0" cellpadding="2">
	<tr>
		<td><jsp:include page="top.jsp"/></td>
	</tr>
	<tr>
		<td><jsp:include page="${param.CONTENTPAGE }"/></td>
	</tr>
</table>
</body>
</html>