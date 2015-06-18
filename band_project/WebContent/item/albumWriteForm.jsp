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
<form action="album-post" method="post" enctype="">
앨범번호 : <input type="text" name="albumid"/><br/> 
앨범이미지:<input type="file" name="imagename"/><br/> 
앨범제목:<input type="text" name="title"/> <br/> 
앨범가격:<input type="text" name="price"/> <br/> 
앨범내용 :<textarea name="content" cols="80" rows="5"></textarea><br/> <br/> 
<input type="submit" value="앨범등록"/>
</form>
</body>
</html>