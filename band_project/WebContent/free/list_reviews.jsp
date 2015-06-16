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
<form>
<table width="100%" border="1" cellpadding="1">
<tr>
	<td>제목</td>
	<td><input type="text" name="title" size="40" value="${title }"/></td>
</tr>
<tr>
	<td>사진첨부</td>
	<td><input type="file" name="imagename" size="30"/></td>
</tr>
<tr>
	<td>부연설명</td>
	<td><textarea name="content" rows="8" cols="40"></textarea></td>
</tr>
</table>
`	<div align="right">
	<input type="submit" value="등록"/>				
	</div>
</form>		
</body>
</html>