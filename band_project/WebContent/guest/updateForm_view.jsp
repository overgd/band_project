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
	}else if(form.content.value == ""){
		alert("������ �Է��ϼ���."); return false;
	}
}
</script>
<c:if test="${ ! empty writing }">
<form action="guest.update.do" method="post" enctype="multipart/form-data"
			onSubmit="return validate(this)">

<table class="list" width="65%" border="1" cellpadding="1" align="center">
<tr>
	<th width="30%">������</th>
	<td><input type="text" name="title" size="75"
								value="${writing.title }"/></td>
</tr>
<tr>
	<th width="30%">�۳���</th>
	<td><textarea name="content" rows="8" cols="76">${writing.content }</textarea></td>
</tr>
<tr>
	<td colspan="2" align="right">
		<input type="submit" value="����"/>
		<input type="button" value="���"
					onClick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>
</form>
</c:if>
</body>
</html>