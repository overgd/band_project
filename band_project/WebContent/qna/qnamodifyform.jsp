<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 수정</title>
</head>
<body>
<c:if test="${sessionScope.ID == param.ID }">
<form name="modifyform" action="../qna_modify.do" method="post" onsubmit="return modifyCheck()">
<input type="hidden" name="writing_id" value="${param.WID }"/>
<input type="hidden" name="writer_id" value="${param.ID }"/>
<table align="center" border="1px" width="700px">
	<tr>
		<td align="left" width="150px">글쓴이 : ${param.ID }</td>
		<td align="left" width="550px">제목 : <input type="text" name="title" value="${param.TI }"/></td>
	</tr>
</table>
<table align="center" border="1px" width="700px">
	<tr>
		<td width="400px" align="left">내용</td>
		<td width="400px"><textarea name="content" rows="7" cols="90">${param.CON }</textarea>
		</td>
	</tr>
</table>
<table align="center" border="1px">
	<tr>
		<td width="60px"><input type="submit" value="등록"></td>
		<td width="60px"><a href="javascript:winClose()">취소</a></td>
	</tr>
</table>
</form>
</c:if>
<c:if test="${sessionScope.ID != param.ID }">
작성자가 같지 않습니다!
</c:if>
<script type="text/javascript">
function modifyCheck() {
	
	if(modifyform.title.value == "" || modifyform.content.value == "") {
		alert("입력되지 않은 폼이 있습니다.");
		return false;
	}
	
}
function winClose() {
	
	close();
	
}
</script>
</body>
</html>