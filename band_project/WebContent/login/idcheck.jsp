<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ߺ�Ȯ��</title>
</head>
<body>
<form name="idcheck">
<c:if test="${param.result == 'true' }">
����ϼŵ� �����ϴ�!
</c:if>
<c:if test="${param.result != 'true' }">
�ٸ� ���̵� �����ּ���.
</c:if>
<input type="hidden" name="check" value="${param.result }">
<input type="button" value="�ݱ�" onclick="click_close()">
</form>
<script type="text/javascript">
function click_close() {
	
	var check = idcheck.check.value;
	
	window.opener.document.form.check.value = check;
	
	window.close();
	
}
</script>
</body>
</html>