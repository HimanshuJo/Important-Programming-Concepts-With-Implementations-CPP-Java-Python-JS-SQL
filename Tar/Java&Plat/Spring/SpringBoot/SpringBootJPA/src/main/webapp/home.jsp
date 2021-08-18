<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Data</title>
</head>
<body>

	<h1>Please fill your details here!</h1>
	<h4>Please note first field should be an 'integer' value and
		second filed should be a 'string' value</h4>
		
	<hr>
	<h2>Currently we have the following records.</h2>
	<h2>${aliens}</h2>

	<h2>Do you want to add an alien?</h2>
	<form action="addAlien">
		<input type="text" name="aid" style="margin-bottom: 5px"> <br>
		<input type="text" name="aname" style="margin-bottom: 5px"> <br>
		<input type="text" name="tech" style="margin-bottom: 5px"> <br>
		<input type="submit" style="margin-top: 5px"><br>
	</form>

	<hr>
	<h2>Which Alien do you want to get?</h2>
	<form action="getAlien">
		<input type="text" name="aid" style="margin-bottom: 5px;"
			placeholder=''> <br> <input type="submit"
			style="margin-top: 5px"><br>
	</form>

	<hr>
	<h2>Do you want to update an Alien?</h2>
	<form action="updateAlien">
		<input type="text" name="aid" style="margin-bottom: 5px"> <br>
		<input type="text" name="aname" style="margin-bottom: 5px"> <br>
		<input type="text" name="tech" style="margin-bottom: 5px"> <br>
		<input type="submit" style="margin-top: 5px"><br>
	</form>

	<hr>
	<h2>Do you want to delete an Alien?</h2>
	<form action="deleteAlien">
		<input type="text" name="aid" style="margin-bottom: 5px;"
			placeholder=''> <br> <input type="submit"
			style="margin-top: 5px"><br>
	</form>

</body>
</html>