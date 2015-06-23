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
<table width="1000px">
	<tr>
		<td align="left" width="300px">글쓴이 : ${sessionScope.NAME }</td>
		<td width="10%"></td>
		<td width="10%"><input type="submit" value="등록"></td>
		<td width="10%"><a href="">취소</a></td>
	</tr>
</table>
<table width="1000px">
	<tr>
		<td align="left">내용</td>
	</tr>
	<tr>
		<td><textarea name="content" rows="5" cols="100"></textarea>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
</script>
</body>
</html>