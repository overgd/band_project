<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table width="100%" hegiht = "150%" cellpadding="1">
	<tr>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>DATE</b></font></td>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>BAND</b></font></td>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>TITLE</b></font></td>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>LOCATION</b></font></td>
		<td bgcolor="black"><font FACE="Geneva, TAHOMA" color="white" size="5"><b>IMAGE</b></font></td>
		
	</tr>
	<c:if test="${empty list }">
	<tr>
		<td bgcolor="#f0f0f0" colspan="4" align="center">
		��ϵ� ������ �����ϴ�.
		</td>
	</tr>
	</c:if>
	<c:if test="${ ! empty list }">
		<c:forEach var="writing" items="${list }">
		<tr bgcolor="#f0f0f0">
			<td>${writing.writingdate }</td>
			<td>${writing.writerid }</td>
			<td><a href="javascript:goView(${writing.writingid })">${writing.title }</a></td>
			<td>${writing.location }</td>
			<td><img src="upload_files/small.${writing.imagename }" 
				alt="�̹���" width="50"/></td>
		</tr>		
		</c:forEach>
	</c:if>
	<tr>
		<td colspan="4" align="right">
		<c:if test="${sessionScope.ID == INFO[c].writer_id}">
		<a href="sch/schwriteForm.jsp">���</a></td>
		</c:if>
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
	<a href="javascript:goPage(${startPage - 10 })">[����]</a>
</c:if>
<c:forEach var="pageNo" begin="${startPage }" end="${endPage }">
	<c:if test="${currentPage == pageNo }"><font size="5"></c:if>
	<a href ="javascript:goPage(${pageNo })">${pageNo }</a>
	<c:if test="${currentPage == pageNo }"></font></c:if>
</c:forEach>
<c:if test="${endPage < pageCount }">
	<a href="javascript:goPage(${startPage + 10 })">[����]</a>
</c:if>
</c:if>
<script type="text/javascript">
function goPage(pageNo){
	document.move.action="sch-list";
	document.move.page.value=pageNo;
	document.move.submit();
}
function goView(id){
	if(id == null){ alert("�۹�ȣ�� �����ϴ�."); }
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