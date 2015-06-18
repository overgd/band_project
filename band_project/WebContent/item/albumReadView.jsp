<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>앨범번호</td>
		<td>${ai.albumid }</td>
	</tr>
	<tr>
		<td>앨범제목</td>
		<td>${ai.title} </td>
	</tr>
	<tr>
		<td>앨범가격</td>
		<td>${ai.price }</td>
	</tr>
	<tr>
		<td>앨범내용</td>
		<td>${ai.content }</td>
	</tr>
</table>
</body>
</html>