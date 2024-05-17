<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js">
</script>


</head>
<body>
	<table width="100%"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>#번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정일</th>
			</tr>
		</thead>

		<c:forEach items="${list}" var="board">

			<tr>
				<td><c:out value="${board.bno}" /></td>
				<td><a class="move" href='<c:out value="${board.bno}"/>'><c:out
							value="${board.title}" /></a></td>
				<td><c:out value="${board.writer}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
						value="${board.regdate}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
						value="${board.updateDate }" /></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>