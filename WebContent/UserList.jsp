<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.UserDAO_Mariadb"%>
<%@page import="service.UserServiceimpl"%>
<%@page import="service.UserService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My User List</title>
 <!-- 링크 컨트롤 클릭하면 이동되면 정상적 -->
<link rel="stylesheet" href="./css/my.css">
<link rel="stylesheet" href="./css/main.css">
</head>
<body>
<%@ include file="common/header.jsp" %>	
<section>
<h1> User List </h1>

<table class="tableb">
	<tr><th>ID</th> <th>PASSWORD</th> <th>NAME</th> <th>ROLE</th></tr>
	
<%
	UserDAO_Mariadb dao = new UserDAO_Mariadb();
	UserService service = new UserServiceimpl(dao);
	List<UserVO> list = service.userlist();
	for(UserVO data:list) {
	
%>
	<tr>
		<td><%= data.getId() %></td>
		<td><%= data.getPassword() %></td>
		<td><%= data.getName() %></td>
		<td><%= data.getRole() %></td>
	</tr>
	
<% } %>

</table>
</section>
<%@ include file="common/footer.jsp" %>	
</body>
</html>