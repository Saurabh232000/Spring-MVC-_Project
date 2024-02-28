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
		<form action="submit" method="post">
			Name:<input type="text" name="name"
				placeholder="Enter Your_Name Here"><br> <br>
			Phone:<input type="number" name="phone"
				placeholder="Enter Your_Phone Here"><br> <br> Age:<input
				type="number" name="age" placeholder="Enter Your_Real Age Here"><br>
			<br> Email:<input type="text" name="email"
				placeholder="Enter Your_Email Here"><br> <br>
			Password:<input type="password" name="password"
				placeholder="Enter Your_Password Here"><br> <br>
			<button type="submit">Submit</button>
			<button type="reset">Reset</button>
		</form>
	</div>
</body>
</html>