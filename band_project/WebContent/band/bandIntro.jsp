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
			<td width="500px">
			<c:if test="${BAND.image_name != null }">
				<img width="500px" alt="${BAND.name }" src="band_upload_files/${BAND.image_name }"/>
			</c:if>
			<c:if test="${BAND.image_name == null }">
				이미지를 등록해주세요!
			</c:if>
			</td>

		<td width="500px">
			<table align="center" width="500px">
				<tr>
					<th>
					<h2>밴드 이름</h2>
					</th>
				</tr>
				<tr>
					<td align="center">
					<h3>${BAND.name }</h3>
					</td>
				</tr>
				<tr>
					<th>
					<h2>장르</h2>
					</th>
				</tr>
				<tr>
					<td align="center">
					<h3>${BAND.genre }</h3>
					</td>
				</tr>
				<tr>
					<th>
					<h2>소개</h2>
					</th>
				</tr>
				<tr>
					<td align="center">
					<h3>${BAND.content }</h3>
					</td>
				</tr>
			</table>
		</td>
			
		</tr>
		
	</table>
	<br/>
	<c:if test="${sessionScope.ID == ID }">
		<input type="submit" value="수정하기"/>
	</c:if>
</form>
</body>
</html>