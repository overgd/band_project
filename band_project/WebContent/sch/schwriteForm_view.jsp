<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="robots" content="noindex,nofollow" />
<title>Dynamically attach jQuery DatePicker to Text box </title>

<link rel="stylesheet" href="/resources/themes/master.css" type="text/css" />

<title>Dynamic</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />

  <style>
    .datepicker{
    }
  </style>

<script type="text/javascript">
$(function() {
    $( ".datepicker" ).datepicker();
  });
</script>
<script type="text/javascript">
function validate(form){
	if(form.title.value == ""){
		alert("제목을 입력하세요."); return false;
	}else if(form.writerid.value == ""){
		alert("작성자를 입력하세요."); return false;
	}else if(form.content.value == ""){
		alert("글 내용을 입력하세요."); return false;
	}else if(form.location.value == ""){
		alert("장소를 내용을 입력하세요."); return false;
}
</script>
</head>
<body>
	<div id="allContent">
</div>
<form action="schwrite.do" method="post" enctype="multipart/form-data"
			onSubmit="return validate(this)">
<input type="hidden" name="orderno" value="${writing.orderno + 1 }"/>
<c:if test="${! empty writing.groupid }">
<input type="hidden" name="groupid" value="${writing.groupid }"/>
</c:if>
<c:if test="${! empty writing.parentid }">
<input type="hidden" name="parentid" value="${writing.parentid }"/>
</c:if>

<table class="list" width="100%" border="1" cellpadding="1">
<tr>
<td bgcolor="black"><font FACE="돋움" color="white" size="5">공연날짜</font></td>
<td>
<p><input type="text" name="writingdate" class="datepicker" /></p></td>
<tr>
	<td bgcolor="black"><font FACE="돋움" color="white" size="5">공연명</font></td>
	<td><input type="text" name="title" size="40" value="${title }"/></td>
</tr>
<tr>
	<td bgcolor="black"><font FACE="돋움" color="white" size="5">작성 밴드명</font></td>
	<td><input disabled="disabled" type="text" size="10" value="${sessionScope.ID }"/></td>
	
</tr>
<tr>
	<td bgcolor="black"><font FACE="돋움" color="white" size="5">이미지</font></td>
	<td><input type="file" name="imagename" size="20"/></td>
</tr>
<tr>
	<td bgcolor="black"><font FACE="돋움" color="white" size="5">내용</font></td>
	<td><textarea name="content" cols="40" rows="8"></textarea></td>
</tr>
<tr>
	<td bgcolor="black"><font FACE="돋움" color="white" size="5">장소</font></td>
	<td><textarea name="location" cols="40" rows="8"></textarea></td>
</tr>

<tr>
	<td colspan="2"><input type="submit" value="등록"/>
	<input type="button" value="취소" 
					onClick="javascript:history.go(-1)"/></td>
</tr>
</table>
<input type="hidden" name="writerid" size="10" value="${sessionScope.ID }"/>
</form>
</body>
</html>