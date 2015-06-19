<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>중복확인</title>
</head>
<body>
<form name="idcheck">
<c:choose>
	<c:when test="${param.result == 'empty' }">
	ID를 입력해주세요!
	</c:when>
	<c:when test="${param.result == 'true' }">
	사용하셔도 좋습니다!
	</c:when>
	<c:when test="${param.result != 'true' }">
	다른 아이디를 적어주세요.
	</c:when>
</c:choose><br/>
<input type="hidden" name="check" value="${param.result }">
<input type="button" value="닫기" onclick="click_close()">
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