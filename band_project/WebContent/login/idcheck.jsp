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
<c:choose>
	<c:when test="${param.result == 'empty' }">
	ID�� �Է����ּ���!
	</c:when>
	<c:when test="${param.result == 'true' }">
	����ϼŵ� �����ϴ�!
	</c:when>
	<c:when test="${param.result != 'true' }">
	�ٸ� ���̵� �����ּ���.
	</c:when>
</c:choose><br/>
<input type="hidden" name="check" value="${param.result }">
<input type="button" value="�ݱ�" onclick="click_close()">
</form>
<script type="text/javascript">
function click_close() {
	
	var check = idcheck.check.value;
	
	window.opener.document.form.check.value = check;
	if(check != "true"){
		window.opener.document.form.id.value = null;
	}
	window.close();
	
}
</script>
</body>
</html>