<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book App</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="./css/my.css">
<link rel="stylesheet" href="./css/main.css">

</head>
<body>
<%@ include file="common/header.jsp" %>				<!-- common 파일에서 머리랑 발 가지고오기 -->
<section>											<!-- 모든 페이지에 section가지고 오기 -->
<h3> link list </h3>
<ul>
		<!-- ${pageContext.request.contextPath} : url 경로 설정 잡아줌 달아 주는걸 추천   -->
	<li><a href="${pageContext.request.contextPath}/Login.jsp">Login</a></li> <br>
	<li><a href="${pageContext.request.contextPath}/logout.do">Logout</a></li> <br>
	<li><a href="${pageContext.request.contextPath}/booklist.do">Book List</a></li> <br>
	<li><a href="${pageContext.request.contextPath}/Book.jsp">Book 등록</a></li> <br>
	<li><a href="${pageContext.request.contextPath}/">메뉴1</a></li>
	<li><a href="${pageContext.request.contextPath}/">메뉴2</a></li>
</ul>




</section>
<%@ include file="common/footer.jsp" %>				<!-- common 파일에서 머리랑 발 가지고오기 -->
</body>
</html>