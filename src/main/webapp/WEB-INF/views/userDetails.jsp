<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>	<h3>List of Users</h3>
	<table class="table table-bordered" style="width: 300px">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Role</th>
			<th> Action</th>
		</tr>

		<c:forEach items="${usrdetails}" var="user">
			<tr>
				<td width="60" align="center">${user.id}</td>
				<td width="60" align="center">${user.name}</td>
				<td width="60" align="center">${user.address}</td>
				<td width="60" align="center">${user.email}</td>
				<td width="60" align="center">${user.gender}</td>
				<td width="60" align="center">${user.role}</td>
				 <td width="60" align="center"><a href="edit/${user.id}">Edit</a>/
				 <a href="delete/${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
	
	</table>
	<tr>
		<td>
		<a href="http://localhost:8084/HelloMVC/logout" class="button">Log Out</a>  
				<a href="http://localhost:8084/HelloMVC/user" class="button">Add User</a> 
	</td>
	</tr>
</body>
</html>