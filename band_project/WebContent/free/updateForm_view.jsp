<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
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
<c:if test="${! empty writing }">
<form action="free.update.do" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
<input type="hidden" name="id" value="${writing.writingid }"/>
<table width="100%" border="1" cellpadding="1">
<tr>
	<td>������</td>
	<td><input type="text" name="title" size="20" value="${writing.title}"/></td>
</tr>
<tr>
	<td>�̹���</td>
	<td><input type="file" name="image_name"/><br/>
	<img src="upload_files/${writing.imagename }" alt=",�̹���" width="150" border="0"/>
	</td>
</tr>
<tr>
	<td>�۳���</td>
	<td><textarea name="content" rows="8" cols="40">${writing.content }</textarea></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="����"/>
		<input type="button" value="���" onClick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>
<input type="hidden" name="name" size="20" value="${writing.writername}"/>
</form>
</c:if>
</body>
</html>
















