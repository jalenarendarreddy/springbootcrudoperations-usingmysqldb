<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Add Employee</title>
</head>
<body>
	<form:form action="/saveEmp" method="POST">
		<label>Name:</label>
		<input type="text" id="name" name="name">
		<br>
		<label>Designation:</label>
		<input type="text" id="desig" name="desig">
		<br>
		<label>salary:</label>
		<input type="text" id="sal" name="sal">
		<br>
		<input type="submit">
	</form:form>
	
	<a href="/showEmployees">show Employees</a>
</body>
</html>