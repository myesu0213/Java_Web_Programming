<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<h2>사용자 로그인</h2>
<form action="login" method="post"> 
<!-- 로그인 입력폼을 값을 서버에 전달할 때는 post요청을하도록 <form> 태그를 설정하였다. -->
이메일: <input type= "text" name="email"><br>
암호: <input type= "password" name="password"><br>
<input type="submit" value="로그인">
</form>
</body>
</html>