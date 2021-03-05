
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>회원 목록</h1>
<p><a href='add'>신규 회원</a><p>
<c:forEach var="member" items="${members}">
${member.no},// 뒤에 있는 배열의 값을 하나하나 꺼내줌 
<a href='update?no=${member.no}'>${member.name}</a>,
${member.email},
${member.createdDate}
<a href='delete?no=${member.no}'>[삭제]</a><br>
</c:forEach>
<jsp:include page="/Tail.jsp"/>
</body>
</html>