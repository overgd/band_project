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
���� �������� �ʽ��ϴ�.
</c:if>
<c:if test="${ ! empty writing }">
<table width="100%" border="1" cellpadding="1">
<tr>
	<td bgcolor="black"><font color = "white" FACE= "����" align="center">����</font></td><td>${writing.title }</td>
</tr>
<tr>
	<td bgcolor="black"><font color = "white"  FACE= "����">�ۼ���</font></td><td>${writing.writerid }</td>
</tr>
<tr>
	<td colspan="2" align="center"><img src="upload_files/${writing.imagename }" 
		alt="�̹���" width="350" border="0"/></td>
</tr>
<tr>
	<td bgcolor="black"><font color = "white"  FACE= "����">�۳���</font></td><td>${writing.content }</td>
</tr>
<tr>
	<td bgcolor="black"><font color = "white"  FACE= "����">���</font></td><td>${writing.location }</td>
</tr>
<tr>
	<td colspan="2">
	
		<a href="">�ı�</a>
		<a href="javascript:schModify()">����</a>
		<a href="javascript:schDelete()">����</a>
		<a href="sch-list">���</a>
	</td>
</tr>
</table>
</c:if>
<script type="text/javascript">
function goReply(){
	document.move.action="sch-reply";
	document.move.submit();
}
function goDelete(){
	document.move.action="sch-delete";
	document.move.submit();
}
function goModify(){
	document.move.action="sch-update";
	document.move.submit();
}
</script>
<form name="move" method="post">
<input type="hidden" name="id" value="${writing.writingid }"/>
</form>
</body>
</html>






