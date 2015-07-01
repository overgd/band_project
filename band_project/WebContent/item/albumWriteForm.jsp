<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>앨범등록</h2>
<form action="album-post" method="post" enctype="multipart/form-data">
<table>
<tr>
<th>앨범이미지</th><td><input type="file" name="image_name"/></td>
</tr>
<tr>
<th>앨범제목</th><td><input type="text" name="title"/></td>
</tr>
<tr>
<th>앨범가격</th><td><input type="text" name="price"/></td>
</tr>
<tr>
<th>샘플음원</th><td><input type="file" name="file_name"/></td>
</tr>
<tr>
<th>앨범내용</th><td><textarea name="content" cols="80" rows="5"></textarea></td>
</tr>
</table>
<input type="submit" value="앨범등록"/>
</form>
</body>
</html>