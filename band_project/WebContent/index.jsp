<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css"/>
</head>
<body>
<div class="index">
	<div class="head">
		<a href="index.html">
		<img  alt="logo" src="./images/logo.jpg" height="200px">
		</a>
	</div>
	<div class="top" align="center">
		<table class="top.table">
		<tr>
			<td width="800px"></td>
			<td class="top.menu">
			<a href="index.jsp?MAIN=free/list_reviews.jsp">정보공유</a>
			</td>
			<td width="3500px" align="center">
			</td>
			<td class="top.login">
			<jsp:include page="login/loginForm.html"/>
			</td>
			<td width="800px"></td>
		</tr> 
		</table>
	</div>
	<div class="main">
	<table>
		<tr>
			<td width="800px"></td>
			<td width="5000px">
			<c:if test="${param.MAIN != null }">
			<jsp:include page="${param.MAIN }"/>
			</c:if>
			</td>
			<td width="800px"></td>
		</tr>
	</table>
	</div>
	<div class="bottom">
	<table class="bottom.table">
		<tr>
			<td width="800px"></td>
			<td width="5000px">BOTTOM.MENU</td>
			<td width="800px"></td>
		</tr>
	</table>
	</div>
</div>
</body>
</html>