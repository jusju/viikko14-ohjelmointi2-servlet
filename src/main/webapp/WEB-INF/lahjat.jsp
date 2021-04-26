<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Joululahjat</title>
	<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>

	<h1>Joululahjatoiveet</h1>
	
	<c:forEach items="${ lahjat }" var="item">
		<c:out value="${ item.lahja }" /><br/>
	</c:forEach>
</body>
</html>