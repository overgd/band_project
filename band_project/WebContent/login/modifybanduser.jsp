<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BAND 정보 수정</title>
</head>
<body>
BAND 정보수정<br/><br/>
<form name="form" action="modifyuserinfo.do" method="post" onsubmit="return submitcheck()">
<table class="list" cellpadding="10px">
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="password"/></td>
</tr>
<tr>
	<th>비밀번호 확인</th>
	<td><input type="password" name="repassword"/></td>
</tr>
<tr>
	<th>밴드이름</th>
	<td><input type="text" name="name" value="${sessionScope.NAME }"/></td>
	<td>한글, 영문</td>
</tr>
<tr>
	<th>이메일</th>
	<td><input type="text" name="email" value="${sessionScope.EMAIL }"/></td>
</tr>
<tr>
	<th>장르</th>
	<td>${sessionScope.GENRE } - 
		<select name="genre">
			<option>Rock</option>
			<option>Blues</option>
			<option>R&B</option>
			<option>Folk</option>
			<option>Electronic</option>
		</select>
	</td>
</tr>
</table><br/><br/>
<input type="submit" value="수정하기"/>
<input type="hidden" name="check"/>
<input type="hidden" name="readpassword" value="${PWD }" />
</form>
<script type="text/javascript">
function submitcheck() {
		
	var readpassword = form.readpassword.value;
	var password = form.password.value;
	var repassword = form.repassword.value;
	var name = form.name.value;
	var email = form.email.value;
	var genre = form.genre.value;
	
	var name_cnt = 0;
	
	for (i=0;i<name.length;i++){
  		
		ls_one_char = name.charAt(i);
	
	 	if(ls_one_char.search(/[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]/) == -1) {
	 		name_cnt++;
		}
	 	
	}
	
	if(name_cnt!=0) {
		alert("이름은 영문, 한글, 숫자만 가능합니다.") 
		return false;
	}
	
	if(password == "" || repassword == "" || name == "" || email == "" || genre == "") {
		alert("입력되지 않은 폼이 있습니다.");
		return false;
	}else if(password != repassword) {
		alert("비밀번호가 같지 않습니다.");
		return false;
	}else if(password != readpassword) {
		alert("비밀번호를 확인해주세요!");
		return false;
	}else {
		alert("수정되었습니다.");
		return true;
	}
	
}
</script>
</body>
</html>