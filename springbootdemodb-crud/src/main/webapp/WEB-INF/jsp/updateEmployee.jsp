<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Add Employee</title>
</head>
<body>
	<form:form action="/updateEmp" method="POST" >
	   <input type="hidden" id="id" name="id" value="${emp.id }">
		<label>Name:</label>
		<input type="text" id="name" name="name" value="${emp.name }">
		<br>
		<label>Designation:</label>
		<input type="text" id="desig" name="desig" value="${emp.designation }">
		<br>
		<label>salary:</label>
		<input type="text" id="sal" name="sal" value="${emp.salary }">
		<br>
		<input type="submit">
	</form:form>
	
	<a href="/showEmployees">show Employees</a>
</body>
</html>