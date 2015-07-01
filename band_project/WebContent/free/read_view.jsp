<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
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
<c:if test="${! empty writing }">
<h2>Free Board</h2>
<table class="list" width="1000"border="1" cellpadding="1"  align="center">
<tr>
	<th width="500">제목</th><th width="500">작성자</th>
</tr>
<tr>
	<td align="center">${writing.title }</td><td align="center">${writing.writername}</td>

<tr>
	<th>이미지</th><th>글내용</th>
</tr>
<tr>
	<td align="center"><img src="free_upload_files/${writing.imagename }" alt="이미지" width="150" border="0"></td><td align="center">${writing.content }</td>
</tr>
<c:if test="${ ! empty sessionScope.ID }">
<tr>
	<td  colspan="4" align="right">
		<a href="javascript:goReply()">[답글]</a>
		<a href="javascript:goModify()">[수정]</a>
		<a href="javascript:goDelete()">[삭제]</a>
		<a href="free-list">[목록]</a>
	</td>
</tr>
</c:if>
<c:if test="${  empty sessionScope.ID }">
<tr>
	<td  colspan="4" align="right">
		
		<a href="free-list">[목록]</a>
	</td>
</tr>
</c:if>
</table>
</c:if>
<script type="text/javascript">
function goReply(){
	document.move.action="free-reply";
	document.move.submit();
}	
function goDelete(){
	document.move.action="free-delete";
	document.move.submit();
}
function goModify(){
	document.move.action="free-update";
	document.move.submit();
}
</script>
<form name="move" method="post">
<input type="hidden" name="id" value="${writing.writingid }"/>
<input type="hidden" name="parentid" value="${ writing.writingid }"/>
<input type="hidden" name="groupid" value="${ writing.groupid }"/>
</form>
</body>
</html>















