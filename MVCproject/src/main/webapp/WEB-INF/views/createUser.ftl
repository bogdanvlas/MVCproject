<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create user page</title>
</head>
<body>
	<form name="user" action="/MVCproject/addUser" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<td>
			<input type="submit" value="Save">
		</table>
	</form>
</body>
</html>