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
<form action="album-post" method="post" enctype="multipart/form-data">
<table>
<tr>
<th>�ٹ��̹���</th><td><input type="file" name="image_name"/></td>
</tr>
<tr>
<th>�ٹ�����</th><td><input type="text" name="title"/></td>
</tr>
<tr>
<th>�ٹ�����</th><td><input type="text" name="price"/></td>
</tr>
<tr>
<th>��������</th><td><input type="file" name="file_name"/></td>
</tr>
<tr>
<th>�ٹ�����</th><td><textarea name="content" cols="80" rows="5"></textarea></td>
</tr>
</table>
<input type="submit" value="�ٹ����"/>
</form>
</body>
</html>