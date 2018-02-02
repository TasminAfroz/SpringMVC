<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BJIT</title>
</head>
<body>
	<h1>Student profile Page</h1>
	<table>
		<tr>
			<td>Name</td>
			<td>${student.name}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${student.email}</td>
		</tr>
		<tr>
			<td>Age</td>
			<td>${student.age}</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>${student.id}</td>
		</tr>
	</table>
</body>
</html>