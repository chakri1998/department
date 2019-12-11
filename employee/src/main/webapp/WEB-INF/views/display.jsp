<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2" width="70%" cellpadding="2">
		
		<c:forEach items="${departments}" var="department">
		<tr style="background-color:red; color:#fff;">
			<th>DEPARTMENT ID</th>
			<th>DEPARTMENT NAME</th>
			<th>EMPLOYEE ID</th>
			<th>EMPLOYEE NAME</th>
			<th>EMPLOYEE EXPERIENCE</th>
			<th>EMPLOYEE SALARY</th>
			<th>EMPLOYEE ID</th>
			<th>EMPLOYEE NAME</th>
			<th>EMPLOYEE EXPERIENCE</th>
			<th>EMPLOYEE SALARY</th>
			<th>EMPLOYEE ID</th>
			<th>EMPLOYEE NAME</th>
			<th>EMPLOYEE EXPERIENCE</th>
			<th>EMPLOYEE SALARY</th>
		</tr>
			<tr style="background-color:#1c87c9; color:#fff;">
				<td><c:out value="${department.getDepartmentId()}" /></td>
				<td><c:out value="${department.getDepartmentName()}" /></td>
				<c:forEach items="${department.getEmployeesDto()}" var="employee">
				<td><c:out value="${employee.getEmployeeId()}" /></td>
				<td><c:out value="${employee.getEmployeeName()}" /></td>
				<td><c:out value="${employee.getEmployeeExperience()}" /></td>
				<td><c:out value="${employee.getEmployeeSalary()}" /></td>
				</c:forEach>
			
			</tr>

		</c:forEach>
		<button type="submit" onclick="location.href='/'">Home</button>
	</table>

</body>
</html>