<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BJIT</title>
<style type="text/css">
.error {
	color: red;
}
</style>
<P>
	
</P>

</head>
<body>
	<h2>User Input From</h2>
	<hr />
	<form:form action="http://localhost:8081/HelloMVC/saveUser" method="post" modelAttribute="user">
		<table>
		
			<tr>
				
				
				<td><form:input hidden="true" path="id" type="text" required="true" /> <form:errors
						path="id" cssClass="error" /></td>
			</tr>
		
			<tr>
				<th>Name</th>
				
				<td><form:input path="name" type="text" required="true" /> <form:errors
						path="name" cssClass="error" /></td>
			</tr>


			<tr>
				<th>Email</th>
				<td><form:input path="email" type="email" /> <form:errors
						path="email" cssClass="error" /></td>
			</tr>

			<tr>
				<th>PassWord</th>
				<td><form:input path="password" type="password" /> <form:errors
						path="password" /></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><form:radiobutton path="gender" value="Male" label="Male" />
					<form:radiobutton path="gender" value="Female" label="Female" /> <form:errors
						path="gender" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Role</th>
				<td><form:radiobutton path="role" value="Admin" label="Admin" /> <form:radiobutton
						path="role" value="User" label="User" /> <form:errors path="role"
						cssClass="error" /></td>
			</tr>

			<tr>
				<th>Address</th>
				<td><form:input path="address" /> <form:errors path="address"
						cssClass="error" /></td>
			</tr>

			<tr>
			
		
	
				<td><button type="submit">Save</button></td>
				<td><a href="http://localhost:8081/HelloMVC/usersDetails" class="button">User Details</a></td>
			
			</tr>
		</table>
	</form:form>
</body>
</html>