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
<script type="text/javascript">
function validate(form){
	if(form.title.value == ""){
		alert("������ �Է��ϼ���."); return false;
	}else if(form.imagename.value == ""){
		alert("�̹����� �־��ּ���."); return false;
	}else if(form.content.value == ""){
		alert("�� ������ �Է��ϼ���."); return false;
	}	
	
}
</script>
<form action="free.write.do" method="post" enctype="multipart/form-data"
				onSubmit="return validate(this)">
<input type="hidden" name="orderno" value="${writing.orderno + 1 }"/>		
<c:if test="${! empty writing.groupid }">
<input type="hidden" name="groupid" value="${writing.groupid }"/>
</c:if>		
<c:if test="${! empty writing.parentid }">
<input type="hidden" name="parentid" value="${writing.parentid }"/>
</c:if>

<table class="list" width="1000px" border="1" cellpadding="1"  align="center">

<tr>
	<td bgcolor = "#00bfff"><span style="color:#ffffff">�� ����</span></td>
	<td align="left"><input type="text" name="title" size="40" value="${title }"/></td>
</tr>
<tr>
	<td bgcolor = "#00bfff"><span style="color:#ffffff">�̹���</span></td>
	<td  align="left"><input type="file" name="imagename" size="20"/></td>
</tr>
<tr>
	<td bgcolor = "#00bfff"><span style="color:#ffffff">�۳���</span></td>
	<td  align="left"><textarea name="content" rows="8" cols="40"></textarea></td>
</tr>
<tr>
	<td colspan="2"  align="right"><input type="submit" value="�� �ø���"/>
	<input type="button" value="���" onClick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>	
<input type="hidden" name="writername" size="10" value="session.getId()"/>		
</form>				
</body>
</html>