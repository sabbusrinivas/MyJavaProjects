<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees view</title>

</head>
<body>
	<h1>List of Employees</h1>
		
	<br></br>
	
	<button onclick="window.location.href='${pageContext.request.contextPath}/addEmployee'">Add Employee</button>
	
	<br></br>
	<table border = "1" width="100%">
        <thead>
            <tr>
                <th>id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Date of Birth</th>
				<th>Salary</th>
				<th>Actions</th>
            </tr>
        </thead>
        <tbody>
                <c:forEach items="${empList}" var="emp">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.email}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy" value="${emp.dob}" /></td>
						<td>${emp.salary}</td>
						<td>
							<a href = "${pageContext.request.contextPath}/edit/${emp.id}">Edit</a>
							<a href = "${pageContext.request.contextPath}/delete/${emp.id}">Delete</a>
						</td>
					</tr>
		</c:forEach>
        </tbody>
         
    </table>
</body>

</html>