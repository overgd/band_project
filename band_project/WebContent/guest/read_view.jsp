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
<c:if test="${empty writing }">
�������� �ʴ� ���Դϴ�.
</c:if>
<c:if test="${ ! empty writing }">
<table class="list" width="65%" border="1" cellpadding="1" align="center">
<tr>
	<th width="30%">����</th><td align="center">${writing.title }</td>
</tr>
<tr>
	<th width="30%">�ۼ���</th><td align="center">${writing.writerid }</td>
</tr>
<tr>
	<th width="30%">�۳���</th><td align="center">${writing.content }</td>
</tr>
<tr>
	<td colspan="2" align="center">
	<a href="javascript:goReply()"><input type="submit" value="���"/></a>
	<a href="javascript:goModify()"><input type="submit" value="����"/></a>
	<a href="javascript:goDelete()"><input type="submit" value="����"/></a>
	<a href="index.jsp?MAIN=guest-list"><input type="submit" value="���"/></a>
	</td>
</tr>
</table>
</c:if>
<script type="text/javascript">
function goReply(){
	document.move.action="index.jsp?MAIN=guest-reply";
	document.move.submit();
}
function goDelete(){
	document.move.action="index.jsp?MAIN=guest-delete"
	document.move.submit();
}
function goModify(){
	document.move.action="index.jsp?MAIN=guest-update"
	document.move.submit();
}
</script>
<form name="move" method="post">
<input type="hidden" name="id" value="${writing.writingid }"/>
<input type="hidden" name="parentid" value="${writing.writingid }"/>
<input type="hidden" name="groupid" value="${writing.groupid }"/>
</form>
</body>
</html>