<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To Questions</title>
</head>
<body>
	<h1>${oneQuestion.question} </h1>
	<h3>Tags:
	 	<c:forEach items= "${oneQuestion.tags}" var="tag">
	 		<button>${tag.subject}</button>
	 	</c:forEach>  
	</h3>
	<table>
		<thead>
			<tr>
				<th>Answer:</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items= "${oneQuestion.answers}" var="answer">
					<tr>
						<td>${answer.answer}</td>		
					</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="/questions/${oneQuestion.id }" method="post">
		<label for="answer">Answer:</label>
		<textarea name="answer"></textarea>
		<button>Add Answer</button>
	</form>
	<a href="/questions">Main page</a>
</body>
</html>