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
<table class="list">
	<tr>
		<td>
			<table width="500px" class="list">
				<tr>
					<td><img width="500px" alt="${album.image_name }" src="album_upload_files/${album.image_name }"/></td>
				</tr>
			</table>
		</td>
		<td>
			<table width="500px" class="list">
				<tr>
					<th width="100px">앨범번호</th>
					<td>${album.album_id }</td>
				</tr>
				<tr>
					<th>출시일</th>
					<td>${album.register_date }</td>
				</tr>
				<tr>
					<th>앨범제목</th>
					<td>${album.title} </td>
				</tr>
				<tr>
					<th>만든이</th>
					<td>${bbs.writer_id} </td>
				</tr>
				<tr>
					<th>앨범가격</th>
					<td>${album.price } 원</td>
				</tr>
			
				<tr>
					<th>앨범내용</th>
					<td height="200px">${album.content }</td>
				</tr>
				<tr>
					<td></td>
					<td align="right">
					<table align="right" class="list"><tr>
					<c:if test="${sessionScope.ID != null && sessionScope.ID != sessionScope.BID }">
					<td>담기</td>
					</c:if>
					<c:if test="${sessionScope.ID == album.band_id }">
					<td>수정</td>
					<td>삭제</td>
					</c:if>
					</tr></table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>