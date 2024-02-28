<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="p" items="${allData }">
		<h2>${p.id }</h2>
		<h2>${p.name }</h2>
		<h2>${p.phone }</h2>
		<h2>${p.age }</h2>
		<h2>${p.email}</h2>
		<h2>${p.password}</h2>
	</c:forEach>
</body>
</html>