<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<form name="writeform" action="qna_write.do" method="post" onsubmit="return insertCheck()">
<input type="hidden" name="name" value="${sessionScope.NAME }"/>
<table class="list" border="1px" width="1000px">
	<tr>
		<th align="center" width="100px">�۾���</th><td class="list" align="left"> ${sessionScope.ID }</td>
	</tr>
	<tr>
		<th align="center">����</th><td class="list" align="left"><input type="text" name="title" size="118"/></td>
	</tr>
</table>
<table class="list" border="1px" width="1000px">
	<tr>
		<th width="100px" align="center">����</th><td class="list" align="left"><textarea name="content" rows="5" cols="113"></textarea>
		</td>
	</tr>
</table>
<table class="list" border="1px">
	<tr>
		<td width="50px"><input type="submit" value="���" ></td>
	</tr>
</table>
</form>
<script type="text/javascript">
function insertCheck() {
	
	if(writeform.title.value == "" || writeform.content.value == "") {
		alert("�Էµ��� ���� ���� �ֽ��ϴ�.");
		return false;
	}
	
}
</script>
</body>
</html>