<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	function myFunction() {
		var a = confirm("Are you sure?");
		if (!a) {
			console.log(a);
			document.forms[0].action = "editemp";
			document.forms[0].submit();
		}
	}
</script>
<style>
.error {
	color: red;
	font-Size: 13px;
}
</style>
<br>
<h1 align="center">Edit Employee</h1>
<form:form method="POST" action="/EmployeeManagement/editsave"
	modelAttribute="emp">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="id" /></td>
		</tr>
		<table>
			<tr>
				<td>&emsp;First Name:&emsp;</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>&emsp;Last Name:&emsp;</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>&emsp;Salary:&emsp;</td>
				<td><form:input path="salary" /></td>
				<td><form:errors path="salary" cssClass="error" /></td>
			</tr>
			<tr>
				<td>&emsp;Department:&emsp;</td>
				<td><form:select path="department">
						<form:option value="IT" label="IT" />
						<form:option value="HR" label="HR" />
						<form:option value="Marketing" label="Marketing" />
						<form:option value="Executive" label="Executive" />
					</form:select></td>
				<td><form:errors path="department" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" onclick="myFunction()"
					value="Edit Save" /></td>
			</tr>
		</table>
		</form:form>