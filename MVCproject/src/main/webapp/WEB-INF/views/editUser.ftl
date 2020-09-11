<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit user page</title>
</head>
<body>
	<form name="user" action="/MVCproject/updateUser" method="post">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" name="id" value="${user.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${user.name}"></td>
			</tr>
			<td>
			<input type="submit" value="Save">
		</table>
	</form>
</body>
</html>