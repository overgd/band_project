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
${sessionScope.BNAME }���� �����!<br/><br/>
<c:if test="${sessionScope.ID != null }">
<jsp:include page="/qna/qnawriteform.jsp"></jsp:include><br/>
</c:if>
<c:if test="${!empty INFO }">
<c:forEach var="writing" items="${INFO }">
<table border="1px" width="1000px">
	<tr>
		<td align="left" width="200px">�۾��� : ${writing.writer_id }</td>
		<td align="left">���� : ${writing.title }</td>
	</tr>
</table>
<table border="1px" width="1000px">
	<tr>
		<td width="200px" align="left">����</td><td>${CONTENT[writing.writing_id-1].content }</td>
	</tr>
</table>
<table border="1px">
	<tr>
		<c:if test="${sessionScope.ID == writing.writer_id }">
		<td width="60px">
		����
		</td>
		</c:if>
		<c:if test="${sessionScope.ID == writing.writer_id }">
		<td width="60px">
		����
		</td>
		</c:if>
		<td width="60px">
		<c:if test="${sessionScope.BID == BID }">
		���ϱ�
		</c:if>
		</td>
	</tr>
</table><br/>
</c:forEach>
</c:if>
<c:if test="${empty INFO }">
<table width="1000px" border="1px">
<tr><td>��ϵ� ���� �����ϴ�!</td></tr>
</table>
</c:if>
<script type="text/javascript">
function goInsert() {
	
	location.href("index.jsp?MAIN=qna/qnalist.jsp?INSERT=qnawriteform.jsp");
	
}
</script>
</body>
</html>