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
<table width="100%" cellpadding="1">
	<tr>
		<td bgcolor="#e9e9e9"><b>앨범번호</b></td>
		<td bgcolor="#e9e9e9"><b>앨범이미지</b></td>
		<td bgcolor="#e9e9e9"><b>앨범제목</b></td>
		<td bgcolor="#e9e9e9"><b>앨범가격</b></td>
	</tr>
	 <c:if test="${empty  }">
	 <tr>
 	 	<td bgcolor="#f0f0f0" colspan="4" align="center">
 	 	등록된 이미지가 없습니다.
 	 	</td>
 	 </tr>
 	 </c:if>
 	 <c:if test="${ ! empty  }">
 	 	<c:forEach var="writing" items="${ } }"> <!--발전된 For문  -->
 	 	<tr bgcolor="#f0f0f0">
 	 		<td>${} </td>
 	 		<td><img src="upload_files/small.${ }" title="${}" width="50"/></td>
 	 		<td><a href="javascript:goView(${})">${} </td>
 	 		<td>${}</td>
 	 		<td>${}</td>
 	 	</tr>
 	 	</c:forEach>
 	 </c:if>
 	 <tr>
 	 	<td colspan="4" align="right">
 	 	<a href="albumForm.jsp">[앨범등록]</a></td>
 	 </tr>
</table>

</table>
</body>
</html>