<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
</head>
<body>
<table width="1000" border="1">
	<tr>
		<td width="40">���̵�</td>
		<td width="300">�̸�</td>
		<td width="80">�帣</td>
	</tr>
	<c:choose>
		<c:when test="${LISTSIZE > 0 }">
		<c:forEach var="cnt" begin="0" end="${LISTSIZE -1 }">
			<tr>
				<td>${LISTRESULT[cnt].id }</td>
				<td><a href="index.jsp?MAIN=bandintro.do?ID=${LISTRESULT[cnt].id }">${LISTRESULT[cnt].name }</a></td>
				<td>${LISTRESULT[cnt].genre }</td>
			</tr>	
		</c:forEach>
		</c:when>
		<c:when test="${LISTSIZE <= 0 }">
			<tr>
				<td></td>
				<td>�˻������ �����ϴ�!</td>
				<td></td>
			</tr>
		</c:when>
	</c:choose>
</table>
</body>
</html>