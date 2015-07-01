<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name="form">
<input type="hidden" name="bid" value="${sessionScope.BID }"/>
</form>
<c:if test="${RESULT == 'TRUE' }">
<script type="text/javascript">
location.href="index.jsp?MAIN=albumlist.do?BID="+document.form.bid.value;
</script>
</c:if>
</body>
</html>