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
<form method="post" name="cart">
<table align="center" class="list" width="1000px">
	<tr>
		<th>앨범번호</th>
		<th>앨범제목</th>
		<th>앨범가격</th>
		<th>앨범수량</th>
		<th>총가격</th>
	</tr>
	<c:if test="${!empty sessionScope.CP }">
	<c:forEach varStatus="st" var="CP" items="${sessionScope.CP }">
	<tr align="center">
		<td>${CP.album.album_id }</td>
		<td>${CP.album.title }</td>
		<td>${CP.album.price }</td>
		<td><input type="button" value="-" onclick="numdecrease(${CP.album.album_id })"/>
		${CP.number }
		<input type="button" value="+" onclick="numincrease(${CP.album.album_id })"/>
		</td>
		<td>${CP.number * CP.album.price } 원</td>
	</tr>
	</c:forEach>
	<input type="hidden" name="aid" value="-1"/>
	</c:if>
</table>
<c:if test="${empty sessionScope.CP }">
<table align="center" class="list" width="1000px">
<tr><td align="center">장바구니가 비었습니다!</td></tr>
</table>
</c:if>
<br/><br/>
<div align="right">
<a class="white" href="">결제하기</a>
<a class="white" href="javascript:cartremove()">초기화</a>
</div>
</form>
</body>
<script type="text/javascript">
function numincrease(id) {
	
	document.cart.aid.value = id;
	document.cart.action="cartmodify.do?function=plus";
	document.cart.submit();
}
function numdecrease(id) {

	document.cart.aid.value = id;
	document.cart.action="cartmodify.do?function=minus";
	document.cart.submit();
}
function cartremove(id) {

	document.cart.action="cartmodify.do?function=remove";
	document.cart.submit();
	
}
</script>
</html>