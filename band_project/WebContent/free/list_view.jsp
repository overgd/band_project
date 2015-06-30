<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${count > 0 }">
<h2>Free Board</h2>
	<table width="100%" cellpadding="1">
		<tr>
			<td align="right">
				<b>${startRow} ~ ${endRow} / ${count }</b>
			</td>
		</tr>
	</table>
</c:if>	

<table class="list" width = "1000" border="0" cellpadding="1"  align="center">
   <tr align="center">
      <th bgcolor = "#00bfff"><b>이미지</b></th>
      <th bgcolor = "#00bfff"><b>글제목</b></th>
      <th bgcolor = "#00bfff"><b>작성자</b></th>
      <th bgcolor = "#00bfff"><b>작성일</b></th>
   </tr>
   <c:if test = "${empty list }">
   <tr>
      <td bgcolor="#f0f0f0" colspan="4" align = "center">
      등록된 글이 없습니다.
      </td>
   </tr>
   </c:if>
   <c:if test = "${ ! empty list }">
      <c:forEach var = "writing" items = "${list }">
       <tr bgcolor="#f0f0f0">
       <td align="center"><a href="javascript:goView(${writing.writingid })"><img src="free_upload_files/small.${writing.imagename }" alt="이미지" width="50"/></a></td>
          <td align="center"><a href="javascript:goView(${writing.writingid })">${writing.title }</a></td>
          <td align="center"><a href="javascript:goView(${writing.writingid })">${writing.writername} </a></td>
          <td align="center"><a href="javascript:goView(${writing.writingid })">${writing.writingdate }</a></td>
      </tr>
      </c:forEach>
   </c:if>
   <tr>
      <td colspan = "4" align = "right"><c:if test="${ ! empty sessionScope.ID }">
      <a href = "free-write"><input type="submit"value="글 등록"></a></c:if></td>
   </tr>
</table>

<c:if test="${count >0 }">
<c:set var="pageCount" value="${count / PAGE_SIZE + (count % PAGE_SIZE == 0 ? 0 : 1) }"/>
<c:set var="startPage" value="${currentPage - (currentPage % 10 == 0 ? 10 :(currentPage % 10)) + 1 }"/>
<c:set var="endPage" value="${startPage +9 }"/>
<c:if test="${endPage > pageCount }">
	<c:set var="endPage" value="${pageCount }"/>
</c:if>
<c:if test="${startPage >10 }">
	<a href="javascript:goPage(${startPage - 10 })">[이전]</a>
</c:if>
<c:forEach var="pageNo" begin="${startPage }" end="${endPage }">
	<c:if test="${currentPage ==pageNo }"><font size="6" ></c:if>
<a href="javascript:goPage(${pageNo })" style="color: white">${pageNo }</a>
<c:if test="${currentPage == pageNo }"></font></c:if>
</c:forEach>
<c:if test="${endPage < pageCount }">
	<a href="javascript:goPage(${startPage+ 10 })">[다음]</a>
</c:if>
</c:if>
<script type="text/javascript">
function goPage(pageNo){
	document.move.action="free-list";
	document.move.page.value=pageNo;
	document.move.submit();
}
function goView(id){
	console.log(id);
	if(id==null){alert("글번호가 없습니다.");}
	else{
		document.move.action="free-read";
		document.move.id.value = id;
		document.move.submit();
	}
}
</script>
<form name="move" method="post">
<input type="hidden" name="id" value="${session.id }"/>
<input type="hidden" name="page" value="${currentPage }"/>
</form>
</body>
</html>





























