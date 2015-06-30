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
		alert("제목을 입력하세요."); return false;
	}else if(form.content.value == ""){
		alert("내용을 입력하세요."); return false;
	}
}
</script>
<c:if test="${ ! empty writing }">
<form action="guest.update.do" method="post" enctype="multipart/form-data"
			onSubmit="return validate(this)">

<table class="list" width="1000px" border="1" cellpadding="1" align="center">
<tr>
	<th width="30%">글제목</th>
	<td align="center"><input type="text" name="title" size="100%" 
								value="${writing.title }"/></td>
</tr>
<tr>
	<th width="30%">글내용</th>
	<td align="center"><textarea name="content" rows="8" cols="100%">${writing.content }</textarea></td>
</tr>
<tr>
	<td colspan="2" align="right">
		<input type="submit" value="수정"/>
		<input type="button" value="취소"
					onClick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>
</form>
</c:if>
</body>
</html>