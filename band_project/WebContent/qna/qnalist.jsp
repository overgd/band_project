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
<form name="qnalist">
<c:if test="${!empty INFO }">
<c:set var="cnt" value="${COUNT }"/>
<c:forEach var="c" begin="0" end="${COUNT-1 }">
<table border="1px" width="1000px">
	<tr>
		<td align="left" width="200px">�۾��� : ${INFO[c].writer_id }</td>
		<td align="left">���� : ${INFO[c].title }</td>
	</tr>
</table>
<table border="1px" width="1000px">
	<tr>
		<td width="200px" align="left">����</td><td align="left">${CONTENT[c].content }</td>
	</tr>
</table>
<c:if test="${sessionScope.ID != null}">
<table border="1px">
	<tr>
		<c:if test="${sessionScope.ID == INFO[c].writer_id }">
		<td width="60px">
		����
		</td>
		</c:if>
		<c:if test="${sessionScope.ID == INFO[c].writer_id }">
		<td width="60px">
		<a href="javascript:goDelete(${INFO[c].writing_id}, '${INFO[c].writer_id }', '${INFO[c].band_id }')">����</a>
		</td>
		</c:if>
		<td width="60px">���ϱ�</td>
	</tr>
</table>
</c:if><br/>
</c:forEach>
</c:if>
<c:if test="${empty INFO }">
<table width="1000px" border="1px">
<tr><td>��ϵ� ���� �����ϴ�!</td></tr>
</table>
</c:if>
</form>
<script type="text/javascript">
function goInsert() {
	
	location.href("index.jsp?MAIN=qna/qnalist.jsp?INSERT=qnawriteform.jsp");
	
}
function goDelete(writing_id, writer_id, band_id) {
	
	var choice;
	
	choice=confirm("������ �����Ͻðڽ��ϱ�?");
	
	if(choice) {
		alert("�����մϴ�.");
		location.href("index.jsp?MAIN=qnadelete.do?WID="+writing_id+"&BID="+band_id+"&ID="+writer_id);
	} else {
		alert("����ϼ̽��ϴ�.");
	}
}
</script>
</body>
</html>