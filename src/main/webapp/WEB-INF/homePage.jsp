<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome to Questions</title>
</head>
<body>
	<h1>Question Database</h1>
	<table>
		<thead>
			<tr>
				<th>User</th>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items= "${allQuestions}" var="question">
					<tr>
						<td>${questions.user.email}</td>
						<td><a href="/questions/${question.id}">${question.question}</a></td>
						<td>"${questions.displayTags()}</td>
						
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<a href= "/questions/new">Add Question</a>
	<a href= "/logout">Logout</a>
</body>
</html>