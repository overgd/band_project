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
		<td bgcolor="#e9e9e9"><b>�ٹ���ȣ</b></td>
		<td bgcolor="#e9e9e9"><b>�ٹ��̹���</b></td>
		<td bgcolor="#e9e9e9"><b>�ٹ�����</b></td>
		<td bgcolor="#e9e9e9"><b>�ٹ�����</b></td>
	</tr>
	 <c:if test="${empty  }">
	 <tr>
 	 	<td bgcolor="#f0f0f0" colspan="4" align="center">
 	 	��ϵ� �̹����� �����ϴ�.
 	 	</td>
 	 </tr>
 	 </c:if>
 	 <c:if test="${ ! empty  }">
 	 	<c:forEach var="writing" items="${ } }"> <!--������ For��  -->
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
 	 	<a href="albumForm.jsp">[�ٹ����]</a></td>
 	 </tr>
</table>

</table>
</body>
</html>