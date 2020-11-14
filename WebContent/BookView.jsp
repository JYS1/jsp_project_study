<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Book List</title>


<!-- 링크 컨트롤 클릭하면 이동되면 정상적 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- core태그 라이브러리 -->
<link rel="stylesheet" href="./css/my.css">
<link rel="stylesheet" href="./css/main.css">



<script>
	function modify() {
		f.action="modify.jsp";
		f.submit();

	}
	function bookDelete() {
		if(confirm("삭제 할것 입니까?") ) {
			f.action="deleteBook.do";		//이런식으로 action을 버튼별로 바꾸면됨
			f.submit();
			alert("삭제 되었습니다.");
		}
		
	}
	function bookList() {
		f.action="booklist.do";
		f.submit();
	}
</script>

</head>
<body>
	<%@ include file="common/header.jsp"%>
	<section>
		<h2>Book Board</h2>
		<form action="" name="f" method="post">
		<!-- 값을 숨겨서 delete에 값을 넣어 주기 -->
		<input type="hidden" name="bookno" value="${ book.bookno }">	
			<table>
				<tr>
					<td>책번호</td>
					<td>${ book.bookno }</td>
				</tr>
				<tr>
					<td>책제목</td>
					<td>${ book.title }</td>
				</tr>
				<tr>
					<td>출판사</td>
					<td>${ book.publisher }</td>
				</tr>
				<tr>
					<td>가격</td>
					<td>${ book.price }</td>
				</tr>
				<tr>
					<td colspan="2"><img alt="...." src="./img/java.jpg"
						width="200"></img></td>
				</tr>
			</table>
			<table>
				<td align="center"><input type="button" value="수정"
					onclick="modify()"> <input type="button" value="삭제"
					onclick="bookDelete()"> <input type="button" value="목록"
					onclick="bookList()"></td>
			</table>
		</form>
	</section>
</body>

<%@ include file="common/footer.jsp"%>
</html>



