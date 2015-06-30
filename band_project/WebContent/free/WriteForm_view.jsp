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
	}else if(form.writername.value == ""){
		alert("작성자를 입력하세요."); return false;
	}else if(form.content.value == ""){
		alert("글 내용을 입력하세요."); return false;
	}	
	
}
</script>
<form action="write.do" method="post" enctype="multipart/form-data"
				onSubmit="return validate(this)">
<input type="hidden" name="orderno" value="${writing.orderno + 1 }"/>		
<c:if test="${! empty writing.groupid }">
<input type="hidden" name="groupid" value="${writing.groupid }"/>
</c:if>		
<c:if test="${! empty writing.parentid }">
<input type="hidden" name="parentid" value="${writing.parentid }"/>
</c:if>

<table class="list" width="1000px" border="1" cellpadding="1" align="center">
<tr>
	<th align="center" width="30%"><span style="color:#ffffff">글 제목</span></th>
	<td><input type="text" name="title" size="100%" value="${title }"/></td>
</tr>
<tr>
	<th align="center" width="30%"><span style="color:#ffffff">이미지</span></th>
	<td><input type="file" name="imagename" size="100%"/></td>
</tr>
<tr>
	<th align="center" width="30%"><span style="color:#ffffff">글내용</span></th>
	<td><textarea name="content" rows="8" cols="100%"></textarea></td>
</tr>
<tr>
	<td colspan="4" align="right"><input type="submit" value="글 올리기"/>
	<input type="button" value="취소" onClick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>	
<input type="hidden" name="writername" size="10" value="session.getId()"/>		
</form>				
</body>
</html>