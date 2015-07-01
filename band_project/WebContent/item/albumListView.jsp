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
<h2>${sessionScope.BNAME }�� �ٹ�</h2>
<table align="center" class="list" width="1000px">
	<tr>
		<th width="80px">�۹�ȣ</th>
		<th width="80px">�ٹ���ȣ</th>
		<th width="100px">�ٹ��̹���</th>
		<th width="500px">�ٹ�����</th>
		<th>�ٹ�����</th>
		<c:if test="${sessionScope.ID != null && sessionScope.ID != sessionScope.BID }">
		<th>��ٱ���</th>
		</c:if>
	</tr>
	<c:if test="${!empty bbs }">
	<c:set var="cnt" value="${COUNT }"/>
	<c:forEach var="c" begin="0" end="${COUNT-1 }">
		<tr align="center">
			<td>${bbs[c].writing_id }</td>
			<td>${bbs[c].album_id }</td>
			<td><a href="index.jsp?MAIN=albumread.do?AID=${bbs[c].album_id }"><img width="100px" alt="${album[c].image_name }" src="album_upload_files/thumb.${album[c].image_name }"/></a></td>
			<td><a href="index.jsp?MAIN=albumread.do?AID=${bbs[c].album_id }">${album[c].title }</a></td>
			<td>${album[c].price } ��</td>
			<c:if test="${sessionScope.ID != null && sessionScope.ID != sessionScope.BID }">
			<td><input type="button" value="���" onclick="cartadd('${album[c].album_id}')"/></td>
			</c:if>
		</tr>
	</c:forEach>
	</c:if>
</table>
<c:if test="${empty bbs }">
	<table width="1000px" class="list"><tr><td align="center">��ϵ� �ٹ��� �����ϴ�!</td></tr></table>
</c:if>
<c:if test="${sessionScope.ID == sessionScope.BID }">
<br/><a class="white" href="index.jsp?MAIN=item/albumWriteForm.jsp">�ٹ����</a>
</c:if>
</body>
<script type="text/javascript">
function cartadd(aid) {
	
	var choice;
	
	document.cart.album_id.value = aid;
	
	choice=confirm("��ٱ��Ͽ� ��� �̵��ұ��?");
	if(choice) {
		document.cart.action="cartadd.do?movecart=yes";
		document.cart.submit();
	} else {
		document.cart.action="cartadd.do?movecart=no";
		document.cart.submit();
	}
	
}
</script>
<form name="cart" method="post">
<input type="hidden" name="album_id" value=""/>
</form>
</html>