<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<form method="post" action="bandintromodifygo.do">
	<table width="1000" border="1">
		<tr>
			<td>
			<c:if test="${BAND.image_name != null }">
				<img alt="${BAND.name }" src="band_upload_files/${BAND.image_name }"/>
			</c:if>
			<c:if test="${BAND.image_name == null }">
				이미지를 등록해주세요!
			</c:if>
			</td>
		</tr>
		<tr>
			<td>
			${BAND.name }
			</td>
		</tr>
		<tr>
			<td>
			${BAND.genre }
			</td>
		</tr>
		<tr>
			<td>
			${BAND.content }
			</td>
		</tr>
	</table>
	<c:if test="${sessionScope.ID == ID }">
		<input type="submit" value="수정"/>
	</c:if>
</form>
</body>
</html>