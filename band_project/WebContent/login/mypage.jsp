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
${sessionScope.NAME }���� ����������<br/>
<c:choose>
<c:when test="${sessionScope.DIV == 'f' }">
	<a href="index.jsp?MAIN=login/modifyfanuser.jsp">���� ����</a>
</c:when>
<c:when test="${sessionScope.DIV == 'b' }">
	<a href="index.jsp?MAIN=login/modifybanduser.jsp">���� ����</a>
</c:when>
</c:choose>
<a href="">ȸ�� Ż��</a>
</body>
</html>