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

<c:if test="${ ! empty writing }">
<form action="guest.delete.do" method="post" onsubmit="return validate(this)">
<input type="hidden" name="id" value="${writing.writingid }"/>
<input type="hidden" name="title" value="${writing.title }"/>
<table class="list" width="1000px" border="1" cellpadding="1" align="center">
<tr>
	<th width="30%">글제목</th><td align="center">${writing.title }</td>
</tr>
<tr>
	<th width="30%">글내용</th><td align="center">${writing.content }</td>
</tr>
<tr>
	<td colspan="2" align="right">
		<input type="submit" value="삭제" />
		<input type="button" value="취소"
						onClick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>
</form>
</c:if>
</body>
</html>