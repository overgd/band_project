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
<form name="modifyform" method="post" action="bandintromodify.do" enctype="multipart/form-data" onsubmit="return voidcheck()">
	<table class="list" width="1000" border="0">
		<tr>
			<th>로고</th>
			<td>
			<c:if test="${BAND.image_name != null }">
				<img alt="${BAND.name }" src="band_upload_files/thumb.${BAND.image_name }"/>
			</c:if>
			<c:if test="${BAND.image_name == null }">
				이미지 없음!
			</c:if>
				<input type="file" name="image_name"/>
				<input type="hidden" name="org_image_name" value="${BAND.image_name }"/>
			</td>
		</tr>
		<tr>
			<th>밴드 이름</th>
			<td>
				<input type="text" name="name" value="${BAND.name }"/>
			</td>
		</tr>
		<tr>
			<th>장르</th>
			<td>
				${BAND.genre } - 
				<select name="genre">
					<option>Rock</option>
					<option>Blues</option>
					<option>R&B</option>
					<option>Folk</option>
					<option>Electronic</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>소개</th>
			<td>
				<textarea name="content" rows="4" cols="100">${BAND.content }</textarea>
			</td>
		</tr>
	</table>
	<br/>
	<input type="submit" value="수정완료"/>
	<input type="button" value="취소" onclick=""/>
</form>
<script type="text/javascript">
function voidcheck() {
	
	if(modifyform.name.value == "") {
		alert("이름이 비어 있습니다.");
		return false;
	}else if(modifyform.genre.value == "") {
		alert("장르가 비어 있습니다.");
		return false;
	}
	alert("수정합니다.");
	return true;
	
}
</script>
</body>
</html>