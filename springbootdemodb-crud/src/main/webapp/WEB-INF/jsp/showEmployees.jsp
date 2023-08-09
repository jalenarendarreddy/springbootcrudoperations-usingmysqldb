<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Add Employee</title>
</head>
<body>
	<table border="1">
		<tr>
		<th>name</th>
		<th>designation</th>
		<th>salary</th>
		<th>edit</th>
		<th>delete</th>
		</tr>

		</th>
		<c:forEach items="${listEmp}" var="emp">
			<tr>
			<td>${emp.name }</td>
			<td>${emp.designation }</td>
			<td>${emp.salary }</td>
			<td><a href="editEmployee/${emp.id }">Edit</a></td>
			<td><a href="deleteEmployee?id=${emp.id }">Delete</a></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>