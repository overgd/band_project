<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��������</title>
</head>
<body>
${sessionScope.BNAME }���� �����!<br/>
<c:choose>
<c:when test="${param.INSERT == null }">
<table width="1000px">
	<tr>
		<td align="left" width="300px">�۾��� : ������������</td>
		<td width="10%">
		<c:if test="${sessionScope.ID == param.ID }">
		����
		</c:if>
		</td>
		<td width="10%">
		<c:if test="${sessionScope.ID == param.ID }">
		����
		</c:if>
		<td width="10%">
		<c:if test="${sessionScope.BID == BID }">
		���ϱ�
		</c:if>
		</td>
	</tr>
</table>
<table width="1000px">
	<tr>
		<td align="left">����</td>
	</tr>
	<tr>
		<td>������������</td>
	</tr>
	<tr>
		<td><a href="javascript:goInsert()">���</a></td>
	</tr>
</table>
</c:when>
<c:when test="${param.INSERT != null }">
	<jsp:include page="${param.INSERT }"></jsp:include>
</c:when>
</c:choose>

<script type="text/javascript">
function goInsert() {
	
	location.href("index.jsp?MAIN=qna/qnalist.jsp?INSERT=qnawriteform.jsp");
	
}
</script>
</body>
</html>