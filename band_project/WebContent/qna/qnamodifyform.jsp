<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ����</title>
</head>
<body>
<c:if test="${sessionScope.ID == param.ID }">
<form name="modifyform" action="../qna_modify.do" method="post" onsubmit="return modifyCheck()">
<input type="hidden" name="writing_id" value="${param.WID }"/>
<input type="hidden" name="writer_id" value="${param.ID }"/>
<table align="center" border="1px" width="700px">
	<tr>
		<td align="left" width="150px">�۾��� : ${param.ID }</td>
		<td align="left" width="550px">���� : <input type="text" name="title" value="${param.TI }"/></td>
	</tr>
</table>
<table align="center" border="1px" width="700px">
	<tr>
		<td width="400px" align="left">����</td>
		<td width="400px"><textarea name="content" rows="7" cols="90">${param.CON }</textarea>
		</td>
	</tr>
</table>
<table align="center" border="1px">
	<tr>
		<td width="60px"><input type="submit" value="���"></td>
		<td width="60px"><a href="javascript:winClose()">���</a></td>
	</tr>
</table>
</form>
</c:if>
<c:if test="${sessionScope.ID != param.ID }">
�ۼ��ڰ� ���� �ʽ��ϴ�!
</c:if>
<script type="text/javascript">
function modifyCheck() {
	
	if(modifyform.title.value == "" || modifyform.content.value == "") {
		alert("�Էµ��� ���� ���� �ֽ��ϴ�.");
		return false;
	}
	
}
function winClose() {
	
	close();
	
}
</script>
</body>
</html>