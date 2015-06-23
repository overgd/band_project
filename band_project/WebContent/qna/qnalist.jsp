<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>질의응답</title>
</head>
<body>
${sessionScope.BNAME }에게 물어봐!<br/>
<c:choose>
<c:when test="${param.INSERT == null }">
<table width="1000px">
	<tr>
		<td align="left" width="300px">글쓴이 : ㅂㅈㄱㅂㅈㄱ</td>
		<td width="10%">
		<c:if test="${sessionScope.ID == param.ID }">
		수정
		</c:if>
		</td>
		<td width="10%">
		<c:if test="${sessionScope.ID == param.ID }">
		삭제
		</c:if>
		<td width="10%">
		<c:if test="${sessionScope.BID == BID }">
		답하기
		</c:if>
		</td>
	</tr>
</table>
<table width="1000px">
	<tr>
		<td align="left">내용</td>
	</tr>
	<tr>
		<td>ㅂㅈㄱㅂㅈㄱ</td>
	</tr>
	<tr>
		<td><a href="javascript:goInsert()">등록</a></td>
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