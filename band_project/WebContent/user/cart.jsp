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
<table align="center" class="list" width="1000px">
	<tr>
		<th>�ٹ���ȣ</th>
		<th>�ٹ�����</th>
		<th>�ٹ�����</th>
		<th>�ٹ�����</th>
		<th>�Ѱ���</th>
	</tr>
	<c:if test="${!empty sessionScope.CP }">
	<c:forEach var="CP" items="${sessionScope.CP }">
	<tr align="center">
		<td>${CP.album.album_id }</td>
		<td>${CP.album.title }</td>
		<td>${CP.album.price }</td>
		<td>${CP.number }</td>
		<td>${CP.number * CP.album.price } ��</td>
	</tr>
	</c:forEach>
	</c:if>
</table>
<c:if test="${empty sessionScope.CP }">
<table align="center" class="list" width="1000px">
<tr><td>��ٱ��ϰ� ������ϴ�!</td></tr>
</table>
</c:if>
<br/><br/><a class="white" href="">�����ϱ�</a>
</body>
</html>