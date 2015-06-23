<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<table>
	<tr>
		<td>글쓴이 : ${sessionScope.NAME }</td>
	</tr>
	<tr>
		<td><textarea name="content" rows="5" cols="100"></textarea>
		</td>
	</tr>
</table>
</body>
</html>