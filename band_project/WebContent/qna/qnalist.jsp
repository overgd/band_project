<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��������</title>
</head>
<body>
<h2>${sessionScope.BNAME }���� �����!</h2><br/><br/>
<c:if test="${sessionScope.ID != null }">
<jsp:include page="/qna/qnawriteform.jsp"></jsp:include><br/>
</c:if>
<form name="qnalist">
	<c:if test="${!empty INFO }">
		<c:set var="cnt" value="${COUNT }"/>
		<c:forEach var="c" begin="0" end="${COUNT-1 }">
		
			<c:if test="${INFO[c].order_no == '0' }">
			<table border="1px" width="1000px">
				<tr>
					<th align="center" width="100px">�۾���</th><td align="left"> ${INFO[c].writer_id }</td>
				</tr>
				<tr>
					<th align="center">����</th><td align="left"> ${INFO[c].title }</td>
				</tr>
			</table>
			<table border="1px" width="1000px">
				<tr>
					<th width="100px" align="center">����</th><td align="left">${CONTENT[c].content }</td>
				</tr>
			</table>
			<c:if test="${sessionScope.ID != null}">
				<table border="1px">
					<tr>
						<c:if test="${sessionScope.ID == INFO[c].writer_id }">
						<td width="60px">
						<a href="javascript:goModify(${INFO[c].writing_id}, '${INFO[c].writer_id }', '${INFO[c].band_id }', '${CONTENT[c].content }', '${INFO[c].title }')">����</a>
						</td>
						</c:if>
						<c:if test="${sessionScope.ID == INFO[c].writer_id }">
						<td width="60px">
						<a href="javascript:goDelete(${INFO[c].writing_id}, '${INFO[c].writer_id }', '${INFO[c].band_id }')">����</a>
						</td>
						</c:if>
						<c:if test="${sessionScope.ID == sessionScope.BID && INFO[c].order_no == '0' && INFO[c+1].order_no != '1' }">
						<td width="60px">
						<a href="javascript:goReply(${INFO[c].writing_id}, '${INFO[c].writer_id }', '${INFO[c].band_id }', '${CONTENT[c].content }', '${INFO[c].title }')">���ϱ�</a>
						</td>
						</c:if>
					</tr>
				</table>
			</c:if><br/>
			</c:if>
			
			<c:if test="${INFO[c].order_no == '1' }">
			<table border="0px">
			<tr>
			<td width="100px"></td>
			<td>
			<table border="1px" width="900px">
				<tr>
					<th align="center" width="100px">�۾���</th><td align="left"> ${INFO[c].writer_id }</td>
				</tr>
				<tr>
					<th align="center">����</th><td align="left"> ${INFO[c].title }</td>
				</tr>
			</table>
			<table border="1px" width="900px">
				<tr>
					<th width="100px" align="center" >����</th><td align="left">${CONTENT[c].content }</td>
				</tr>
			</table>
			<c:if test="${sessionScope.ID != null}">
				<table border="1px">
					<tr>
						<c:if test="${sessionScope.ID == INFO[c].writer_id }">
						<td width="60px">
						<a href="javascript:goModify(${INFO[c].writing_id}, '${INFO[c].writer_id }', '${INFO[c].band_id }', '${CONTENT[c].content }', '${INFO[c].title }')">����</a>
						</td>
						</c:if>
						<c:if test="${sessionScope.ID == INFO[c].writer_id }">
						<td width="60px">
						<a href="javascript:goDelete(${INFO[c].writing_id}, '${INFO[c].writer_id }', '${INFO[c].band_id }')">����</a>
						</td>
						</c:if>
					</tr>
				</table>
			</c:if>
			</td>
			</tr>
			</table><br/>
			</c:if>
			
		</c:forEach>
		
	</c:if>
	<c:if test="${empty INFO }">
		<table width="1000px" border="1px">
		<tr><td>��ϵ� ���� �����ϴ�!</td></tr>
		</table>
	</c:if>
</form>
<script type="text/javascript">
var newWindow;

function goReply(writing_id, writer_id, band_id, content, title) {
	
	newWindow = window.open("qna/qnareplyform.jsp?WID="+writing_id+"&BID="+band_id+"&ID="+writer_id+"&CON="+content+"&TI="+title, "modify", "height=200, width=750, top=100, left=100, location=no, resizable=no, menubar=no, directories=no");
	
}

function goModify(writing_id, writer_id, band_id, content, title) {
	
	newWindow = window.open("qna/qnamodifyform.jsp?WID="+writing_id+"&BID="+band_id+"&ID="+writer_id+"&CON="+content+"&TI="+title, "modify", "height=200, width=750, top=100, left=100, location=no, resizable=no, menubar=no, directories=no");
	
}

function goDelete(writing_id, writer_id, band_id) {
	
	var choice;
	
	choice=confirm("������ �����Ͻðڽ��ϱ�?");
	
	if(choice) {
		alert("�����մϴ�.");
		location.href("index.jsp?MAIN=qnadelete.do?WID="+writing_id+"&BID="+band_id+"&ID="+writer_id);
	} else {
		alert("����ϼ̽��ϴ�.");
	}
}
</script>
</body>
</html>