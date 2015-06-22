<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 결과</title>
</head>
<body>
<table border="1">
	<tr>
		<td width="40">아이디</td>
		<td width="300">이름</td>
		<td width="80">장르</td>
	</tr>
	<c:forEach var="cnt" begin="0" end="${LISTSIZE -1 }">
		<tr>
			<td>${LISTRESULT[cnt].id }</td>
			<td>${LISTRESULT[cnt].name }</td>
			<td>${LISTRESULT[cnt].genre }</td>
		</tr>	
	</c:forEach>
</table>
</body>
</html>