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
${sessionScope.NAME }님의 마이페이지<br/><br/>
<c:choose>
<c:when test="${sessionScope.DIV == 'f' }">
	<a href="index.jsp?MAIN=pwdread.do">정보 수정</a>
</c:when>
<c:when test="${sessionScope.DIV == 'b' }">
	<a href="index.jsp?MAIN=pwdread.do">정보 수정</a>
</c:when>
</c:choose>
<a href="deleteuser.do" onclick="return deleteuser()">회원 탈퇴</a>
</body>
<script type="text/javascript">
function deleteuser() {
	
	var del;
	del=confirm("정말로 탈퇴하시겠습니까?");
	
	if(del) {
		return true;
	}else {
		return false;
	}
		
}
</script>
</html>