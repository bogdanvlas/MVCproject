<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users list</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		<#list users as user>
		<tr>
			<td><a href="user/${user.id}">${user.id}</a></td>
			<td>${user.name}</td>
			<td><a href="deleteUser/${user.id}">Delete</a>
			<td><a href="editUser/${user.id}">Edit</a>
		</tr>
		</#list>
		<tr>
		<td><a href="createUser">Add new user</a></td>
		</tr>
	</table>
</body>
</html>