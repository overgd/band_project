<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�ٹ����</h2>
<form action="album-post" method="post" enctype="">
�ٹ���ȣ : <input type="text" name="albumid"/><br/> 
�ٹ��̹���:<input type="file" name="imagename"/><br/> 
�ٹ�����:<input type="text" name="title"/> <br/> 
�ٹ�����:<input type="text" name="price"/> <br/> 
�ٹ����� :<textarea name="content" cols="80" rows="5"></textarea><br/> <br/> 
<input type="submit" value="�ٹ����"/>
</form>
</body>
</html>