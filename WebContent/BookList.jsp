<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BookDAO_Mariadb"%>
<%@page import="service.BookServiceimpl"%>
<%@page import="service.BookService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Book List</title>
<link rel="stylesheet"  href="./css/my.css"> <!-- 링크 컨트롤 클릭하면 이동되면 정상적 -->
</head>
<body>
<h1> Book List </h1>

<table class="tableb">
	<tr><th>BookNo</th> <th>Title</th> <th>Publicher</th> <th>Price</th></tr>
	
<%
	BookDAO_Mariadb dao = new BookDAO_Mariadb();
	BookService service = new BookServiceimpl(dao);
	List<BookVO> list = service.booklist();
	for(BookVO data:list) {
	
%>
	
	<tr>
		<td><%= data.getBookno() %></td>
		<td><%= data.getTitle() %></td>
		<td><%= data.getPublisher() %></td>
		<td><%= data.getPrice() %></td>
	</tr>
	
<% } %>

</table>

</body>
</html>