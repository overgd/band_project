<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
BAND - ${BNAME }�� �޴�
<table align="center">
		<tr>
			<td>
			<a href="index.jsp?MAIN=albumlist.do?BID=${sessionScope.BID }">
			<img src="./images/um1_1.png" onmouseover="this.src='./images/um1.png';"
			onmouseout="this.src='./images/um1_1.png';" alt="logo" title="�ٹ�����" width="58px"/>
			</a>
			</td>
			<td width="50px"></td>
			<td>
			<a href="index.jsp?MAIN=qnalist.do?BID=${sessionScope.BID }">
			<img src="./images/qna_1.png" onmouseover="this.src='./images/qna.png';"
			onmouseout="this.src='./images/qna_1.png';" alt="logo" title="��������" width="58px"/>		
			 </a>
			</td>
			<td width="50px"></td>
			<td>
			<a href="index.jsp?MAIN=guest-list?ID=${sessionScope.BID }">
			<img src="./images/guest_1.png" onmouseover="this.src='./images/guest.png';"
			onmouseout="this.src='./images/guest_1.png';" alt="logo" title="����" width="58px"/>		
			 </a>
			</td>
		</tr>
</table>
</body>
</html>