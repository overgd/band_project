<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>DYNAMIC</title>
<link type="text/css" rel="stylesheet" href="style.css"/>
<script type="text/javascript">
</script>
</head>
<body topmargin="0" leftmargin="0">
<div class="index">
	<div class="head">
		<table class="head.table" align="center">
		<tr>
			<td width="5%"></td>
			<td width="10%" class="top.menu">
			</td>
			<td width="181px" class="top.center">
			<a href="index.html">
			<img  alt="logo" src="./images/logo.jpg" height="200px">
			</a>
			</td>
			<td width="10%" class="top.login">
			</td>
			<td width="5%"></td>
		</tr> 
		</table>
	</div>
	<div id="top" align="center">
		<table class="top.table">
		<tr>
			<td width="5%"></td>
			<td width="10%" class="top.menu">
			<jsp:include page="top/topForm.html"/>
			</td>
			<td width="181px" class="top.center">
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
	<div id="main">
	<table align="center">
		<tr>
			<td width="5%"></td>
			<td>
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
	<c:if test="${sessionScope.BID != null || param.BOTTOM != null || sessionScope.DIV == 'b'}">
	<div id="bottom">
		<c:choose>
			<c:when test="${param.BOTTOM != null }">
				<jsp:include page="${param.BOTTOM }"/>
			</c:when>
			<c:when test="${sessionScope.BID != null }">
				<jsp:include page="bottom/bottomMenu.jsp?BID=${sessionScope.BID }"/>
			</c:when>
			<c:when test="${sessionScope.DIV == 'b' }">
				<jsp:include page="bottom/bottomMenu.jsp?BID=${sessionScope.BID }"/>
			</c:when>
		</c:choose>
	</div>
	</c:if>
</div>
</body>
</html>