<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${BNAME }
<table align="center">
		<tr>
			<td>
			<a href="index.jsp">
			<img alt="�ٹ�����" src="./images/um1.png" width="58px">
			<input type="button" value="�ٹ�����" style="background-color:orange;font-face:����;font-size:7pt;color:#ffffff;"/></a>
			</td>
			<td width="100px"></td>
			<td>
			<a href="index.jsp?MAIN=qna/qnalist.jsp?BID=${sessionScope.BID }">
			<img alt="��������" src="./images/qna.png" width="58px">
			<input type="button" value="��������" style="background-color:orange;font-face:����;font-size:7pt;color:#ffffff;"/>
			 </a>
			</td>
			<td width="100px"></td>
			<td>
			<a href="index.jsp?MAIN=guest-list?ID=${sessionScope.BID }">
			<img alt="����" src="./images/guest.png" width="58px">
			<input type="button" value="����" style="background-color:orange;font-face:����;font-size:7pt;color:#ffffff;"/>
			 </a>
			</td>
		</tr>
</table>
</body>
</html>