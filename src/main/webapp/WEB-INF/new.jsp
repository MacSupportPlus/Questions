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
	<h1>What is your Question</h1>
	<a href= "/questions">Home Page</a>
	<a href= "/logout">Logout</a>
	
	<form action="/questions" method="post" >
	
		<label for="question">Question: </label>
		<textarea id="question" name="question"></textarea>
		<label for= "tag">Tags: </label>
		<input type="text" name="tags"/>
		<button type = "submit" >Add question</button>
	</form>
</body>
</html>