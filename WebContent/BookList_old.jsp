<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Book List</title>
<link rel="stylesheet" href="./css/my.css">
<!-- 링크 컨트롤 클릭하면 이동되면 정상적 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- core태그 라이브러리 -->

<script tpye="text/javascript">
	function f1() {
		return confirm("삭제 하시겠습니까?");
	}
</script>

</head>
<body>
	<h1>Book List</h1>
	
	<form action="deleteBook.do" method = "get">
	
		<table class="tableb">
			<tr>
				<th>BookNo</th>
				<th>Title</th>
				<th>Publicher</th>
				<th>Price</th>
				<th><input type="submit" value="삭제" onclick="return f1()"></th>
			</tr>


			<c:forEach var="data" items="${booklist}">

				<tr>
					<td>${ data.bookno }</td>
					<td>${ data.title }</td>
					<td>${ data.publisher }</td>
					<td>${ data.price }</td>
					<td><input type="checkbox" name="bookno" value=${ data.bookno }></td>
				</tr>

			</c:forEach>

		</table>
	</form>
	<a href="Book.jsp">등록</a>
</body>
</html>

