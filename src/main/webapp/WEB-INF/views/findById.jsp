<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {
	background-color: pink;
	color: green;
	text-align: center;
	margin: 50px;
	padding: 50px;
	width: 70%;
}
</style>
</head>
<body>
	<div class="container">
		<form action="find" method="post">
			Id:<input type="number" name="id"
				placeholder="Enter Person_ID To Find"><br>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>