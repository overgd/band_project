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
<form action="album_modify.do" name="modifyform" method="post" enctype="multipart/form-data">
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
					<td>${album.album_id }<input type="hidden" name="album_id" value="${album.album_id }"/></td>
				</tr>
				<tr>
					<th>출시일</th>
					<td>${album.register_date }</td>
				</tr>
				<tr>
					<th>앨범제목</th>
					<td>
					<input type="text" name="title" value="${album.title }"/>
					</td>
				</tr>
				<tr>
					<th>앨범이미지</th>
					<td><input type="file" name="image_name" value="${album.image_name }"/></td>
				</tr>
				<tr>
					<th>만든이</th>
					<td>${writer }</td>
				</tr>
				<tr>
					<th>앨범가격</th>
					<td><input type="text" name="price" value="${album.price }"/> 원</td>
				</tr>
				<tr>
					<th>샘플음원</th>
					<td><input type="file" name="file_name" value="${album.file_name }"/></td>
				</tr>
				<tr>
					<th>앨범내용</th>
					<td height="200px">
					<textarea name="content" rows="10" cols="50">${album.content }</textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="right">
					<table align="right" class="list"><tr>
					<td><input type="submit" value="수정하기"/></td>
					<td><input type="button" value="취소" onclick="javascript:history.go(-1)"/></td>
					</tr></table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">

</script>
</body>
</html>