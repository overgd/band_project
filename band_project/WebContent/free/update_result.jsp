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
<c:if test="${! empty RESULT }">
	<script type="text/javascript">
	alert("������� �ʾҽ��ϴ�.");
	location.href="bbs-update?id=${id}";
	</script>
</c:if>
<c:if test="${ empty RESULT }">
	<script type="text/javascript">
	alert("����Ǿ����ϴ�.");
	location.href="bbs-update?id=${id}";
	</script>
</c:if>
</body>
</html>