<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta charset="utf-8">
	<title>Shopping List</title>
	<script src="/js/app.js"></script>
	<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>

	<h1>Shopping List</h1>
	
	<c:forEach items="${ ostokset }" var="item">
		<li id="${ item.id }">
			<c:out value="${ item.title }  " /><button onClick="removeProduct(${ item.id })">-</button><br/>
		</li>
	</c:forEach>



</body>
</html>