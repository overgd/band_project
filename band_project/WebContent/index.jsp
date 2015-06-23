<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>DYNAMIC</title>
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
			<td width="5%"></td>
			<td width="10%" class="top.menu">
			<jsp:include page="top/topForm.html"/>
			</td>
			<td width="3000px">
			</td>
			<td width="15%" class="top.login">
			<c:choose>
				<c:when test="${sessionScope.ID == null }">
					<jsp:include page="login/loginForm.html"/>
				</c:when>
				<c:when test="${sessionScope.ID != null }">
					<jsp:include page="login/loginConfirm.jsp?ID=${sessionScope.ID }"/>
				</c:when>
			</c:choose>
			</td>
			<td width="5%"></td>
		</tr> 
		</table>
	</div>
	<div class="main">
	<table>
		<tr>
			<td width="5%"></td>
			<td width="3000px">
			<c:choose>
				<c:when test="${param.MAIN != null }">
					<jsp:include page="${param.MAIN }"/>
				</c:when>
				<c:when test="${sessionScope.DIV == 'b' }">
					<c:redirect url="bandintrosession"/>
				</c:when>
			</c:choose>
			</td>
			<td width="5%"></td>
		</tr>
	</table>
	</div>
	<c:if test="${param.BOTTOM != null || sessionScope.DIV == 'b'}">
	<div class="bottom">
	<table class="bottom.table">
		<tr>
			<td width="5%"></td>
			<td width="5000px">
			<c:choose>
				<c:when test="${param.BOTTOM != null }">
					<jsp:include page="${param.BOTTOM }"/>
				</c:when>
				<c:when test="${sessionScope.DIV == 'b' }">
					<jsp:include page="bottom/bottomMenu.jsp?ID=${sessionScope.BID }"/>
				</c:when>
			</c:choose>
			</td>
			<td width="5%"></td>
		</tr>
	</table>
	</div>
	</c:if>
</div>
</body>
</html>