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
	<b>Welcome Admin ${user.name}:</b> <b>Your details are</b>
</P>

</head>
<body>

	<hr />
	<form:form action="http://localhost:8081/HelloMVC/saveUser"
		method="post" modelAttribute="user">
		<table>

			<tr>


				<td><form:input hidden="true" path="id" type="text"
						required="true" /> <form:errors path="id" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Name</th>

				<td><form:input path="name" type="text" required="true"
						disabled="true" /> <form:errors path="name" cssClass="error" /></td>
			</tr>


			<tr>
				<th>Email</th>
				<td><form:input path="email" type="email" disabled="true" /> <form:errors
						path="email" cssClass="error" /></td>
			</tr>

			<tr>
				<th>PassWord</th>
				<td><form:input path="password" type="text" disabled="true" />
					<form:errors path="password" /></td>
			</tr>
			<tr>
				<th>Gender</th>

				<td><form:input path="gender" readOnly="true"
						value="${user.gender}" />
			</tr>

			<tr>
				<th>Role</th>

				<td><form:input path="role" readOnly="true"
						value="${user.role}" />
			</tr>


			<tr>
				<th>Address</th>
				<td><form:input path="address" disabled="true" /> <form:errors
						path="address" cssClass="error" /></td>
			</tr>

			<tr>
				<td><a href="http://localhost:8081/HelloMVC/logout" class="button">Log Out</a>  
				<a href="http://localhost:8081/HelloMVC/user" class="button">Add New</a> 
				<a href="http://localhost:8081/HelloMVC/usersDetails" class="button">User Details</a></td>



			</tr>
		</table>
	</form:form>
</body>
</html>