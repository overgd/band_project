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
<c:if test="${param.RESULT == 'TRUE' }">
작성되었습니다!<br/>
<a href="javascript:winClose()">닫기</a>
</c:if>
<c:if test="${param.RESULT == 'FALSE' }">
실패했습니다.
<a href="javascript:winClose()">닫기</a>
</c:if>
<script type="text/javascript">
function winClose() {
	
	opener.location.reload();
	close();
	
}
</script>
</body>
</html>