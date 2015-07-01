<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 성공!</title>
</head>
<body>
<table class="f">
	<tr>
		<td>
		${sessionScope.NAME }님 환영합니다!!
		</td>
		<td>
		<input type="button" value="로그아웃" onclick="logout()" class="f"/>
		</td>
	</tr>
	<tr>
		<td>
		<a class="white" href="index.jsp?MAIN=login/mypage.jsp">마이페이지</a>
		</td>
		<td>
		<a class="white" href="index.jsp?MAIN=user/cart.jsp">장바구니</a>
		</td>
	</tr>
</table>
<script type="text/javascript">
function logout() {
	location.href("logout.do");
}
</script>
</body>
</html>