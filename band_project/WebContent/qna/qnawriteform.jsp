<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<form action="qna_write.do" method="post">
<input type="hidden" name="name" value="${sessionScope.NAME }"/>
<table border="1px" width="1000px">
	<tr>
		<td align="left" width="200px">�۾��� : ${sessionScope.NAME }</td>
		<td align="left" width="59.3%">���� : <input type="text" name="title"/></td>
		<td width="10%"><input type="submit" value="���"></td>
		<td width="10%"><a href="">����</a></td>
	</tr>
</table>
<table border="1px" width="1000px">
	<tr>
		<td width="200px" align="left">����</td><td><textarea name="content" rows="5" cols="100"></textarea>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
</script>
</body>
</html>