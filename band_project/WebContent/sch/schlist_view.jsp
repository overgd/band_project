<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
		<style>
		tr:nth-child(3n).sch { background:#333333; }
		tr:nth-child(3n+1).sch { background:#3333ff; }/*파랑*/
		tr:nth-child(3n+2).sch { background:#ff6699; }/*핑크*/
		tr:nth-child(3n+3).sch { background:#663366; }/*보라*/
		</style>
</head>
<body>
<table class= "list" width="100%" height = "200%" cellpadding="0">
	<tr>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>DATE</b></font></td>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>BAND</b></font></td>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>TITLE</b></font></td>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>LOCATION</b></font></td>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>IMAGE</b></font></td>
		
	</tr>
	<c:if test="${empty list }">
	<tr>
		<td bgcolor="#f0f0f0" colspan="4" align="center" height="200%">
		등록된 일정이 없습니다.
		</td>
	</tr>
	</c:if>
	<c:if test="${ ! empty list }">
		<c:forEach var="writing" items="${list }">
		<tr class="sch"
			bgcolor="#f0f0f0"  height="3" > 
			<td><font FACE="Geneva, TAHOMA" color="white" size="6">
						<a href="javascript:goView(${writing.writingid })" style="color: white">
			${writing.writingdate }</a></font></td>
			<td><font FACE="Geneva, TAHOMA" color="white" size="5">
						<a href="javascript:goView(${writing.writingid })" style="color: white">
			${writing.writerid }</a></font></td>
			<td><font FACE="Geneva, TAHOMA" color="white" size="4">
			<a href="javascript:goView(${writing.writingid })" style="color: white">${writing.title }</a></font></td>
			<td><font FACE="Geneva, TAHOMA" color="white" size="4">
			<a href="javascript:goView(${writing.writingid })" style="color: white">${writing.location }</a></font></td>
			<td><font FACE="Geneva, TAHOMA" color="white" size="4">
						<a href="javascript:goView(${writing.writingid })" style="color: white">
			<img src="upload_files/small.${writing.imagename }" 
				alt="이미지" width="50"/></a></font></td>
		</tr>		
		</c:forEach>
	</c:if>
	<tr>
		<td colspan="4" align="right">
	</tr>
</table>
<c:if test="${count > 0 }">
<c:set var="pageCount" 
	value="${count / PAGE_SIZE + (count % PAGE_SIZE == 0 ? 0 : 1) }"/>
<c:set var="startPage" 
	value="${currentPage - 
				(currentPage % 10 == 0 ? 10:(currentPage % 10)) + 1 }"/>
<c:set var="endPage" value="${startPage + 9 }"/>
<c:if test="${endPage > pageCount }">
	<c:set var="endPage" value="${pageCount }"/>
</c:if>	
<c:if test="${startPage > 10 }">
	<a class="white" href="javascript:goPage(${startPage - 10 })">[이전]</a>
</c:if>
<c:forEach var="pageNo" begin="${startPage }" end="${endPage }">
	<c:if test="${currentPage == pageNo }"><font size="5"></c:if>
	<a class="white" href ="javascript:goPage(${pageNo })">${pageNo }</a>
	<c:if test="${currentPage == pageNo }"></font></c:if>
</c:forEach>
<c:if test="${endPage < pageCount }">
	<a class="white" href="javascript:goPage(${startPage + 10 })">[다음]</a>
</c:if>
</c:if>
<tr>
      <td colspan = "4" align = "right">
<c:if test="${sessionScope.DIV == 'b'}">
		<br/><a class="white" href="sch/schwriteForm.jsp">
		<input type="submit"value="글 등록"></a></c:if></td>
<script type="text/javascript">



function goPage(pageNo){
	document.move.action="sch-list";
	document.move.page.value=pageNo;
	document.move.submit();
}
function goView(id){
	if(id == null){ alert("글번호가 없습니다."); }
	else {
		document.move.action="sch-read";
		document.move.id.value = id;
		document.move.submit();
	}
}
</script>
<form name="move" method="post">
<input type="hidden" name="id" value=""/>
<input type="hidden" name="page" value="${currentPage }"/>
</form>
</body>
</html>