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

<c:if test="${ ! empty writing }">
<form action="index.jsp?MAIN=guest.delete.do" method="post" onsubmit="return validate(this)">
<input type="hidden" name="id" value="${writing.writingid }"/>
<input type="hidden" name="title" value="${writing.title }"/>
<table width="100%" border="1" cellpadding="1">
<tr>
	<td>������</td><td>${writing.title }</td>
</tr>
<tr>
	<td>�۳���</td><td>${writing.content }</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="����"/>
		<input type="button" value="���"
						onClick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>
</form>
</c:if>
</body>
</html>