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
<table class="list">
	<tr>
		<td>
			<table width="500px" class="list">
				<tr>
					<td><img width="500px" alt="${album.image_name }" src="album_upload_files/${album.image_name }"/></td>
				</tr>
			</table>
		</td>
		<td>
			<table width="500px" class="list">
				<tr>
					<th width="100px">앨범번호</th>
					<td>${album.album_id }</td>
				</tr>
				<tr>
					<th>출시일</th>
					<td>${album.register_date }</td>
				</tr>
				<tr>
					<th>앨범제목</th>
					<td>${album.title} </td>
				</tr>
				<tr>
					<th>만든이</th>
					<td>${bbs.writer_id} </td>
				</tr>
				<tr>
					<th>앨범가격</th>
					<td>${album.price } 원</td>
				</tr>
				<tr>
					<th>샘플음원</th>
					<td>${album.file_name }</td>
				</tr>
				<tr>
					<th>앨범내용</th>
					<td height="200px">${album.content }</td>
				</tr>
				<tr>
					<td></td>
					<td align="right">
					<table align="right" class="list"><tr>
					<c:if test="${sessionScope.ID != null && sessionScope.ID != sessionScope.BID }">
					<td>담기</td>
					</c:if>
					<c:if test="${sessionScope.ID == album.band_id }">
					<td><a href="javascript:modify()">수정</a></td>
					<td><a href="javascript:deletealbum()">삭제</a></td>
					</c:if>
					</tr></table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<script type="text/javascript">
function modify(){
	document.move.action="album_modify_form.do";
	document.move.submit();
}
function deletealbum() {
	
	var choice;
	
	choice=confirm("정말로 삭제하시겠습니까?");
	
	if(choice) {
		alert("삭제합니다.");
		document.move.action="album_delete.do";
		document.move.submit();
	} else {
		alert("취소하셨습니다.");
	}
	
}
</script>
<form name="move" method="post">
<input type="hidden" name="album_id" value="${album.album_id }"/>
<input type="hidden" name="band_id" value="${album.band_id }"/>
<input type="hidden" name="register_date" value="${album.register_date }"/>
<input type="hidden" name="title" value="${album.title }"/>
<input type="hidden" name="writer_id" value="${bbs.writer_id }"/>
<input type="hidden" name="price" value="${album.price }"/>
<input type="hidden" name="content" value="${album.content }"/>
<input type="hidden" name="file_name" value="${album.file_name }"/>
<input type="hidden" name="image_name" value="${album.image_name }"/>
</form>
</body>
</html>