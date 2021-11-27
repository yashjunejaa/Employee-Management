
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	background-color:#E6E6FA;
}

form {
	text-align: center;
}
</style>
<script>
function myFunction(path) {
    var a = confirm("Are you sure?");
    if(a) {
    	console.log(a);
    	document.forms[0].action = path;
    	document.forms[0].submit();
    }
}
</script>
<br>
<h1 align="center">Employees List</h1>
<table border="1" width="70%" cellpadding="2" align="center">
	<tr>
		<th>Id</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Salary</th>
		<th>Department</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="emp" items="${list}">
		<tr>
			<td align="center">${emp.id}</td>
			<td align="center">${emp.firstName}</td>
			<td align="center">${emp.lastName}</td>
			<td align="center">${emp.salary}</td>
			<td align="center">${emp.department}</td>
			<td align="center"><button onClick="myFunction('edit/${emp.id}')">Edit</button></td>
			<td align="center"><button onClick="myFunction('delete/${emp.id}')">Delete</button></td>
		</tr>
	</c:forEach>
</table>
<br/>
<br>
<br>
<form method="get" action="addemp">
	<button type="submit">Add new Employee</button>
</form>
