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
존재하지 않는 글입니다.
</c:if>
<c:if test="${ ! empty writing }">
<table class="list" width="100%" border="1" cellpadding="1">
<tr>
	<th>제목</th><td>${writing.title }</td>
</tr>
<tr>
	<th>작성자</th><td>${writing.writerid }</td>
</tr>
<tr>
	<th>글내용</th><td>${writing.content }</td>
</tr>
<tr>
	<td colspan="2">
	<a href="javascript:goReply()">[답글]</a>
	<a href="javascript:goModify()">[수정]</a>
	<a href="javascript:goDelete()">[삭제]</a>
	<a href="index.jsp?MAIN=guest-list">[목록]</a>
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